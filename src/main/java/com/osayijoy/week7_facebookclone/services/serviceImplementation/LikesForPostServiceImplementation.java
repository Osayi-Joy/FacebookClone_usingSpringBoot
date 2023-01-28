package com.osayijoy.week7_facebookclone.services.serviceImplementation;

import com.osayijoy.week7_facebookclone.models.LikesForPost;
import com.osayijoy.week7_facebookclone.repositories.LikesForPostRepository;
import com.osayijoy.week7_facebookclone.services.LikesForPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesForPostServiceImplementation implements LikesForPostService {
    @Autowired
    LikesForPostRepository likesForPostRepository;
    @Override
    public LikesForPost getLikes(LikesForPost like) {
        return likesForPostRepository.findByUserAndPost(like.getUser(), like.getPost());
    }

    @Override
    public void deleteLike(LikesForPost like) {
        likesForPostRepository.delete(like);
    }

    @Override
    public void addLike(LikesForPost like) {
        likesForPostRepository.save(like);
    }
}
