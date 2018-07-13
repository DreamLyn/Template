package com.lyn.common;


import org.junit.Test;

public class ThreadTest {
    @Test
    public void test() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("hello,world1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 删除老的access_token
                    System.out.println("hello,world");
                }
            }
        }).start();
    }
}
