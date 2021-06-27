package com.lsgggg123.demo.netty.proto.client;

import com.lsgggg123.demo.netty.proto.DataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class ProtoClientHandler extends SimpleChannelInboundHandler<DataInfo.Data> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, DataInfo.Data msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        DataInfo.Data data = DataInfo.Data.newBuilder().setName("John").setAge(23).setAddress("bj").build();
        ctx.channel().writeAndFlush(data);
    }
}
