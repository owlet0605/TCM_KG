<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row>
          <el-breadcrumb :separator-icon="ArrowRight">
            <el-breadcrumb-item :to="{ name: 'ArticleHome' }">
              中药资讯
            </el-breadcrumb-item>
            <el-breadcrumb-item>热门资讯</el-breadcrumb-item>
          </el-breadcrumb>
        </el-row>
        <el-divider/>
        <h1 class="title">热门资讯</h1>
        <div class="articles">
          <el-row v-for="article in articles">
            <ArticleItem :article="article"></ArticleItem>
          </el-row>
        </div>
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
import {articleRecommend, hotArticle} from "@/api/article";
import {ArrowRight} from "@element-plus/icons-vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "HotArticles",
  computed: {
    ArrowRight() {
      return ArrowRight
    }
  },
  components: {SystemFooter, ArticleItem, SystemHeader},
  data() {
    return {
      articles: []
    }
  },
  created() {
    hotArticle().then(res=>{
      for(let i=0; i<res.data.object.length; i++){
        let article=res.data.object[i]
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
    })
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
  width: 65%;
  background-color: #fff;
  padding: 25px 25px 25px 25px;
  text-align: center;
}

.articles {
  text-align: center;
  padding: 5px 25px 25px 25px;
  margin: 0px 0px 10px 0px;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}
</style>