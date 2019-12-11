package cn.study.springbootredis.service.impl;

import cn.study.springbootredis.bean.Book;
import cn.study.springbootredis.dao.BookMapper;
import cn.study.springbootredis.service.BookService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: BookServiceImpl
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    private static Lock lock = new ReentrantLock();

    @Override
    public List<Book> getAllBook() {
        List<Book> userList = new ArrayList<>();
        userList = (List<Book>) redisTemplate.opsForValue().get("userlist") ;
        /**
         * 并发时，会出现缓存穿透
         * 当大量的用户同时访问未缓存的数据时，会发生大量请求数据库的现象，称之为缓存穿透
         * 通过双重检测锁的方式可以解决
         * 但在分布式的集群中，因为服务器有多台，所有需要使用zookeeper来搭建分布式锁
         */
        if(userList == null){
            lock.lock();
            //双重检测锁
            userList = (List) redisTemplate.opsForValue().get("userlist");
            if(null == userList){
                System.out.println("从数据库中查找");
                userList = bookMapper.getAllBook();
                redisTemplate.opsForValue().set("userlist",userList);
            }
            lock.unlock();
        }
        return userList;
    }
}
