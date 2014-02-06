/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-09-10 08:51:33 by code generator
 */
package dwz.business.company;

import java.util.Date;

import dwz.common.util.EnumUtils;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.SysCompany;

public class Company extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private SysCompany sysCompany;
	
	/* generateConstructor */
	public Company() {
		this.sysCompany = new SysCompany();
		this.sysCompany.setStatus(CompanyStatus.ACTIVE.toString());
	}
	public Company(SysCompany sysCompany) {
		this.sysCompany = sysCompany;
	}
	public SysCompany getSysCompany(){
		return this.sysCompany;
	}

	
	public Integer getId() {
		return this.sysCompany.getId();
	}

	public void setId(Integer id) {
		this.sysCompany.setId(id);
	}
	
	public String getName() {
		return this.sysCompany.getName();
	}

	public void setName(String name) {
		this.sysCompany.setName(name);
	}
	
	public String getContactName() {
		return this.sysCompany.getContactName();
	}

	public void setContactName(String contactName) {
		this.sysCompany.setContactName(contactName);
	}
	
	public String getEmail() {
		return this.sysCompany.getEmail();
	}

	public void setEmail(String email) {
		this.sysCompany.setEmail(email);
	}
	
	public String getPhone() {
		return this.sysCompany.getPhone();
	}

	public void setPhone(String phone) {
		this.sysCompany.setPhone(phone);
	}
	
	public CompanyStatus getStatus() {
		if (EnumUtils.isDefined(CompanyStatus.values(), sysCompany.getStatus()))
			return CompanyStatus.valueOf(sysCompany.getStatus());

		return CompanyStatus.INACTIVE;
	}
	
	public Date getStartDate() {
		return this.sysCompany.getStartDate();
	}

	public void setStartDate(Date startDate) {
		this.sysCompany.setStartDate(startDate);
	}
	
	public Date getExpiryDate() {
		return this.sysCompany.getExpiryDate();
	}

	public void setExpiryDate(Date expiryDate) {
		this.sysCompany.setExpiryDate(expiryDate);
	}
	
	public String getRemark() {
		return this.sysCompany.getRemark();
	}

	public void setRemark(String remark) {
		this.sysCompany.setRemark(remark);
	}
	
	public Date getInsertDate() {
		return this.sysCompany.getInsertDate();
	}
	
	public Date getUpdateDate() {
		return this.sysCompany.getUpdateDate();
	}

	public String getIpRange() {
		return this.sysCompany.getIpRange();
	}

	public void setIpRange(String ipRange) {
		this.sysCompany.setIpRange(ipRange);
	}
}

