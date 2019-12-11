package cn.study.pagehelper.service.impl;

import cn.study.pagehelper.bean.Book;
import cn.study.pagehelper.dao.BookMapper;
import cn.study.pagehelper.service.BookService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PageInfo<Book> getAllBook() {
        List<Book> userList = bookMapper.getAllBook();
        PageInfo<Book> bookPageInfo = new PageInfo<>(userList);
        return bookPageInfo;
    }
}
