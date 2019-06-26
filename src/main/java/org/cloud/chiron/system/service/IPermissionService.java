package org.cloud.chiron.system.service;

import java.util.List;

import org.cloud.chiron.common.base.BaseService;
import org.cloud.chiron.system.model.Permission;

public interface IPermissionService extends BaseService<Permission> {
    public List<Permission> getPagePermissions(int pagenum, int pagesize);
}
