package cn.study.springbootredis.dao;

import cn.study.springbootredis.bean.Book;

import java.util.List;

/**
 * @ClassName: BookMapper
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
public interface BookMapper {

    List<Book> getAllBook();
}
