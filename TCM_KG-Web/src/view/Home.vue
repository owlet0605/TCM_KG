<template>
  <el-container class="el-container">
    <el-header class="el-header">
      <SystemHeader/>
    </el-header>
    <el-main class="el-main">
      <div class="detail">
        <div class="introduce">
          <el-row class="title"><h1>中药搜索</h1></el-row>
          <el-row>我们有丰富的中药资料库，用户可以随时随地通过网站找到自己所需的中药信息</el-row>

          <el-row class="title"><h1>中药产地可视化</h1></el-row>
          <el-row>我们通过地图的方式将中药产地信息可视化展示，方便用户查阅自己所需的信息</el-row>

          <el-row class="title"><h1>中药知识图谱图谱</h1></el-row>
          <el-row>我们有丰富的中药知识图谱数据，并将其展示给用户，知识图谱将更加直观地进</el-row>
          <el-row>行中药知识的科普和查询</el-row>
          <el-row class="title"><h1>中药资讯社区</h1></el-row>
          <el-row>我们有功能全面的中药资讯社区，用户可以在社区中互相交流，发布咨询等，我</el-row>
          <el-row>们旨在构建一个关注中药资讯的稳定好用的社区平台</el-row>
        </div>
      </div>
    </el-main>
    <el-footer class="el-footer">
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import SystemHeader from "@/components/header/SystemHeader.vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "Home",
  components: {SystemFooter, SystemHeader}
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
  background-image: url("../assets/login-background.png");
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

.introduce {
  text-align: center;
}

.title {
  font-size: 20px;
}

</style>