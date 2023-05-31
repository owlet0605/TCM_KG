<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row>
          <h1 class="title">{{articleType.articleTypeTag}}</h1>
        </el-row>
        <el-row>
          <h3 class="describe">{{articleType.articleTypeDescribe}}</h3>
        </el-row>
        <div v-if="total!==0" class="articles">
          <el-row><el-tag size="large">共{{articleType.articleTypeNum}}篇</el-tag></el-row>
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
        <div v-else class="articles"><el-empty>暂未发布该类型的资讯</el-empty></div>
      </div>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import SystemHeader from "@/components/header/SystemHeader.vue";
import ArticleItem from "@/components/Item/ArticleItem.vue";
import {getArticleType, showArticlesOfType} from "@/api/article";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "ArticleTypeDetail",
  components: {SystemFooter, ArticleItem, SystemHeader},
  data() {
    return {
      articleType: {
        articleTypeId: "",
        articleTypeTag: "",
        articleTypeDescribe: "",
        articleTypeNum: ""
      },
      page: 1,
      total: 0,
      articles: []
    }
  },
  created() {
    getArticleType(this.$route.query.atid).then(res=>{
      if(res.data.code===200){
        this.articleType.articleTypeId=res.data.object.articleTypeId
        this.articleType.articleTypeTag=res.data.object.articleTypeTag
        this.articleType.articleTypeDescribe=res.data.object.articleTypeDescribe
        this.articleType.articleTypeNum=res.data.object.articleTypeNum
      }
    }).catch(e=>{
      console.log(e)
    })

    showArticlesOfType(this.$route.query.atid, this.page).then(res=>{
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
            articleLike: article.articleLike,
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    changePage: function () {
      this.articles=[]
      showArticlesOfType(this.$route.query.atid, this.page).then(res=>{
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
              articleLike: article.articleLike,
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    },
  }
}
</script>

<style scoped>
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
  text-align: center;
}

.articles {
  text-align: left;
  padding: 5px 10px 10px 10px;
  margin: 0px 0px 10px 0px;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}

.describe {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}
</style>