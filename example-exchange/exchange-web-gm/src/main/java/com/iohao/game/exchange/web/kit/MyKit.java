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
package com.iohao.game.exchange.web.kit;

import com.iohao.game.action.skeleton.core.BarSkeleton;
import com.iohao.game.bolt.broker.core.client.BrokerClient;
import com.iohao.game.exchange.web.kit.UserFlowContext;
import lombok.experimental.UtilityClass;

/**
 * @author 渔民小镇
 * @date 2024-03-13
 */
@UtilityClass
public class MyKit {
    public BarSkeleton barSkeleton;
    public BrokerClient brokerClient;

    public UserFlowContext ofUserFlowContext(long userId) {
        return UserFlowContext.of(userId, barSkeleton);
    }
}
