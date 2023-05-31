<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div>
        <el-form :rules="rules" label-width="100px" label-position="top">
          <h3 class="title">修改密码</h3>
          <el-form-item label="新密码" prop="password">
            <el-col><el-input v-model="password1"></el-input></el-col>
          </el-form-item>
          <el-form-item label="确认新密码" prop="password">
            <el-col><el-input v-model="password2"></el-input></el-col>
          </el-form-item>
          <el-form-item>
            <el-col><el-button type="primary" @click="changePwd">确认修改</el-button></el-col>
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
import {changePwd} from "@/api/user";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: 'PwdChange',
  components: {SystemFooter, SystemHeader},
  data() {
    return {
      password1: "",
      password2: "",
      rules: {
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, max: 20, message: '长度在 6 到 20 个字符', trigger: 'blur' },
        ],
      }
    }
  },
  methods: {
    changePwd: function () {
      if (this.password1 === this.password2) {
        changePwd(this.$route.query.id, this.password1).then(res=>{
          if (res.data.code === 200) {
            ElNotification({
              title: '成功',
              message: '密码修改成功，即将返回登录界面',
              type: 'success',
            })
            this.$router.push({
              name: 'UserLogin'
            })
          }
        }).catch(e => {
          console.log(e);
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

