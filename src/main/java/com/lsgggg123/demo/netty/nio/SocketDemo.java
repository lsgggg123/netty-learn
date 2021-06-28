package com.lsgggg123.demo.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ss = ServerSocketChannel.open();
        ss.socket().bind(new InetSocketAddress(8899));

        int length = 2 + 3 + 4;
        ByteBuffer[] byteBuffers = new ByteBuffer[3];
        byteBuffers[0] = ByteBuffer.allocate(2);
        byteBuffers[1] = ByteBuffer.allocate(3);
        byteBuffers[2] = ByteBuffer.allocate(4);

        SocketChannel socketChannel = ss.accept();

        int readLength = 0;
        while (readLength < length) {
            long read = socketChannel.read(byteBuffers);
            readLength += read;
            System.out.println("read: " + read);

            Arrays.stream(byteBuffers).map(b -> "position: " + b.position() + ", limit: " + b.limit()).forEach(System.out::println);
        }

        Arrays.asList(byteBuffers).forEach(Buffer::flip);

        int writeLength = 0;
        while (writeLength < length) {
            long write = socketChannel.write(byteBuffers);
            writeLength += write;
            System.out.println("write: " + write);

            Arrays.stream(byteBuffers).map(b -> "position: " + b.position() + ", limit: " + b.limit()).forEach(System.out::println);
        }

        Arrays.asList(byteBuffers).forEach(Buffer::clear);

        System.out.println(readLength);
        System.out.println(writeLength);
    }

}
