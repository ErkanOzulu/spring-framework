package com.myComp.proxy;

import com.myComp.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
