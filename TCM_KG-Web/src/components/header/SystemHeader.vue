<template>
  <el-menu
      class="el-menu"
      mode="horizontal"
      :ellipsis="false"
      background-color="#be935a"
      text-color="#fff"
      active-text-color="#cd853f"
  >
    <el-menu-item index="0" @click="goHome" class="logo">
      Tcm_KGSystem
    </el-menu-item>
    <el-menu-item index="1" @click="goTcmHome" class="el-menu-item1">中药查询</el-menu-item>
    <el-menu-item index="2" @click="goArticleHome" class="el-menu-item1">中药资讯</el-menu-item>
    <el-menu-item index="3" @click="goMap" class="el-menu-item1">中药产地可视化</el-menu-item>
    <el-menu-item index="4" @click="goTcmKg" class="el-menu-item1">中药知识图谱可视化</el-menu-item>
    <div style="width: 70%"></div>
    <div class="el-sub-menu">
      <el-sub-menu v-if="this.$store.getters['token']===''" index="5">
        <template #title><div @click="login">登录</div></template>
        <el-menu-item index="5-1" @click="register">注册</el-menu-item>
      </el-sub-menu>
      <el-sub-menu v-else index="5">
        <template #title>
          <div @click="goUserHome">
            <el-avatar fit="fill"
                       :src="this.$store.getters['user'].userImg"
            />
          </div>
        </template>
        <el-menu-item>{{this.$store.getters['user'].userName}}</el-menu-item>
        <el-menu-item index="5-1" @click="goUserHome">个人中心</el-menu-item>
        <el-menu-item index="5-2" @click="goChat">消息</el-menu-item>
        <el-menu-item index="5-3" @click="logout">登出</el-menu-item>
      </el-sub-menu>
    </div>

  </el-menu>
</template>

<script>
export default {
  name: "SystemHeader",
  methods: {
    goHome: function (){
      this.$router.push({
        name: 'Home'
      })
    },
    goTcmHome: function (){
      this.$router.push({
        name: 'TcmHome'
      })
    },
    goArticleHome: function (){
      this.$router.push({
        name: 'ArticleHome'
      })
    },
    goTcmKg: function (){
      this.$router.push({
        name: 'TcmKg'
      })
    },
    goMap: function (){
      this.$router.push({
        name: 'TcmMap'
      })
    },
    login: function (){
      this.$router.push({
        name: 'UserLogin'
      })
    },
    register: function (){
      this.$router.push({
        name: 'UserRegister'
      })
    },
    goUserHome: function (){
      this.$router.push({
        name: 'UserHome',
        query: {
          id: this.$store.getters['user'].userId
        }
      })
    },
    goChat: function (){
      this.$router.push({
        name: 'Chat',
      })
    },
    logout: function (){
      this.$store.dispatch('logout')
      this.$router.go(0)
    }
  }
}
</script>

<style scoped>
.el-menu {
  height: 100%;
  width: 100%;
}

.logo {
  height: 100%;
  width: 20%;
  font-size: 25px;
}
img{
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.el-menu-item1 {
  height: 100%;
  width: 10%;
}

.el-sub-menu {
  height: 100%;
  width: 10%;
}
</style>