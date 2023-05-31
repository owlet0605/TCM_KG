<template>
  <el-container class="el-container">
    <el-header class="el-header">
      <SystemHeader/>
    </el-header>
    <el-main class="el-main">
      <el-form :rules="rules" label-width="120px" label-position="left" class="login-form">
        <h3 class="title">中药知识图谱可视化系统</h3>
        <el-form-item label="用户名(邮箱)" prop="text">
          <el-col><el-input v-model="text"></el-input></el-col>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-col><el-input type="password" v-model="password"></el-input></el-col>
        </el-form-item>
        <el-form-item>
          <el-col>
            <el-button type="primary"
                       @click="login"
                       style="width: 200px;height: 40px"
            >登录</el-button>
          </el-col>
        </el-form-item>
        <el-form-item>
          <el-col :span="12"><router-link to="/user/register">注册</router-link></el-col>
          <el-col :span="12"><router-link to="/user/pwdForget">忘记密码</router-link></el-col>
        </el-form-item>
      </el-form>
    </el-main>
    <el-footer class="el-footer">
      <SystemFooter/>
    </el-footer>
  </el-container>

</template>

<script>
import {ElMessageBox, ElNotification} from 'element-plus'
import SystemHeader from "@/components/header/SystemHeader.vue";
import {sendEmailCode, userLogin} from "@/api/user";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: 'UserLogin',
  components: {SystemFooter, SystemHeader},
  data() {
    return {
      text: "",
      password: "",
      rules: {
        text: [
          { required: true, message: '请输入用户名或邮箱', trigger: 'blur' },
          { min: 1, trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' },
        ],
      }
    }
  },
  methods: {
    login: function() {
      userLogin(this.text, this.password).then(res => {
        if (res.data.code === 200) {
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
        else if(res.data.code===201){
          ElMessageBox.confirm(
              '该用户开启了二次验证，即将跳转至邮箱验证',
              '二次验证',
              {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
              }
          ).then(()=>{
            sendEmailCode(res.data.object).then(re=>{
              if(re.data.code===200){
                this.$router.push({
                  name: 'EmailCode',
                  query: {
                    email: res.data.object,
                    use: 'login'
                  }
                })
              } else{
                ElNotification({
                  title: '错误',
                  message: '邮箱发送失败',
                  type: 'error',
                })
              }
            }).catch(e=>{
              console.log(e)
            })
          }).catch(()=>{
            ElNotification({
              title: '登陆取消',
              message: '已取消登录',
              type: 'info',
            })
          })
        }
        else if(res.data.code===400){
          ElMessageBox.confirm(
              '该用户未激活，即将跳转至邮箱激活',
              '用户未激活',
              {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
              }
          ).then(()=>{
            sendEmailCode(res.data.object).then(re=>{
              if(re.data.code===200){
                this.$router.push({
                  name: 'EmailCode',
                  query: {
                    email: res.data.object,
                    use: 'activate'
                  }
                })
              } else{
                ElNotification({
                  title: '错误',
                  message: '邮箱发送失败',
                  type: 'error',
                })
              }
            }).catch(e=>{
              console.log(e)
            })
          }).catch(()=>{
            ElNotification({
              title: '登陆取消',
              message: '已取消登录',
              type: 'info',
            })
          })
        }
        else{
          ElNotification({
            title: '登陆失败',
            message: res.data.msg,
            type: 'error',
          })
        }
      }).catch(e => {
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

.login-form {
  background-color: #fff;
  border-radius: 6px;
  width: 400px;
  padding: 25px 25px 5px 25px;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}
</style>