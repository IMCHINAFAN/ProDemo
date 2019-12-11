package cn.study.springbootthreadpool.service.impl;

import cn.study.springbootthreadpool.service.AsyncService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: AsyncServiceImpl
 * @author: 10724
 * @date: Created in 2019/11/14
 * @Description:
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static Logger logger = LogManager.getLogger(AsyncServiceImpl.class);

    private Lock lock = new ReentrantLock();

    @Override
    @Async("defaultThreadPool")
    public int sale(int num) {
        lock.lock();
        logger.info("线程-" + Thread.currentThread().getId() + "在执行写入");
        num--;
        lock.unlock();
        return num;
    }
}
