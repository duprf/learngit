package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ComAuthor extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1878088734391740487L;
	private Integer id;
	private Integer categoryId;
	private String iconPath;
	private String sn;
	private Integer userId;
	private String name;
	private String region;
	private String keywords;
	private String summary;
	private String description;
	private String pdfPath;

	private String authorType;
	private Integer authorSequence;
	
	public ComAuthor(){
	}

	public ComAuthor(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setCategoryId(Integer value) {
		this.categoryId = value;
	}
	
	public Integer getCategoryId() {
		return this.categoryId;
	}
	public void setIconPath(String value) {
		this.iconPath = value;
	}
	
	public String getIconPath() {
		return this.iconPath;
	}
	public void setSn(String value) {
		this.sn = value;
	}
	
	public String getSn() {
		return this.sn;
	}
	public void setUserId(Integer value) {
		this.userId = value;
	}
	
	public Integer getUserId() {
		return this.userId;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}
	public void setRegion(String value) {
		this.region = value;
	}
	
	public String getRegion() {
		return this.region;
	}
	public void setKeywords(String value) {
		this.keywords = value;
	}
	
	public String getKeywords() {
		return this.keywords;
	}
	public void setSummary(String value) {
		this.summary = value;
	}
	
	public String getSummary() {
		return this.summary;
	}
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return this.description;
	}
	public void setPdfPath(String value) {
		this.pdfPath = value;
	}
	
	public String getPdfPath() {
		return this.pdfPath;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CategoryId",getCategoryId())
			.append("IconPath",getIconPath())
			.append("Sn",getSn())
			.append("UserId",getUserId())
			.append("Name",getName())
			.append("Region",getRegion())
			.append("Keywords",getKeywords())
			.append("Summary",getSummary())
			.append("Description",getDescription())
			.append("PdfPath",getPdfPath())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ComAuthor == false) return false;
		if(this == obj) return true;
		ComAuthor other = (ComAuthor)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	public void setAuthorType(String authorType) {
		this.authorType = authorType;
	}

	public String getAuthorType() {
		return authorType;
	}

	public void setAuthorSequence(Integer authorSequence) {
		this.authorSequence = authorSequence;
	}

	public Integer getAuthorSequence() {
		return authorSequence;
	}


}

