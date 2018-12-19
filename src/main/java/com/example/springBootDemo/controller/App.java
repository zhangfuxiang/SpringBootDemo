package com.example.springBootDemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @Auther: zhangfx
 * @Date: 2018/12/19 16:27
 * @Description:
 */
public class App {
    private  final  static Logger logger=LoggerFactory.getLogger(App.class);
    public static void main(String[] args) {
        logger.info("logback 成功了");
        logger.error("logback 成功了");
    }
}
