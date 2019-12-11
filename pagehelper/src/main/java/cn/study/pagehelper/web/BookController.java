package cn.study.pagehelper.web;

import cn.study.pagehelper.bean.Book;
import cn.study.pagehelper.service.BookService;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/getAll")
    public JSONObject getAllBooks(@RequestParam(value="pageNum",defaultValue = "1") int pageNum,
                                      @RequestParam(value="pageSize",defaultValue = "2") int pageSize){
        JSONObject json = new JSONObject();
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Book> pageInfo = bookService.getAllBook();
        json.put("pageInfo",pageInfo);
        return json;
    }

}
