package com.example.tcm_kgsystem.service;

import com.example.tcm_kgsystem.entity.Comment;
import com.example.tcm_kgsystem.transport.TransportObject;

public interface CommentService {
    TransportObject commentInsert(Comment comment);

    TransportObject commentDelete(Comment comment);

    TransportObject ShowAllComment(Comment comment, int page);

    TransportObject ShowAllCommentOfTopComment(Comment comment, int page);

    TransportObject getComment(long commentId);
}
