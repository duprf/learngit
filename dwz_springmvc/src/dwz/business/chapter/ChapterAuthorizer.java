/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2013-03-11 20:46:12 by code generator
 */
package dwz.business.chapter;

import dwz.business.common.AuthorServiceMgr;
import dwz.business.common.AuthorizerServiceMgr;
import dwz.business.common.PublishingServiceMgr;
import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.business.BusinessFactory;
import dwz.persistence.beans.ResChapterAuthorizer;

public class ChapterAuthorizer extends AbstractBusinessObject{
	private static final long serialVersionUID = 1L;
	private ResChapterAuthorizer resChapterAuthorizer;
	
	
	/* generateConstructor */
	public ChapterAuthorizer() {
		this.resChapterAuthorizer = new ResChapterAuthorizer();
	}
	public ChapterAuthorizer(ResChapterAuthorizer resChapterAuthorizer) {
		this.resChapterAuthorizer = resChapterAuthorizer;
	}
	public ResChapterAuthorizer getResChapterAuthorizer(){
		return this.resChapterAuthorizer;
	}

	
	public Integer getId() {
		return this.resChapterAuthorizer.getId();
	}

	public void setId(Integer id) {
		this.resChapterAuthorizer.setId(id);
	}
	
	public int getChapterId() {
		Integer value = this.resChapterAuthorizer.getChapterId();
		return value != null ? value : 0;
	}

	public void setChapterId(int chapterId) {
		this.resChapterAuthorizer.setChapterId(chapterId);
	}
	
	public int getRelativeId() {
		Integer value = this.resChapterAuthorizer.getRelativeId();
		return value != null ? value : 0;
	}

	public void setRelativeId(int relativeId) {
		this.resChapterAuthorizer.setRelativeId(relativeId);
	}
	
	public String getRelativeType() {
		return this.resChapterAuthorizer.getRelativeType();
	}

	public void setRelativeType(String relativeType) {
		this.resChapterAuthorizer.setRelativeType(relativeType);
	}
	public String getName(){
		String relativeType = getRelativeType();
		int relativeId = getRelativeId();
		String name = "";
		if("author".equals(relativeType)){
			AuthorServiceMgr authorMgr = BusinessFactory.getInstance()
			.getService(AuthorServiceMgr.SERVICE_NAME);
			name = authorMgr.getAuthor(relativeId).getName();
		}else if("publishing".equals(relativeType)){
			PublishingServiceMgr publishingMgr = BusinessFactory.getInstance()
			.getService(PublishingServiceMgr.SERVICE_NAME);
			name = publishingMgr.getPublishing(relativeId).getName();
		}else if("thirdparty".equals(relativeType)){
			AuthorizerServiceMgr authorizerMgr = BusinessFactory.getInstance()
			.getService(AuthorizerServiceMgr.SERVICE_NAME);
			name = authorizerMgr.getAuthorizer(relativeId).getName();
		}
		return name;
	}
	
	public int getSequence() {
		Integer value = this.resChapterAuthorizer.getSequence();
		return value != null ? value : 0;
	}

	public void setSequence(int sequence) {
		this.resChapterAuthorizer.setSequence(sequence);
	}

}

