package com.lsgggg123.demo.netty.proto.server;

import com.lsgggg123.demo.netty.proto.DataInfo;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

public class ProtoServerHandler extends SimpleChannelInboundHandler<DataInfo.Data> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Data msg) throws Exception {
        System.out.println(msg.getName());
        System.out.println(msg.getAge());
        System.out.println(msg.getAddress());
    }
}
