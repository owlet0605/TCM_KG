<template>
  <div class="header">
    <div class="user">
      <el-row>
        <el-col :span="8">
          <div class="image">
            <el-avatar @click="img"
                       size="large"
                       :src="user.userImg"
            />
          </div>
          {{user.userName}}
          <el-icon v-if="user.userSex==='男'" color="blue"><Male /></el-icon>
          <el-icon v-if="user.userSex==='女'" color="pink"><Female /></el-icon>
          <el-tag v-if="user.userStatus===1" type="success">已激活</el-tag>
          <el-tag v-if="user.userStatus===0" type="warning">未激活</el-tag>
          <el-tag v-if="user.userStatus===2" type="danger">冻结中</el-tag>
        </el-col>
        <el-col :span="5" :offset="11">
          <el-button type="primary" v-if="!my&&!concernIs" @click="concernAdd" size="large">关注</el-button>
          <el-button type="primary" plain v-if="!my&&concernIs" @click="concernDel" size="large">已关注</el-button>
          <el-button v-if="!my" @click="chat"><el-icon><ChatLineSquare /></el-icon></el-button>
          <el-button v-if="!my" @click="openReport"><el-icon color="red" size="20px" ><Warning /></el-icon></el-button>
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
      </el-row>
    </div>
    <div class="menu">
      <el-row>
        <el-col :span="8">
          <el-menu
              :default-active="'1'"
              class="el-menu-demo"
              mode="horizontal"
              :ellipsis="false"
          >
            <el-menu-item index="1" @click="goHome">主页</el-menu-item>
            <el-menu-item index="2" @click="goArticle">投稿</el-menu-item>
            <el-menu-item index="3" @click="goCollect">收藏</el-menu-item>
            <el-menu-item index="4" @click="goLike">点赞</el-menu-item>
            <el-menu-item index="5" v-if="my" @click="goHistory">历史记录</el-menu-item>
          </el-menu>
        </el-col>
        <el-col :span="10">
          <el-row>
            <el-input v-model="str" placeholder="搜索...">
              <template #append>
                <el-button type="primary" @click="search"><el-icon><Search /></el-icon></el-button>
              </template>
            </el-input>
          </el-row>
        </el-col>
        <el-col :span="6">
          <el-row>
            <el-col :span="6" @click="goFan">
              <el-row><el-link>粉丝数</el-link></el-row>
              <el-row><el-link>{{user.userFans}}</el-link></el-row>
            </el-col>
            <el-col :span="6" @click="goConcern">
              <el-row><el-link>关注数</el-link></el-row>
              <el-row><el-link>{{user.userConcern}}</el-link></el-row>
            </el-col>
            <el-col :span="6">
              <el-row><el-text>获赞量</el-text></el-row>
              <el-row><el-text>{{user.userLike}}</el-text></el-row>
            </el-col>
            <el-col :span="6">
              <el-row><el-text>浏览量</el-text></el-row>
              <el-row><el-text>{{user.userView}}</el-text></el-row>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </div>
  </div>

</template>

<script>
import SystemHeader from "@/components/header/SystemHeader.vue";
import {ChatLineSquare, Female, Male, Search, Warning} from "@element-plus/icons-vue";
import {getUser} from "@/api/user";
import {concernByUser, concernDelete, concernIf} from "@/api/concern";
import {linkOn} from "@/api/chat";
import {resultInsert} from "@/api/result";
import {ElNotification} from "element-plus";

export default {
  name: "UserHome",
  components: {Warning, ChatLineSquare, Female, Search, SystemHeader, Male},
  props: ['uid'],
  data() {
    return{
      id: this.uid,
      my: '',
      str: "",
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
      checkConcern: '',
      reportVisible: false,
      reportForm: {
        object: '',
        reason: ''
      },
    }
  },
  created() {
    this.my=this.uid===this.$store.getters['user'].userId
    getUser(this.id).then(res=>{
      if(res.data.code===200){
        this.user.userId=res.data.object.userId
        this.user.userName=res.data.object.userName
        this.user.userSex=res.data.object.userSex
        this.user.userStatus=res.data.object.userStatus
        this.user.userImg='http://localhost:8080/api/file/userImg/'+res.data.object.userImg
        this.user.userFans=res.data.object.userFans
        this.user.userConcern=res.data.object.userConcern
        this.user.userLike=res.data.object.userLike
        this.user.userView=res.data.object.userView
      }
    }).catch(e=>{
      console.log(e)
    })

    if(this.$store.getters['user'].userId===''){
      this.checkConcern=false
    }
    else{
      concernIf(this.id, this.$store.getters['user'].userId).then(res=>{
        this.checkConcern=res.data.object
      })
    }
  },
  computed: {
    concernIs() {
      return this.checkConcern
    }
  },
  methods: {
    goHome: function (){
      this.$router.push({
        name: 'UserHome',
        query: {
          id: this.id
        }
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
    },
    search: function (){
      this.$router.push({
        name: 'UserSearch',
        query: {
          id: this.id,
          str: this.str
        }
      })
    },
    goConcern: function (){
      this.$router.push({
        name: 'UserConcern',
        query: {
          id: this.id
        }
      })
    },
    goFan: function (){
      this.$router.push({
        name: 'UserFan',
        query: {
          id: this.id
        }
      })
    },
    concernAdd: function (){
      concernByUser(this.id, this.$store.getters['user'].userId)
    },
    concernDel: function (){
      concernDelete(this.id, this.$store.getters['user'].userId)
    },
    img: function (){
      if(this.my){
        /**修改图像**/
      }
      else{
        /**查看图象**/
      }
    },
    goHistory: function (){
      this.$router.push({
        name: 'UserHistory',
        query: {
          id: this.id
        }
      })
    },
    chat: function (){
      console.log(this.$store.getters['user'].userId)
      console.log(this.id)
      linkOn(this.$store.getters['user'].userId,this.id).then(res=>{
        console.log(res)
        this.$router.push({
          name: 'Chat',
          query: {
            id: res.data.object
          }
        })
      })
    },
    openReport: function (){
      this.reportVisible=true
      this.reportForm.object=''
      this.reportForm.reason=''
    },
    report: function (){
      resultInsert(this.$store.getters['user'].userId,this.user.userId, 'report', this.reportForm.object, this.reportForm.reason).then(res=>{
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
    }
  }
}
</script>

<style scoped>
.header {
  height: 100%;
  width: 100%;
}

.user {
  background-color: #dbb583;
  padding: 20px 25px 25px 25px;
}

.menu {
  background-color: #fff;
  padding: 0px 25px 0px 0px;
}

.el-input {
  margin: 10px 25px 0px 0px;
  width: 200px;
}

.image {
  margin: 0px 0px 10px 0px;
}

</style>