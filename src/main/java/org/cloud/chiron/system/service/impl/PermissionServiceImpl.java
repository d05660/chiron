package org.cloud.chiron.system.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.cloud.chiron.common.base.BaseServiceImpl;
import org.cloud.chiron.system.mapper.PermissionMapper;
import org.cloud.chiron.system.model.Permission;
import org.cloud.chiron.system.service.IPermissionService;
import org.springframework.stereotype.Service;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, Permission> implements IPermissionService {

    @Resource
    PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPagePermissions(int pageNum, int pageSize) {
        return this.getAll(pageNum, pageSize);
    }

}
