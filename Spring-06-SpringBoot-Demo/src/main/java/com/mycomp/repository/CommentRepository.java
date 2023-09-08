package com.mycomp.repository;

import com.mycomp.model.Comment;

public interface CommentRepository {
    void storeComment(Comment comment);
}
