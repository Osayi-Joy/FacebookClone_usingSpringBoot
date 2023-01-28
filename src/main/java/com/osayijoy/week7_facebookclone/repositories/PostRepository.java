package com.osayijoy.week7_facebookclone.repositories;

import com.osayijoy.week7_facebookclone.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Post findPostById(Long id);
}
