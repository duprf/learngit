/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2013-03-09 23:32:07 by code generator
 */
package dwz.business.chapter;

import java.util.Date;
import java.util.List;

import dwz.business.book.Book;
import dwz.business.book.BookServiceMgr;
import dwz.business.common.Author;
import dwz.business.common.AuthorServiceMgr;
import dwz.business.common.AuthorType;
import dwz.business.common.Category;
import dwz.business.common.CategoryServiceMgr;
import dwz.business.common.Publishing;
import dwz.business.common.PublishingServiceMgr;
import dwz.business.enums.ChapterRelativeType;
import dwz.business.enums.ChapterStatus;
import dwz.common.util.EnumUtils;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.business.BusinessFactory;
import dwz.persistence.beans.ResChapter;

public class Chapter extends AbstractBusinessObject {
	private static final long serialVersionUID = 1L;
	private ResChapter resChapter;
	private List<ChapterAuthorizer> authorizerList;
	private List<Author> authorList;

	// 增加solr索引项
	private RelativeSolr relativeSolr;// 针对不同的文献类型（期刊，图书，法规，词典）

	/* generateConstructor */
	public Chapter() {
		this.resChapter = new ResChapter();
		this.resChapter.setStatus(ChapterStatus.active.toString());
	}

	public Chapter(ResChapter resChapter) {
		this.resChapter = resChapter;
	}

	public ResChapter getResChapter() {
		return this.resChapter;
	}

	public Integer getId() {
		return this.resChapter.getId();
	}

	public void setId(Integer id) {
		this.resChapter.setId(id);
	}

	public int getRelativeId() {
		Integer value = this.resChapter.getRelativeId();
		return value != null ? value : 0;
	}

	public void setRelativeId(int relativeId) {
		this.resChapter.setRelativeId(relativeId);
	}

	public ChapterRelativeType getRelativeTypeEnum() {
		if (EnumUtils.isDefined(ChapterRelativeType.values(), resChapter.getRelativeType()))
			return ChapterRelativeType.valueOf(resChapter.getRelativeType());

		return null;
	}

	public String getRelativeType() {
		return resChapter.getRelativeType();
	}

	public void setRelativeType(String relativeType) {
		this.resChapter.setRelativeType(relativeType);
	}

	public String getChapterNo() {
		return this.resChapter.getChapterNo();
	}

	public void setChapterNo(String chapterNo) {
		this.resChapter.setChapterNo(chapterNo);
	}

	public String getNameCn() {
		return this.resChapter.getNameCn();
	}

	public void setNameCn(String nameCn) {
		this.resChapter.setNameCn(nameCn);
	}

	public String getNameEn() {
		return this.resChapter.getNameEn();
	}

	public void setNameEn(String nameEn) {
		this.resChapter.setNameEn(nameEn);
	}

	public String getSummary() {
		return this.resChapter.getSummary();
	}

	public void setSummary(String summary) {
		this.resChapter.setSummary(summary);
	}

	public String getPath() {
		return this.resChapter.getPath();
	}

	public void setPath(String path) {
		this.resChapter.setPath(path);
	}

	public String getPdf2jsonUri() {
		String path = getPath();

		if (path == null || path.length() == 0)
			return null;

		int lastIndex = path.lastIndexOf(".");
		if (lastIndex >= 0) {
			return getAppConfig().getBaseReaderUri() + path.substring(0, lastIndex);
		}

		return null;
	}

	public String getKeywords() {
		return this.resChapter.getKeywords();
	}

	public void setKeywords(String keywords) {
		this.resChapter.setKeywords(keywords);
	}

	public boolean isInitContent() {
		Boolean value = this.resChapter.getInitContent();
		return value != null ? value : false;
	}

	public void setInitContent(boolean initContent) {
		this.resChapter.setInitContent(initContent);
	}

	public int getStartPageNo() {
		Integer value = this.resChapter.getStartPageNo();
		return value != null ? value : 0;
	}

	public void setStartPageNo(int startPageNo) {
		this.resChapter.setStartPageNo(startPageNo);
	}

	public int getPageCount() {
		Integer value = this.resChapter.getPageCount();
		return value != null ? value : 0;
	}

	public void setPageCount(int pageCount) {
		this.resChapter.setPageCount(pageCount);
	}

	public int getPublicCount() {
		Integer value = this.resChapter.getPublicCount();
		return value != null ? value : 0;
	}

	public void setPublicCount(int publicCount) {
		this.resChapter.setPublicCount(publicCount);
	}

	public ChapterStatus getStatus() {
		if (EnumUtils.isDefined(ChapterStatus.values(), resChapter.getStatus())) {
			return ChapterStatus.valueOf(resChapter.getStatus());
		}
		return ChapterStatus.active;
	}

