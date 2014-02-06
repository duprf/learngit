package dwz.business.chapter.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.chapter.Chapter;
import dwz.business.chapter.ChapterAuthorizer;
import dwz.business.chapter.ChapterConditionVO;
import dwz.business.chapter.ChapterServiceMgr;
import dwz.business.common.Author;
import dwz.business.enums.ChapterStatus;
import dwz.common.util.DateUtil;
import dwz.common.util.ExecUtils;
import dwz.framework.config.AppConfiguration;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.DataStore;
import dwz.persistence.beans.ResChapter;
import dwz.persistence.beans.ResChapterAuthor;
import dwz.persistence.beans.ResChapterAuthorizer;
import dwz.persistence.mapper.ResChapterAuthorMapper;
import dwz.persistence.mapper.ResChapterAuthorizerMapper;
import dwz.persistence.mapper.ResChapterMapper;

@Transactional(rollbackFor = Exception.class)
@Service(ChapterServiceMgr.SERVICE_NAME)
public class ChapterServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements ChapterServiceMgr {
	@Autowired
	private ResChapterAuthorMapper chapterAuthorMapper;
	@Autowired
	private ResChapterMapper chapterMapper;
	@Autowired
	private ResChapterAuthorizerMapper chapterAuthorizerMapper;
//	@Autowired
//	private SolrServiceMgr solrMgr;

	public Chapter getChapter(int id) {
		ResChapter po = chapterMapper.load(id);
		if (po == null){
			 return null;
		};
		
		Chapter chapter = new Chapter(po);
		List<ChapterAuthorizer> authorizerList = new ArrayList<ChapterAuthorizer>();
		List <ResChapterAuthorizer> rcas = chapterAuthorizerMapper.findChapterAuthorizer(id);
		for(ResChapterAuthorizer rca:rcas){
			authorizerList.add(new ChapterAuthorizer(rca));
		}
		chapter.setAuthorizerList(authorizerList);
		
		return chapter;
	}

	public void addChapter(Chapter chapter, File file) {
		if (file==null || !file.exists()) return;
		Date now = new Date();
		AppConfiguration config = getAppConfig();
		
		String fileName = file.getName();
		String name = fileName, ext = "";
		int lastIndex = fileName.lastIndexOf(".");
		if (lastIndex >= 0) {
			name = fileName.substring(0, lastIndex);
			ext = fileName.substring(lastIndex + 1).toLowerCase();
		}
		
		if (!"pdf".equals(ext)) return;
		
		String dirPath = DateUtil.date2String(now, "/yyyy/MM");
		String bookPath = dirPath + "/" + name+"."+ext;
		File bookDir = new File(config.getBookRootPath()+dirPath);
		if (!bookDir.exists()) bookDir.mkdirs();
		
		System.out.println("renameTo: "+config.getBookRootPath() + bookPath);
		file.renameTo(new File(config.getBookRootPath() + bookPath));

		// save to database
		ResChapter po = chapter.getResChapter();
		po.setPath(bookPath);
		po.setInsertDate(now);
		po.setUpdateDate(now);
		po.setInitContent(false);
		chapterMapper.insert(po);
		
		// pdf2json
		String destDir = config.getBaseReaderPath() + dirPath + "/" + name;
		ExecUtils.pdf2json(config.getBookRootPath() + bookPath, destDir);
	}

	public void updChapter(Chapter chapter) {
		Date now = new Date();
		ResChapter po = chapterMapper.load(chapter.getId());

		po.setChapterNo(chapter.getChapterNo());
		po.setParentCategoryId(chapter.getParentCategoryId());
		po.setCategoryId1(chapter.getCategoryId1());
		po.setCategoryId2(chapter.getCategoryId2());
		po.setKeywords(chapter.getKeywords());
		po.setNameCn(chapter.getNameCn());
		po.setNameEn(chapter.getNameEn());
		po.setSummary(chapter.getSummary());
		po.setStartPageNo(chapter.getStartPageNo());
		po.setPageCount(chapter.getPageCount());
		
		po.setInitContent(false);
		po.setUpdateDate(now);
		chapterMapper.updateSelective(po);
		
//		chapterAuthorizerMapper.deleteByChapterId(chapter.getId());
//		for(ChapterAuthorizer ca : chapter.getAuthorizerList()){
//			if(ca.getRelativeType() != null && !"".equals(ca.getRelativeType())){
//				ca.setChapterId(chapter.getId());
//				chapterAuthorizerMapper.insert(ca.getResChapterAuthorizer());
//			}
//		}

		
		List <ResChapterAuthorizer> _authorizerList = chapterAuthorizerMapper.findChapterAuthorizer(chapter.getId());
		List <ResChapterAuthorizer> authorizerList = new ArrayList<ResChapterAuthorizer>();
		for(ChapterAuthorizer ca : chapter.getAuthorizerList()){
			if(ca.getRelativeType() != null && !"".equals(ca.getRelativeType())){
				ca.setChapterId(chapter.getId());
				authorizerList.add(ca.getResChapterAuthorizer());
			}
		}
		DataStore<ResChapterAuthorizer> authorizerStore = new DataStore<ResChapterAuthorizer>(_authorizerList);
		authorizerStore.updItems(authorizerList);
		authorizerStore.sync(chapterAuthorizerMapper);
		
		chapterAuthorMapper.deleteByChapterId(chapter.getId());
		for(Author author : chapter.getAuthorList()){
			if(author.getId() > 0){
				ResChapterAuthor resChapterAuthor = new ResChapterAuthor();
				resChapterAuthor.setAithorId(author.getId());
				resChapterAuthor.setChapterId(chapter.getId());
				resChapterAuthor.setType(author.getAuthorType().toString());
				resChapterAuthor.setSequence(author.getAuthorSequence());
				chapterAuthorMapper.insert(resChapterAuthor);
			}
		}
	}

