package com.myApp;

import com.myApp.config.ProjectConfig;
import com.myApp.model.Comment;
import com.myApp.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class myApp {
    public static void main(String[] args) {
        Comment comment=new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        CommentService commentService=context.getBean(CommentService.class);
        commentService.publishComment(comment);




    }
}
