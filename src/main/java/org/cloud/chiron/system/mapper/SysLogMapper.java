package org.cloud.chiron.system.mapper;

import org.cloud.chiron.common.base.BaseMapper;
import org.cloud.chiron.system.model.SysLog;

public interface SysLogMapper extends BaseMapper<SysLog> {

    void clearLogs();

}
