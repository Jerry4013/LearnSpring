package com.imooc.springbootemail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("jingchao.zhang@mail.concordia.ca",
                "Test email",
                "Hello World");
    }

    @Test
    public void sendHTMLMail() throws MessagingException {
        String content = "<html>\n<body>\n<h3> Hello world! This is a HTML email.</h3>\n</body>\n</html>";
        mailService.sendHTMLMail("jingchao.zhang@mail.concordia.ca", "HTML Email", content);
    }

    @Test
    public void sendAttachmentMail() throws MessagingException {
        String filePath = "C:\\Users\\I505998\\Desktop\\imooc.txt";
        mailService.sendAttachmentMail("jingchao.zhang@mail.concordia.ca",
                "Test email",
                "Hello World", filePath);
    }

    @Test
    public void senInlineResourceMail() throws MessagingException {
        String imgPath = "C:\\Users\\I505998\\OneDrive - Concordia University - Canada\\ProgrammingProjects\\LearnSpring\\springbootemail\\src\\main\\resources\\static\\jingchaoZhang.jpg";
        String rscId = "zjc";
        String content = "<html><body><img src=\'cid:" + rscId
                + "\'></img></body></html>";
        mailService.sendInlineResourceMail("jingchao.zhang@mail.concordia.ca", "test", content, imgPath, rscId);
    }

    @Test
    public void templateMail() throws MessagingException {
        Context context = new Context();
//        context.setVariable("id", "006");
        String emailTemplate = templateEngine.process("emailTemplate", context);
        mailService.sendHTMLMail("jingchao.zhang@mail.concordia.ca", "test", emailTemplate);
    }
}