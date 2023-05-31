package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.ArticleExample;
import com.example.tcm_kgsystem.entity.Comment;
import com.example.tcm_kgsystem.entity.CommentExample;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.CommentMapper;
import com.example.tcm_kgsystem.service.CommentService;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentMapper commentMapper;
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public TransportObject commentInsert(Comment comment) {
        Date time=new Date();
        comment.setCommentTime(time);
        try{
            commentMapper.insert(comment);

            ArticleExample articleExample=new ArticleExample();
            articleExample.createCriteria().andArticleIdEqualTo(comment.getCommentArticleId());
            Article article=articleMapper.selectByExample(articleExample).get(0);
            article.setArticleComment(article.getArticleComment()+1);
            articleMapper.updateByPrimaryKey(article);
            TransportObject transportObject=new TransportObject(200,"ok",comment);
            return transportObject;
        }catch (Exception e){
            e.printStackTrace();
            TransportObject transportObject=new TransportObject(300,"error",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject commentDelete(Comment comment) {
        if(Objects.nonNull(commentMapper.selectByPrimaryKey(comment.getCommentId()))){
            commentMapper.deleteByPrimaryKey(comment.getCommentId());

            ArticleExample articleExample=new ArticleExample();
            articleExample.createCriteria().andArticleIdEqualTo(comment.getCommentArticleId());
            Article article=articleMapper.selectByExample(articleExample).get(0);
            article.setArticleComment(article.getArticleComment()-1);
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
    public TransportObject ShowAllComment(Comment comment, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        CommentExample commentExample=new CommentExample();
        commentExample.setOrderByClause("comment_like desc");
        commentExample.setOrderByClause("comment_time desc");
        commentExample.createCriteria().andCommentArticleIdEqualTo(comment.getCommentArticleId()).andCommentTopIdIsNull().andCommentForIdIsNull();

        List<Comment> comments=commentMapper.selectByExample(commentExample);
        if(CollectionUtils.isEmpty(comments)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Comment> Result=new PageInfo<>(comments);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject ShowAllCommentOfTopComment(Comment comment, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        CommentExample commentExample=new CommentExample();
        commentExample.setOrderByClause("comment_like desc");
        commentExample.setOrderByClause("comment_time desc");
        commentExample.createCriteria().andCommentTopIdEqualTo(comment.getCommentId()).andCommentArticleIdEqualTo(comment.getCommentArticleId());

        List<Comment> comments=commentMapper.selectByExample(commentExample);
        if(CollectionUtils.isEmpty(comments)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Comment> Result=new PageInfo<>(comments);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject getComment(long commentId) {
        TransportObject transportObject;
        CommentExample commentExample=new CommentExample();
        commentExample.createCriteria().andCommentIdEqualTo(commentId);
        List<Comment> comments=commentMapper.selectByExample(commentExample);
        if(CollectionUtils.isEmpty(comments)){
            transportObject=new TransportObject(400,"null",null);
        }
        else{
            transportObject=new TransportObject(200, "ok", comments.get(0));
        }
        return transportObject;
    }
}
