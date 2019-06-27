package org.cloud.chiron.system.mapper;

import org.cloud.chiron.framework.core.BaseMapper;
import org.cloud.chiron.system.model.Role;

public interface RoleMapper extends BaseMapper<Role> {

    void addRolePermission(long roleid, long permissionid);

    void deleteRolePermission(long roleid, long permissionid);// 删除一个角色和一个权限的关联

    void deleteRoles(long roleid);// 删除一个角色的所有权限关联

}
