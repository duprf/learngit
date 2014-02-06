/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2013-03-11 20:46:12 by code generator
 */
package dwz.business.common;

import dwz.business.enums.Region;
import dwz.common.util.EnumUtils;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.persistence.beans.ComAuthorizer;

public class Authorizer extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private ComAuthorizer comAuthorizer;
	
	/* generateConstructor */
	public Authorizer() {
		this.comAuthorizer = new ComAuthorizer();
	}
	public Authorizer(ComAuthorizer comAuthorizer) {
		this.comAuthorizer = comAuthorizer;
	}
	public ComAuthorizer getComAuthorizer(){
		return this.comAuthorizer;
	}

	
	public Integer getId() {
		return this.comAuthorizer.getId();
	}

	public void setId(Integer id) {
		this.comAuthorizer.setId(id);
	}
	
	public String getName() {
		return this.comAuthorizer.getName();
	}

	public void setName(String name) {
		this.comAuthorizer.setName(name);
	}
	
	public Region getRegion() {
		String regionName = this.comAuthorizer.getRegion();
		if (EnumUtils.isDefined(Region.values(), regionName)) {
			return Region.valueOf(regionName);
		}
		return Region.CN;
	}

	public void setRegion(Region region) {
		if (region != null) {
			this.comAuthorizer.setRegion(region.toString());
		}
	}
	
	public String getSummary() {
		return this.comAuthorizer.getSummary();
	}

	public void setSummary(String summary) {
		this.comAuthorizer.setSummary(summary);
	}
	
	public String getDescription() {
		return this.comAuthorizer.getDescription();
	}

	public void setDescription(String description) {
		this.comAuthorizer.setDescription(description);
	}

}

