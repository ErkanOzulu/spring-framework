package com.mycomp.proxy;

import com.mycomp.model.Comment;

public interface CommentNotificationProxy {
    void sendComment(Comment comment);
}
