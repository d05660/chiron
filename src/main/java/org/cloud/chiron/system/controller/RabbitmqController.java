package org.cloud.chiron.system.controller;

import org.cloud.chiron.common.util.CommandLine;
import org.cloud.chiron.common.util.ResultBean;
import org.cloud.chiron.framework.amqp.CommandSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/amqp")
public class RabbitmqController {

    @Autowired
    private CommandSender ipMessageSender;

    @GetMapping("/getipaddress")
    @ResponseBody
    public ResultBean sendIPCaller() {
        CommandLine commandLine = new CommandLine("192.168.1.100");
        ipMessageSender.sendExchangeMsg(commandLine);
        return ResultBean.success();
    }

}
