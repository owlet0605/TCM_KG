<template>
  <el-container class="el-container">
    <el-header class="el-header">
      <SystemHeader/>
    </el-header>
    <el-main class="el-main">
      <el-form label-width="100px" label-position="top" class="register-form">
        <h3 class="title">中药知识图谱可视化系统</h3>
        <el-form-item label="用户名" prop="name">
          <el-col><el-input v-model="user.name"></el-input></el-col>
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-col>
            <el-radio-group v-model="user.sex">
              <el-radio label="男" size="large" border>男</el-radio>
              <el-radio label="女" size="large" border>女</el-radio>
            </el-radio-group>
          </el-col>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-col><el-input v-model="user.email"></el-input></el-col>
        </el-form-item>
        <el-form-item label="手机号码" prop="phone">
          <el-col><el-input v-model="user.phone"></el-input></el-col>
        </el-form-item>
        <el-form-item label="生日" prop="birthday">
          <el-col>
            <el-date-picker
                v-model="user.birthday"
                type="date"
                value-format="yyyy-MM-dd"
            />
          </el-col>
        </el-form-item>
        <el-row :gutter="5">
          <el-col :span="12">
            <el-form-item label="密码" prop="password">
              <el-col><el-input type="password" v-model="user.password1"></el-input></el-col>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="确认密码" prop="password">
              <el-col><el-input type="password" v-model="user.password2"></el-input></el-col>
            </el-form-item>
          </el-col>
        </el-row>
        <el-form-item>
          <el-col><el-button type="primary" @click="register" style="width: 200px; height: 30px">注册</el-button></el-col>
        </el-form-item>
        <el-form-item>
          <el-col><router-link to="/user/login">现在登录</router-link></el-col>
        </el-form-item>
      </el-form>
    </el-main>
    <el-footer class="el-footer">
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import {ElNotification} from "element-plus";
import SystemHeader from "@/components/header/SystemHeader.vue";
import {sendEmailCode, userRegister} from "@/api/user";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: 'UserRegister',
  components: {SystemFooter, SystemHeader},
  data() {
    return {
      rules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 10, message: '长度在 3 到 10 个字符', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '不为空', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入邮箱', trigger: 'blur' }
        ],
        phone: [
          { required: true, message: '请输入手机号码', trigger: 'blur' }
        ],
        birthday: [
          { required: true, message: '不为空', trigger: 'blur' }
        ],
      },
      user: {
        name: "",
        password1: "",
        password2: "",
        sex: "",
        email: "",
        phone: "",
        birthday: ""
      }
    }
  },
  methods: {
    register: function() {
      if (this.password1 === this.password2) {
        userRegister(this.user).then(res => {
          if (res.data.code === 200) {
            sendEmailCode(this.user.email).then(re=>{
              if(re.data.code===200){
                this.$router.push({
                  name: 'EmailCode',
                  query: {
                    email: this.user.email,
                    use: 'activate'
                  }
                })
              }
              else{
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
              title: '注册失败',
              message: res.data.msg,
              type: 'error',
            })
          }
        }).catch(e => {
          console.log(e)
        })
      } else {
        ElNotification({
          title: '密码输入有误',
          message: '两次输入的密码不同',
          type: 'warning',
        })
      }
    }
  }
}
</script>

<!-- 添加“scoped”属性以将CSS仅限于此组件 -->
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

.register-form {
  background-color: #fff;
  border-radius: 6px;
  width: 500px;
  padding: 25px 25px 5px 25px;
  text-align: center;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}
</style>

