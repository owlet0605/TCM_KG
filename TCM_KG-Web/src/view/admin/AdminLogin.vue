<template>
  <el-container>
    <el-main>
      <el-form :rules="rules" label-width="120px" label-position="left" class="login-form">
        <h3 class="title">中药知识图谱可视化后台管理系统</h3>
        <el-form-item label="用户名" prop="text">
          <el-col><el-input v-model="adminName"></el-input></el-col>
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
      </el-form>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import {adminLogin} from "@/api/admin";
import {ElNotification} from "element-plus";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "AdminLogin",
  components: {SystemFooter},
  data() {
    return {
      adminName: '',
      password: '',
      rules: {
        adminName: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
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
    login: function (){
      adminLogin(this.adminName, this.password).then(res=>{
        if(res.data.code===200){
          this.$store.dispatch("adminLogin",{
            admin: res.data.object
          })
          this.$router.push({
            name: 'AdminHome'
          })
          ElNotification({
            title: '欢迎',
            message: '欢迎管理员'+res.data.object.adminName+"登陆成功",
            type: 'success',
          })
        }
        else{
          ElNotification({
            title: '登陆失败',
            message: res.data.msg,
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