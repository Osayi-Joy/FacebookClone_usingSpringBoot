package com.osayijoy.week7_facebookclone.services;

import com.osayijoy.week7_facebookclone.models.LikesForComment;

public interface LikesForCommentService {
    LikesForComment getLikes(LikesForComment like);

    void deleteLike(LikesForComment like);

    void addLike(LikesForComment like);
}
