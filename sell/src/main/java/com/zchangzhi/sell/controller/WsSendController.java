package com.zchangzhi.sell.controller;

import com.zchangzhi.sell.VO.ResultVO;
import com.zchangzhi.sell.service.WebSocket;
import com.zchangzhi.sell.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
@RestController
@RequestMapping("/getwebsocket")
public class WsSendController {
    @Autowired
    private WebSocket webSocket;

    @PostMapping("/send")
    public ResultVO demo(@RequestParam("typeId") Integer typeId,@RequestParam("deviceId") Integer deviceId){
        System.out.println("执行了");
        if (typeId==0){
            webSocket.sendMessage("关机中...");
        }else if (typeId==1){
            webSocket.sendMessage("开机中...");
        }
        return ResultVOUtil.success();
    }
}
