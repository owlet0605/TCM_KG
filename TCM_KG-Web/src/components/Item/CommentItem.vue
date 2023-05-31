<template>
  <el-card>
    <el-row>
      <el-col :span="2" class="img">
        <el-avatar size="large"
                   @click="goUserHome"
                   :src="user.userImg"
        />
      </el-col>
      <el-col :span="22" class="context">
        <el-row class="header">
          <el-link @click="goUserHome"><el-text><h3 class="userName">{{user.userName}}</h3></el-text></el-link>
          <el-button v-if="my" type="danger" size="small" class="delete" @click="commentDel"><el-icon><Delete /></el-icon></el-button>
        </el-row>
        <el-row class="comment">
          <el-text v-if="comment.commentForId===''||comment.commentForId===comment.commentTopId">
            {{comment.commentContext}}
          </el-text>
          <el-text v-else>
            回复@<el-link @click="goHome">{{forComment.commentUserName}}: </el-link> {{comment.commentContext}}
          </el-text>
        </el-row>
        <el-row class="num">
          <el-col :span="10"><el-text>{{comment.commentTime}}</el-text></el-col>
          <el-col :span="2" :offset="11">
            <div v-if="likeIs">
              <el-icon @click="likeDel" style="background: #00BFFF"><Pointer /></el-icon>
              <el-text>{{comment.commentLike}}</el-text>
            </div>
            <div v-else>
              <el-icon @click="likeIt"><Pointer /></el-icon>
              <el-text>{{comment.commentLike}}</el-text>
            </div>
          </el-col>
          <el-col :span="1"><el-button text @click="doComment=true" class="for">回复</el-button></el-col>
        </el-row>
        <div v-if="total!==0" class="comments">
          <div v-if="all">
            <el-row v-for="comment in subComments">
              <SubCommentItem :comment="comment"></SubCommentItem>
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
          <div v-else>
            <el-row v-for="i in 3">
              <SubCommentItem :comment="subComments[i]"></SubCommentItem>
            </el-row>
            <el-row>
              <el-text>共{{total}}条回复，</el-text>
              <el-link @click="all=true"><el-text>点击查看</el-text></el-link>
            </el-row>
          </div>
        </div>
        <div v-if="doComment" class="myComment">
          <el-row>
            <el-col :span="2">
              <el-avatar v-if="this.$store.getters['user'].userImg===''" size="large">未登录</el-avatar>
              <el-avatar v-else
                         size="large"
                         :src="this.$store.getters['user'].userImg"
              />
            </el-col>
            <el-col :span="19">
              <el-form v-if="doComment" :model="myComment">
                <el-form-item>
                  <el-input v-model="myComment.commentContext" type="textarea" :placeholder="'回复@'+this.user.userName"/>
                </el-form-item>
              </el-form>
            </el-col>
            <el-col :span="2" :offset="1">
              <el-button plain @click="commentIt" class="commentContext">发布</el-button>
            </el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </el-card>
</template>

<script>
import {likeAdd, likeDelete, likeIf} from "@/api/like";
import {commentAdd, commentDelete, getComment, showCommentsOfTop} from "@/api/comment";
import {getUser} from "@/api/user";
import {Apple, Delete, Pointer} from "@element-plus/icons-vue";
import {ElMessageBox} from "element-plus";
import SubCommentItem from "@/components/Item/SubCommentItem.vue";

export default {
  name: "CommentItem",
  components: {SubCommentItem, Pointer, Delete, Apple},
  props: ['comment'],
  data() {
    return{
      user: {
        userId: '',
        userName: '',
        userImg: ''
      },
      subComments: [],
      page: 1,
      total: 0,
      my: '',
      all: false,
      doComment: false,
      myComment: {
        commentArticleId: this.comment.commentArticleId,
        commentUserId: '',
        commentContext: '',
        commentTopId: this.comment.commentId,
        commentForId: this.comment.commentId
      },
      checkLike: ''
    }
  },
  created() {
    this.my=this.comment.commentUserId===this.$store.getters['user'].userId
    getUser(this.comment.commentUserId).then(res=>{
      if(res.data.code===200){
        this.user.userId=res.data.object.userId
        this.user.userName=res.data.object.userName
        this.user.userImg='http://localhost:8080/api/file/userImg/'+res.data.object.userImg
      }
    }).catch(e=>{
      console.log(e)
    })

    showCommentsOfTop(this.comment.commentId, this.comment.commentArticleId, this.page).then(res=>{
      this.total=res.data.object.total
      if(res.data.code===200){
        for(let i=0;i<res.data.object.list.length;i++){
          let comment=res.data.object.list[i]
          this.subComments.push({
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

    if(this.$store.getters['user'].userId===''){
      this.checkLike=false;
    }
    else{
      likeIf(this.comment.commentId, this.$store.getters['user'].userId, "comment").then(res=>{
        this.checkLike=res.data.object
      })
    }
  },
  computed: {
    likeIs() {
      return this.checkLike
    }
  },
  methods: {
    goUserHome: function (){
      this.$router.push({
        name: 'UserHome',
        query: {
          id: this.comment.commentUserId
        }
      })
    },
    goHome: function (){
      this.$router.push({
        name: 'UserHome',
        query: {
          id: this.forComment.commentUserId
        }
      })
    },
    likeIt: function (){
      this.comment.commentLike=this.comment.commentLike+1
      likeAdd(this.comment.commentId, this.$store.getters['user'].userId, "comment")
      this.checkLike=true
    },
    likeDel: function (){
      this.comment.commentLike=this.comment.commentLike-1
      likeDelete(this.comment.commentId, this.$store.getters['user'].userId, "comment")
      this.checkLike=false
    },
    commentIt: function (){
      this.myComment.commentUserId=this.$store.getters['user'].userId
      commentAdd(this.myComment)
    },
    commentDel: function (){
      ElMessageBox.confirm(
          '评论将被删除. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        commentDelete(this.comment.commentId)
      })
    },
    changePage: function (){
      this.subComments=[]
      showCommentsOfTop(this.comment.commentId, this.comment.commentArticleId, this.comment.commentType, this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0;i<res.data.object.list.length;i++){
            let comment=res.data.object.list[i]
            this.subComments.push({
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
.el-card {
  margin: 0 0 10px 0;
  width: 850px;
}

.img {

  padding: 10px 0 0 0;
  text-align: center;
}

.context {

}

.delete {
  margin: 5px 10px 5px 5px;
}

.userName {
  margin: 5px 10px 5px 5px;
}

.comment {
  padding: 10px 20px 10px 20px;
}

.num {
  padding: 5px 20px 0 20px;
}

.for {
  padding: 0px 10px 10px 10px;
}

.comments {
  padding: 0px 20px 0 20px;
}

.myComment {
  border-style: ridge;
  padding: 10px 25px 5px 25px;
}
</style>