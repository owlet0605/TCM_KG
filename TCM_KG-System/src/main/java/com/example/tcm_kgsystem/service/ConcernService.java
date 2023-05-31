package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.User;
import com.example.tcm_kgsystem.transport.TransportObject;

public interface ConcernService {
    TransportObject ConcernByUser(User user1,User user2);

    TransportObject ConcernDelete(User user1,User user2);

    TransportObject ConcernIf(User user1,User user2);
}
