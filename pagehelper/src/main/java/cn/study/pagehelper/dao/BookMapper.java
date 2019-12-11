package cn.study.pagehelper.dao;

import cn.study.pagehelper.bean.Book;

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
