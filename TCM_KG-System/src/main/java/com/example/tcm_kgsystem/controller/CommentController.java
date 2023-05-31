package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Comment;
import com.example.tcm_kgsystem.service.CommentService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/add")
    TransportObject insert(Comment comment){
        return commentService.commentInsert(comment);
    }

    @RequestMapping("/delete")
    TransportObject delete(Comment comment){
        return commentService.commentDelete(comment);
    }

    @RequestMapping("/show")
    TransportObject ShowAllComment(Comment comment, @RequestParam int page){
        return commentService.ShowAllComment(comment, page);
    }

    @RequestMapping("/show/sub")
    TransportObject ShowAllCommentOfTopComment(Comment comment, @RequestParam int page){
        return commentService.ShowAllCommentOfTopComment(comment, page);
    }
    
    @RequestMapping("/get")
    TransportObject getComment(Comment comment){
        return commentService.getComment(comment.getCommentId());
    }
}
