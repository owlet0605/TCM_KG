package com.example.tcm_kgsystem.controller;

import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.ArticleType;
import com.example.tcm_kgsystem.entity.History;
import com.example.tcm_kgsystem.service.ArticleService;
import com.example.tcm_kgsystem.service.ArticleTypeService;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import com.example.tcm_kgsystem.transport.FileToUser;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleController {

    @Autowired
    ArticleTypeService articleTypeService;
    @Autowired
    ArticleService articleService;
    @Autowired
    ESUtil esUtil;

    @RequestMapping("/tag")
    TransportObject showAllArticle(@RequestParam long articleTypeId, @RequestParam int page){
        return articleTypeService.ShowAllArticle(articleTypeId, page);
    }

    @RequestMapping("/type")
    TransportObject getArticleType(ArticleType articleType){
        return articleTypeService.getArticleType(articleType.getArticleTypeId());
    }

    @RequestMapping("/show")
    TransportObject showArticles(@RequestParam long userId, @RequestParam int page){
        return articleService.userShowArticle(userId, page);
    }

    @RequestMapping("/add")
    TransportObject articlePublish(Article article, @RequestParam String key){
        return articleService.articlePublish(article, key);
    }

    @RequestMapping("/view")
    TransportObject articleView(History history){
        return articleService.articleView(history.getHistoryUserId(), history.getHistoryArticleId());
    }

    @RequestMapping("/delete")
    TransportObject articleDelete(Article article){
        return articleService.articleDelete(article.getArticleId());
    }

    @RequestMapping("/search")
    TransportObject articleSelect(@RequestParam String str, @RequestParam int page){
        return articleService.articleSelect(str, page);
    }

    @RequestMapping("/recommend")
    TransportObject articleRecommend(@RequestParam long userId){
        return articleService.articleRecommend(userId);
    }

    @RequestMapping("/hot")
    TransportObject hotArticles(){
        return articleService.hotArticles();
    }

    @RequestMapping("/get")
    TransportObject articleGet(Article article){
        return articleService.articleGet(article.getArticleId());
    }

    @RequestMapping("/searchOnUser")
    TransportObject articleSearchOnUser(@RequestParam long userId, @RequestParam String str, @RequestParam int page) {
        return articleService.articleSearchOnUser(userId, str, page);
    }

    @RequestMapping("/all")
    TransportObject searchAll(@RequestParam int page){
        return articleService.searchAll(page);
    }

    @RequestMapping("/typeAll")
    TransportObject findAllType(@RequestParam int page){
        return articleTypeService.findAll(page);
    }

    @RequestMapping("/changeAudit")
    TransportObject changeArticleAudit(Article article){
        return articleService.changeArticleAudit(article.getArticleId(), article.getArticleAudit());
    }

    @RequestMapping("/typeAdd")
    TransportObject articleTypeInsert(ArticleType articleType){
        return articleTypeService.articleTypeInsert(articleType);
    }

    @RequestMapping("/typeDelete")
    TransportObject articleTypeDelete(ArticleType articleType){
        return articleTypeService.articleTypeDelete(articleType.getArticleTypeId());
    }

    @RequestMapping("/typeChange")
    TransportObject articleTypeChange(ArticleType articleType){
        return articleTypeService.articleTypeChange(articleType);
    }

    @RequestMapping("/build")
    TransportObject build(){
        return esUtil.buildArticle();
    }

    @RequestMapping("/deleteES")
    TransportObject delete(){
        return esUtil.deleteAllArticle();
    }

    @RequestMapping("/allES")
    TransportObject search(){
        return esUtil.searchAllArticle();
    }

    @RequestMapping("/adminUpdateImg")
    TransportObject articleUpdateImg(FileToUser ftu, @RequestParam String key){
        return articleService.articleUploadImg(ftu.getFile(), key);
    }

    @RequestMapping("/history")
    TransportObject showHistory(@RequestParam long userId, @RequestParam int page){
        return articleService.showHistory(userId,page);
    }

    @RequestMapping("/typeAllNonPage")
    TransportObject getTypeAllNonPage(){
        return articleTypeService.findAllNonPage();
    }

    @RequestMapping("/tihuan")
    TransportObject tihuan(){
        return articleService.tihuan();
    }
}
