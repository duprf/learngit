package dwz.persistence.mapper;

import java.util.Date;
import java.util.List;

import dwz.dal.BaseMapper;
import dwz.persistence.beans.SysCompany;
import dwz.persistence.beans.SysUser;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

@Repository
public interface SysCompanyMapper extends BaseMapper<SysCompany,Integer>{
	
	void updateStatus(@Param("id") int id, @Param("status") String userStatus,
			@Param("updateDate") Date updateDate);
	
	// 查询
	List<SysCompany> findPageBreakByCondition(
			@Param("status") String status,
			@Param("keywords") String keywords,
			@Param("startInsertDate") Date startInsertDate,
			@Param("endInsertDate") Date endInsertDate, RowBounds rb);

	Integer findNumberByCondition(
			@Param("status") String status,
			@Param("keywords") String keywords,
			@Param("startInsertDate") Date startInsertDate,
			@Param("endInsertDate") Date endInsertDate);
}
