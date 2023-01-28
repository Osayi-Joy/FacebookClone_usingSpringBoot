package com.osayijoy.week7_facebookclone.services.serviceImplementation;

import com.osayijoy.week7_facebookclone.models.Comment;
import com.osayijoy.week7_facebookclone.repositories.CommentRepository;
import com.osayijoy.week7_facebookclone.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImplementation implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void createComment(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Long id) {
        return commentRepository.findCommentById(id);
    }

    @Override
    public void updateComment(Comment comment, Long id) {
        Comment oldComment = commentRepository.findCommentById(id);
        oldComment.setCommentMessage(comment.getCommentMessage());
        commentRepository.save(oldComment);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentRepository.delete(comment);
    }

//    @Override
//    public List<Comment> getPostComments(Post post) {
//        return commentRepository.findAllByPost(post);
//    }
}
