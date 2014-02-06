package dwz.business.company;

import java.util.List;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.persistence.BaseConditionVO;

public interface CompanyServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "companyServiceMgr";

	void addCompany(Company company);

	void updCompany(Company company);

	Company getCompany(int id);
	
	void delCompany(int id);

	List<Company> searchCompany(BaseConditionVO vo);

	Integer searchCompanyNum(BaseConditionVO vo);
	
	/**
	 * 激活
	 * @param id
	 */
	void activeCompany(int id);
	/**
	 * 禁用
	 * @param id
	 */
	void inActiveCompany(int id);
	
}
