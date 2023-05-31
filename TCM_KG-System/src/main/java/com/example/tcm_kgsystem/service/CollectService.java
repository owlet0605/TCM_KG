package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.Collect;
import com.example.tcm_kgsystem.transport.TransportObject;

public interface CollectService {
    TransportObject CollectByArticle(long articleId, long userId);

    TransportObject CollectDelete(Collect collect);

    TransportObject ShowAll(long userId, int page);

    TransportObject articleCollectIf(long userId, long articleId);
}
