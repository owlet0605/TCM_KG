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
          <el-breadcrumb-item>绑定手机号码</el-breadcrumb-item>
        </el-breadcrumb>
        <div class="form">
          <el-steps :space="200" :active="3" align-center process-status="finish" finish-status="success">
            <el-step title="验证身份" />
            <el-step title="绑定手机号码" />
            <el-step title="绑定成功" />
          </el-steps>
          <el-form  label-width="100px" label-position="top" >
            <h2>手机号码修改成功，{{count}}s后将自动跳转至个人信息界面，若未跳转，请手动点击按钮返回</h2>
            <el-form-item>
              <el-col><el-button type="primary" @click="back">返回</el-button></el-col>
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
import SystemHeader from "@/components/header/SystemHeader.vue";
import {ArrowRight} from "@element-plus/icons-vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "PhoneChangeSuccess",
  computed: {
    ArrowRight() {
      return ArrowRight
    }
  },
  components: {SystemFooter, SystemHeader},
  data() {
    return{
      count: "",
    }
  },
  created() {
    this.fiveSecond()
  },
  methods: {
    fiveSecond() {
      const TIME_COUNT = 5;
      if (!this.timer) {
        this.count = TIME_COUNT;
        this.timer = setInterval(() => {
          if (this.count > 0 && this.count <= TIME_COUNT) {
            this.count--;
          } else {
            clearInterval(this.timer);
            this.timer = null;
            this.$router.push({
              name: 'ChangeInfo'
            });
          }
        }, 1000)
      }
    },
    back: function () {
      this.$router.push({
        name: 'ChangeInfo'
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
  padding: 5px 40px 20px 20px;
}
</style>