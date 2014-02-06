package dwz.persistence.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import dwz.business.chapter.ChapterConditionVO;
import dwz.dal.BaseMapper;
import dwz.persistence.beans.ResBook;

@Repository
public interface ResBookMapper extends BaseMapper<ResBook, Integer> {

	// 查询
	List<ResBook> findPageBreakByCondition(ChapterConditionVO vo, RowBounds rb);

	Integer findNumberByCondition(ChapterConditionVO vo);
}
