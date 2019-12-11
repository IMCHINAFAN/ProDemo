package cn.study.springbootredis.bean;

import java.io.Serializable;

/**
 * @ClassName: Book
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 2553985218723665223L;
    private Long bookId;
    private String bookName;
    private Long number;

    public Book() {
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
