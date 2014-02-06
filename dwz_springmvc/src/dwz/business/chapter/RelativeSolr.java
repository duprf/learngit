/*
 * Solr全文检索，篇章关联数据项
 * 暂时只有期刊，以后再增加图书、法规、词典等
 */
package dwz.business.chapter;

import java.util.Date;

import dwz.business.common.Category;
import dwz.business.common.Publishing;

public class RelativeSolr {
	
	//期刊信息表
	private String relativeSn;
	private String relativeNameEn;
	private String relativeNameCn;
	private Publishing publishing;
	private Category category;
	
	//期刊-卷/期信息表
	private String journalTerm;
	private Date publishDate;

	public RelativeSolr(){
	}

	public String getRelativeSn() {
		return relativeSn;
	}

	public void setRelativeSn(String relativeSn) {
		this.relativeSn = relativeSn;
	}

	public String getRelativeNameEn() {
		return relativeNameEn;
	}

	public void setRelativeNameEn(String relativeNameEn) {
		this.relativeNameEn = relativeNameEn;
	}

	public String getRelativeNameCn() {
		return relativeNameCn;
	}

	public void setRelativeNameCn(String relativeNameCn) {
		this.relativeNameCn = relativeNameCn;
	}

	public String getJournalTerm() {
		return journalTerm;
	}

	public void setJournalTerm(String journalTerm) {
		this.journalTerm = journalTerm;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public Publishing getPublishing() {
		return publishing;
	}

	public void setPublishing(Publishing publishing) {
		this.publishing = publishing;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}
	
	
}

