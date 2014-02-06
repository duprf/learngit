package dwz.business.common;

import java.util.List;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;

public interface PublishingServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "publishingServiceMgr";
	
	List<Publishing> searchPublishing(BaseConditionVO vo);
	
	List<Publishing> searchPublishingWeight();
	
	Integer searchPublishingNum(BaseConditionVO vo);

	Publishing getPublishing(int id);

	void addPublishing(Publishing publishing);

	void updPublishing(Publishing publishing);

	void delPublishing(int id) throws ServiceException;
}
