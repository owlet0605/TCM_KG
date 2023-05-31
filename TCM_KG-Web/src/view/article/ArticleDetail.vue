<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <div class="header">
          <el-row>
            <el-col :span="2">
              <el-avatar @click="goUserHome"
                         size="large"
                         :src="this.user.userImg"
              />
            </el-col>
            <el-col :span="18">
              <el-row><el-text><h4 class="userName">{{user.userName}}</h4></el-text></el-row>
              <el-row><el-text>粉丝: {{user.userFans}}</el-text></el-row>
            </el-col>
            <el-col :span="1" class="concern">
              <el-button type="primary" size="large" v-if="!my&&!checkConcern" @click="concernAdd">关注</el-button>
              <el-button type="primary" size="large" plain v-if="!my&&checkConcern" @click="concernDel">已关注</el-button>
            </el-col>
          </el-row>
          <el-row>
            <el-text><h1 class="title">{{article.articleTitle}}</h1></el-text>
            <el-tag @click="goArticleType" effect="dark" class="tag">{{articleType.articleTypeTag}}</el-tag>
          </el-row>
          <el-row>
            <el-col :span="4"><el-text>{{article.articleTime}}</el-text></el-col>
            <el-col :span="2"><el-text>{{article.articleView}}阅读</el-text></el-col>
            <el-col :span="5" :offset="12">
              <el-row>
                <el-col :span="9">
                  <div v-if="checkLike">
                    <el-icon @click="likeArticleDel"><Pointer style="background: #00BFFF"/></el-icon>
                    <el-text>{{article.articleLike}}点赞</el-text>
                  </div>
                  <div v-else>
                    <el-icon @click="likeArticle"><Pointer /></el-icon>
                    <el-text>{{article.articleLike}}点赞</el-text>
                  </div>
                </el-col>
                <el-col :span="9">
                  <div v-if="checkCollect">
                    <el-icon @click="collectDel" style="background: #00BFFF"><Star /></el-icon>
                    <el-text>{{article.articleCollect}}收藏</el-text>
                  </div>
                  <div v-else>
                    <el-icon @click="collect"><Star /></el-icon>
                    <el-text>{{article.articleCollect}}收藏</el-text>
                  </div>
                </el-col>
                <el-col :span="4">
                  <el-icon color="red" size="20px" @click="openReport"><Warning /></el-icon>
                  <el-dialog
                      v-model="reportVisible"
                      title="举报"
                      center
                      destroy-on-close
                  >
                    <el-form :model="reportForm">
                      <el-form-item label="对象" prop="object">
                        <el-input v-model="reportForm.object"></el-input>
                      </el-form-item>
                      <el-form-item label="理由" prop="reason">
                        <el-input v-model="reportForm.reason" type="textarea"></el-input>
                      </el-form-item>
                    </el-form>
                    <el-button type="primary" size="large" @click="report">提交</el-button>
                  </el-dialog>
                </el-col>
                <el-col :span="2">
                  <el-button v-if="my" size="small" type="danger" @click="deleteArticle">
                    <el-icon><Delete/></el-icon>
                  </el-button>
                </el-col>
              </el-row>
            </el-col>
          </el-row>
        </div>
        <div class="context">
