package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class SysCompany extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4888300500724997526L;
	private Integer id;
	private String name;
	private String contactName;
	private String email;
	private String phone;
	private String status;
	private java.util.Date startDate;
	private java.util.Date expiryDate;
	private String ipRange;
	private String remark;
	private java.util.Date insertDate;
	private java.util.Date updateDate;

	public SysCompany(){
	}

	public SysCompany(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	public void setContactName(String value) {
		this.contactName = value;
	}
	
	public String getContactName() {
		return this.contactName;
	}
	public void setEmail(String value) {
		this.email = value;
	}
	
	public String getEmail() {
		return this.email;
	}
	public void setPhone(String value) {
		this.phone = value;
	}
	
	public String getPhone() {
		return this.phone;
	}
	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return this.status;
	}

	public void setStartDate(java.util.Date value) {
		this.startDate = value;
	}
	
	public java.util.Date getStartDate() {
		return this.startDate;
	}

	public void setExpiryDate(java.util.Date value) {
		this.expiryDate = value;
	}
	
	public java.util.Date getExpiryDate() {
		return this.expiryDate;
	}
	public void setRemark(String value) {
		this.remark = value;
	}
	
	public String getRemark() {
		return this.remark;
	}

	public void setInsertDate(java.util.Date value) {
		this.insertDate = value;
	}
	
	public java.util.Date getInsertDate() {
		return this.insertDate;
	}

	public void setUpdateDate(java.util.Date value) {
		this.updateDate = value;
	}
	
	public java.util.Date getUpdateDate() {
		return this.updateDate;
	}

	public String getIpRange() {
		return ipRange;
	}

	public void setIpRange(String ipRange) {
		this.ipRange = ipRange;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("ContactName",getContactName())
			.append("Email",getEmail())
			.append("Phone",getPhone())
			.append("Status",getStatus())
			.append("StartDate",getStartDate())
			.append("ExpiryDate",getExpiryDate())
			.append("Remark",getRemark())
			.append("InsertDate",getInsertDate())
			.append("UpdateDate",getUpdateDate())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof SysCompany == false) return false;
		if(this == obj) return true;
		SysCompany other = (SysCompany)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

