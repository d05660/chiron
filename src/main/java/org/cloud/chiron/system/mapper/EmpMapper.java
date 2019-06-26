package org.cloud.chiron.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cloud.chiron.common.base.BaseMapper;
import org.cloud.chiron.system.model.Emp;

public interface EmpMapper extends BaseMapper<Emp> {
    int updateStatusByPrimaryKey(@Param("id") Long id, @Param("status") int status);

    List<Emp> selectAllByCondition(@Param("username") String username, @Param("deptName") String deptName);

    Long selectCountByCondition(@Param("username") String username, @Param("deptName") String deptName);
}
