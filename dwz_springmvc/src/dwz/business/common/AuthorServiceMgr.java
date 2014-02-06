package dwz.business.common;

import java.util.List;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;

public interface AuthorServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "authorServiceMgr";
	
	List<Author> searchAuthor(BaseConditionVO vo);
	Integer searchAuthorNum(BaseConditionVO vo);

	Author getAuthor(int id);

	void addAuthor(Author author);

	void updAuthor(Author author);

	void delAuthor(int id) throws ServiceException;
	

	List<Author> listAuthorByChapter(Integer chapterId);
	Author getAuthorByChapter(int chapterId, AuthorType authorType);
}
