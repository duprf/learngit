package dwz.persistence.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.BaseConditionVO;
import dwz.persistence.beans.ComPublishing;

@Repository
public interface ComPublishingMapper extends BaseMapper<ComPublishing, Integer> {

	// 查询
	List<ComPublishing> findPageBreakByCondition(BaseConditionVO vo, RowBounds rb);

	Integer findNumberByCondition(BaseConditionVO vo);

	List<ComPublishing> findPublishingWeight();
}
