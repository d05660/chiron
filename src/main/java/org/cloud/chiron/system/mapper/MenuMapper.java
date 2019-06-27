package org.cloud.chiron.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.cloud.chiron.framework.core.BaseMapper;
import org.cloud.chiron.system.model.Menu;

public interface MenuMapper extends BaseMapper<Menu> {
    List<Menu> getMenuList(@Param("level") int level);
}
