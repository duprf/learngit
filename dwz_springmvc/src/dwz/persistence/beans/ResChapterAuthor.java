package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ResChapterAuthor extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7245084287791567300L;
	private Integer id;
	private Integer aithorId;
	private Integer chapterId;
	private String type;
	private Integer sequence;

	public ResChapterAuthor(){
	}

	public ResChapterAuthor(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setAithorId(Integer value) {
		this.aithorId = value;
	}
	
	public Integer getAithorId() {
		return this.aithorId;
	}
	public void setChapterId(Integer value) {
		this.chapterId = value;
	}
	
	public Integer getChapterId() {
		return this.chapterId;
	}
	public void setType(String value) {
		this.type = value;
	}
	
	public String getType() {
		return this.type;
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
			.append("AithorId",getAithorId())
			.append("ChapterId",getChapterId())
			.append("Type",getType())
			.append("Sequence",getSequence())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ResChapterAuthor == false) return false;
		if(this == obj) return true;
		ResChapterAuthor other = (ResChapterAuthor)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

