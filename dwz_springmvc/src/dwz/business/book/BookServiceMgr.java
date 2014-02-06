package dwz.business.book;

import java.util.List;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dwz.business.chapter.ChapterConditionVO;
import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

public interface BookServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "bookServiceMgr";

	Book getBook(int id);

	void addBook(Book book);

	void updBook(Book book);

	void delBook(int id) throws ServiceException;

	List<Book> searchBook(ChapterConditionVO vo);

	int searchBookNum(ChapterConditionVO vo);

	void uploadIcon(int bookId, CommonsMultipartFile mFile) throws ServiceException;

}
