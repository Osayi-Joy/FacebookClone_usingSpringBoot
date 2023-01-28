package com.osayijoy.week7_facebookclone.repositories;

import com.osayijoy.week7_facebookclone.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Comment findCommentById(Long id);
}
