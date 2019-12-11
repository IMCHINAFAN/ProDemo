package cn.study.pagehelper.service;

import cn.study.pagehelper.bean.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @ClassName: BookService
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
public interface BookService {

    PageInfo<Book> getAllBook();
}
