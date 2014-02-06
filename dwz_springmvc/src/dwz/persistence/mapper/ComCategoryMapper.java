package dwz.persistence.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import dwz.dal.BaseMapper;
import dwz.persistence.BaseConditionVO;
import dwz.persistence.beans.ComCategory;

@Repository
public interface ComCategoryMapper extends BaseMapper<ComCategory,Integer>{

	List<ComCategory> findPageBreakByCondition(BaseConditionVO vo,
			RowBounds rb);

	Integer findNumberByCondition(BaseConditionVO vo);

	Integer findNumberByPid(int pid);
	
	Integer findBookNumberById(int id);
	
	Integer procsCategoryInit(@Param("lft") int lft, @Param("pid") int pid);

	/*
	 * find sub categories
	 */
	List<ComCategory> findByPid(int pid);
	
	/*
	 * find parent categories
	 */
	List<ComCategory> findParentCategories(int categoryId);
}
