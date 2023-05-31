<template>
  <el-text><h3>安全中心</h3></el-text>
  <el-table :data="tableData" style="width: 100%" show-header:false>
    <el-table-column prop="title">
      <template #default="scope">
        <div style="display: flex; align-items: center">
          <el-icon><Check /></el-icon>
          <span style="margin-left: 10px">{{ scope.row.title}}</span>
        </div>
      </template>
    </el-table-column>
    <el-table-column prop="content"/>
    <el-table-column prop="change">
      <template #default="scope">
        <el-button type="primary" @click="change(scope.row.change)">修改</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import {Check} from "@element-plus/icons-vue";
import {changeUserSecurity, getUser, sendEmailCode} from "@/api/user";
import {ElNotification} from "element-plus";

export default {
  name: "UserSecurity",
  components: {Check},
  data() {
    return {
      user:{
        userId: "",
        userEmail: "",
        userPhone: "",
        userSecurity: ''
      },
      tableData: [{
        title: "二次验证",
        content: "已设置",
        change: 'security'
      },
        {
        title: "设置密码",
        content: "已设置",
        change: 'pwd'
      },
        {
          title: "绑定邮箱",
          content: "",
          change: 'email'
        },
        {
          title: "绑定手机号码",
          content: "",
          change: 'phone'
        }]
    }
  },
  created() {
    getUser(this.$store.getters['user'].userId).then(res=>{
      if(res.data.code===200){
        this.user.userId=res.data.object.userId
        this.user.userEmail=res.data.object.userEmail
        this.user.userPhone=res.data.object.userPhone
        this.user.userSecurity=res.data.object.userSecurity
        if(this.user.userSecurity===0){
          this.tableData[0].content='未开启'
        }
        else{
          this.tableData[0].content='已开启'
        }
        this.tableData[2].content=res.data.object.userEmail
        this.tableData[3].content=res.data.object.userPhone
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    change: function (val){
      if(val==='security'){
        if(this.user.userSecurity===0){
          changeUserSecurity(this.user.userId, 1).then(res=>{
            if(res.data.code===200){
              ElNotification({
                title: '成功',
                message: '二次验证已开启',
                type: 'success',
              })
            }
            else{
              ElNotification({
                title: '出错',
                message: '二次验证开启失败',
                type: 'error',
              })
            }
          }).then(e=>{
            console.log(e)
          })
        }
        else{
          this.$router.push({
            name: 'EmailCode',
            query: {
              email: this.user.userEmail,
              use: 'security'
            }
          })
        }
      }
      else if(val==='pwd'){
        this.$router.push({
          name: 'PwdConfirm'
        })
      }
      else if(val==='email'){
        this.$router.push({
          name: 'EmailConfirm'
        })
        sendEmailCode(this.user.userEmail).then(res=>{
          if (res.data.code === 200) {
            this.isSend='1'
          } else {
            this.isSend='0'
          }
          this.$router.push({
            name: 'EmailCode',
            query: {
              email: this.user.userEmail,
              message: res.data.msg,
              isSend: this.isSend,
              use: 'emailChange'
            }
          })
        }).catch(e=>{
          console.log(e)
        })
      }
      else{
        this.$router.push({
          name: 'PhoneChange',
          query: {
            id: this.user.userId
          }
        })
      }
    }
  }
}
</script>

<style scoped>

</style>