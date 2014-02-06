package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ComPublishing extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3964920989530850648L;
	private Integer id;
	private String name;
	private String region;
	private String agency;
	private double weight;
	private String summary;
	private String description;

	public ComPublishing(){
	}

	public ComPublishing(Integer id){
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
	
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setAgency(String value) {
		this.agency = value;
	}
	
	public String getAgency() {
		return this.agency;
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
			.append("Agency",getAgency())
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
		if(obj instanceof ComPublishing == false) return false;
		if(this == obj) return true;
		ComPublishing other = (ComPublishing)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}

