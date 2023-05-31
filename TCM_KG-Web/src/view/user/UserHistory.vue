<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <UserHeader :uid=this.id></UserHeader>
        <div v-if="total!==0" class="articles">
          <el-row class="header">
            <el-text><h3>历史记录</h3></el-text>
          </el-row>
          <el-row class="mode">
            <el-link @click="">全部</el-link>
            <el-text>{{"&nbsp"+total}}</el-text>
          </el-row>
          <el-row v-for="article in articles">
            <ArticleItem v-if="article.articleAudit===1||my" :article="article"></ArticleItem>
          </el-row>
          <el-pagination
              @current-change="changePage"
              v-model:current-page="this.page"
              :default-current-page="parseInt(this.page)"
              hide-on-single-page
              :page-size="10"
              background
              layout="prev, pager, next, jumper"
              :total="parseInt(this.total)"
          ></el-pagination>
        </div>
        <div v-else class="articles"><el-empty><h3>用户还未浏览任何资讯文章</h3></el-empty></div>
      </div>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import SystemFooter from "@/components/footer/SystemFooter.vue";
import ArticleItem from "@/components/Item/ArticleItem.vue";
import SystemHeader from "@/components/header/SystemHeader.vue";
import UserHeader from "@/components/header/UserHeader.vue";
import {showArticles, showHistories} from "@/api/article";

export default {
  name: "UserHistory",
  components: {SystemFooter, ArticleItem, SystemHeader, UserHeader},
  data() {
    return{
      id: this.$route.query.id,
      page: 1,
      total: 0,
      articles: []
    }
  },
  created() {
    showHistories(this.id, this.page).then(res=>{
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
            articleAudit: article.articleAudit
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    changePage: function (){
      this.articles=[]
      showHistories(this.id, this.page).then(res=>{
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
              articleAudit: article.articleAudit
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    }
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
  background-image: url("../../assets/login-background.png");
  background-size: cover;
  display: flex;
  justify-content: center;
  align-items: start;
  padding: 0px 20px 0px 20px;
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
  width: 80%;
  padding: 0px 25px 25px 25px;
}

.articles {
  background-color: #fff;
  border-radius: 6px;

  padding: 25px 25px 25px 25px;
  margin: 10px 0px 10px 0px;
}

.mode {
  background-color: #99a9bf;
  padding: 10px;
  margin: 0px 0px 10px 0px;
}
</style>