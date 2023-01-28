package com.osayijoy.week7_facebookclone.services;

import com.osayijoy.week7_facebookclone.models.Comment;

public interface CommentService {
    void createComment(Comment comment);
    Comment getCommentById(Long id);
    void updateComment(Comment comment, Long id);
    void deleteComment(Comment comment);
}
