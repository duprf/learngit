package dwz.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.ResChapterAuthorizer;

@Repository
public interface ResChapterAuthorizerMapper extends
		BaseMapper<ResChapterAuthorizer, Integer> {
	Integer deleteByChapterId(@Param("chapterId") Integer chapterId);
	List<ResChapterAuthorizer> findChapterAuthorizer(@Param("chapterId") Integer chapterId);
	int countByRelativeIdAndType(@Param("relativeId") int relativeId,
			@Param("relativeType") String relativeType);

}
