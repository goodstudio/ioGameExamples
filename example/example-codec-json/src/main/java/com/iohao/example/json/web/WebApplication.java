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
package com.iohao.example.json.web;

import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.Solon;

/**
 * @author 渔民小镇
 * @date 2023-02-01
 */
@Slf4j
public class WebApplication {
    public static void start(int serverPort) {

        Solon.start(WebApplication.class, new String[]{"server.port=" + serverPort}, app -> {

            //在后端把 / 变成 /index.html
            app.filter((ctx, chain) -> {
                if ("/".equals(ctx.pathNew())) {
                    ctx.pathNew("/index.html");
                }

                chain.doFilter(ctx);
            });

        });
    }

    public static void main(String[] args) {
        start(8080);
    }
}
