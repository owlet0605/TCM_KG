<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div>
        <el-form :rules="rules" label-width="100px" label-position="top">
          <h3 class="title">忘记密码</h3>
          <el-form-item label="用户名" prop="name">
            <el-col><el-input v-model="userName" placeholder="请输入用户名"></el-input></el-col>
          </el-form-item>
          <el-form-item>
            <el-col><el-button type="primary" @click="send">下一步</el-button></el-col>
          </el-form-item>
        </el-form>
      </div>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import {ElNotification} from "element-plus";
import SystemHeader from "@/components/header/SystemHeader.vue";
import {getUserByName, sendEmailCode} from "@/api/user";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "PwdForget",
  components: {SystemFooter, SystemHeader},
  data(){
    return{
      userName: "",
      userEmail: "",
      rules: {
        userName: [
          { required: true, message: '请输入用户名', trigger: 'blur' }
        ]
      }
    }
  },
  methods:{
    send: function (){
      getUserByName(this.userName).then(res=>{
        if(res.data.code===200){
          this.userEmail=res.data.object.userEmail
          sendEmailCode(this.userEmail).then(res=>{
            if(res.data.code===200){
              this.$router.push({
                name: 'EmailCode',
                query:{
                  email: this.userEmail,
                  use: 'pwdChange'
                }
              })
            }else{
              ElNotification({
                title: '错误',
                message: '邮箱发送失败',
                type: 'error',
              })
            }
          }).catch(e=>{
            console.log(e)
          })
        }
        else{
          ElNotification({
            title: '失败',
            message: '找不到已注册的用户'+this.userName,
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
  padding: 20px;
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

.el-form {
  background-color: #fff;
  border-radius: 6px;
  width: 500px;
  text-align: center;
  padding: 25px 25px 5px 25px;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}
</style>