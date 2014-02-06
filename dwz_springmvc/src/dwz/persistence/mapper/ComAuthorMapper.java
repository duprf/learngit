package dwz.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.ComAuthor;

@Repository
public interface ComAuthorMapper extends BaseMapper<ComAuthor, Integer> {

	// 查询
	List<ComAuthor> findPageBreakByCondition(@Param("keywords") String keywords,
			RowBounds rb);

	Integer findNumberByCondition(@Param("keywords") String keywords);

	List<ComAuthor> findAllByChapter(@Param("chapterId") Integer chapterId);
	
	ComAuthor findByChapter(@Param("chapterId") Integer chapterId, @Param("authorType") String authorType);
}
