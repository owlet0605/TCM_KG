package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.mapper.*;
import com.example.tcm_kgsystem.service.LikeService;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    LikeMapper likeMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CommentMapper commentMapper;

    @Override
    public TransportObject LikeAdd(Like like) {
        Date time=new Date();
        like.setLikeTime(time);
        try{
            likeMapper.insert(like);

            if(like.getLikeType().equals("article")){
                Article article=articleMapper.selectByPrimaryKey(like.getLikeArticleId());
                article.setArticleLike(article.getArticleLike()+1);
                articleMapper.updateByPrimaryKey(article);

                User user=userMapper.selectByPrimaryKey(article.getArticleUserId());
                user.setUserLike(user.getUserLike()+1);
                userMapper.updateByPrimaryKey(user);
            }
            else if(like.getLikeType().equals("comment")){
                Comment comment=commentMapper.selectByPrimaryKey(like.getLikeCommentId());
                comment.setCommentLike(comment.getCommentLike()+1);
                commentMapper.updateByPrimaryKey(comment);
            }
            TransportObject transportObject=new TransportObject(200,"ok",like);
            return transportObject;
        }catch (Exception e){
            e.printStackTrace();
            TransportObject transportObject=new TransportObject(300,"error",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject LikeDelete(Like like) {
        LikeExample likeExample=new LikeExample();
        if(like.getLikeType().equals("article")){
            likeExample.createCriteria().andLikeUserIdEqualTo(like.getLikeUserId()).andLikeArticleIdEqualTo(like.getLikeArticleId());
            if(CollectionUtils.isEmpty(likeMapper.selectByExample(likeExample))){
                TransportObject transportObject=new TransportObject(300,"null",null);
                return transportObject;
            }
            else{
                Article article=articleMapper.selectByPrimaryKey(like.getLikeArticleId());
                article.setArticleLike(article.getArticleLike()-1);
                articleMapper.updateByPrimaryKey(article);

                User user=userMapper.selectByPrimaryKey(article.getArticleUserId());
                user.setUserLike(user.getUserLike()-1);
                userMapper.updateByPrimaryKey(user);

                likeMapper.deleteByExample(likeExample);
                TransportObject transportObject=new TransportObject(200,"ok",null);
                return transportObject;
            }
        }
        else if(like.getLikeType().equals("comment")){
            likeExample.createCriteria().andLikeUserIdEqualTo(like.getLikeUserId()).andLikeCommentIdEqualTo(like.getLikeCommentId());
            if(CollectionUtils.isEmpty(likeMapper.selectByExample(likeExample))){
                TransportObject transportObject=new TransportObject(300,"null",null);
                return transportObject;
            }
            else{
                Comment comment=commentMapper.selectByPrimaryKey(like.getLikeCommentId());
                comment.setCommentLike(comment.getCommentLike()-1);
                commentMapper.updateByPrimaryKey(comment);

                likeMapper.deleteByExample(likeExample);
                TransportObject transportObject=new TransportObject(200,"ok",null);
                return transportObject;
            }
        }
        else{
            return null;
        }
    }

    @Override
    public TransportObject ShowAll(long userId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        LikeExample likeExample=new LikeExample();
        likeExample.setOrderByClause("like_time desc");
        likeExample.createCriteria().andLikeUserIdEqualTo(userId);
        List<Like> likes=likeMapper.selectByExample(likeExample);
        List<Article> articles=new ArrayList<>();
        Iterator<Like> iterator=likes.iterator();
        while(iterator.hasNext()){
            Like like=iterator.next();
            articles.add(articleMapper.selectByPrimaryKey(like.getLikeArticleId()));
        }
        if(CollectionUtils.isEmpty(articles)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
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
    public TransportObject likeIf(Like like) {
        LikeExample likeExample=new LikeExample();
        if(like.getLikeType().equals("article")){
            likeExample.createCriteria().andLikeUserIdEqualTo(like.getLikeUserId()).andLikeArticleIdEqualTo(like.getLikeArticleId());
        }
        else if(like.getLikeType().equals("comment")){
            likeExample.createCriteria().andLikeUserIdEqualTo(like.getLikeUserId()).andLikeCommentIdEqualTo(like.getLikeCommentId());
        }
        List<Like> Result=likeMapper.selectByExample(likeExample);
        if(CollectionUtils.isEmpty(Result)){
            TransportObject transportObject=new TransportObject(400,"not",false);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(200,"is",true);
            return transportObject;
        }
    }
}
