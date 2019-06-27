package org.cloud.chiron.system.mapper;

import org.cloud.chiron.framework.core.BaseMapper;
import org.cloud.chiron.system.model.SysLog;

public interface SysLogMapper extends BaseMapper<SysLog> {

    void clearLogs();

}
