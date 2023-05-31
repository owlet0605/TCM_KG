<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <UserHeader :uid=this.id></UserHeader>
        <el-row class="users">
          <el-col :span="4">
            <el-menu>
              <el-menu-item index="1" @click="goConcern">
                <el-icon><Avatar /></el-icon>
                <el-text>全部关注</el-text>
              </el-menu-item>
              <el-menu-item index="2" @click="goFan">
                <el-icon><UserFilled /></el-icon>
                <el-text v-if="my">我的粉丝</el-text>
                <el-text v-else>他的粉丝</el-text>
              </el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="19">
            <div v-if="total!==0">
              <el-row class="header">
                <el-text v-if="my"><h3>我的粉丝</h3></el-text>
                <el-text v-else><h3>他的粉丝</h3></el-text>
              </el-row>
              <el-row v-for="user in users">
                <UserItem :user="user"></UserItem>
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
            <div v-else><el-empty><h3>没有粉丝用户</h3></el-empty></div>
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
import UserHeader from "@/components/header/UserHeader.vue";
import SystemHeader from "@/components/header/SystemHeader.vue";
import UserItem from "@/components/Item/UserItem.vue";
import {showFans} from "@/api/user";
import {Avatar, UserFilled} from "@element-plus/icons-vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "UserFans",
  components: {SystemFooter, UserFilled, Avatar, UserItem, SystemHeader, UserHeader},
  data() {
    return{
      id: this.$route.query.id,
      my: this.$route.query.id===this.$store.getters['user'].userId,
      page: 1,
      total: 0,
      users:[]
    }
  },
  created() {
    showFans(this.id, this.page).then(res=>{
      this.total=res.data.object.total
      if(res.data.code===200){
        for(let i=0; i<res.data.object.list.length; i++){
          let user=res.data.object.list[i]
          this.users.push({
            userId: user.userId,
            userName: user.userName,
            userSex: user.userSex,
            userImg: user.userImg,
            userFans: user.userFans,
            userConcern: user.userConcern
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
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
    changePage: function (){
      this.users=[]
      showFans(this.id, this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0; i<res.data.object.list.length; i++){
            let user=res.data.object.list[i]
            this.users.push({
              userId: user.userId,
              userName: user.userName,
              userSex: user.userSex,
              userImg: user.userImg,
              userFans: user.userFans,
              userConcern: user.userConcern
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

.users {
  background-color: #fff;
  border-radius: 6px;
  width: 80%;
  text-align: center;
  padding: 5px 25px 15px 0px;
  margin: 10px 0px 10px 100px;
}
</style>