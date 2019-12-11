package cn.study.email.web;

import cn.study.email.config.EmailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: EmailController
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
@RestController
public class EmailController {

    @Autowired
    EmailConfig emailConfig;

    @GetMapping("/send")
    public String send(){
        try{
            emailConfig.sendSimpleMessage();
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }
}
