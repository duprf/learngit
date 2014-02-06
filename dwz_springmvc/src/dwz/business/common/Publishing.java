/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2013-02-24 18:14:27 by code generator
 */
package dwz.business.common;

import dwz.business.enums.PublishingAgency;
import dwz.business.enums.Region;
import dwz.common.util.EnumUtils;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.ComPublishing;

public class Publishing extends AbstractBusinessObject {
	private static final long serialVersionUID = 1L;
	private ComPublishing comPublishing;

	/* generateConstructor */
	public Publishing() {
		this.comPublishing = new ComPublishing();
	}

	public Publishing(ComPublishing comPublishing) {
		this.comPublishing = comPublishing;
	}

	public ComPublishing getComPublishing() {
		return this.comPublishing;
	}

	public Integer getId() {
		return this.comPublishing.getId();
	}

	public void setId(Integer id) {
		this.comPublishing.setId(id);
	}

	public String getName() {
		return this.comPublishing.getName();
	}

	public void setName(String name) {
		this.comPublishing.setName(name);
	}

	public Region getRegion() {
		String regionName = this.comPublishing.getRegion();
		if (EnumUtils.isDefined(Region.values(), regionName)) {
			return Region.valueOf(regionName);
		}
		return Region.CN;
	}

	public void setRegion(Region region) {
		if (region != null) {
			this.comPublishing.setRegion(region.toString());
		}
	}
	
	public double getWeight(){
		return this.comPublishing.getWeight();
	}

	public void setWeight(double weight) {
		this.comPublishing.setWeight(weight);
	}
	
	public PublishingAgency getAgency() {
		String agency = this.comPublishing.getAgency();
		if (EnumUtils.isDefined(PublishingAgency.values(), agency)) {
			return PublishingAgency.valueOf(agency);
		}
		return null;
	}

	public void setAgency(PublishingAgency agency) {
		if (agency != null) {
			this.comPublishing.setAgency(agency.toString());
		}
	}

	public String getSummary() {
		return this.comPublishing.getSummary();
	}

	public void setSummary(String summary) {
		this.comPublishing.setSummary(summary);
	}

	public String getDescription() {
		return this.comPublishing.getDescription();
	}

	public void setDescription(String description) {
		this.comPublishing.setDescription(description);
	}

}
