package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ResChapterAuthorizer extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7575316150953736798L;
	private Integer id;
	private Integer chapterId;
	private Integer relativeId;
	private String relativeType;
	private Integer sequence;

	public ResChapterAuthorizer(){
	}

	public ResChapterAuthorizer(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setChapterId(Integer value) {
		this.chapterId = value;
	}
	
	public Integer getChapterId() {
		return this.chapterId;
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
	public void setSequence(Integer value) {
		this.sequence = value;
	}
	
	public Integer getSequence() {
		return this.sequence;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("ChapterId",getChapterId())
			.append("RelativeId",getRelativeId())
			.append("RelativeType",getRelativeType())
			.append("Sequence",getSequence())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ResChapterAuthorizer == false) return false;
		if(this == obj) return true;
		ResChapterAuthorizer other = (ResChapterAuthorizer)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

