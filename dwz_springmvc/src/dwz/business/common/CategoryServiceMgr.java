package dwz.business.common;

import java.util.List;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;

public interface CategoryServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "categoryServiceMgr";

	List<Category> searchCategory(BaseConditionVO vo);
	int searchCategoryNum(BaseConditionVO vo);
	
	List<Category> getSubCategories(Integer pid);
	List<Category> getParentCategories(Integer categoryId);

	Category getCategory(int id);

	void addCategory(int pid, String sn, String name) throws ServiceException;

	void updCategory(int id, String sn, String name) throws ServiceException;

	void delCategory(int id) throws ServiceException;

}
