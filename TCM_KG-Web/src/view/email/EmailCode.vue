<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div>
        <el-form label-width="100px" label-position="top">
          <h3 class="title">验证码已发送到邮箱，有效期5分钟，请及时查收</h3>
          <el-form-item label="验证码" prop="code">
            <el-col><el-input v-model="code" placeholder="请输入验证码"></el-input></el-col>
          </el-form-item>
          <el-form-item>
            <el-col :span="12"><el-button type="primary" @click="resend">重新发送</el-button></el-col>
            <el-col :span="12">
              <el-button type="primary" @click="confirm">确认</el-button>
            </el-col>
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
import {changeUserSecurity, confirmEmailCode, sendEmailCode} from "@/api/user";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "EmailCode",
  components: {SystemFooter, SystemHeader},
  data() {
    return{
      code: ""
    }
  },
  methods:{
    confirm: function (){
      confirmEmailCode(this.$route.query.email, this.code).then(res=>{
        if(res.data.code===200){
          if(this.$route.query.use==='activate'){
            this.$store.dispatch('login',{
              user: res.data.object,
              success: () => {
                console.log(res.data.msg)
              }
            })
            ElNotification({
              title: '激活成功',
              message: '欢迎'+res.data.object.userName+"登陆成功",
              type: 'success',
            })
            this.$router.push({
              name: 'Empty',
              query: {
                name: 'Home'
              }
            })
          }
          else if(this.$route.query.user==='login'){
            this.$store.dispatch("login",{
              user: res.data.object,
              success: () => {
                console.log(res.data.msg)
              }
            })
            ElNotification({
              title: '欢迎回来',
              message: '欢迎'+res.data.object.userName+"登陆成功",
              type: 'success',
            })
            this.$router.push({
              name: 'Home'
            })
          }
          else if(this.$route.query.use==='pwdChange'){
           this.$router.push({
             name: 'PwdChange',
             query: {
               id: res.data.object.userId
             }
           })
          }
          else if(this.$route.query.use==='security'){
            changeUserSecurity(this.$store.getters['user'].userId,0).then(res=>{
              this.$router.push({
                name: 'ChangeInfo'
              })
              if(res.data.code===200){
                ElNotification({
                  title: '成功',
                  message: '二次验证已关闭',
                  type: 'success',
                })
              }
              else{
                ElNotification({
                  title: '出错',
                  message: '二次验证关闭失败',
                  type: 'error',
                })
              }
            }).then(e=>{
              console.log(e)
            })
          }
        }
        else{
          ElNotification({
            title: '出错',
            message: res.data.msg,
            type: 'error',
          })
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    resend: function (){
      sendEmailCode(this.$route.query.email).then(res=> {
        if (res.data.code === 200) {
          ElNotification({
            title: '发送成功',
            message: '邮箱发送成功，有效期为5分钟，注意查收',
            type: 'success',
          })
        } else {
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