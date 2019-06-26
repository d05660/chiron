package org.cloud.chiron.system.mapper;

import org.cloud.chiron.common.base.BaseMapper;
import org.cloud.chiron.system.model.Permission;

public interface PermissionMapper extends BaseMapper<Permission> {
    void deletePermissionsById(Long permissionid);
}
