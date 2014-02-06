package dwz.business.company.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dwz.business.company.Company;
import dwz.business.company.CompanyServiceMgr;
import dwz.business.company.CompanyStatus;
import dwz.common.util.ip.IpRangeUtils;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.persistence.BaseConditionVO;
import dwz.persistence.beans.SysCompany;
import dwz.persistence.mapper.SysCompanyMapper;

@Transactional(rollbackFor = Exception.class)
@Service(CompanyServiceMgr.SERVICE_NAME)
public class CompanyServiceMgrImpl extends AbstractBusinessObjectServiceMgr
		implements CompanyServiceMgr {

	@Autowired
	private SysCompanyMapper companyMapper;
	
	public void addCompany(Company company) {
		Date now = new Date();
		
		SysCompany po = company.getSysCompany();
		
		po.setIpRange(IpRangeUtils.fixIpRanges(po.getIpRange())); //去除非法IP段
		po.setInsertDate(now);
		po.setUpdateDate(now);

		companyMapper.insert(po);
	}

	public void updCompany(Company company) {
		Date now = new Date();
		
		SysCompany po = company.getSysCompany();
		po.setIpRange(IpRangeUtils.fixIpRanges(po.getIpRange())); //去除非法IP段
		po.setUpdateDate(now);

		companyMapper.updateSelective(po);
	}

	public Company getCompany(int id) {
		SysCompany po = companyMapper.load(id);
		if (po == null) return null;
		
		return new Company(po);
	}
	public void delCompany(int id) {
		companyMapper.updateStatus(id, CompanyStatus.DELETED.toString(), new Date());
	}

	public List<Company> searchCompany(BaseConditionVO vo) {
		List<Company> bos = new ArrayList<Company>();
		RowBounds rb = new RowBounds(vo.getStartIndex(), vo.getPageSize());
		List<SysCompany> pos = companyMapper.findPageBreakByCondition(
				vo.getStatus(), vo.getKeywords(), vo.getStartDate(),
				vo.getEndDate(), rb);
		
		for (SysCompany po : pos) {
			bos.add(new Company(po));
		}
		return bos;
	}

	public Integer searchCompanyNum(BaseConditionVO vo) {
		Integer count = companyMapper.findNumberByCondition(vo.getStatus(),
				vo.getKeywords(), vo.getStartDate(), vo.getEndDate());

		return count;
	}

	public void activeCompany(int id) {
		companyMapper.updateStatus(id, CompanyStatus.INACTIVE.toString(), new Date());
	}

	public void inActiveCompany(int id) {
		companyMapper.updateStatus(id, CompanyStatus.ACTIVE.toString(), new Date());
	}


}
