package org.cloud.chiron.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cloud.chiron.common.base.BaseMapper;
import org.cloud.chiron.system.model.Menu;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getMenuList(@Param("level") int level);
}
