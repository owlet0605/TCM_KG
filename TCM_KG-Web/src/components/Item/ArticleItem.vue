<template>
  <el-card class="box-card">
    <template #header>
      <div class="card-header">
        <el-row>
          <el-col :span="10"><el-link @click="showDetail"><span v-html="article.articleTitle"></span></el-link></el-col>
          <el-col :span="2"><el-tag effect="dark" @click="typeDetail">{{articleType.articleTypeTag}}</el-tag></el-col>
          <el-col :span="1" :offset="1">
            <el-button v-if="this.user.userId.toString()===this.$store.getters['user'].userId" size="small" type="danger" @click="deleteArticle">
              <el-icon><Delete/></el-icon>
            </el-button>
          </el-col>
          <el-col :span="5" :offset="5">{{article.articleTime}}</el-col>
        </el-row>
      </div>
    </template>
    <el-row>
      <el-col :span="20"><el-text>{{user.userName}}</el-text></el-col>
      <el-col :span="2"><el-text>浏览量{{article.articleView}}</el-text></el-col>
      <el-col :span="2"><el-text>点赞量{{article.articleLike}}</el-text></el-col>
    </el-row>
  </el-card>
</template>

<script>

import {getUser} from "@/api/user";
import {articleDelete, getArticleType} from "@/api/article";
import {Delete} from "@element-plus/icons-vue";
import {ElMessageBox} from "element-plus";

export default {
  name: "ArticleItem",
  components: {Delete},
  props: ['article'],
  data() {
    return{
      user: {
        userId: '',
        userName: ''
      },
      articleType: {
        articleTypeId: '',
        articleTypeTag: ''
      }
    }
  },
  created() {
    getUser(this.article.articleUserId).then(res=>{
      if(res.data.code===200){
        this.user.userId=res.data.object.userId
        this.user.userName=res.data.object.userName
      }
    }).catch(e=>{
      console.log(e)
    })

    getArticleType(this.article.articleTypeId).then(res=>{
      if(res.data.code===200){
        this.articleType.articleTypeId=res.data.object.articleTypeId
        this.articleType.articleTypeTag=res.data.object.articleTypeTag
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    showDetail: function (){
      this.$router.push({
        name: 'ArticleDetail',
        query: {
          aid: this.article.articleId
        }
      })
    },
    typeDetail: function (){
      this.$router.push({
        name: 'ArticleTypeDetail',
        query: {
          atid: this.articleType.articleTypeId
        }
      })
    },
    deleteArticle: function (){
      ElMessageBox.confirm(
          '资讯将被删除. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        articleDelete(this.article.articleId).then(res=>{
          if(res.data.code===200){
            this.$router.push({
              name: 'ArticleHome'
            })
          }
        }).catch(e=>{
          console.log(e)
        })
      })
    },
  }
}
</script>

<style scoped>
.el-card {
  margin: 0 0 10px 0;
  width: 1000px;
}
</style>