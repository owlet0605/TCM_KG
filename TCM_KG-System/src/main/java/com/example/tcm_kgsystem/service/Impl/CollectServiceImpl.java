package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.ArticleExample;
import com.example.tcm_kgsystem.entity.Collect;
import com.example.tcm_kgsystem.entity.CollectExample;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.CollectMapper;
import com.example.tcm_kgsystem.mapper.UserMapper;
import com.example.tcm_kgsystem.service.CollectService;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class CollectServiceImpl implements CollectService {

    @Autowired
    CollectMapper collectMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;
    @Override
    public TransportObject CollectByArticle(long articleId, long userId) {
        Date time=new Date();
        Collect collect=new Collect((long)0,articleId,userId,time);
        try{
            collectMapper.insert(collect);

            ArticleExample articleExample=new ArticleExample();
            articleExample.createCriteria().andArticleIdEqualTo(articleId);
            Article article=articleMapper.selectByExample(articleExample).get(0);
            article.setArticleCollect(article.getArticleCollect()+1);
            articleMapper.updateByPrimaryKey(article);

            TransportObject transportObject=new TransportObject(200,"ok",collect);
            return transportObject;
        }catch (Exception e){
            TransportObject transportObject=new TransportObject(300,"error",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject CollectDelete(Collect collect) {
        CollectExample collectExample=new CollectExample();
        collectExample.createCriteria().andCollectArticleIdEqualTo(collect.getCollectArticleId()).andCollectUserIdEqualTo(collect.getCollectUserId());
        if(!CollectionUtils.isEmpty(collectMapper.selectByExample(collectExample))){
            collectMapper.deleteByExample(collectExample);

            ArticleExample articleExample=new ArticleExample();
            articleExample.createCriteria().andArticleIdEqualTo(collect.getCollectArticleId());
            Article article=articleMapper.selectByExample(articleExample).get(0);
            article.setArticleCollect(article.getArticleCollect()-1);
            articleMapper.updateByPrimaryKey(article);

            TransportObject transportObject=new TransportObject(200,"ok",null);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(300,"null",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject ShowAll(long userId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        CollectExample collectExample=new CollectExample();
        collectExample.setOrderByClause("collect_time desc");
        collectExample.createCriteria().andCollectUserIdEqualTo(userId);
        List<Collect> collects=collectMapper.selectByExample(collectExample);
        List<Article> articles=new ArrayList<>();
        Iterator<Collect> iterator=collects.iterator();
        while(iterator.hasNext()){
            Collect collect=iterator.next();
            articles.add(articleMapper.selectByPrimaryKey(collect.getCollectArticleId()));
        }
        if(CollectionUtils.isEmpty(articles)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Article> Result=new PageInfo<>(articles);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject articleCollectIf(long userId, long articleId) {
        CollectExample collectExample=new CollectExample();
        collectExample.createCriteria().andCollectUserIdEqualTo(userId).andCollectArticleIdEqualTo(articleId);
        List<Collect> result=collectMapper.selectByExample(collectExample);
        if(CollectionUtils.isEmpty(result)){
            TransportObject transportObject=new TransportObject(400,"not",false);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(200,"is",true);
            return transportObject;
        }
    }
}
