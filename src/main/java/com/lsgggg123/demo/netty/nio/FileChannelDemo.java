package com.lsgggg123.demo.netty.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("pom.xml");
        FileChannel channel = fileInputStream.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        channel.read(byteBuffer);

        byteBuffer.flip();

        while (byteBuffer.remaining() > 0) {
            char b = (char) byteBuffer.get();
            System.out.print(b);
        }
        channel.close();
    }
}
