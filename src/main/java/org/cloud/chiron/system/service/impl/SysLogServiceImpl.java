package org.cloud.chiron.system.service.impl;

import javax.annotation.Resource;

import org.cloud.chiron.common.base.BaseServiceImpl;
import org.cloud.chiron.system.mapper.SysLogMapper;
import org.cloud.chiron.system.model.SysLog;
import org.cloud.chiron.system.service.ISysLogService;
import org.springframework.stereotype.Service;

@Service("sysLogService")
public class SysLogServiceImpl extends BaseServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

    @Resource
    private SysLogMapper sysLogMapper;

    @Override
    public void clearLogs() {
        sysLogMapper.clearLogs();
    }

}
