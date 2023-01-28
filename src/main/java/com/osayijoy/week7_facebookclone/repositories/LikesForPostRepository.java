package com.osayijoy.week7_facebookclone.repositories;

import com.osayijoy.week7_facebookclone.models.LikesForPost;
import com.osayijoy.week7_facebookclone.models.Post;
import com.osayijoy.week7_facebookclone.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesForPostRepository extends JpaRepository<LikesForPost, Long> {
    LikesForPost findByUserAndPost(User user, Post post);
}
