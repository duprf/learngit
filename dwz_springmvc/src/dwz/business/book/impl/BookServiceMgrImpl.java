package dwz.business.book.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dwz.business.book.Book;
import dwz.business.book.BookServiceMgr;
import dwz.business.chapter.ChapterConditionVO;
import dwz.business.enums.ChapterRelativeType;
import dwz.common.util.DateUtil;
import dwz.common.util.FileUtils;
import dwz.framework.config.AppConfiguration;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.beans.ResBook;
import dwz.persistence.mapper.ResBookMapper;
import dwz.persistence.mapper.ResChapterMapper;

@Transactional(rollbackFor = Exception.class)
@Service(BookServiceMgr.SERVICE_NAME)
public class BookServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements BookServiceMgr {
	
	@Autowired
	private ResBookMapper bookMapper;
	@Autowired
	private ResChapterMapper chapterMapper;

	public Book getBook(int id) {
		ResBook po = bookMapper.load(id);
		if (po == null){
			 return null;
		};
		return new Book(po);
	}

	public void addBook(Book book) {
		Date now = new Date();
		ResBook po = book.getResBook();
		po.setInsertDate(now);
		po.setUpdateDate(now);
		bookMapper.insert(po);
	}

	public void updBook(Book book) {
		Date now = new Date();
		ResBook po = bookMapper.load(book.getId());
		po.setSn(book.getSn());
		po.setNameCn(book.getNameCn());
		po.setNameEn(book.getNameEn());
		po.setPublishingId(book.getPublishingId());
		po.setPublishDate(book.getPublishDate());
		po.setCategoryId(book.getCategoryId());
		po.setDescription(book.getDescription());
		po.setUpdateDate(now);
		bookMapper.updateSelective(po);
	}

	public void delBook(int id) throws ServiceException {
		int count = chapterMapper.countByRelativeIdAndType(id, ChapterRelativeType.book.toString());
		if (count > 0) {
			throw new ServiceException(getMessage("msg.del.related", "chapter"));
		}
		bookMapper.delete(id);
	}

	public List<Book> searchBook(ChapterConditionVO vo) {
		List<Book> bos = new ArrayList<Book>();
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<ResBook> pos = bookMapper.findPageBreakByCondition(vo, rb);
		for (ResBook po : pos) {
			bos.add(new Book(po));
		}

		return bos;
	}

	public int searchBookNum(ChapterConditionVO vo) {
		Integer count = bookMapper.findNumberByCondition(vo);

		return count;
	}


	public void uploadIcon(int bookId, CommonsMultipartFile mFile)
			throws ServiceException {

		ResBook resBook = bookMapper.load(bookId);
		Date now = new Date();
		AppConfiguration config = AppConfiguration.getInstance();
		
		if (mFile.isEmpty()) {
			throw new ServiceException(getMessage("msg.book.icon.failure"));
		}
		if (resBook == null) {
			throw new ServiceException(getMessage("msg.system.failure"));
		}
		
		//删除老书目封面
		String oldIconPath = resBook.getIconPath();
		if (oldIconPath != null && oldIconPath.length()>0){
			File oldIconFile = new File(config.getStaticContentPath()+oldIconPath);
			oldIconFile.deleteOnExit();
		}
		
		//上传文件
		String ext = FileUtils.getFileExt(mFile.getOriginalFilename());
		String dirPath = DateUtil.date2String(now, "/yyyy/MM");
		String iconPath = dirPath + "/icon"+System.currentTimeMillis()+"."+ext;
		File iconBaseDir = new File(config.getBaseUploadPath()+dirPath);
		if (!iconBaseDir.exists()) iconBaseDir.mkdirs();
		
		File file = new File(config.getBaseUploadPath()+iconPath); // 新建一个文件
		try {
			mFile.getFileItem().write(file); // 将上传的文件写入新建的文件中
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(getMessage("msg.system.failure"));
		}
		
		resBook.setIconPath(iconPath);
		
		bookMapper.updateSelective(resBook);
	}
}
