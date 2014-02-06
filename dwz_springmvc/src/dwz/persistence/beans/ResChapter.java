package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ResChapter extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3779737061401839375L;
	private Integer id;
	private Integer relativeId;
	private String relativeType;
	private String chapterNo;
	private Integer parentCategoryId;
	private Integer categoryId1;
	private Integer categoryId2;
	private String nameCn;
	private String nameEn;
	private String summary;
	private String path;
	private String keywords;
	private String content;
	private Boolean initContent;
	private Integer startPageNo;
	private Integer pageCount;
	private Integer publicCount;
	private String status;
	private java.util.Date insertDate;
	private java.util.Date updateDate;

	public ResChapter(){
	}

	public ResChapter(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setRelativeId(Integer value) {
		this.relativeId = value;
	}
	
	public Integer getRelativeId() {
		return this.relativeId;
	}
	public void setRelativeType(String value) {
		this.relativeType = value;
	}
	
	public String getRelativeType() {
		return this.relativeType;
	}

	public void setParentCategoryId(Integer value) {
		this.parentCategoryId = value;
	}
	
	public Integer getParentCategoryId() {
		return this.parentCategoryId;
	}
	public void setCategoryId1(Integer value) {
		this.categoryId1 = value;
	}
	
	public Integer getCategoryId1() {
		return this.categoryId1;
	}
	public void setCategoryId2(Integer value) {
		this.categoryId2 = value;
	}
	
	public Integer getCategoryId2() {
		return this.categoryId2;
	}
	public void setNameCn(String value) {
		this.nameCn = value;
	}
	
	public String getNameCn() {
		return this.nameCn;
	}
	public void setNameEn(String value) {
		this.nameEn = value;
	}
	
	public String getNameEn() {
		return this.nameEn;
	}
	public void setSummary(String value) {
		this.summary = value;
	}
	
	public String getSummary() {
		return this.summary;
	}
	public void setPath(String value) {
		this.path = value;
	}
	
	public String getPath() {
		return this.path;
	}
	public void setKeywords(String value) {
		this.keywords = value;
	}
	
	public String getKeywords() {
		return this.keywords;
	}
	public void setContent(String value) {
		this.content = value;
	}
	
	public String getContent() {
		return this.content;
	}
	public void setInitContent(Boolean value) {
		this.initContent = value;
	}
	
	public Boolean getInitContent() {
		return this.initContent;
	}
	public void setStartPageNo(Integer value) {
		this.startPageNo = value;
	}
	
	public Integer getStartPageNo() {
		return this.startPageNo;
	}
	public void setPageCount(Integer value) {
		this.pageCount = value;
	}
	
	public Integer getPageCount() {
		return this.pageCount;
	}
	public void setPublicCount(Integer value) {
		this.publicCount = value;
	}
	
	public Integer getPublicCount() {
		return this.publicCount;
	}
	public void setStatus(String value) {
		this.status = value;
	}
	
	public String getStatus() {
		return this.status;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("RelativeId",getRelativeId())
			.append("RelativeType",getRelativeType())
			.append("ChapterNo",getChapterNo())
			.append("ParentCategoryId",getParentCategoryId())
			.append("CategoryId1",getCategoryId1())
			.append("CategoryId2",getCategoryId2())
			.append("NameCn",getNameCn())
			.append("NameEn",getNameEn())
			.append("Summary",getSummary())
			.append("Path",getPath())
			.append("Keywords",getKeywords())
			.append("Content",getContent())
			.append("InitContent",getInitContent())
			.append("StartPageNo",getStartPageNo())
			.append("PageCount",getPageCount())
			.append("PublicCount",getPublicCount())
			.append("Status",getStatus())
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
		if(obj instanceof ResChapter == false) return false;
		if(this == obj) return true;
		ResChapter other = (ResChapter)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	public void setChapterNo(String chapterNo) {
		this.chapterNo = chapterNo;
	}

	public String getChapterNo() {
		return chapterNo;
	}
}

