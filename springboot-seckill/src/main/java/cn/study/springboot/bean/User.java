package cn.study.springboot.bean;

import java.io.Serializable;

/**
 * @ClassName: User
 * @author: 10724
 * @date: Created in 2019/11/20
 * @Description:
 */
public class User implements Serializable {
    private static final long serialVersionUID = 2470041644534199877L;
    private Integer userId;
    private String userName;

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
