package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.Like;
import com.example.tcm_kgsystem.transport.TransportObject;

public interface LikeService {
    TransportObject LikeAdd(Like like);

    TransportObject LikeDelete(Like like);

    TransportObject ShowAll(long userId, int page);

    TransportObject likeIf(Like like);
}
