package cn.study.springbootredis.service;

import cn.study.springbootredis.bean.Book;

import java.util.List;

/**
 * @ClassName: BookService
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
public interface BookService {

    List<Book> getAllBook();
}
