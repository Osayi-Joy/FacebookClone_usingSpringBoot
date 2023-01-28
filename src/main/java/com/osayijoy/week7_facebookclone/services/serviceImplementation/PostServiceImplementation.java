package com.osayijoy.week7_facebookclone.services.serviceImplementation;

import com.osayijoy.week7_facebookclone.models.Post;
import com.osayijoy.week7_facebookclone.models.User;
import com.osayijoy.week7_facebookclone.repositories.PostRepository;
import com.osayijoy.week7_facebookclone.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImplementation implements PostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public void createPost(Post post, User user) {
        post.setUser(user);
        postRepository.save(post);
    }

    @Override
    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findPostById(id);
    }

    @Override
    public void deletePost(Post post) {
        postRepository.delete(post);
        System.err.println("Performed");
    }

    @Override
    public void updatePost(Post post, long id) {
        Post oldPost = postRepository.findPostById(id);
        oldPost.setPostMessage(post.getPostMessage());
        postRepository.save(oldPost);
    }

}
