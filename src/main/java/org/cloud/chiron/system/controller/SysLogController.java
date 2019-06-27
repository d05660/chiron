package org.cloud.chiron.system.controller;

import java.util.List;

import javax.annotation.Resource;

import org.cloud.chiron.common.util.PageResultBean;
import org.cloud.chiron.common.util.ResultBean;
import org.cloud.chiron.framework.annotation.OperationLog;
import org.cloud.chiron.system.model.SysLog;
import org.cloud.chiron.system.service.ISysLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/syslog")
public class SysLogController {

    @Resource
    private ISysLogService sysLogService;

    @OperationLog("查看操作日志")
    @GetMapping("/list")
    @ResponseBody
    public PageResultBean<SysLog> listSysLogs(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<SysLog> loginLogs = sysLogService.getAll(page, limit);
        long count = sysLogService.getCount(new SysLog());
        return new PageResultBean<SysLog>(count, loginLogs);
    }

    @OperationLog("清空操作日志")
    @PostMapping("/clear")
    @ResponseBody
    public ResultBean clearSysLogs() {
        sysLogService.clearLogs();
        return ResultBean.success();
    }


}