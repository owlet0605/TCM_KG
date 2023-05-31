<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <UserHeader :uid=this.id></UserHeader>
        <el-row>
          <el-col :span="17" class="articles">
            <div class="myArticles">
              <el-row class="header">
                <el-text v-if="myIf"><h3>我的资讯</h3></el-text>
                <el-text v-else><h3>他的资讯</h3></el-text>
                <el-tag size="small" effect="dark">{{my}}</el-tag>
                <div class="button">
                  <el-button plain @click="goArticle">
                    查看全部
                    <el-icon><ArrowRight /></el-icon>
                  </el-button>
                </div>
              </el-row>
              <el-row v-for="article in myArticles">
                <ArticleItem :article="article"></ArticleItem>
              </el-row>
            </div>
            <el-divider/>
            <div class="collectArticles">
              <el-row class="header">
                <el-text v-if="myIf"><h3>我的收藏</h3></el-text>
                <el-text v-else><h3>他的收藏</h3></el-text>
                <el-tag size="small" effect="dark">{{collect}}</el-tag>
                <div class="button">
                  <el-button plain @click="goCollect">
                    查看全部
                    <el-icon><ArrowRight /></el-icon>
                  </el-button>
                </div>
              </el-row>
              <el-row v-for="article in collectArticles">
                <ArticleItem :article="article"></ArticleItem>
              </el-row>
            </div>
            <el-divider/>
            <div class="likeArticles">
              <el-row class="header">
                <el-text v-if="myIf"><h3>我的点赞</h3></el-text>
                <el-text v-else><h3>他的点赞</h3></el-text>
                <el-tag size="small" effect="dark">{{like}}</el-tag>
                <div class="button">
                  <el-button plain @click="goLike">
                    查看全部
                    <el-icon><ArrowRight /></el-icon>
                  </el-button>
                </div>
              </el-row>
              <el-row v-for="article in likeArticles">
                <ArticleItem :article="article"></ArticleItem>
              </el-row>
            </div>
          </el-col>
          <el-col :span="1"></el-col>
          <el-col :span="6"  class="information">
            <el-row class="header">
              <el-text>个人资料</el-text>
              <el-button v-if="myIf" plain text bg @click="changeInfo">修改资料</el-button>
              <el-button v-if="myIf" type="danger" @click="deleteUser">注销</el-button>
            </el-row>
            <el-divider />
            <el-row>
              <el-text>UID：{{user.userId}}</el-text>
            </el-row>
            <br>
            <el-row v-if="myIf">
              <el-text>生日：{{user.userBirthday}}</el-text>
            </el-row>
            <br>
            <el-row v-if="myIf">
              <el-text>性别：{{user.userSex}}</el-text>
            </el-row>
          </el-col>
        </el-row>
      </div>
    </el-main>
    <el-footer>
      <span>owlet——1029621681@qq.com</span>
    </el-footer>
  </el-container>
</template>

<script>
import UserHeader from "@/components/header/UserHeader.vue";
import SystemHeader from "@/components/header/SystemHeader.vue";
import ArticleItem from "@/components/Item/ArticleItem.vue";
import {getUser, userDelete} from "@/api/user";
import {showLikes} from "@/api/like";
import {showArticles} from "@/api/article";
import {showCollects} from "@/api/collect";
import {ElMessageBox} from "element-plus";
import {ArrowRight} from "@element-plus/icons-vue";
export default {
  name: "UserHome",
  components: {ArrowRight, ArticleItem, SystemHeader, UserHeader},
  data() {
    return{
      id: this.$route.query.id,
      myIf: '',
      user: {
        userId: "",
        userName: "",
        userSex: "",
        userStatus: "",
        userImg: "",
        userFans: "",
        userConcern: "",
        userLike: "",
        userView: ""
      },
      my: 0,
      myArticles: [],
      collect: 0,
      collectArticles: [],
      like: 0,
      likeArticles: [],
    }
  },
  created() {
    if(this.$store.getters['user'].userId===''){
      this.myIf=false
    }
    else{
      this.myIf=this.id===this.$store.getters['user'].userId
    }
    getUser(this.id).then(res=>{
      if(res.data.code===200){
        this.user.userId=res.data.object.userId
        this.user.userName=res.data.object.userName
        this.user.userSex=res.data.object.userSex
        this.user.userStatus=res.data.object.userStatus
        this.user.userImg=res.data.object.userImg
        this.user.userFans=res.data.object.userFans
        this.user.userConcern=res.data.object.userConcern
        this.user.userLike=res.data.object.userLike
        this.user.userView=res.data.object.userView
      }
    }).catch(e=>{
      console.log(e)
    })

    showLikes(this.id, "1").then(res=>{
      this.like=res.data.object.total
      if(res.data.code===200){
        if(this.like>5){
          for(let i=0; i<5; i++){
            let article=res.data.object.list[i]
            this.likeArticles.push({
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
        else{
          for(let i=0; i<this.like; i++){
            let article=res.data.object.list[i]
            this.likeArticles.push({
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
      }
    }).catch(e=>{
      console.log(e)
    })

    showArticles(this.id, "1").then(res=>{
      this.my=res.data.object.total
      if(res.data.code===200){
        if(this.my>5){
          for(let i=0; i<5; i++){
            let article=res.data.object.list[i]
            this.myArticles.push({
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
        else{
          for(let i=0; i<this.my; i++){
            let article=res.data.object.list[i]
            this.myArticles.push({
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
      }
    }).catch(e=>{
      console.log(e)
    })

    showCollects(this.id, "1").then(res=>{
      this.collect=res.data.object.total
      if(res.data.code===200){
        if(this.collect>5){
          for(let i=0; i<5; i++){
            let article=res.data.object.list[i]
            this.collectArticles.push({
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
        else{
          for(let i=0; i<this.collect; i++){
            let article=res.data.object.list[i]
            this.collectArticles.push({
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
      }
    }).catch(e=>{
      console.log(e)
    })


  },
  methods: {
    changeInfo: function (){
      this.$router.push({
        name: 'ChangeInfo'
      })
    },
    deleteUser: function (){
      ElMessageBox.confirm(
          '用户将被注销. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        userDelete(this.id).then(res=>{
          if(res.data.code===200){
            this.$store.dispatch('logout')
            this.$router.push({
              name: 'UserLogin'
            })
          }
        }).catch(e=>{
          console.log(e)
        })
      })
    },
    goArticle: function (){
      this.$router.push({
        name: 'UserArticle',
        query: {
          id: this.id
        }
      })
    },
    goCollect: function (){
      this.$router.push({
        name: 'UserCollect',
        query: {
          id: this.id
        }
      })
    },
    goLike: function (){
      this.$router.push({
        name: 'UserLike',
        query: {
          id: this.id
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

.information {
  background-color: #fff;
  border-radius: 6px;
  text-align: center;
  padding: 25px 15px 15px 15px;
  height: 240px;
  margin: 10px 0px 10px 0px;
}

.el-text {
  margin: 0px 10px 0px 5px;
}

.button {
  width: 85%;
  text-align: right;
}
</style>