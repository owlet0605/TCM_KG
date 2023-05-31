package com.example.tcm_kgsystem.service.Impl;

import com.aliyuncs.utils.StringUtils;
import com.example.tcm_kgsystem.entity.*;
import com.example.tcm_kgsystem.entity.es.document.ArticleDocument;
import com.example.tcm_kgsystem.mapper.*;
import com.example.tcm_kgsystem.mapper.es.ESArticleMapper;
import com.example.tcm_kgsystem.service.ArticleService;
import com.example.tcm_kgsystem.service.Util.ESUtil;
import com.example.tcm_kgsystem.transport.TransportObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    ArticleTypeMapper articleTypeMapper;
    @Autowired
    AuditMapper auditMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    ESArticleMapper esArticleMapper;
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    LikeMapper likeMapper;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    ESUtil esUtil;
    @Autowired(required = false)
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public TransportObject articlePublish(Article article, String key) {
        Date time=new Date();
        article.setArticleTime(time);

        Result analyseText = ToAnalysis.parse(article.getArticleContext());
        List<Term> terms = analyseText.getTerms();
        Map<String, Integer> keys=new HashMap<>();
        for (Term term : terms) {
            String word = term.getName();
            String natureStr = term.getNatureStr();
            if (natureStr.equals("n") || natureStr.equals("nr") || natureStr.equals("ns") || natureStr.equals("nt") || natureStr.equals("nz")) {
                if(keys.containsKey(word)){
                    int num=keys.get(word)+1;
                    keys.put(word,num);
                }
                else{
                    keys.put(word,1);
                }
            }
        }
        if(keys.size()>=4) {
            List<Map.Entry<String, Integer>> list = new ArrayList<>(keys.entrySet());
            list.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            String articleTag = "";
            for (int i = 0; i < 4; i++) {
                articleTag += list.get(i).getKey() + ",";
            }
            article.setArticleTag(articleTag);
        }

        try{
            articleMapper.insert(article);

            long adminId= 100000000;
            ArticleExample articleExample=new ArticleExample();
            articleExample.createCriteria().andArticleUserIdEqualTo(article.getArticleUserId()).andArticleTitleEqualTo(article.getArticleTitle()).andArticleAuditEqualTo(0);
            Article article1=articleMapper.selectByExampleWithBLOBs(articleExample).get(0);
            long id=article1.getArticleId();
            article1.setArticleContext(article1.getArticleContext().replace(key,String.valueOf(id)));
            articleMapper.updateByPrimaryKeyWithBLOBs(article1);
            File file1 = new File("C:/Users/zei/Desktop/TCM_KGSystem/src/main/resources/static/article/"+key);
            file1.renameTo(new File("C:/Users/zei/Desktop/TCM_KGSystem/src/main/resources/static/article/"+String.valueOf(id)));

            esUtil.addArticle(article1);
            Audit audit=new Audit((long)0,adminId,article.getArticleUserId(),id,time,0);
            auditMapper.insert(audit);

            Admin admin=adminMapper.selectByPrimaryKey(adminId);
            admin.setAdminAudit(admin.getAdminAudit()+1);
            adminMapper.updateByPrimaryKey(admin);

            TransportObject transportObject=new TransportObject(200,"ok",article);
            return transportObject;
        }catch (Exception e){
            e.printStackTrace();
            TransportObject transportObject=new TransportObject(300,"error",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject articleView(long userId, long articleId) {
        Date time=new Date();

        HistoryExample historyExample=new HistoryExample();
        historyExample.setOrderByClause("history_time desc");
        historyExample.createCriteria().andHistoryUserIdEqualTo(userId).andHistoryArticleIdEqualTo(articleId);
        List<History> histories=historyMapper.selectByExample(historyExample);

        if(CollectionUtils.isEmpty(histories)){
            History history=new History((long)0, articleId, userId, time);
            historyMapper.insert(history);

            Article article=articleMapper.selectByPrimaryKey(articleId);
            article.setArticleView(article.getArticleView()+1);
            articleMapper.updateByPrimaryKey(article);

            User user=userMapper.selectByPrimaryKey(article.getArticleUserId());
            user.setUserView(user.getUserView()+1);
            userMapper.updateByPrimaryKey(user);
            TransportObject transportObject=new TransportObject(200,"ok",history);
            return transportObject;
        }
        else{
            Date lastedTime=histories.get(0).getHistoryTime();
            Date mustTime=new Date(lastedTime.getTime()+ 60000);
            if(mustTime.before(time)){
                History history=new History((long)0, articleId, userId, time);
                historyMapper.insert(history);

                Article article=articleMapper.selectByPrimaryKey(articleId);
                article.setArticleView(article.getArticleView()+1);
                articleMapper.updateByPrimaryKey(article);

                User user=userMapper.selectByPrimaryKey(article.getArticleUserId());
                user.setUserView(user.getUserView()+1);
                userMapper.updateByPrimaryKey(user);
                TransportObject transportObject=new TransportObject(200,"ok",history);
                return transportObject;
            }
            else{
                TransportObject transportObject=new TransportObject(200,"ok",null);
                return transportObject;
            }
        }
    }

    @Override
    public TransportObject articleDelete(long articleId) {
        if(Objects.nonNull(articleMapper.selectByPrimaryKey(articleId))){
            articleMapper.deleteByPrimaryKey(articleId);

            Article article=articleMapper.selectByPrimaryKey(articleId);

            esUtil.deleteArticle(article);

            User user=userMapper.selectByPrimaryKey(article.getArticleUserId());
            user.setUserView(user.getUserView()-article.getArticleView());
            user.setUserLike(user.getUserLike()-article.getArticleLike());
            userMapper.updateByPrimaryKey(user);

            TransportObject transportObject=new TransportObject(200,"ok",null);
            return transportObject;
        }
        else{
            TransportObject transportObject=new TransportObject(300,"null",null);
            return transportObject;
        }
    }

    @Override
    public TransportObject userShowArticle(long userId, int page) {
        TransportObject transportObject=new TransportObject();
        PageHelper.startPage(page,10);
        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andArticleUserIdEqualTo(userId).andArticleAuditEqualTo(1);
        articleExample.setOrderByClause("article_time desc");
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
    public TransportObject articleSelect(String str, int page) {
        TransportObject transportObject=new TransportObject();
        Pageable pageable=PageRequest.of(page-1,20);
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.should(QueryBuilders.matchQuery("title",str));
        boolQueryBuilder.should(QueryBuilders.matchQuery("context",str));
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(pageable)
                .withHighlightFields(new HighlightBuilder.Field("title"))
                .withHighlightBuilder(new HighlightBuilder().preTags("<em style=\"color:red\">").postTags("</em>"))
                .withSorts(SortBuilders.fieldSort("time").order(SortOrder.DESC));

        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        SearchHits<ArticleDocument> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, ArticleDocument.class);

        long totalHits = searchHits.getTotalHits();
        List<Article> articles = new ArrayList();
        if(totalHits<=0){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            for (SearchHit<ArticleDocument> searchHit : searchHits) {
                long id= Long.parseLong(searchHit.getId());
                Article article=articleMapper.selectByPrimaryKey(id);

                Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
                if(!CollectionUtils.isEmpty(highlightFields)){
                    article.setArticleTitle(highlightFields.get("title").get(0));
                }

                articles.add(article);
            }
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }

        PageImpl<Article> result=new PageImpl<>(articles,pageable,totalHits);

        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject articleRecommend(long userId) {
//        LikeExample likeExample=new LikeExample();
//        likeExample.createCriteria().andLikeUserIdEqualTo(userId);
//        List<Like> likes=likeMapper.selectByExample(likeExample);
//
//        CollectExample collectExample=new CollectExample();
//        collectExample.createCriteria().andCollectUserIdEqualTo(userId);
//        List<Collect> collects=collectMapper.selectByExample(collectExample);
//
//        HistoryExample historyExample=new HistoryExample();
//        historyExample.createCriteria().andHistoryUserIdEqualTo(userId);
//        List<History> histories=historyMapper.selectByExample(historyExample);
//
//        Map<Long,Integer> likeMap=new HashMap<>();
//        Map<Long,Integer> historyMap=new HashMap<>();
//
//        for (Like like : likes) {
//            Article article=articleMapper.selectByPrimaryKey(like.getLikeArticleId());
//            if(likeMap.containsKey(article.getArticleTypeId())){
//                likeMap.put(article.getArticleTypeId(),likeMap.get(article.getArticleTypeId())+1);
//            }
//            else{
//                likeMap.put(article.getArticleTypeId(),1);
//            }
//        }
//        for (Collect collect : collects) {
//            Article article=articleMapper.selectByPrimaryKey(collect.getCollectArticleId());
//            if(likeMap.containsKey(article.getArticleTypeId())){
//                likeMap.put(article.getArticleTypeId(),likeMap.get(article.getArticleTypeId())+2);
//            }
//            else{
//                likeMap.put(article.getArticleTypeId(),2);
//            }
//        }
//        for (History history : histories) {
//            Article article=articleMapper.selectByPrimaryKey(history.getHistoryArticleId());
//            if(historyMap.containsKey(article.getArticleTypeId())){
//                historyMap.put(article.getArticleTypeId(),likeMap.get(article.getArticleTypeId())+1);
//            }
//            else{
//                historyMap.put(article.getArticleTypeId(),1);
//            }
//        }
//
//        List<Map.Entry<Long, Integer>> list1 = new ArrayList<>(likeMap.entrySet());
//        List<Map.Entry<Long, Integer>> list2 = new ArrayList<>(historyMap.entrySet());
//
//        list1.sort(new Comparator<Map.Entry<Long, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//        list2.sort(new Comparator<Map.Entry<Long, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//
//        long articleTypeId1=list1.get(0).getKey();
//        long articleTypeId2=list2.get(0).getKey();
//
//        List<Article> result=new ArrayList<>();
//        if(articleTypeId1==articleTypeId2){
//            ArticleExample articleExample=new ArticleExample();
//            articleExample.createCriteria().andArticleTimeLessThan(new Date()).andArticleTypeIdEqualTo(articleTypeId1);
//            List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);
//            Map<Article, Integer> map=new HashMap<>();
//
//            for (Article article : articles) {
//                int value = article.getArticleView() + article.getArticleLike() * 6 + article.getArticleCollect() * 9 + article.getArticleComment() * 4;
//                map.put(article, value);
//            }
//
//            List<Map.Entry<Article, Integer>> list = new ArrayList<>(map.entrySet()); //转换为list
//
//            list.sort(new Comparator<Map.Entry<Article, Integer>>() {
//                @Override
//                public int compare(Map.Entry<Article, Integer> o1, Map.Entry<Article, Integer> o2) {
//                    return o2.getValue().compareTo(o1.getValue());
//                }
//            });
//
//            for (int i = 0; i < 5; i++) {
//                result.add(list.get(i).getKey());
//            }
//        }
//        else {
//            ArticleExample articleExample=new ArticleExample();
//            articleExample.createCriteria().andArticleTimeLessThan(new Date()).andArticleTypeIdEqualTo(articleTypeId1);
//            List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);
//            Map<Article, Integer> map=new HashMap<>();
//
//            for (Article article : articles) {
//                int value = article.getArticleView() + article.getArticleLike() * 6 + article.getArticleCollect() * 9 + article.getArticleComment() * 4;
//                map.put(article, value);
//            }
//
//            List<Map.Entry<Article, Integer>> list = new ArrayList<>(map.entrySet()); //转换为list
//
//            list.sort(new Comparator<Map.Entry<Article, Integer>>() {
//                @Override
//                public int compare(Map.Entry<Article, Integer> o1, Map.Entry<Article, Integer> o2) {
//                    return o2.getValue().compareTo(o1.getValue());
//                }
//            });
//
//            for (int i = 0; i < 4; i++) {
//                result.add(list.get(i).getKey());
//            }
//
//            ArticleExample articleExample1=new ArticleExample();
//            articleExample1.createCriteria().andArticleTimeLessThan(new Date()).andArticleTypeIdEqualTo(articleTypeId2);
//            List<Article> articles1=articleMapper.selectByExampleWithBLOBs(articleExample);
//            Map<Article, Integer> map1=new HashMap<>();
//
//            for (Article article : articles1) {
//                int value = article.getArticleView() + article.getArticleLike() * 6 + article.getArticleCollect() * 9 + article.getArticleComment() * 4;
//                map1.put(article, value);
//            }
//
//            List<Map.Entry<Article, Integer>> listh = new ArrayList<>(map1.entrySet()); //转换为list
//            list.sort(new Comparator<Map.Entry<Article, Integer>>() {
//                @Override
//                public int compare(Map.Entry<Article, Integer> o1, Map.Entry<Article, Integer> o2) {
//                    return o2.getValue().compareTo(o1.getValue());
//                }
//            });
//
//            result.add(list.get(0).getKey());
//        }

        LikeExample likeExample=new LikeExample();
        likeExample.setOrderByClause("like_time desc");
        likeExample.createCriteria().andLikeUserIdEqualTo(userId);
        List<Like> likes=likeMapper.selectByExample(likeExample);
        CollectExample collectExample=new CollectExample();
        collectExample.setOrderByClause("collect_time desc");
        collectExample.createCriteria().andCollectUserIdEqualTo(userId);
        List<Collect> collects=collectMapper.selectByExample(collectExample);
        HistoryExample historyExample=new HistoryExample();
        historyExample.setOrderByClause("history_time desc");
        historyExample.createCriteria().andHistoryUserIdEqualTo(userId);
        List<History> histories=historyMapper.selectByExample(historyExample);
        Set<Long> userArticleIds=new HashSet<>();
        int likeNum=0;
        int collectNum=0;
        int historyNum=0;
        for(Like like:likes){
            userArticleIds.add(like.getLikeArticleId());
            likeNum++;
            if(likeNum==10){
                break;
            }
        }
        for(Collect collect:collects){
            userArticleIds.add(collect.getCollectArticleId());
            collectNum++;
            if(collectNum==10){
                break;
            }
        }
        for(History history:histories){
            userArticleIds.add(history.getHistoryArticleId());
            historyNum++;
            if(historyNum==10){
                break;
            }
        }

        Set<String> userTags=new HashSet<>();
        for(Long articleId: userArticleIds){
            Article article=articleMapper.selectByPrimaryKey(articleId);
            if(StringUtils.isNotEmpty(article.getArticleTag())){
                List<String> articleTags= Arrays.asList(article.getArticleTag().split(","));
                userTags.addAll(articleTags);
            }
        }

        Set<Long> recommendSet=new HashSet<>();
        for(String tag:userTags){
            ArticleExample articleExample=new ArticleExample();
            articleExample.setOrderByClause("article_time desc");
            articleExample.createCriteria().andArticleTagLike("%"+tag+"%");
            List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);
            for(Article article: articles){
                recommendSet.add(article.getArticleId());
            }
        }

        List<Long> recommendArticle=new ArrayList<>();
        int num=0;
        for(Long articleId: recommendSet){
            LikeExample likeExample1=new LikeExample();
            likeExample1.createCriteria().andLikeArticleIdEqualTo(articleId);
            List<Like> likeList=likeMapper.selectByExample(likeExample1);
            CollectExample collectExample1=new CollectExample();
            collectExample1.createCriteria().andCollectArticleIdEqualTo(articleId);
            List<Collect> collectList=collectMapper.selectByExample(collectExample1);
            HistoryExample historyExample1=new HistoryExample();
            historyExample1.createCriteria().andHistoryArticleIdEqualTo(articleId);
            List<History> historyList=historyMapper.selectByExample(historyExample1);
            if(CollectionUtils.isEmpty(likeList)&&CollectionUtils.isEmpty(collectList)&&CollectionUtils.isEmpty(historyList)){
                recommendArticle.add(articleId);
                num++;
                if(num==20){
                    break;
                }
            }
        }

        Map<Article,Double> articleScores=new HashMap<>();
        for(Long articleId:recommendArticle){
            Article article=articleMapper.selectByPrimaryKey(articleId);
            articleScores.put(article,recommendScore(article,userId));
        }
        List<Map.Entry<Article,Double>> list = new ArrayList<>(articleScores.entrySet());
        list.sort(new Comparator<Map.Entry<Article,Double>>() {
            @Override
            public int compare(Map.Entry<Article,Double> o1, Map.Entry<Article,Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        List<Article> result=new ArrayList<>();
        for(int i=0;i<5;i++){
            result.add(list.get(i).getKey());
        }

        TransportObject transportObject=new TransportObject(200, "ok", result);
        return transportObject;
    }

    Double recommendScore(Article article, long userId){
        if(StringUtils.isEmpty(article.getArticleTag())){
            return 0.0;
        }

        List<String> articleTags= Arrays.asList(article.getArticleTag().split(","));
        Set<Long> articleIds=new HashSet<>();
        for(String tag: articleTags){
            ArticleExample articleExample=new ArticleExample();
            articleExample.setOrderByClause("article_time desc");
            articleExample.createCriteria().andArticleTagLike("%"+tag+"%").andArticleIdNotEqualTo(article.getArticleId());
            List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);
            int num=0;
            for(Article article1:articles){
                articleIds.add(article1.getArticleId());
                num++;
                if(num==5){
                    break;
                }
            }
        }

        Map<Long,Double> sim=new HashMap<>();
        for(Long articleId:articleIds){
            Article article1=articleMapper.selectByPrimaryKey(articleId);
            sim.put(articleId,cos(article,article1));
        }
        List<Map.Entry<Long, Double>> list = new ArrayList<>(sim.entrySet()); //转换为list
        list.sort(new Comparator<Map.Entry<Long, Double>>() {
            @Override
            public int compare(Map.Entry<Long, Double> o1, Map.Entry<Long, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        Map<Long,Integer> result=new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            long articleId=list.get(i).getKey();
            int r=0;
            HistoryExample historyExample=new HistoryExample();
            historyExample.createCriteria().andHistoryArticleIdEqualTo(articleId).andHistoryUserIdEqualTo(userId);
            List<History> histories=historyMapper.selectByExample(historyExample);
            LikeExample likeExample=new LikeExample();
            likeExample.createCriteria().andLikeArticleIdEqualTo(articleId).andLikeUserIdEqualTo(userId);
            List<Like> likes=likeMapper.selectByExample(likeExample);
            CollectExample collectExample=new CollectExample();
            collectExample.createCriteria().andCollectArticleIdEqualTo(articleId).andCollectUserIdEqualTo(userId);
            List<Collect> collects=collectMapper.selectByExample(collectExample);
            if(!CollectionUtils.isEmpty(histories)){
                r+=1;
            }
            if(!CollectionUtils.isEmpty(likes)){
                r+=2;
            }
            if(!CollectionUtils.isEmpty(collects)){
                r+=3;
            }
            if(r!=0){
                result.put(articleId,r);
            }
        }

        double score=0.0;
        for(Map.Entry<Long,Integer> entry:result.entrySet()){
            double si=sim.get(entry.getKey());
            score+=si*entry.getValue();
        }
        return score;
    }

    Double cos(Article article,Article article1){
        List<String> articleTags= Arrays.asList(article.getArticleTag().split(","));
        List<String> articleTags1= Arrays.asList(article1.getArticleTag().split(","));
        List<String> comTag=new ArrayList<>(articleTags);
        comTag.retainAll(articleTags1);

        Map<String,Integer> articleKeys=transKeys(article);
        Map<String,Integer> articleKeys1=transKeys(article1);
        int articleSize=0;
        int articleSize1=0;
        for (Map.Entry<String, Integer> entry : articleKeys.entrySet()) {
            articleSize+=entry.getValue();
        }
        for (Map.Entry<String, Integer> entry : articleKeys1.entrySet()) {
            articleSize1+=entry.getValue();
        }

        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andArticleIdGreaterThan((long)0);
        List<Article> subArticles=articleMapper.selectByExampleWithBLOBs(articleExample);

        List<Double> articleVector=new ArrayList<>();
        List<Double> articleVector1=new ArrayList<>();

        for(String tag:comTag){
            Double TF=(double) Math.round((double) articleKeys.get(tag)/articleSize * 100) / 100;
            Double TF1=(double) Math.round((double) articleKeys1.get(tag)/articleSize1 * 100) / 100;

            ArticleExample articleExample1=new ArticleExample();
            articleExample1.createCriteria().andArticleTagLike(("%"+tag+"%"));
            List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);
            Double IDF=Math.log((double)subArticles.size()/(articles.size()+1));

            articleVector.add(TF*IDF);
            articleVector1.add(TF1*IDF);
        }

        double ab=0.0;
        double a2=0.0;
        double b2=0.0;
        for(int i=0;i<articleVector.size();i++){
            ab+=articleVector.get(i)*articleVector1.get(i);
            a2+=articleVector.get(i)*articleVector.get(i);
            b2+=articleVector1.get(i)*articleVector1.get(i);
        }

        double sim= ab /Math.sqrt(a2*b2);
        return sim;
    }

    Map<String, Integer> transKeys(Article article){
        Result analyseText = ToAnalysis.parse(article.getArticleContext());
        List<Term> terms = analyseText.getTerms();
        Map<String, Integer> articleKeys=new HashMap<>();
        for (Term term : terms) {
            String word = term.getName();
            String natureStr = term.getNatureStr();
            if (natureStr.equals("n") || natureStr.equals("nr") || natureStr.equals("ns") || natureStr.equals("nt") || natureStr.equals("nz")) {
                if(articleKeys.containsKey(word)){
                    int num=articleKeys.get(word)+1;
                    articleKeys.put(word,num);
                }
                else{
                    articleKeys.put(word,1);
                }
            }
        }
        return articleKeys;
    }

    @Override
    public TransportObject hotArticles() {

        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)-1, 0, 0, 0);
        Date yesterday  = cal.getTime();

        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andArticleTimeLessThan(new Date());
        //articleExample.createCriteria().andArticleTimeGreaterThan(yesterday);
        List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);
        Map<Article, Integer> map=new HashMap<>();

        for (Article article : articles) {
            int value = article.getArticleView() + article.getArticleLike() * 6 + article.getArticleCollect() * 9 + article.getArticleComment() * 4;
            map.put(article, value);
        }

        List<Map.Entry<Article, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort(new Comparator<Map.Entry<Article, Integer>>() {
            @Override
            public int compare(Map.Entry<Article, Integer> o1, Map.Entry<Article, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        List<Article> result=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            result.add(list.get(i).getKey());
        }

        TransportObject transportObject=new TransportObject(200,"ok",result);
        return transportObject;
    }

    @Override
    public TransportObject articleGet(long articleId) {
        Article article=articleMapper.selectByPrimaryKey(articleId);
        TransportObject transportObject;
        if(Objects.nonNull(article)){
            transportObject = new TransportObject(200, "ok", article);
        }
        else{
            transportObject = new TransportObject(300, "false", null);
        }
        return transportObject;
    }

    @Override
    public TransportObject articleSearchOnUser(long userId, String str, int page) {
        TransportObject transportObject=new TransportObject();
        Pageable pageable=PageRequest.of(page-1,20);
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(QueryBuilders.matchQuery("title",str));
        boolQueryBuilder.must(QueryBuilders.termQuery("userId", userId));
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder()
                .withQuery(boolQueryBuilder)
                .withPageable(pageable)
                .withHighlightFields(new HighlightBuilder.Field("title"))
                .withHighlightBuilder(new HighlightBuilder().preTags("<em style=\"color:red\">").postTags("</em>"))
                .withSorts(SortBuilders.fieldSort("time").order(SortOrder.DESC));

        NativeSearchQuery nativeSearchQuery = nativeSearchQueryBuilder.build();
        SearchHits<ArticleDocument> searchHits = elasticsearchRestTemplate.search(nativeSearchQuery, ArticleDocument.class);

        long totalHits = searchHits.getTotalHits();
        List<Article> articles = new ArrayList();
        if(totalHits<=0){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            for (SearchHit<ArticleDocument> searchHit : searchHits) {
                long id= Long.parseLong(searchHit.getId());
                Article article=articleMapper.selectByPrimaryKey(id);
                Map<String, List<String>> highlightFields = searchHit.getHighlightFields();
                if(!CollectionUtils.isEmpty(highlightFields)){
                    article.setArticleTitle(highlightFields.get("title").get(0));
                }

                articles.add(article);
            }
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }

        PageImpl<Article> result=new PageImpl<>(articles,pageable,totalHits);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject searchAll(int page) {
        TransportObject transportObject=new TransportObject();

        PageHelper.startPage(page,20);
        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andArticleIdGreaterThan((long)0);
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
    public TransportObject changeArticleAudit(long articleId, int articleAudit) {
        TransportObject transportObject;
        Article article=articleMapper.selectByPrimaryKey(articleId);
        if(Objects.nonNull(article)){
            article.setArticleAudit(articleAudit);
            articleMapper.updateByPrimaryKey(article);
            transportObject=new TransportObject(200,"ok",article);
        }
        else{
            transportObject=new TransportObject(300,"false",null);
        }
        return transportObject;
    }

    @Override
    public TransportObject articleUploadImg(MultipartFile file, String key) {
        TransportObject transportObject=new TransportObject();

        String folder = "C:/Users/zei/Desktop/TCM_KGSystem/src/main/resources/static/article/"+key;
        File imgFolder = new File(folder);
        if  (!imgFolder.exists() && !imgFolder.isDirectory())
        {
            imgFolder.mkdir();
        }
        String fileName = file.getOriginalFilename();
        if(StringUtils.isNotEmpty(fileName)){
            String ext = "." + fileName.substring(fileName.lastIndexOf(".")+1);
            String dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now());
            String newFileName=dateTimeFormatter+ext;
            File filePath = new File(imgFolder, newFileName);

            try{
                file.transferTo(filePath);
                transportObject.setCode(200);
                transportObject.setMsg("success");
                transportObject.setObject("http://localhost:8080/api/file/article/"+key+"/"+newFileName);
            }catch (IOException e){
                e.printStackTrace();
                transportObject.setCode(300);
                transportObject.setMsg("fail");
                transportObject.setObject(null);
            }
        }
        return transportObject;
    }

    @Override
    public TransportObject showHistory(long userId, int page) {
        TransportObject transportObject=new TransportObject();
        HistoryExample historyExample=new HistoryExample();
        historyExample.createCriteria().andHistoryUserIdEqualTo(userId);
        PageHelper.startPage(page,10);
        List<Article> articles=new ArrayList<>();
        List<History> histories=historyMapper.selectByExample(historyExample);

        if(CollectionUtils.isEmpty(histories)){
            transportObject.setCode(400);
            transportObject.setMsg("empty");
        }
        else{
            Iterator<History> iterator=histories.iterator();
            while(iterator.hasNext()){
                History history=iterator.next();
                articles.add(articleMapper.selectByPrimaryKey(history.getHistoryArticleId()));
            }
            transportObject.setCode(200);
            transportObject.setMsg("ok");
        }
        PageInfo<Article> result= new PageInfo<>(articles);
        transportObject.setObject(result);
        return transportObject;
    }

    @Override
    public TransportObject tihuan() {
        ArticleExample articleExample=new ArticleExample();
        articleExample.createCriteria().andArticleIdGreaterThan((long)0);
        List<Article> articles=articleMapper.selectByExampleWithBLOBs(articleExample);

        for(Article article: articles){
            Result analyseText = ToAnalysis.parse(article.getArticleContext());

            List<Term> terms = analyseText.getTerms();

            Map<String, Integer> keys=new HashMap<>();

            for (Term term : terms) {
                String word = term.getName();
                String natureStr = term.getNatureStr();
                if (natureStr.equals("n") || natureStr.equals("nr") || natureStr.equals("ns") || natureStr.equals("nt") || natureStr.equals("nz")) {
                    if(keys.containsKey(word)){
                        int num=keys.get(word)+1;
                        keys.put(word,num);
                    }
                    else{
                        keys.put(word,1);
                    }
                }
            }

            if(keys.size()>=4){
                List<Map.Entry<String, Integer>> list = new ArrayList<>(keys.entrySet());

                list.sort(new Comparator<Map.Entry<String, Integer>>() {
                    @Override
                    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                        return o2.getValue().compareTo(o1.getValue());
                    }
                });

                List<String> tags=new ArrayList<>();
                String articleTag="";
                for (int i = 0; i < 4;i++) {
                    tags.add(list.get(i).getKey());
                    articleTag+=list.get(i).getKey()+",";
                }
                article.setArticleTag(articleTag);
                articleMapper.updateByPrimaryKeyWithBLOBs(article);
            }
        }

        TransportObject transportObject=new TransportObject(200,"ok", articles);
        return transportObject;
    }
}
