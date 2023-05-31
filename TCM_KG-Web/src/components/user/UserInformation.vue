<template>
  <el-form :rules="rules" label-width="120px" label-position="left" style="max-width: 460px">
    <el-text><h3>个人信息</h3></el-text>
    <el-form-item label="用户名" prop="name">
      <el-col><el-input v-model="user.userName"></el-input></el-col>
    </el-form-item>
    <el-form-item label="UID" prop="id">
      <el-col>{{user.userId}}</el-col>
    </el-form-item>
    <el-form-item label="状态" prop="status">
      <el-col>{{user.userStatus}}</el-col>
    </el-form-item>
    <el-form-item label="注册时间" prop="time">
      <el-col>{{user.registerTime}}</el-col>
    </el-form-item>
    <el-form-item label="性别" prop="sex">
      <el-col>
        <el-radio-group v-model="user.userSex">
          <el-radio label="男" size="large" border>男</el-radio>
          <el-radio label="女" size="large" border>女</el-radio>
        </el-radio-group>
      </el-col>
    </el-form-item>
    <el-form-item label="生日" prop="birthday">
      <el-col>
        <el-date-picker
            v-model="user.userBirthday"
            type="date"
        />
      </el-col>
    </el-form-item>
    <el-form-item>
      <el-col><el-button type="primary" size="large" @click="change">保存</el-button></el-col>
    </el-form-item>
  </el-form>
</template>

<script>
import {ElNotification} from "element-plus";
import {changeUserInfo, getUser} from "@/api/user";

export default {
  name: "UserInformation",
  data() {
    return{
      user:{
        userId: "",
        userName: "",
        userSex: "",
        userStatus: "",
        registerTime: "",
        userBirthday: "",
      },
      rules: {
        userName: [
          { required: true, message: '用户名不为空', trigger: 'blur' },
          { min: 1, trigger: 'blur' },
        ]
      }
    }
  },
  created() {
    getUser(this.$store.getters['user'].userId).then(res=>{
      if(res.data.code===200){
        this.user.userId=res.data.object.userId
        this.user.userName=res.data.object.userName
        this.user.userSex=res.data.object.userSex
        this.user.userStatus=res.data.object.userStatus
        this.user.registerTime=res.data.object.registerTime
        this.user.userBirthday=res.data.object.userBirthday
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    change: function (){
      changeUserInfo(this.user).then(res=>{
        alert(res.data.msg)
        if(res.data.code===200){
          this.$store.dispatch('changeUser',{
            user: res.data.object
          })
          this.$router.go(0)
          ElNotification({
            title: '成功',
            message: '用户信息修改成功',
            type: 'success',
          })
        }
        else{
          ElNotification({
            title: '失败',
            message: '用户信息修改失败，请稍后再试',
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
.el-text {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}
</style>