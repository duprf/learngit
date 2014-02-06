package dwz.persistence.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.ResChapterAuthor;

@Repository
public interface ResChapterAuthorMapper extends BaseMapper<ResChapterAuthor,Integer>{
	Integer deleteByChapterId(@Param("chapterId") Integer chapterId);
}
