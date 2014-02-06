package dwz.persistence.beans;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import dwz.dal.object.AbstractDO;

public class ComCategory extends AbstractDO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5128462475187563679L;
	private Integer id;
	private String sn;
	private String name;
	private Integer pid;
	private Integer lft;
	private Integer rgt;
	private Integer depth;

	public ComCategory(){
	}

	public ComCategory(Integer id){
		this.id = id;
	}

	public void setId(Integer value) {
		this.id = value;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setSn(String value) {
		this.sn = value;
	}
	
	public String getSn() {
		return this.sn;
	}
	public void setName(String value) {
		this.name = value;
	}
	
	public String getName() {
		return this.name;
	}

	public void setPid(Integer value) {
		this.pid = value;
	}
	
	public Integer getPid() {
		return this.pid;
	}
	public void setLft(Integer value) {
		this.lft = value;
	}
	
	public Integer getLft() {
		return this.lft;
	}
	public void setRgt(Integer value) {
		this.rgt = value;
	}
	
	public Integer getRgt() {
		return this.rgt;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("Id",getId())
			.append("Sn",getSn())
			.append("Name",getName())
			.append("Pid",getPid())
			.append("Lft",getLft())
			.append("Rgt",getRgt())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof ComCategory == false) return false;
		if(this == obj) return true;
		ComCategory other = (ComCategory)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}

	public void setDepth(Integer depth) {
		this.depth = depth;
	}

	public Integer getDepth() {
		return depth;
	}
}

