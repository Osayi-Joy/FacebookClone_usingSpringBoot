package com.osayijoy.week7_facebookclone.services.serviceImplementation;

import com.osayijoy.week7_facebookclone.models.LikesForComment;
import com.osayijoy.week7_facebookclone.repositories.LikesForCommentRepository;
import com.osayijoy.week7_facebookclone.services.LikesForCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesForCommentServiceImplementation implements LikesForCommentService {

    @Autowired
    LikesForCommentRepository likesForCommentRepository;

    @Override
    public LikesForComment getLikes(LikesForComment like) {
        return likesForCommentRepository.findByUserAndComment(like.getUser(), like.getComment());
    }

    @Override
    public void deleteLike(LikesForComment like) {
        likesForCommentRepository.delete(like);
    }

    @Override
    public void addLike(LikesForComment like) {
        likesForCommentRepository.save(like);
    }
}
