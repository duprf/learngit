/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-07-29 17:54:23 by code generator
 */
package dwz.business.book;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import dwz.business.common.Category;
import dwz.business.common.CategoryServiceMgr;
import dwz.business.common.Publishing;
import dwz.business.common.PublishingServiceMgr;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.business.BusinessFactory;
import dwz.persistence.beans.ResBook;

public class Book extends AbstractBusinessObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6831303272669000452L;
	private ResBook resBook;

	/* generateConstructor */
	public Book() {
		this.resBook = new ResBook();
	}

	public Book(ResBook resBook) {
		this.resBook = resBook;
	}

	public ResBook getResBook() {
		return this.resBook;
	}

	public Integer getId() {
		return this.resBook.getId();
	}
	public void setId(Integer id) {
		this.resBook.setId(id);
	}

	public String getSn() {
		return this.resBook.getSn();
	}

	public void setSn(String sn) {
		this.resBook.setSn(sn);
	}

	public String getNameCn() {
		return this.resBook.getNameCn();
	}

	public void setNameCn(String nameCn) {
		this.resBook.setNameCn(nameCn);
	}

	public String getNameEn() {
		return this.resBook.getNameEn();
	}

	public void setNameEn(String nameEn) {
		this.resBook.setNameEn(nameEn);
	}

	public int getPublishingId() {
		Integer value = this.resBook.getPublishingId();
		return value != null ? value : 0;
	}

	public void setPublishingId(int publishingId) {
		this.resBook.setPublishingId(publishingId);
	}
	
	public Publishing getPublishing() {
		int publishingId = getPublishingId();
		if (publishingId > 0) {
			PublishingServiceMgr publishingMgr = BusinessFactory.getInstance().getService(PublishingServiceMgr.SERVICE_NAME);
			return publishingMgr.getPublishing(publishingId);
		}
		return null;
	}

	public Date getPublishDate() {
		return this.resBook.getPublishDate();
	}

	public void setPublishDate(Date publishDate) {
		this.resBook.setPublishDate(publishDate);
	}

	public String getIconUrl() {
		if (resBook.getIconPath() != null && resBook.getIconPath().length() > 0) {
			return getAppConfig().getBaseUploadUri() + resBook.getIconPath();
		}
		return null;
	}
	public Date getInsertDate() {
		return this.resBook.getInsertDate();
	}

	public void setInsertDate(Date insertDate) {
		this.resBook.setInsertDate(insertDate);
	}

	public Date getUpdateDate() {
		return this.resBook.getUpdateDate();
	}

	public void setUpdateDate(Date updateDate) {
		this.resBook.setUpdateDate(updateDate);
	}

	private Set resChapters = new HashSet(0);

	public void setResChapters(Set resChapter) {
		this.resChapters = resChapter;
	}

	public Set getResChapters() {
		return resChapters;
	}

	public int getCategoryId() {
		Integer value = this.resBook.getCategoryId();
		return value != null ? value : 0;
	}

	public void setCategoryId(int categoryId) {
		this.resBook.setCategoryId(categoryId);
	}
	
	public Category getCategory() {
		int categoryId = getCategoryId();
		if (categoryId > 0) {
			CategoryServiceMgr categoryMgr = BusinessFactory.getInstance()
					.getService(CategoryServiceMgr.SERVICE_NAME);
			return categoryMgr.getCategory(categoryId);
		}
		return null;
	}
	
	public String getDescription() {
		return this.resBook.getDescription();
	}

	public void setDescription(String description) {
		this.resBook.setDescription(description);
	}
}
