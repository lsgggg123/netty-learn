package com.lsgggg123.demo.netty.heartbeat.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class HeartBeatServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "read idle";
                    break;
                case WRITER_IDLE:
                    eventType = "write idle";
                    break;
                case ALL_IDLE:
                    eventType = "read write idle";
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + event.state());
            }
            System.out.println(ctx.channel().remoteAddress() + "-event type: " + eventType);
            ctx.channel().close();
        }
    }
}
