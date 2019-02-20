package com.example.springBootDemo.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: zhangfx
 * @Date: 2019/2/11 17:08
 * @Description:
 */
public class CyclicBarrierTest {

    private static Integer count=0;
    public static void main(String[] args) {
        CyclicBarrier barrier=new CyclicBarrier(20,()->{
            if (count==0){
                System.out.println("班车准备开始运营。。。");
                count++;
            }else {
                System.out.println("车上座位已经满了，请等待下一班！");
                count++;
            }

        });

        for (int i = 0; i < 120; i++) {
            new Thread(()->{
                try {
                    Thread.sleep((long) (Math.random()*1000));
                    barrier.await();
                    System.out.println(Thread.currentThread().getName()
                    +"赶上了第"+count+"趟班车。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
