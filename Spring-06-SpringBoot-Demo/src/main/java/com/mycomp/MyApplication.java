package com.mycomp;

import com.mycomp.model.Comment;
import com.mycomp.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        Comment comment=new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = SpringApplication.run(MyApplication.class, args);
        CommentService cs = context.getBean(CommentService.class);
        cs.publishComment(comment);

    }

}
