package com.lsgggg123.demo.netty.nio;

import java.nio.IntBuffer;
import java.util.Random;

public class NioDemo {
    public static void main(String[] args) {
        Random random = new Random();
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i = 0;i< intBuffer.capacity(); i++) {
            int randomInt = random.nextInt(20);
            intBuffer.put(randomInt);
        }

        intBuffer.flip();

        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
    }
}
