package dwz.persistence.mapper;

import java.util.List;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.ComAuthorizer;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface ComAuthorizerMapper extends BaseMapper<ComAuthorizer,Integer>{

	List<ComAuthorizer> findPageBreakByCondition(@Param("keywords")String keywords, RowBounds rb);

	Integer findNumberByCondition(@Param("keywords")String keywords);
	

}
