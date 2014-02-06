package dwz.business.common;

import java.util.List;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;
import dwz.persistence.BaseConditionVO;

public interface AuthorizerServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "authorizerServiceMgr";
	
	List<Authorizer> searchAuthorizer(BaseConditionVO vo);
	Integer searchAuthorizerNum(BaseConditionVO vo);

	Authorizer getAuthorizer(int id);

	void addAuthorizer(Authorizer authorizer);

	void updAuthorizer(Authorizer authorizer);

	void delAuthorizer(int id) throws ServiceException;
}