	public void delChapter(int id) {
		ResChapter po = chapterMapper.load(id);
		po.setInitContent(false);
		po.setStatus(ChapterStatus.delete.toString());
		po.setUpdateDate(new Date());
		chapterMapper.updateSelective(po);
//		chapterMapper.updateStatus(id, ChapterStatus.delete.toString());
	}

	public List<Chapter> searchChapters(ChapterConditionVO vo) {
		
		List<Chapter> bos = new ArrayList<Chapter>();
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<ResChapter> pos = chapterMapper.findPageBreakByCondition(vo, rb);
		for (ResChapter po : pos) {
			bos.add(new Chapter(po));
		}
		return bos;
	}
	

	public Integer searchChaptersNum(ChapterConditionVO vo) {

		Integer count = chapterMapper.findNumberByCondition(vo);

		return count;
	}

	public void initChaptersContent() {
		List<ResChapter> pos = chapterMapper.findNotInitContent();	
		addSolr(pos);
	}
	//for test add by yhzheng  
	//重建所有索引
	public void initAllChaptersContent() {
//		List<ResChapter> pos = chapterMapper.findAll();
//		List<Integer> ids =  chapterMapper.findAllIds();
//		try {
//			solrMgr.delIndexs(ids);
//		} catch (SolrServerException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		addSolr(pos);
	}
	
	private void addSolr(List<ResChapter> pos){
//		Date now = new Date();
//		AppConfiguration config = getAppConfig();
//		System.out.println("############# Start initChaptersContent: " + now + " size:" + pos.size());
//		for (ResChapter po : pos) {
//			String path = po.getPath();
//			if (path != null && path.endsWith(".pdf")) {
//				int lastIndex = path.lastIndexOf(".");
//				String jsonDirPath = config.getBaseReaderPath() + path.substring(0, lastIndex);
//
//				File txtFile = new File(jsonDirPath + "/p.txt");
//				
//				System.out.println("jsonDirPath: "+txtFile.getPath());
//				if (txtFile.exists()) {
//					String content = FileUtils.getFileContent(txtFile.getPath());
//
//					po.setInitContent(true);
//					po.setUpdateDate(now);
//					
//					
//					
//					Chapter chapter = new Chapter(chapterMapper.load(po.getId()));
//					
//					//增加solr索引
//					SolrItem solrItem = new SolrItem();
//					solrItem.setId(chapter.getId());
//					solrItem.setRelativeType(chapter.getRelativeTypeEnum());
//					solrItem.setRelativeId(chapter.getRelativeId());
//					solrItem.setChapterNo(chapter.getChapterNo());
//					solrItem.setChapterNameEn(chapter.getNameEn());
//					solrItem.setChapterNameCn(chapter.getNameCn());
//					solrItem.setChapterSummary(chapter.getSummary());
//					solrItem.setChapterStartPageNo(chapter.getStartPageNo());
//					solrItem.setChapterPageCount(chapter.getPageCount());
//					solrItem.setKeywords(chapter.getKeywords());
//					solrItem.setContent(content);
//					Category category = chapter.getCategory1();
//					if(category != null){
//						List<Category> categorys = category.getParentCategories();
//						if(categorys.size()==3){
//							solrItem.setCategory1(categorys.get(0).getId());
//							solrItem.setCategory2(categorys.get(1).getId());
//							solrItem.setCategory31(categorys.get(2).getId());
//						}						
//					}
//					solrItem.setCategory32(chapter.getCategoryId2());
//					
//					RelativeSolr relativeSolr = chapter.getRelativeSolr();
//					solrItem.setRelativeSn(relativeSolr.getRelativeSn());
//					solrItem.setRelativeNameEn(relativeSolr.getRelativeNameEn());
//					solrItem.setRelativeNameCn(relativeSolr.getRelativeNameCn());
//					solrItem.setJournalTerm(relativeSolr.getJournalTerm());
//					solrItem.setPublishDate(relativeSolr.getPublishDate());
//					solrItem.setPublishingId(relativeSolr.getPublishing().getId());
//					solrItem.setPublishingName(relativeSolr.getPublishing().getName());
//					
//					Author author = chapter.getAuthor();
//					if (author != null) {
//						solrItem.setAuthorId(author.getId());
//						solrItem.setAuthorName(author.getName());
//					}
//					
//					
//					try {
//						solrMgr.addIndex(solrItem);
//					} catch (SolrServerException e) {
//						e.printStackTrace();
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//					chapterMapper.updateSelective(po);
//				} else {
//					ExecUtils.pdf2json(config.getBookRootPath() + path, jsonDirPath);
//				}
//				
//			}
//		}
	}

}
