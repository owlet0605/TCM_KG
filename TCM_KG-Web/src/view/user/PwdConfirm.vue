<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-breadcrumb :separator-icon="ArrowRight">
          <el-breadcrumb-item :to="{ path: './ChangeInfo' }">
            个人中心
          </el-breadcrumb-item>
          <el-breadcrumb-item>设置密码</el-breadcrumb-item>
        </el-breadcrumb>
        <div class="form">
          <el-steps :space="200" :active="0" align-center process-status="finish" finish-status="success">
            <el-step title="验证身份" />
            <el-step title="设置密码" />
            <el-step title="改密成功" />
          </el-steps>
          <el-form label-width="100px" label-position="left">
            <el-form-item label="确认旧密码" prop="password">
              <el-col><el-input v-model="oldPwd"></el-input></el-col>
            </el-form-item>
            <el-form-item>
              <el-col><el-button type="primary" @click="confirmPwd">确认</el-button></el-col>
            </el-form-item>
          </el-form>
        </div>
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
import {ArrowRight} from "@element-plus/icons-vue";
import {confirmOldPwd} from "@/api/user";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "PwdConfirm",
  computed: {
    ArrowRight() {
      return ArrowRight
    }
  },
  components: {SystemFooter, SystemHeader},
  data() {
    return {
      id: this.$store.getters['user'].userId,
      oldPwd: ""
    }
  },
  methods: {
    confirmPwd: function (){
      confirmOldPwd(this.id, this.oldPwd).then(res=>{
        if(res.data.code===200){
          this.$router.push({
            name: 'PwdChangeSecurity'
          })
        }
        else{
          ElNotification({
            title: '错误',
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
  width: 40%;
  background-color: #fff;
  border-radius: 6px;
  padding: 25px 25px 5px 25px;
  margin: 0px 10px 10px 10px;
}

.el-breadcrumb {
  margin: 0px 0px 30px 0px;
}

.form {
  text-align: center;
}

.el-steps {
  padding: 5px 20px 20px 40px;
}

.el-form {
  padding: 5px 20px 20px 60px;
}
</style>