package com.example.tcm_kgsystem.service.Impl;

import com.aliyuncs.utils.StringUtils;
import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.entity.es.document.TcmDocument;
import com.example.tcm_kgsystem.mapper.TcmMapper;
import com.example.tcm_kgsystem.mapper.es.ESTcmMapper;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.example.tcm_kgsystem.service.TcmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class TcmServiceImpl implements TcmService {

    @Autowired
    TcmMapper tcmMapper;
    @Autowired
    ESTcmMapper esTcmMapper;
    @Autowired
    ESUtil esUtil;
    @Autowired(required = false)
    ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public TransportObject TcmInsert(TcmWithBLOBs tcm) {
        TransportObject transportObject =new TransportObject();

        TcmExample tcmExample=new TcmExample();
        if(StringUtils.isNotEmpty(tcm.getTcmNameZh())){
            tcmExample.createCriteria().andTcmNameZhEqualTo(tcm.getTcmNameZh());
        }
        if(!CollectionUtils.isEmpty(tcmMapper.selectByExample(tcmExample))){
            transportObject.setCode(300);
            transportObject.setMsg("exits");
            transportObject.setObject(null);
        }
        else{
            try{
                tcmMapper.insert(tcm);

                esUtil.addTcm(tcm);

                transportObject.setCode(200);
                transportObject.setMsg("add"+tcm.getTcmNameZh());
                transportObject.setObject(tcm);
            }catch (Exception e){
                e.printStackTrace();
                transportObject.setCode(200);
                transportObject.setMsg("fail");
                transportObject.setObject(null);
            }
        }
        return transportObject;
    }

    @Override
    public TransportObject TcmDelete(long tcmId) {
        TransportObject transportObject =new TransportObject();

        if(Objects.nonNull(tcmMapper.selectByPrimaryKey(tcmId))){
            tcmMapper.deleteByPrimaryKey(tcmId);

            TcmWithBLOBs tcm=tcmMapper.selectByPrimaryKey(tcmId);
            esUtil.deleteTcm(tcm);

            transportObject.setCode(200);
            transportObject.setMsg("success");
        }
        else{
            transportObject.setCode(300);
            transportObject.setMsg("fail");
        }
        transportObject.setObject(null);
        return transportObject;
    }

    @Override
    public TransportObject TcmChange(TcmWithBLOBs tcm) {
        TransportObject transportObject =new TransportObject();

        TcmExample tcmExample=new TcmExample();
        if(StringUtils.isNotEmpty(tcm.getTcmNameZh())){
            tcmExample.createCriteria().andTcmNameZhEqualTo(tcm.getTcmNameZh()).andTcmIdNotEqualTo(tcm.getTcmId());
        }
        if(!CollectionUtils.isEmpty(tcmMapper.selectByExample(tcmExample))){
            transportObject.setCode(300);
            transportObject.setMsg("exits");
        }
        else{
            try{
                tcmMapper.updateByPrimaryKey(tcm);

                esUtil.changeTcm(tcm);

                transportObject.setCode(200);
                transportObject.setMsg("tcm"+tcm.getTcmNameZh()+"change");
            }catch (Exception e){
                e.printStackTrace();
                tcmMapper.updateByPrimaryKey(tcm);
                transportObject.setCode(300);
                transportObject.setMsg("fail");
            }
        }
        transportObject.setObject(tcm);
        return transportObject;
    }

    @Override
    public TransportObject ShowAll(int page) {
        TransportObject transportObject=new TransportObject();

        PageHelper.startPage(page,20);
        TcmExample tcmExample=new TcmExample();
        tcmExample.createCriteria().andTcmIdGreaterThan((long)0);
        List<TcmWithBLOBs> tcms=tcmMapper.selectByExampleWithBLOBs(tcmExample);
        if(CollectionUtils.isEmpty(tcms)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<TcmWithBLOBs> Result=new PageInfo<>(tcms);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject ShowByInitial(String initial, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,20);
        TcmExample tcmExample=new TcmExample();
        tcmExample.createCriteria().andTcmPinyinLike(initial+"%");
        List<TcmWithBLOBs> tcms=tcmMapper.selectByExampleWithBLOBs(tcmExample);
        if(CollectionUtils.isEmpty(tcms)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<TcmWithBLOBs> Result=new PageInfo<>(tcms);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject ShowByInductive(String inductive, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,20);
        TcmExample tcmExample=new TcmExample();
        tcmExample.createCriteria().andTcmInductiveLike("%"+inductive+"%");
        List<TcmWithBLOBs> tcms=tcmMapper.selectByExampleWithBLOBs(tcmExample);
        if(CollectionUtils.isEmpty(tcms)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<TcmWithBLOBs> Result=new PageInfo<>(tcms);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject ShowByTaste(String taste, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,20);
        TcmExample tcmExample=new TcmExample();
        tcmExample.createCriteria().andTcmTasteLike("%"+taste+"%");
        List<TcmWithBLOBs> tcms=tcmMapper.selectByExampleWithBLOBs(tcmExample);
        if(CollectionUtils.isEmpty(tcms)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<TcmWithBLOBs> Result=new PageInfo<>(tcms);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject ShowByProperty(String property, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,20);
        TcmExample tcmExample=new TcmExample();
        tcmExample.createCriteria().andTcmTasteLike("%"+property+"%");
        List<TcmWithBLOBs> tcms=tcmMapper.selectByExampleWithBLOBs(tcmExample);
        if(CollectionUtils.isEmpty(tcms)){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<TcmWithBLOBs> Result=new PageInfo<>(tcms);
        transportObject.setObject(Result);
        return transportObject;
    }

    @Override
    public TransportObject Select(String str, int page) {
        TransportObject transportObject=new TransportObject();
        Pageable pageable= PageRequest.of(page-1,20);

        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmNameZh",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmPinyin",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmInductive",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmTaste",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmAlias",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmDistribution",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmProduce",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmNote",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("tcmFunction",str));
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(pageable)
                .withHighlightFields(new HighlightBuilder.Field("tcmNameZh"))
                .withHighlightBuilder(new HighlightBuilder().preTags("<em style=\"color:red\">").postTags("</em>"));

        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        SearchHits<TcmDocument> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, TcmDocument.class);

        long totalHits = searchHits.getTotalHits();
        List<TcmWithBLOBs> tcms = new ArrayList();
        if(totalHits<=0){
            transportObject.setCode(400);
            transportObject.setMsg("null");
        }
        else{
            for (SearchHit<TcmDocument> searchHit : searchHits) {
                long id= Long.parseLong(searchHit.getId());
                TcmWithBLOBs tcm=tcmMapper.selectByPrimaryKey(id);

                Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
                if(!CollectionUtils.isEmpty(highlightFields)){
                    tcm.setTcmNameZh(highlightFields.get("tcmNameZh").get(0));
                }

                tcms.add(tcm);
            }
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }

        PageImpl<TcmWithBLOBs> result=new PageImpl<>(tcms,pageable,totalHits);

        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject getTcm(long tcmId) {
        Tcm tcm=tcmMapper.selectByPrimaryKey(tcmId);
        TransportObject transportObject;
        if(Objects.nonNull(tcm)){
            transportObject = new TransportObject(200, "ok", tcm);
        }
        else{
            transportObject = new TransportObject(300, "error", null);
        }
        return transportObject;
    }
}
