<template>
  <el-table :data="users" style="width: 100%">
    <el-table-column label="UID" prop="userId" />
    <el-table-column label="用户名" prop="userName" />
    <el-table-column label="性别" prop="userSex" />
    <el-table-column label="邮箱" prop="userEmail" />
    <el-table-column label="手机号码" prop="userPhone" />
    <el-table-column label="注册时间" prop="registerTime" />
    <el-table-column label="浏览量" prop="userView" />
    <el-table-column label="获赞量" prop="userLike" />
    <el-table-column label="状态" prop="userStatus">
      <template #default="scope">
        <el-tag type="warning" v-if="scope.row.userStatus===0">未激活</el-tag>
        <el-tag type="success" v-if="scope.row.userStatus===1">已激活</el-tag>
        <el-tag type="danger" v-if="scope.row.userStatus===2">冻结中</el-tag>
      </template>
    </el-table-column>
    <el-table-column align="right">
      <template #header>
        <el-input v-model="str" size="small" placeholder="输入UID">
          <template #append>
            <el-button @click="search"><el-icon><Search/></el-icon></el-button>
          </template>
        </el-input>
      </template>
      <template #default="scope">
        <el-button
            size="small"
            type="danger"
            v-if="scope.row.userStatus===1"
            @click="stopThisUser(scope.row)"
        >冻结</el-button>
        <el-button
            size="small"
            type="success"
            v-if="scope.row.userStatus===2"
            @click="startThisUser(scope.row)"
        >恢复</el-button>
      </template>
    </el-table-column>
  </el-table>
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
</template>

<script>
import {changeUserStatus, getUser, showAllUser} from "@/api/user";
import {Search} from "@element-plus/icons-vue";
import {ElMessageBox} from "element-plus";
import {tcmDelete} from "@/api/tcm";

export default {
  name: "UserList",
  components: {Search},
  data() {
    return{
      users: [],
      page: 1,
      total: 0,
      str: ''
    }
  },
  created() {
    showAllUser(this.page).then(res=>{
      this.total=res.data.object.total
      if(res.data.code===200){
        for(let i=0;i<res.data.object.list.length;i++){
          let user=res.data.object.list[i]
          this.users.push({
            userId: user.userId,
            userName: user.userName,
            userSex: user.userSex,
            userEmail: user.userEmail,
            userPhone: user.userPhone,
            userStatus: user.userStatus,
            registerTime: user.registerTime,
            userView: user.userView,
            userLike: user.userLike
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    search: function (){
      this.page=1
      if(this.str===''){
        this.changePage()
      }
      else{
        this.users=[]
        getUser(this.str).then(res=>{
          if(res.data.code===200){
            this.total=1
            let user=res.data.object
            this.users.push({
              userId: user.userId,
              userName: user.userName,
              userSex: user.userSex,
              userEmail: user.userEmail,
              userPhone: user.userPhone,
              userStatus: user.userStatus,
              registerTime: user.registerTime,
              userView: user.userView,
              userLike: user.userLike
            })
          }
          else{
            this.total=0
          }
        }).catch(e=>{
          console.log(e)
        })
      }
    },
    stopThisUser: function (val){
      ElMessageBox.confirm(
          '用户将被冻结. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        changeUserStatus(val.userId, 2).then(res=>{
          if(res.data.code===200){
            this.page=1
            this.changePage()
          }
        }).catch(e=>{
          console.log(e)
        })
      })
    },
    startThisUser: function (val){
      ElMessageBox.confirm(
          '用户将被恢复. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        changeUserStatus(val.userId, 1).then(res=>{
          if(res.data.code===200){
            this.page=1
            this.changePage()
          }
        }).catch(e=>{
          console.log(e)
        })
      })
    },
    changePage: function (){
      this.users=[]
      showAllUser(this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0;i<res.data.object.list.length;i++){
            let user=res.data.object.list[i]
            this.users.push({
              userId: user.userId,
              userName: user.userName,
              userSex: user.userSex,
              userEmail: user.userEmail,
              userPhone: user.userPhone,
              userStatus: user.userStatus,
              registerTime: user.registerTime,
              userView: user.userView,
              userLike: user.userLike
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

</style>