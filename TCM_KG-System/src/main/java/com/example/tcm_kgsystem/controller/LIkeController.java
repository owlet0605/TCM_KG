package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Like;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.service.LikeService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/like")
public class LIkeController {

    @Autowired
    LikeService likeService;
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/add")
    TransportObject byArticle(Like like){
        return likeService.LikeAdd(like);
    }

    @RequestMapping("/delete")
    TransportObject delete(Like like){
        return likeService.LikeDelete(like);
    }

    @RequestMapping("/show")
    TransportObject ShowByUser(@RequestParam long userId, @RequestParam int page){
        return likeService.ShowAll(userId, page);
    }

    @RequestMapping("/if")
    TransportObject likeIf(Like like){
        return likeService.likeIf(like);
    }
}
