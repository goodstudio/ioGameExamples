/*
 * # iohao.com . 渔民小镇
 * Copyright (C) 2021 - present double joker （262610965@qq.com） . All Rights Reserved.
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
package com.iohao.game.example.interaction.weather.action;

import com.iohao.game.action.skeleton.annotation.ActionController;
import com.iohao.game.action.skeleton.annotation.ActionMethod;
import com.iohao.game.action.skeleton.core.CmdInfo;
import com.iohao.game.action.skeleton.core.flow.FlowContext;
import com.iohao.game.example.interaction.msg.DemoWeatherMsg;
import com.iohao.game.example.interaction.msg.MatchMsg;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.concurrent.atomic.LongAdder;

/**
 * 天气 action
 *
 * @author 渔民小镇
 * @date 2022-03-24
 */
@Slf4j
@ActionController(DemoCmdForWeather.cmd)
public class DemoWeatherAction {
    public static LongAdder longAdder = new LongAdder();

    /**
     * 今天天气情况
     *
     * @return 天气响应
     */
    @ActionMethod(DemoCmdForWeather.todayWeather)
    public DemoWeatherMsg todayWeather(FlowContext flowContext) {
        // 当前时间
        int value = Calendar.getInstance().get(Calendar.SECOND);

        DemoWeatherMsg demoWeatherMsg = new DemoWeatherMsg();
        // 根据当前时间来增加战斗力
        demoWeatherMsg.attack = value;
        return demoWeatherMsg;
    }

    @ActionMethod(DemoCmdForWeather.createRoom)
    public void createRoom(MatchMsg matchMsg, FlowContext flowContext) {
        CmdInfo createRoomCmd = CmdInfo.of(DemoCmdForWeather.cmd, DemoCmdForWeather.createRoom);
        // 全服广播：路由、业务数据
        flowContext.broadcast(createRoomCmd, matchMsg);
    }
}
