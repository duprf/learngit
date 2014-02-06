package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import dwz.dal.object.AbstractDO;
import java.util.*;

public class ResBook extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9038120706226048344L;
	private Integer id;
	private Integer categoryId;
	private String sn;
	private String nameCn;
	private String nameEn;
	private Integer publishingId;
	private java.util.Date publishDate;
	private String iconPath;
	private String description;
	private java.util.Date insertDate;
	private java.util.Date updateDate;

	public ResBook(){
	}

	public ResBook(Integer id){
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
	public void setSn(String value) {
		this.sn = value;
	}
	
	public String getSn() {
		return this.sn;
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

	public Integer getPublishingId() {
		return publishingId;
	}

	public void setPublishingId(Integer publishingId) {
		this.publishingId = publishingId;
	}

	public void setPublishDate(java.util.Date value) {
		this.publishDate = value;
	}
	
	public java.util.Date getPublishDate() {
		return this.publishDate;
	}
	public void setIconPath(String value) {
		this.iconPath = value;
	}
	
	public String getIconPath() {
		return this.iconPath;
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
	
	private Set resChapters = new HashSet(0);
	public void setResChapters(Set<ResChapter> resChapter){
		this.resChapters = resChapter;
	}
	
	public Set<ResChapter> getResChapters() {
		return resChapters;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("CategoryId",getCategoryId())
			.append("Sn",getSn())
			.append("NameCn",getNameCn())
			.append("NameEn",getNameEn())
			.append("PublishingId",getPublishingId())
			.append("PublishDate",getPublishDate())
			.append("IconPath",getIconPath())
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
		if(obj instanceof ResBook == false) return false;
		if(this == obj) return true;
		ResBook other = (ResBook)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}

