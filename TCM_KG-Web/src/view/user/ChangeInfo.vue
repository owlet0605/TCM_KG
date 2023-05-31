<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row>
          <el-col :span="4">
            <el-menu>
              <el-menu-item @click="this.$router.push({name: 'UserHome',query: {id: this.$store.getters['user'].userId}})">
                <el-icon><ArrowLeft /></el-icon>
                <span>个人中心</span>
              </el-menu-item>
              <el-menu-item index="1" @click="this.mode='information'">
                <el-icon><User /></el-icon>
                <span>我的信息</span>
              </el-menu-item>
              <el-menu-item index="2" @click="this.mode='image'">
                <el-icon><Avatar /></el-icon>
                <span>我的头像</span>
              </el-menu-item>
              <el-menu-item index="3" @click="this.mode='security'">
                <el-icon><Discount /></el-icon>
                <span>账号安全</span>
              </el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="20">
            <div class="item">
              <UserInformation v-if="mode==='information'"/>
              <UserImage v-if="mode==='image'"/>
              <UserSecurity v-if="mode==='security'"/>
            </div>
          </el-col>
        </el-row>
      </div>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import SystemHeader from "@/components/header/SystemHeader.vue";
import {ArrowLeft, Avatar, Discount, User} from "@element-plus/icons-vue";
import UserInformation from "@/components/user/UserInformation.vue";
import UserSecurity from "@/components/user/UserSecurity.vue";
import UserImage from "@/components/user/UserImage.vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "ChangeInfo",
  components: {SystemFooter, Avatar, ArrowLeft, UserImage, UserSecurity, UserInformation, Discount, SystemHeader, User},
  data() {
    return {
      mode: "information"
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

.item {
  border-radius: 6px;
  text-align: center;
  padding: 25px 25px 5px 25px;
  margin: 10px 0px 10px 60px;
}

.detail {
  width: 50%;
  height: 96%;
  padding: 0px 25px 25px 25px;
  background-color: #fff;
}
</style>