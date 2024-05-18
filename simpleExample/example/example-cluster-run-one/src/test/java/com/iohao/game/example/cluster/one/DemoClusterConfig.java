/*
 * ioGame
 * Copyright (C) 2021 - present  渔民小镇 （262610965@qq.com、luoyizhu@gmail.com） . All Rights Reserved.
 * # iohao.com . 渔民小镇
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.iohao.game.example.cluster.one;

import com.iohao.game.bolt.broker.core.common.IoGameGlobalConfig;
import lombok.experimental.UtilityClass;

import java.util.List;

/**
 * @author 渔民小镇
 * @date 2024-02-25
 */
@UtilityClass
public class DemoClusterConfig {
    /**
     * 种子节点地址
     * <pre>
     *     格式： ip:port
     *
     *     -- 生产环境的建议 --
     *     注意，在生产上建议一台物理机配置一个 broker （游戏网关）
     *     一个 broker 就是一个节点
     *     比如配置三台机器，端口可以使用同样的端口，假设三台机器的 ip 分别是:
     *     192.168.1.10:30056
     *     192.168.1.11:30056
     *     192.168.1.12:30056
     *
     *     -- 为了方便演示 --
     *     这里配置写死是方便在一台机器上启动集群
     *     但是同一台机器启动多个 broker 来实现集群就要使用不同的端口，因为《端口被占用，不能相同》
     *     所以这里的配置是：
     *     127.0.0.1:30056
     *     127.0.0.1:30057
     *     127.0.0.1:30058
     * </pre>
     */
    public List<String> seedAddress = List.of(
            "127.0.0.1:30056"
            , "127.0.0.1:30057"
            , "127.0.0.1:30058"
    );

    public void defaultConfig() {
        // true 开启集群相关日志
        IoGameGlobalConfig.brokerClusterLog = true;
    }

}
