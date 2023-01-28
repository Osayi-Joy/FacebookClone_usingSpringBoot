package com.osayijoy.week7_facebookclone.services;

import com.osayijoy.week7_facebookclone.models.LikesForPost;

public interface LikesForPostService {

    LikesForPost getLikes(LikesForPost likes);

    void deleteLike(LikesForPost like);

    void addLike(LikesForPost like);
}
