package com.myApp.proxy;

import com.myApp.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
