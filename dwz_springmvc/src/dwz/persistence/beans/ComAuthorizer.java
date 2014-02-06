package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ComAuthorizer extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2085051590287210613L;
	private Integer id;
	private String name;
	private String region;
	private String summary;
	private String description;

	public ComAuthorizer(){
	}

	public ComAuthorizer(Integer id){
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
	public void setRegion(String value) {
		this.region = value;
	}
	
	public String getRegion() {
		return this.region;
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

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Name",getName())
			.append("Region",getRegion())
			.append("Summary",getSummary())
			.append("Description",getDescription())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ComAuthorizer == false) return false;
		if(this == obj) return true;
		ComAuthorizer other = (ComAuthorizer)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