	public void setStatus(ChapterStatus status) {
		if (status != null) {
			this.resChapter.setStatus(status.toString());
		}
	}

	public Date getInsertDate() {
		return this.resChapter.getInsertDate();
	}

	public void setInsertDate(Date insertDate) {
		this.resChapter.setInsertDate(insertDate);
	}

	public Date getUpdateDate() {
		return this.resChapter.getUpdateDate();
	}

	public void setUpdateDate(Date updateDate) {
		this.resChapter.setUpdateDate(updateDate);
	}

	public List<ChapterAuthorizer> getAuthorizerList() {
		return authorizerList;
	}

	public void setAuthorizerList(List<ChapterAuthorizer> authorizerList) {
		this.authorizerList = authorizerList;
	}

	public RelativeSolr getRelativeSolr() {
		if (relativeSolr != null)
			return relativeSolr;

		relativeSolr = new RelativeSolr();
		if (getRelativeId() > 0) {

			switch (getRelativeTypeEnum()) {

			case book:
				BookServiceMgr bookMgr = BusinessFactory.getInstance().getService(BookServiceMgr.SERVICE_NAME);
				Book book = bookMgr.getBook(getRelativeId());
				if (book != null) {

					relativeSolr.setPublishDate(book.getPublishDate());
					relativeSolr.setRelativeNameCn(book.getNameCn());
					relativeSolr.setRelativeNameEn(book.getNameEn());
					relativeSolr.setRelativeSn(book.getSn());

					if (book.getPublishingId() > 0) {
						PublishingServiceMgr publishingMgr = BusinessFactory.getInstance().getService(PublishingServiceMgr.SERVICE_NAME);
						Publishing publishing = publishingMgr.getPublishing(book.getPublishingId());
						relativeSolr.setPublishing(publishing);
					}

					if (book.getCategoryId() > 0) {
						CategoryServiceMgr categoryMgr = BusinessFactory.getInstance().getService(CategoryServiceMgr.SERVICE_NAME);
						Category category = categoryMgr.getCategory(book.getCategoryId());
						relativeSolr.setCategory(category);
					}
				}
				break;

			default:
				break;
			}

		}
		return relativeSolr;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	public List<Author> getAuthorList() {
		if (authorList == null) {
			AuthorServiceMgr authorMgr = BusinessFactory.getInstance().getService(AuthorServiceMgr.SERVICE_NAME);
			authorList = authorMgr.listAuthorByChapter(this.getId());
		}
		return authorList;
	}

	public Author getAuthor() {
		int chapterId = this.getId();
		if (chapterId > 0) {
			AuthorServiceMgr authorMgr = BusinessFactory.getInstance().getService(AuthorServiceMgr.SERVICE_NAME);
			return authorMgr.getAuthorByChapter(chapterId, AuthorType.author);
		}
		return null;
	}

	public int getParentCategoryId() {
		Integer value = this.resChapter.getParentCategoryId();
		return value != null ? value : 0;
	}

	public void setParentCategoryId(int categoryId) {
		this.resChapter.setParentCategoryId(categoryId);
	}

	public Category getParentCategory() {
		int categoryId = getParentCategoryId();
		if (categoryId > 0) {
			CategoryServiceMgr categoryMgr = BusinessFactory.getInstance().getService(CategoryServiceMgr.SERVICE_NAME);
			return categoryMgr.getCategory(categoryId);
		}
		return null;
	}

	public int getCategoryId1() {
		Integer value = this.resChapter.getCategoryId1();
		return value != null ? value : 0;
	}

	public void setCategoryId1(int categoryId) {
		this.resChapter.setCategoryId1(categoryId);
	}

	public Category getCategory1() {
		int categoryId = getCategoryId1();
		if (categoryId > 0) {
			CategoryServiceMgr categoryMgr = BusinessFactory.getInstance().getService(CategoryServiceMgr.SERVICE_NAME);
			return categoryMgr.getCategory(categoryId);
		}
		return null;
	}

	public int getCategoryId2() {
		Integer value = this.resChapter.getCategoryId2();
		return value != null ? value : 0;
	}

	public void setCategoryId2(int categoryId) {
		this.resChapter.setCategoryId2(categoryId);
	}

	public Category getCategory2() {
		int categoryId = getCategoryId2();
		if (categoryId > 0) {
			CategoryServiceMgr categoryMgr = BusinessFactory.getInstance().getService(CategoryServiceMgr.SERVICE_NAME);
			return categoryMgr.getCategory(categoryId);
		}
		return null;
	}
}
