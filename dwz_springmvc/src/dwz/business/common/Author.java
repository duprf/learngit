/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2013-03-09 23:32:06 by code generator
 */
package dwz.business.common;

import dwz.business.enums.Region;
import dwz.common.util.EnumUtils;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.business.BusinessFactory;
import dwz.persistence.beans.ComAuthor;

public class Author extends AbstractBusinessObject {
	private static final long serialVersionUID = 1L;
	private ComAuthor comAuthor;

	/* generateConstructor */
	public Author() {
		this.comAuthor = new ComAuthor();
	}

	public Author(ComAuthor comAuthor) {
		this.comAuthor = comAuthor;
	}

	public ComAuthor getComAuthor() {
		return this.comAuthor;
	}

	public Integer getId() {
		return this.comAuthor.getId();
	}

	public void setId(Integer id) {
		this.comAuthor.setId(id);
	}

	public int getCategoryId() {
		Integer value = this.comAuthor.getCategoryId();
		return value != null ? value : 0;
	}

	public void setCategoryId(int categoryId) {
		this.comAuthor.setCategoryId(categoryId);
	}

	public Category getCategory() {
		int categoryId = getCategoryId();
		if (categoryId > 0) {
			CategoryServiceMgr categoryMgr = BusinessFactory.getInstance().getService(CategoryServiceMgr.SERVICE_NAME);
			return categoryMgr.getCategory(categoryId);
		}
		return null;
	}

	public String getIconPath() {
		return this.comAuthor.getIconPath();
	}

	public void setIconPath(String iconPath) {
		this.comAuthor.setIconPath(iconPath);
	}

	public String getSn() {
		return this.comAuthor.getSn();
	}

	public void setSn(String sn) {
		this.comAuthor.setSn(sn);
	}

	public int getUserId() {
		Integer value = this.comAuthor.getUserId();
		return value != null ? value : 0;
	}

	public void setUserId(int userId) {
		this.comAuthor.setUserId(userId);
	}

	public String getName() {
		return this.comAuthor.getName();
	}

	public void setName(String name) {
		this.comAuthor.setName(name);
	}

	public Region getRegion() {
		String regionName = this.comAuthor.getRegion();
		if (EnumUtils.isDefined(Region.values(), regionName)) {
			return Region.valueOf(regionName);
		}
		return Region.CN;
	}

	public void setRegion(Region region) {
		if (region != null) {
			this.comAuthor.setRegion(region.toString());
		}
	}

	public void setAuthorType(AuthorType authorType) {
		if (authorType != null) {
			this.comAuthor.setAuthorType(authorType.toString());
		}
	}

	public AuthorType getAuthorType() {
		String authorType = this.comAuthor.getAuthorType();
		if (EnumUtils.isDefined(AuthorType.values(), authorType)) {
			return AuthorType.valueOf(authorType);
		}
		return AuthorType.author;
	}

	public void setAuthorSequence(Integer authorSequence) {
		this.comAuthor.setAuthorSequence(authorSequence);
	}

	public Integer getAuthorSequence() {
		return this.comAuthor.getAuthorSequence();
	}

	public String getKeywords() {
		return this.comAuthor.getKeywords();
	}

	public void setKeywords(String keywords) {
		this.comAuthor.setKeywords(keywords);
	}

	public String getSummary() {
		return this.comAuthor.getSummary();
	}

	public void setSummary(String summary) {
		this.comAuthor.setSummary(summary);
	}

	public String getDescription() {
		return this.comAuthor.getDescription();
	}

	public void setDescription(String description) {
		this.comAuthor.setDescription(description);
	}

	public String getPdfPath() {
		return this.comAuthor.getPdfPath();
	}

	public void setPdfPath(String pdfPath) {
		this.comAuthor.setPdfPath(pdfPath);
	}

}
