package com.example.tcm_kgsystem.service.Impl;

import com.example.tcm_kgsystem.entity.Article;
import com.example.tcm_kgsystem.entity.ArticleExample;
import com.example.tcm_kgsystem.entity.ArticleType;
import com.example.tcm_kgsystem.entity.ArticleTypeExample;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.ArticleTypeMapper;
import com.example.tcm_kgsystem.service.ArticleTypeService;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleTypeServiceImpl implements ArticleTypeService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleTypeMapper articleTypeMapper;

    @Override
    public TransportObject ShowAllArticle(long articleTypeId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andArticleTypeIdEqualTo(articleTypeId).andArticleAuditEqualTo(1);
        List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);

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
    public TransportObject getArticleType(long articleTypeId) {
        ArticleType articleType=articleTypeMapper.selectByPrimaryKey(articleTypeId);
        TransportObject transportObject;
        if(Objects.nonNull(articleType)){
            transportObject = new TransportObject(200, "ok", articleType);
        }
        else{
            transportObject = new TransportObject(300, "false", null);
        }
        return transportObject;
    }

    @Override
    public TransportObject findAll(int page) {
        TransportObject transportObject=new TransportObject();
        ArticleTypeExample articleTypeExample=new ArticleTypeExample();
        articleTypeExample.createCriteria().andArticleTypeIdGreaterThan((long)0);
        PageHelper.startPage(page,10);
        List<ArticleType> articleTypes=articleTypeMapper.selectByExample(articleTypeExample);
        if(CollectionUtils.isEmpty(articleTypes)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<ArticleType> result=new PageInfo<>(articleTypes);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject findAllNonPage() {
        TransportObject transportObject=new TransportObject();
        ArticleTypeExample articleTypeExample=new ArticleTypeExample();
        articleTypeExample.createCriteria().andArticleTypeIdGreaterThan((long)0);
        List<ArticleType> articleTypes=articleTypeMapper.selectByExample(articleTypeExample);
        if(CollectionUtils.isEmpty(articleTypes)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        transportObject.setObject(articleTypes);
        return transportObject;
    }

    @Override
    public TransportObject articleTypeInsert(ArticleType articleType) {
        TransportObject transportObject;
        try{
            articleTypeMapper.insert(articleType);
            transportObject=new TransportObject(200,"ok",articleType);
        }catch (Exception e){
            e.printStackTrace();
            transportObject=new TransportObject(300,"false",null);
        }
        return transportObject;
    }

    @Override
    public TransportObject articleTypeChange(ArticleType articleType) {
        TransportObject transportObject;
        ArticleType articleType1=articleTypeMapper.selectByPrimaryKey(articleType.getArticleTypeId());
        if(Objects.nonNull(articleType1)){
            articleType1.setArticleTypeTag(articleType.getArticleTypeTag());
            articleType1.setArticleTypeDescribe(articleType.getArticleTypeDescribe());
            transportObject=new TransportObject(200,"ok",articleType1);
        }
        else{
            transportObject=new TransportObject(300,"false",null);
        }
        return transportObject;
    }

    @Override
    public TransportObject articleTypeDelete(long articleTypeId) {
        TransportObject transportObject;
        ArticleType articleType=articleTypeMapper.selectByPrimaryKey(articleTypeId);
        if(Objects.nonNull(articleType)){
            articleTypeMapper.deleteByPrimaryKey(articleTypeId);
            transportObject=new TransportObject(200, "ok", null);
        }
        else{
            transportObject=new TransportObject(300,"error",null);
        }
        return transportObject;
    }
}
