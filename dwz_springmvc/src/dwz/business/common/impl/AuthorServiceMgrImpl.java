package dwz.business.common.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.common.Author;
import dwz.business.common.AuthorServiceMgr;
import dwz.business.common.AuthorType;
import dwz.business.enums.AuthorizerRelativeType;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;
import dwz.persistence.beans.ComAuthor;
import dwz.persistence.mapper.ComAuthorMapper;
import dwz.persistence.mapper.ResChapterAuthorizerMapper;
import dwz.persistence.mapper.ResChapterMapper;

@Transactional(rollbackFor = Exception.class)
@Service(AuthorServiceMgr.SERVICE_NAME)
public class AuthorServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements AuthorServiceMgr {

	@Autowired
	private ComAuthorMapper authorMapper;
	
	@Autowired
	private ResChapterMapper chapterMapper;
	
	@Autowired
	private ResChapterAuthorizerMapper chapterAuthorizerMapper;

	public List<Author> searchAuthor(BaseConditionVO vo) {
		List<Author> bos = new ArrayList<Author>();

		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<ComAuthor> pos = authorMapper.findPageBreakByCondition(
				vo.getKeywords(), rb);

		for (ComAuthor po : pos) {
			bos.add(new Author(po));
		}

		return bos;
	}

	public Integer searchAuthorNum(BaseConditionVO vo) {

		return authorMapper.findNumberByCondition(vo.getKeywords());
	}

	public Author getAuthor(int id) {
		ComAuthor po = authorMapper.load(id);
		if (po == null) return null;
		
		return new Author(po);
	}

	public void addAuthor(Author author) {
		authorMapper.insert(author.getComAuthor());
	}

	public void updAuthor(Author author) {
		ComAuthor po = authorMapper.load(author.getId());
		po.setSn(author.getSn());
		po.setName(author.getName());
		po.setRegion(author.getRegion().toString());
		po.setCategoryId(author.getCategoryId());
		po.setSummary(author.getSummary());
		po.setDescription(author.getDescription());
		
		authorMapper.updateSelective(po);
	}

	public void delAuthor(int id) throws ServiceException {
		int countChapter = chapterMapper.countByAuthorId(id);
		if (countChapter > 0) {
			throw new ServiceException(getMessage("msg.del.related", "chapter"));
		}
		
		int countChapterAuthorizer = chapterAuthorizerMapper.countByRelativeIdAndType(id, AuthorizerRelativeType.thirdparty.toString());
		if (countChapterAuthorizer > 0) {
			throw new ServiceException(getMessage("msg.del..related", "chapter_authorizer"));
		}
		authorMapper.delete(id);
	}

	public List<Author> listAuthorByChapter(Integer chapterId) {
		List<Author> bos = new ArrayList<Author>();
		List<ComAuthor> pos = authorMapper.findAllByChapter(chapterId);

		for (ComAuthor po : pos) {
			bos.add(new Author(po));
		}

		return bos;
	}

	public Author getAuthorByChapter(int chapterId, AuthorType authorType) {
		ComAuthor po = authorMapper.findByChapter(chapterId, authorType.toString());
		if (po == null) return null;
		
		return new Author(po);
	}

}
