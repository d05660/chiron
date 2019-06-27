package org.cloud.chiron.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cloud.chiron.framework.core.BaseServiceImpl;
import org.cloud.chiron.system.mapper.MenuMapper;
import org.cloud.chiron.system.model.Menu;
import org.cloud.chiron.system.service.IMenuService;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl extends BaseServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;
    
    @Override
    public List<Menu> getTreeData(int level) {
        return menuMapper.getMenuList(level);
    }

}
