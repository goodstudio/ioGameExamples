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
package com.iohao.game.example.endpoint.animal;

import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilder;
import com.iohao.game.action.skeleton.core.BarSkeletonBuilderParamConfig;
import com.iohao.game.action.skeleton.core.flow.attr.FlowAttr;
import com.iohao.game.action.skeleton.core.flow.internal.DebugInOut;
import com.iohao.game.bolt.broker.client.AbstractBrokerClientStartup;
import com.iohao.game.bolt.broker.core.client.BrokerClientBuilder;
import com.iohao.game.example.endpoint.animal.action.AnimalAction;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 渔民小镇
 * @date 2023-06-06
 */
@Slf4j
public class AnimalLogicServer extends AbstractBrokerClientStartup {
    @Override
    public BarSkeleton createBarSkeleton() {
        // 业务框架构建器 配置
        var config = new BarSkeletonBuilderParamConfig()
                // 扫描 action 类所在包
                .scanActionPackage(AnimalAction.class);

        BarSkeletonBuilder builder = config.createBuilder();

        DebugInOut debugInOut = new DebugInOut();
        builder.addInOut(debugInOut);
        debugInOut.setPrintConsumer((msg, flowContext) -> {
            String tag = flowContext.option(FlowAttr.logicServerTag);
            String logicServerId = flowContext.option(FlowAttr.logicServerId);
            System.out.println();
            int[] bindingLogicServerIds = flowContext.getHeadMetadata().getBindingLogicServerIds();
            log.info("绑定的游戏逻辑服id : {}", bindingLogicServerIds);
            log.info("{}-{}", tag, logicServerId);
        });

        return builder.build();
    }

    @Override
    public BrokerClientBuilder createBrokerClientBuilder() {
        // 因为要在一个进程中启动多个相同的逻辑服
        // 不在这里设置了，在启动类中设置
        return null;
    }
}
