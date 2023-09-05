package com.myComp.repository;

import com.myComp.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
