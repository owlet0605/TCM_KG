package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.Collect;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.service.CollectService;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/collect")
public class CollectController {

    @Autowired
    CollectService collectService;
    @Autowired
    ArticleMapper articleMapper;

    @RequestMapping("/add")
    TransportObject byArticle(Collect collect){
        return collectService.CollectByArticle(collect.getCollectArticleId(),collect.getCollectUserId());
    }

    @RequestMapping("/delete")
    TransportObject delete(Collect collect){
        return collectService.CollectDelete(collect);
    }

    @RequestMapping("/show")
    TransportObject ShowAll(@RequestParam long userId, @RequestParam int page){
        return collectService.ShowAll(userId, page);
    }

    @RequestMapping("/if")
    TransportObject collectIf(Collect collect){
        return collectService.articleCollectIf(collect.getCollectUserId(),collect.getCollectArticleId());
    }
}
