package com.osayijoy.week7_facebookclone.services;

import com.osayijoy.week7_facebookclone.models.Post;
import com.osayijoy.week7_facebookclone.models.User;

import java.util.List;

public interface PostService {
    void createPost(Post post, User user);
    List<Post> getAllPost();
    Post getPostById(Long id);
    void deletePost(Post post);
    void updatePost(Post post, long id);
}
