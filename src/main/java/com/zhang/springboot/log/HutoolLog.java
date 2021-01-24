package com.zhang.springboot.log;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.zhang.springboot.websocket.WebSocketServer;

public class HutoolLog {
    private static Log log = LogFactory.get(WebSocketServer.class);

    public static void main(String[] args) {
        log.debug("Huool日志记录{}","default");
    }
}
