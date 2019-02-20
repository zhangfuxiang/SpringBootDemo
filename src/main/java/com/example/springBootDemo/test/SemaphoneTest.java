package com.example.springBootDemo.test;

import java.util.concurrent.Semaphore;

/**
 * @Auther: zhangfx
 * @Date: 2019/2/11 17:32
 * @Description:
 */
public class SemaphoneTest {

    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(10,false);
        while (true) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+
                    "进入停车场，占用一个停车位。");
                    Thread.sleep((long) (Math.random()*1000));
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+
                            "离开停车场。。。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
