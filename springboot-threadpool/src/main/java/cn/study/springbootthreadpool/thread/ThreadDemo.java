package cn.study.springbootthreadpool.thread;

import org.apache.tomcat.jni.Thread;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: threadDemo
 * @author: 10724
 * @date: Created in 2019/11/19
 * @Description:
 */
public class ThreadDemo {

    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;

    /**
     * 多线程将耗时程序并发执行，
     * 当并发执行时，会发生数据脏读等现象
     * 使用锁，synchoronized，volatile关键字来维护
     */
    public void demo(){

        /**
         * 使用循环来模拟多用户请求场景
         * 秒杀场景中：压力最大的是商品详情页和下单
         * 前端可以使用nginx优化，
         * 下单使用redis和zookeeper等
         */
        for(int i=0;i<100;i++){
            threadPoolExecutor.execute(()->{
                System.out.println();
                //放执行的内容
            });
        }

    }
}
