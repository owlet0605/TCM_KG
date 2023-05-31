package com.example.tcm_kgsystem.service.Util;

import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.entity.es.document.ArticleDocument;
import com.example.tcm_kgsystem.entity.es.document.TcmDocument;
import com.example.tcm_kgsystem.mapper.ArticleMapper;
import com.example.tcm_kgsystem.mapper.TcmMapper;
import com.example.tcm_kgsystem.mapper.es.ESArticleMapper;
import com.example.tcm_kgsystem.mapper.es.ESTcmMapper;
import com.example.tcm_kgsystem.transport.TransportObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Iterator;
import java.util.List;

@Service
public class ESUtilImpl implements ESUtil {
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ESArticleMapper esArticleMapper;
    @Autowired
    ESTcmMapper esTcmMapper;
    @Autowired
    TcmMapper tcmMapper;
    @Autowired(required = false)
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public TransportObject buildArticle(){
        TransportObject transportObject;
        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andArticleIdGreaterThan((long)0);
        List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);
        if(!CollectionUtils.isEmpty(articles)){
            Iterator<Article> iterator=articles.iterator();
            while(iterator.hasNext()){
                Article article=iterator.next();
                ArticleDocument articleDocument=new ArticleDocument();
                articleDocument.setId(article.getArticleId());
                articleDocument.setTitle(article.getArticleTitle());
                articleDocument.setContext(article.getArticleContext());
                articleDocument.setTime(article.getArticleTime());
                articleDocument.setUserId(article.getArticleUserId());
                try {
                    esArticleMapper.save(articleDocument);
                }catch (Exception e){
                    e.printStackTrace();
                    transportObject=new TransportObject(300, "error", null);
                }
            }
            transportObject=new TransportObject(200,"ok", articles);
        }
        else{
            transportObject=new TransportObject(400, "error", null);
        }
        return transportObject;
    }

    @Override
    public TransportObject buildTcm() {
        TransportObject transportObject;
        TcmExample tcmExample=new TcmExample();
        tcmExample.createCriteria().andTcmIdGreaterThan((long)0);
        List<TcmWithBLOBs> tcms=tcmMapper.selectByExampleWithBLOBs(tcmExample);
        if(!CollectionUtils.isEmpty(tcms)){
            Iterator<TcmWithBLOBs> iterator=tcms.iterator();
            while(iterator.hasNext()){
                TcmWithBLOBs tcm=iterator.next();
                TcmDocument tcmDocument=new TcmDocument();
                tcmDocument.setId(tcm.getTcmId());
                tcmDocument.setTcmNameZh(tcm.getTcmNameZh());
                tcmDocument.setTcmPinyin(tcm.getTcmPinyin());
                tcmDocument.setTcmAlias(tcm.getTcmAlias());
                tcmDocument.setTcmInductive(tcm.getTcmInductive());
                tcmDocument.setTcmTaste(tcm.getTcmTaste());
                tcmDocument.setTcmDistribution(tcm.getTcmDistribution());
                tcmDocument.setTcmProduce(tcm.getTcmProduce());
                tcmDocument.setTcmNote(tcm.getTcmNote());
                tcmDocument.setTcmFunction(tcm.getTcmFunction());
                try {
                    esTcmMapper.save(tcmDocument);
                }catch (Exception e){
                    e.printStackTrace();
                    transportObject=new TransportObject(300, "error", null);
                }
            }
            transportObject=new TransportObject(200,"ok", tcms);
        }
        else{
            transportObject=new TransportObject(400, "error", null);
        }
        return transportObject;
    }

    @Override
    public TransportObject deleteAllArticle() {
        esArticleMapper.deleteAll();
        return null;
    }

    @Override
    public TransportObject searchAllArticle() {
        Iterable<ArticleDocument> articleDocumentIterator= esArticleMapper.findAll();
        TransportObject transportObject=new TransportObject(200, "ok", articleDocumentIterator);
        return transportObject;
    }

    @Override
    public TransportObject deleteAllTcm() {
        esTcmMapper.deleteAll();
        return null;
    }

    @Override
    public TransportObject searchAllTcm() {
        Iterable<TcmDocument> tcmDocuments=esTcmMapper.findAll();
        TransportObject transportObject=new TransportObject(200, "ok", tcmDocuments);
        return transportObject;
    }

    @Override
    public void addArticle(Article article) {
        ArticleDocument articleDocument=new ArticleDocument();
        articleDocument.setId(article.getArticleId());
        articleDocument.setTitle(article.getArticleTitle());
        articleDocument.setContext(article.getArticleContext());
        articleDocument.setTime(article.getArticleTime());
        articleDocument.setUserId(article.getArticleUserId());
        try {
            esArticleMapper.save(articleDocument);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void addTcm(TcmWithBLOBs tcm) {
        TcmDocument tcmDocument=new TcmDocument();
        tcmDocument.setId(tcm.getTcmId());
        tcmDocument.setTcmNameZh(tcm.getTcmNameZh());
        tcmDocument.setTcmPinyin(tcm.getTcmPinyin());
        tcmDocument.setTcmAlias(tcm.getTcmAlias());
        tcmDocument.setTcmInductive(tcm.getTcmInductive());
        tcmDocument.setTcmTaste(tcm.getTcmTaste());
        tcmDocument.setTcmDistribution(tcm.getTcmDistribution());
        tcmDocument.setTcmProduce(tcm.getTcmProduce());
        tcmDocument.setTcmNote(tcm.getTcmNote());
        tcmDocument.setTcmFunction(tcm.getTcmFunction());
        try {
            esTcmMapper.save(tcmDocument);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteArticle(Article article) {
        ArticleDocument articleDocument=new ArticleDocument();
        articleDocument.setId(article.getArticleId());
        articleDocument.setTitle(article.getArticleTitle());
        articleDocument.setContext(article.getArticleContext());
        articleDocument.setTime(article.getArticleTime());
        articleDocument.setUserId(article.getArticleUserId());
        try {
            esArticleMapper.delete(articleDocument);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTcm(TcmWithBLOBs tcm) {
        TcmDocument tcmDocument=new TcmDocument();
        tcmDocument.setId(tcm.getTcmId());
        tcmDocument.setTcmNameZh(tcm.getTcmNameZh());
        tcmDocument.setTcmPinyin(tcm.getTcmPinyin());
        tcmDocument.setTcmAlias(tcm.getTcmAlias());
        tcmDocument.setTcmInductive(tcm.getTcmInductive());
        tcmDocument.setTcmTaste(tcm.getTcmTaste());
        tcmDocument.setTcmDistribution(tcm.getTcmDistribution());
        tcmDocument.setTcmProduce(tcm.getTcmProduce());
        tcmDocument.setTcmNote(tcm.getTcmNote());
        tcmDocument.setTcmFunction(tcm.getTcmFunction());
        try {
            esTcmMapper.delete(tcmDocument);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void changeArticle(Article article) {
        ArticleDocument articleDocument=new ArticleDocument();
        articleDocument.setId(article.getArticleId());
        articleDocument.setTitle(article.getArticleTitle());
        articleDocument.setContext(article.getArticleContext());
        articleDocument.setTime(article.getArticleTime());
        articleDocument.setUserId(article.getArticleUserId());
        try {
            esArticleMapper.save(articleDocument);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void changeTcm(TcmWithBLOBs tcm) {
        TcmDocument tcmDocument=new TcmDocument();
        tcmDocument.setId(tcm.getTcmId());
        tcmDocument.setTcmNameZh(tcm.getTcmNameZh());
        tcmDocument.setTcmPinyin(tcm.getTcmPinyin());
        tcmDocument.setTcmAlias(tcm.getTcmAlias());
        tcmDocument.setTcmInductive(tcm.getTcmInductive());
        tcmDocument.setTcmTaste(tcm.getTcmTaste());
        tcmDocument.setTcmDistribution(tcm.getTcmDistribution());
        tcmDocument.setTcmProduce(tcm.getTcmProduce());
        tcmDocument.setTcmNote(tcm.getTcmNote());
        tcmDocument.setTcmFunction(tcm.getTcmFunction());
        try {
            esTcmMapper.save(tcmDocument);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
