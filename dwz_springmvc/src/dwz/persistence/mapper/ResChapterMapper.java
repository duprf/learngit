package dwz.persistence.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import dwz.business.chapter.ChapterConditionVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.ResChapter;

@Repository
public interface ResChapterMapper extends BaseMapper<ResChapter, Integer> {

	List<ResChapter> findByRelativeIdAndType(Integer relativeId, String relativeType);

	// 查询
	List<ResChapter> findPageBreakByCondition(ChapterConditionVO vo, RowBounds rb);

	Integer findNumberByCondition(ChapterConditionVO vo);
	
	List<ResChapter> findNotInitContent();

	int countByAuthorId(@Param("authorId")int authorId);
	int countByRelativeIdAndType(@Param("relativeId") int relativeId,
			@Param("relativeType") String relativeType);
	
	void updateStatus(@Param("id")int id, @Param("status") String status);
	
}
