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
            <el-breadcrumb-item>资讯频道</el-breadcrumb-item>
          </el-breadcrumb>
        </el-row>
        <el-divider/>
        <el-row>
          <el-col :span="4" class="menu">
            <el-menu
                default-active="1"
                text-color="#2d4b73"
                background-color="#ebddcb"
            >
              <el-menu-item v-for="articleType in articleTypes" @click="show(articleType.articleTypeId)">
                <span>{{articleType.articleTypeTag}}</span>
              </el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="19" class="articles">
            <el-row class="button">
              <el-col><el-button plain text bg @click="typeDetail">更多<el-icon><DArrowRight /></el-icon></el-button></el-col>
            </el-row>
            <el-row v-for="article in articles">
              <ArticleItem :article="article"></ArticleItem>
            </el-row>
          </el-col>
        </el-row>
      </div>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import SystemHeader from "@/components/header/SystemHeader.vue";
import {showAllArticleType, showArticlesOfType} from "@/api/article";
import ArticleItem from "@/components/Item/ArticleItem.vue";
import {ArrowRight, DArrowRight} from "@element-plus/icons-vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "ArticleType",
  computed: {
    ArrowRight() {
      return ArrowRight
    }
  },
  components: {SystemFooter, DArrowRight, ArticleItem, SystemHeader},
  data() {
    return {
      articleTypes: [],
      articles: [],
      typeId: 100000000,
      page: 1
    }
  },
  created() {
    showAllArticleType(this.page).then(res=>{
      if(res.data.code===200){
        for(let i=0; i<res.data.object.list.length; i++){
          let type=res.data.object.list[i]
          this.articleTypes.push({
            articleTypeId: type.articleTypeId,
            articleTypeTag: type.articleTypeTag
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })

    showArticlesOfType(100000000,1).then(res=>{
      if(res.data.code===200){
        let max=res.data.object.list.length>10?10:res.data.object.list.length
        for(let i=0; i<max; i++){
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
    show: function (id){
      this.articles=[]
      this.typeId=id
      showArticlesOfType(id,1).then(res=>{
        if(res.data.code===200){
          let max=res.data.object.list.length>10?10:res.data.object.list.length
          for(let i=0; i<max; i++){
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
    typeDetail: function (){
      this.$router.push({
        name: 'ArticleTypeDetail',
        query: {
          atid: this.typeId
        }
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
  width: 80%;
  background-color: #fff;
  padding: 25px 25px 25px 25px;
}

.articles {
  width: 80%;
  padding: 10px 10px 10px 10px;
  margin: 0px 0px 0px 20px;
  border-style: ridge;
}

.menu {
  background-color: #ebddcb;
  heigth: 100%
}

.button {
  margin: 0px 0px 10px 850px;
}
</style>