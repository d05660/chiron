package org.cloud.chiron.system.service;

import org.cloud.chiron.framework.core.BaseService;
import org.cloud.chiron.system.model.SysLog;

public interface ISysLogService extends BaseService<SysLog> {

    public void clearLogs();

}
