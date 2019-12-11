package cn.study.springbootredis.web;

import cn.study.springbootredis.bean.Book;
import cn.study.springbootredis.service.BookService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: BookController
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String getBook(){
        List<Book> bookList = bookService.getAllBook();
        return JSONObject.toJSONString(bookList,true);
    }
}
