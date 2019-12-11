package cn.study.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: SessionController
 * @author: 10724
 * @date: Created in 2019/11/13
 * @Description:
 */
@RestController
public class SessionController {

    @GetMapping("/setSession")
    public String setSession(HttpSession session) {
        session.setAttribute("url", "http://www.helloworld.com");
        return "ok";
    }

    @GetMapping("/getSession")
    public String getSession(HttpSession session) {
        String url = (String) session.getAttribute("url");
        return null == url ? "no session" : url;
    }
}
