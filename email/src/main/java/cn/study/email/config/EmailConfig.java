package cn.study.email.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @ClassName: EmailConfig
 * @author: 10724
 * @date: Created in 2019/11/11
 * @Description:
 */
@Component
public class EmailConfig {

    @Autowired
    private JavaMailSenderImpl javaMailSender;

    public void sendSimpleMessage(){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("这里设置右键的标题");
        simpleMailMessage.setText("这里设置右键的内容");
        //设置收件人，多个邮箱按照，隔开
        simpleMailMessage.setTo("1072447117@qq.com");
        //设置发件人
        simpleMailMessage.setFrom("1072447117@qq.com");

        javaMailSender.send(simpleMailMessage);
    }

    public void sendFile(String fileName, File file){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            //第二个参数，是否可以上传文件，第三项可以设置编码格式
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");

            messageHelper.setSubject("这里设置右键的标题");
            messageHelper.setText("这里设置右键的内容");
            //设置收件人，多个邮箱按照，隔开
            messageHelper.setTo("1072447117@qq.com");
            //设置发件人
            messageHelper.setFrom("1072447117@qq.com");

            /**
             * 设置右键发送文件，可以发送数据流或文件
             * 可以上传多个文件，多次调用addAttachment即可
             */
            messageHelper.addAttachment(fileName,file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

}
