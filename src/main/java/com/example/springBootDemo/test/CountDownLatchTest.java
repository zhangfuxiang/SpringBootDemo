package com.example.springBootDemo.test;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: zhangfx
 * @Date: 2019/2/11 17:22
 * @Description:
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                try {
                    Thread.sleep((long) (Math.random()*1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+
                "拼团成功。。。。");
                latch.countDown();
            }).start();
        }
        try {
            latch.await();
            System.out.println("三人拼团成功，商家发货！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
