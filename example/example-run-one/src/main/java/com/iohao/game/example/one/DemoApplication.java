/*
 * # iohao.com . 渔民小镇
 * Copyright (C) 2021 - present double joker （262610965@qq.com） . All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License..
 */
package com.iohao.game.example.one;

import com.iohao.game.example.one.action.DemoCmd;
import com.iohao.game.example.one.server.DemoLogicServer;
import com.iohao.game.external.core.config.ExternalGlobalConfig;
import com.iohao.game.external.core.netty.simple.NettySimpleHelper;

import java.util.List;

/**
 * 启动类
 * <pre>
 *     启动 对外服、网关服、逻辑服; 并生成游戏业务文档
 * </pre>
 * @author 渔民小镇
 * @date 2022-02-24
 */
public class DemoApplication {
    public static void main(String[] args) {

        var accessAuthenticationHook = ExternalGlobalConfig.accessAuthenticationHook;
        // 表示登录才能访问业务方法
        accessAuthenticationHook.setVerifyIdentity(true);
        // 添加不需要登录也能访问的业务方法 (action)
        accessAuthenticationHook.addIgnoreAuthCmd(DemoCmd.cmd, DemoCmd.loginVerify);

        // 游戏对外服端口
        int port = 10100;

        // 逻辑服
        var demoLogicServer = new DemoLogicServer();

        // 启动 对外服、网关服、逻辑服; 并生成游戏业务文档
        NettySimpleHelper.run(port, List.of(demoLogicServer));

        /*
         * 该示例文档地址
         * https://www.yuque.com/iohao/game/zm6qg2
         */
    }
}
