package org.cloud.chiron.system.service;

import java.util.List;

import org.cloud.chiron.common.base.BaseService;
import org.cloud.chiron.system.model.Menu;

public interface IMenuService extends BaseService<Menu> {
    public List<Menu> getTreeData(int level);
}