<!--          <div v-for="con in content">-->
<!--            <el-row>{{con}}</el-row>-->
<!--            <br v-if="con!==''">-->
<!--          </div>-->
          <mavon-editor  v-html="getHtML()"
                         :subfield="false"
                         defaultOpen="preview"
                         :toolbarsFlag="false"
                         :editable="false"
          ></mavon-editor>
        </div>
        <div class="comment">
          <div v-if="total!==0">
            <el-row v-for="comment in thisComments">
              <CommentItem :comment="comment"></CommentItem>
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
          <div v-else><el-empty description="尚未有人评论" image-size="60px"></el-empty></div>
          <div class="myComment">
            <el-row>
              <el-col :span="2">
                <el-avatar v-if="this.$store.getters['user'].userImg===''" size="large">未登录</el-avatar>
                <el-avatar v-else
                           size="large"
                           :src="this.$store.getters['user'].userImg"
                />
              </el-col>
              <el-col :span="19">
                <el-form :model="comment" >
                  <el-form-item>
                    <el-input v-model="comment.commentContext" type="textarea" />
                  </el-form-item>
                </el-form>
              </el-col>
              <el-col :span="2" :offset="1">
                <el-button plain @click="commentForArticle" class="commentContext">发布</el-button>
              </el-col>
            </el-row>
          </div>
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
import {ArrowRight, Delete, Female, Male, Pointer, Star, Warning} from "@element-plus/icons-vue";
import CommentItem from "@/components/Item/CommentItem.vue";
import {articleDelete, articleView, getArticle, getArticleType} from "@/api/article";
import {getUser, userDelete} from "@/api/user";
import {commentAdd, showComments} from "@/api/comment";
import {concernByUser, concernDelete, concernIf} from "@/api/concern";
import {likeAdd, likeDelete, likeIf} from "@/api/like";
import {collectAdd, collectDelete, collectIf} from "@/api/collect";
import {resultInsert} from "@/api/result";
import {ElMessageBox, ElNotification} from "element-plus";
import { marked } from 'marked';
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "ArticleDetail",
  components: {SystemFooter, Delete, Warning, Pointer, CommentItem, Star, Female, Male, SystemHeader},
  data() {
    return {
      article: {
        articleId: "",
        articleUserId: "",
        articleTypeId: "",
        articleTitle: "",
        articleContext: "",
        articleTime: "",
        articleView: "",
        articleComment: "",
        articleLike: "",
        articleCollect: "",
      },
      user: {
        userId: "",
        userName: "",
        userImg: "",
        userFans: ""
      },
      reportVisible: false,
      reportForm: {
        object: '',
        reason: ''
      },
      articleType: {
        articleTypeId: "",
        articleTypeTag: ""
      },
      my: '',
      page: 1,
      total: "",
      comments: [],
      comment: {
        commentArticleId: '',
        commentUserId: '',
        commentContext: '',
        commentTopId: '',
        commentForId: '',
      },
      count: "",
      concernIs: '',
      collectIs: '',
      likeArticleIs: ''
    }
  },
  created() {
    if(this.$store.getters['user'].userId!==''){
      this.fifteenSecond()
    }

    getArticle(this.$route.query.aid).then(res=>{
      if(res.data.code===200){
        this.article.articleId=res.data.object.articleId
        this.article.articleUserId=res.data.object.articleUserId
        this.article.articleTypeId=res.data.object.articleTypeId
        this.article.articleTitle=res.data.object.articleTitle
        this.article.articleContext=res.data.object.articleContext
        this.article.articleTime=res.data.object.articleTime
        this.article.articleView=res.data.object.articleView
        this.article.articleComment=res.data.object.articleComment
        this.article.articleLike=res.data.object.articleLike
        this.article.articleCollect=res.data.object.articleCollect
        this.article.articleForward=res.data.object.articleForward
        this.my=this.article.articleUserId.toString()===this.$store.getters['user'].userId

        getUser(this.article.articleUserId).then(res=>{
          if(res.data.code===200){
            this.user.userId=res.data.object.userId
            this.user.userName=res.data.object.userName
            this.user.userImg='http://localhost:8080/api/file/userImg/'+res.data.object.userImg
            this.user.userFans=res.data.object.userFans
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

        if(this.$store.getters['user'].userId===''){
          this.concernIs=false;
        }
        else{
          concernIf(this.article.articleUserId, this.$store.getters['user'].userId).then(res=>{
            this.concernIs=res.data.object
          })
        }

        if(this.$store.getters['user'].userId===''){
          this.likeArticleIs=false;
        }
        else{
          likeIf(this.article.articleId, this.$store.getters['user'].userId, "article").then(res=>{
            this.likeArticleIs=res.data.object
          })
        }

        if(this.$store.getters['user'].userId===''){
          this.collectIs=false;
        }
        else{
          collectIf(this.$store.getters['user'].userId, this.article.articleId).then(res=>{
            this.collectIs=res.data.object
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })

    showComments(this.$route.query.aid, this.page, "article").then(res=>{
      this.total=res.data.object.total
      if(res.data.code===200){
        for(let i=0; i<res.data.object.list.length; i++){
          let comment=res.data.object.list[i];
          this.comments.push({
            commentId: comment.commentId,
            commentArticleId: comment.commentArticleId,
            commentUserId: comment.commentUserId,
            commentTime: comment.commentTime,
            commentContext: comment.commentContext,
            commentLike: comment.commentLike,
            commentTopId: comment.commentTopId,
            commentForId: comment.commentForId,
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  computed: {
    ArrowRight() {
      return ArrowRight
    },
    content () {
      let arr = this.article.articleContext.split("\\n");
      return arr
      // return arr.map((item) => {
      //   return item === "\\n" ? "<br>" : item
      // }).join("")
    },
    checkConcern() {
      return this.concernIs
    },
    checkCollect() {
      return this.collectIs
    },
    checkLike() {
      return this.likeArticleIs
    },
    thisComments() {
      return this.comments
    }
  },
  methods: {
    fifteenSecond: function (){
      const TIME_COUNT = 15;
      if(!this.timer){
        this.count = TIME_COUNT;
        this.timer = setInterval(()=>{
          if(this.count > 0 && this.count <= TIME_COUNT){
            this.count--;
          }else{
            clearInterval(this.timer);
            this.timer = null;
            articleView(this.$store.getters['user'].userId, this.article.articleId)
          }
        },1000)
      }
    },
    getHtML: function (){
      return marked(this.article.articleContext)
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
    concernAdd: function (){
      concernByUser(this.user.userId, this.$store.getters['user'].userId).then(res=>{
        if(res.data.code===200){
          this.concernIs=true;
        }
      })
    },
    concernDel: function (){
      concernDelete(this.user.userId, this.$store.getters['user'].userId).then(res=>{
        if(res.data.code===200){
          this.concernIs=false
        }
      })
    },
    collect: function (){
      collectAdd(this.$store.getters['user'].userId, this.article.articleId).then(res=>{
        if(res.data.code===200){
          this.collectIs=true
          this.article.articleCollect=this.article.articleCollect+1
        }
      })
    },
    collectDel: function (){
      collectDelete(this.$store.getters['user'].userId, this.article.articleId).then(res=>{
        if(res.data.code===200){
          this.collectIs=false
          this.article.articleCollect=this.article.articleCollect-1
        }
      })
    },
    likeArticle: function (){
      likeAdd(this.article.articleId, this.$store.getters['user'].userId, "article").then(res=>{
        if(res.data.code===200){
          this.likeArticleIs=true
          this.article.articleLike=this.article.articleLike+1
        }
      })
    },
    likeArticleDel: function (){
      likeDelete(this.article.articleId, this.$store.getters['user'].userId, "article").then(res=>{
        if(res.data.code===200){
          this.likeArticleIs=false
          this.article.articleLike=this.article.articleLike-1
        }
      })
    },
    goArticleType: function (){
      this.$router.push({
        name: 'ArticleTypeDetail',
        query: {
          atid: this.articleType.articleTypeId
        }
      })
    },
    commentForArticle: function (){
      this.comment.commentArticleId=this.article.articleId
      this.comment.commentUserId=this.$store.getters['user'].userId
      commentAdd(this.comment).then(res=>{
        if(res.data.code===200){
          this.comment.commentContext=''
        }
      })

      this.comments=[]
      showComments(this.$route.query.aid, this.page, "article").then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0; i<res.data.object.list.length; i++){
            let comment=res.data.object.list[i];
            this.comments.push({
              commentId: comment.commentId,
              commentArticleId: comment.commentArticleId,
              commentUserId: comment.commentUserId,
              commentTime: comment.commentTime,
              commentContext: comment.commentContext,
              commentLike: comment.commentLike,
              commentTopId: comment.commentTopId,
              commentForId: comment.commentForId,
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    goUserHome: function (){
      this.$router.push({
        name: 'UserHome',
        query: {
          id: this.user.userId
        }
      })
    },
    openReport: function (){
      this.reportVisible=true
      this.reportForm.object=''
      this.reportForm.reason=''
    },
    report: function (){
      resultInsert(this.$store.getters['user'].userId,this.article.articleId, 'report', this.reportForm.object, this.reportForm.reason).then(res=>{
        if(res.data.code===200){
          ElNotification({
            title: '举报成功',
            message: '您的举报申请已提交，管理员将确认后进行操作',
            type: 'success',
          })
          this.reportVisible=false
        }
        else{
          ElNotification({
            title: '举报失败',
            message: '您的举报申请未发送出去，请您稍后再试',
            type: 'error',
          })
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    changePage :function (){
      this.comments=[]
      showComments(this.$route.query.aid, "article", this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0; i<res.data.object.list.length; i++){
            let comment=res.data.object.list[i];
            this.comments.push({
              commentId: comment.commentId,
              commentArticleId: comment.commentArticleId,
              commentUserId: comment.commentUserId,
              commentTime: comment.commentTime,
              commentContext: comment.commentContext,
              commentLike: comment.commentLike,
              commentTopId: comment.commentTopId,
              commentForId: comment.commentForId,
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
  padding: 0;
}

.title {
  margin: 20px auto 10px auto;
}

.tag {
  margin: 20px auto 10px 5px;
}

.context {
  border-style: ridge;
  padding: 10px 25px 10px 25px;
  margin: 10px;
  white-space:pre-line;
}

.header {
  background-color: #ebddcb;
  padding: 10px 20px 10px 20px;
}

.userName {
  margin: 15px 10px 5px 0px;
}

.concern {
  text-align: right;
  padding: 10px 20px 10px 20px;
}

.comment {
  padding: 10px 25px 10px 25px;
  margin: 10px;
}

.myComment {
  border-style: ridge;
  padding: 10px 25px 5px 25px;
  height: 100px;
}
</style>