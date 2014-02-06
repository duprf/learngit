package dwz.business.chapter;

import java.io.File;
import java.util.List;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface ChapterServiceMgr extends BusinessObjectServiceMgr {
	String SERVICE_NAME = "chapterServiceMgr";
	
	Chapter getChapter(int id);
	void addChapter(Chapter chapter, File file);
	void updChapter(Chapter chapter);
	void delChapter(int id);
	
	List<Chapter> searchChapters(ChapterConditionVO vo);
	Integer searchChaptersNum(ChapterConditionVO vo);
	
	void initChaptersContent();
	//for test
	void initAllChaptersContent();
	
}
