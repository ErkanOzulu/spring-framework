package com.myApp.repository;

import com.myApp.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
