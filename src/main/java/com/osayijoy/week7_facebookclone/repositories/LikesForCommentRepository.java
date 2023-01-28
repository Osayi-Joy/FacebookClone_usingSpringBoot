package com.osayijoy.week7_facebookclone.repositories;

import com.osayijoy.week7_facebookclone.models.Comment;
import com.osayijoy.week7_facebookclone.models.LikesForComment;
import com.osayijoy.week7_facebookclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesForCommentRepository extends JpaRepository<LikesForComment, Long> {
    LikesForComment findByUserAndComment(User user, Comment comment);
}
