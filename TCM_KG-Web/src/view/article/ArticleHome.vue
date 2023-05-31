<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row class="header">
          <el-col :span="3"><el-button round @click="hotArticle">热门资讯</el-button></el-col>
          <el-col :span="3"><el-button round @click="typeList">资讯频道</el-button></el-col>
          <el-col :span="15">
            <el-input v-model="str" placeholder="搜索...">
              <template #append>
                <el-button slot="append" type="primary" @click="search"><el-icon><Search/></el-icon>搜索</el-button>
              </template>
            </el-input>
          </el-col>
          <el-col :span="2">
            <el-button type="primary" @click="publish"><el-icon><Plus /></el-icon>发布资讯</el-button></el-col>
        </el-row>
        <el-carousel v-if="this.recommendArticles.length!==0" indicator-position="outside" type="card" height="200px">
          <el-carousel-item v-for="article in recommendArticles" :key="article">
            <div class="recommend">
              <el-link @click="showDetail(article.articleId)"><h3>{{ article.articleTitle }}</h3></el-link>
            </div>
          </el-carousel-item>
        </el-carousel>
        <div v-if="total!==0" class="articles">
          <el-row v-for="article in articles">
            <ArticleItem :article="article"></ArticleItem>
          </el-row>
          <el-pagination
              @current-change="changePage"
              v-model:current-page="this.page"
              :default-current-page="parseInt(this.page)"
              hide-on-single-page
              :page-size="20"
              background
              layout="prev, pager, next, jumper"
              :total="parseInt(this.total)"
          ></el-pagination>
        </div>
        <div v-else class="articles"><el-empty><h3>未找到相关信息</h3></el-empty></div>
      </div>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import SystemHeader from "@/components/header/SystemHeader.vue";
import {Plus, Search} from "@element-plus/icons-vue";
import ArticleItem from "@/components/Item/ArticleItem.vue";
import {articleAll, articleRecommend, articleSearch} from "@/api/article";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "ArticleHome",
  components: {SystemFooter, ArticleItem, Search, Plus, SystemHeader},
  data() {
    return {
      str: "",
      page: 1,
      total: 0,
      mode: "all",
      recommendArticles: [],
      articles: []
    }
  },
  created() {
    this.str=this.$route.query.str===undefined?'':this.$route.query.str
    this.mode=this.$route.query.mode===undefined?'all':this.$route.query.mode
    this.changePage()

    if(this.$store.getters['user'].userId!==''&&this.mode==='all'){
      articleRecommend(this.$store.getters['user'].userId).then(res=>{
        for(let i=0; i<5; i++){
          let article=res.data.object[i]
          this.recommendArticles.push({
            articleId: article.articleId,
            articleUserId: article.articleUserId,
            articleTypeId: article.articleTypeId,
            articleTitle: article.articleTitle,
            articleTime: article.articleTime,
            articleView: article.articleView,
            articleLike: article.articleLike
          })
        }
      }).catch(e=>{
        console.log(e)
      })
    }
  },
  methods: {
    changePage: function () {
      this.articles=[]
      if(this.mode==="all"){
        articleAll(this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0; i<res.data.object.list.length; i++){
              let article=res.data.object.list[i]
              this.articles.push({
                articleId: article.articleId,
                articleUserId: article.articleUserId,
                articleTypeId: article.articleTypeId,
                articleTitle: article.articleTitle,
                articleTime: article.articleTime,
                articleView: article.articleView,
                articleLike: article.articleLike
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else{
        articleSearch(this.str, this.page).then(res=>{
          this.total=res.data.object.totalElements
          if(res.data.code===200){
            for(let i=0; i<res.data.object.content.length; i++){
              let article=res.data.object.content[i]
              this.articles.push({
                articleId: article.articleId,
                articleUserId: article.articleUserId,
                articleTypeId: article.articleTypeId,
                articleTitle: article.articleTitle,
                articleTime: article.articleTime,
                articleView: article.articleView,
                articleLike: article.articleLike
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
    },
    search: function (){
      if(this.str!==''){
        this.articles=[]
        this.mode="search"
        this.$router.push({
          name: 'ArticleHome',
          query: {
            mode: this.mode,
            str: this.str
          }
        })
      }
    },
    hotArticle: function (){
      this.$router.push({
        name: 'HotArticles'
      })
    },
    typeList: function (){
      this.$router.push({
        name: 'ArticleType'
      })
    },
    publish: function (){
      this.$router.push({
        name: 'ArticlePublish'
      })
    },
    showDetail: function (val) {
      this.$router.push({
        name: 'ArticleDetail',
        query: {
          aid: val
        }
      })
    }
  }
}
</script>

<style scoped>
.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

.el-container {
  height: 100%;
  width: 100%;
  position: fixed;
}

.el-header {
  height: 8%;
  width: 100%;
  padding: 0;
}

.el-main {
  height: 80%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: start;
  padding: 0px 20px 20px 20px;
  background-image: url("../../assets/login-background.png");
  background-size: cover;
}

.el-footer {
  height: 5%;
  width: 100%;
  line-height: 40px;
  bottom: 0;
  text-align: center;
  font-size: 12px;
  letter-spacing: 1px;
}

.detail {
  width: 60%;
  background-color: #fff;
  padding: 25px 25px 25px 25px;
}

.header {
  padding: 0px 5px 15px 5px;
}

.el-input {
  width: 300px;
}

.articles {
  text-align: left;

  padding: 5px 10px 10px 10px;
  margin: 0px 0px 10px 0px;
}

.recommend {
  text-align: center;
  padding: 50px 5px 0 5px;
}
</style>