<template>
  <el-container class="container">
    <el-header class="header">
      <el-menu
          class="el-menu"
          mode="horizontal"
          :ellipsis="false"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
      >
        <el-menu-item index="0">
          中药知识图谱可视化后台系统
        </el-menu-item>
        <div style="width: 78%"></div>
        <el-sub-menu index="1">
          <template #title>
            <div @click="addTab('主页','home')" class="img">
              <el-avatar> {{this.$store.getters['admin'].adminName}} </el-avatar>
            </div>
          </template>
          <el-menu-item>{{this.$store.getters['admin'].adminName}}</el-menu-item>
          <el-menu-item index="1-1" @click="addTab('主页','home')">首页</el-menu-item>
          <el-menu-item index="1-3" @click="logout">登出</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-header>
    <el-main class="main">
      <el-container>
        <el-aside class="aside">
          <el-menu
              default-active="1"
          >
            <el-menu-item index="2" @click="addTab('用户信息','user')">
              <span><el-text>用户信息</el-text></span>
            </el-menu-item>
            <el-menu-item index="3" @click="addTab('中药信息','tcm')">
              <span><el-text>中药信息</el-text></span>
            </el-menu-item>
            <el-menu-item index="4" @click="addTab('资讯信息','article')">
              <span><el-text>资讯信息</el-text></span>
            </el-menu-item>
            <el-menu-item index="5" @click="addTab('咨询种类信息','articleType')">
              <span><el-text>咨询种类信息</el-text></span>
            </el-menu-item>
            <el-menu-item index="6" @click="addTab('审核列表','audit')">
              <span><el-text>审核列表</el-text></span>
            </el-menu-item>
            <el-menu-item index="7" @click="addTab('处理列表','result')">
              <span><el-text>处理列表</el-text></span>
            </el-menu-item>
            <el-menu-item index="8" >
              <span><el-text>中药知识图谱数据</el-text></span>
            </el-menu-item>
          </el-menu>
        </el-aside>
        <el-main class="sub-main">
          <el-tabs
              v-model="editableTabsValue"
              type="card"
              closable
              @tab-remove="removeTab"
          >
            <el-tab-pane
                v-for="item in editableTabs"
                :key="item.name"
                :label="item.title"
                :name="item.name"
            >
              <AdminTotal v-if="item.content==='home'"/>
              <UserList v-if="item.content==='user'"/>
              <TcmList v-if="item.content==='tcm'"/>
              <ArticleList v-if="item.content==='article'"/>
              <ArticleTypeList v-if="item.content==='articleType'"/>
              <AuditList v-if="item.content==='audit'"/>
              <ResultList v-if="item.content==='result'"/>
            </el-tab-pane>
          </el-tabs>
        </el-main>
      </el-container>
    </el-main>
  </el-container>
</template>

<script>
import AdminTotal from "@/components/admin/AdminTotal.vue";
import UserList from "@/components/admin/UserList.vue";
import TcmList from "@/components/admin/TcmList.vue";
import ArticleList from "@/components/admin/ArticleList.vue";
import ArticleTypeList from "@/components/admin/ArticleTypeList.vue";
import AuditList from "@/components/admin/AuditList.vue";
import ResultList from "@/components/admin/ResultList.vue";

export default {
  name: "AdminHome",
  components: {ResultList, AuditList, ArticleTypeList, ArticleList, TcmList, UserList, AdminTotal},
  data() {
    return {
      editableTabsValue: 1,
      tabIndex: 1,
      editableTabs: [
        {
          title: '主页',
          name: '1',
          content: 'home'
        }
      ]
    }
  },
  methods: {
    logout: function (){
      this.$store.dispatch('adminLogout')
      this.$router.push({
        name: 'AdminLogin'
      })
    },
    addTab: function (title, content){
      let flag=false
      for(let i=0; i<this.editableTabs.length; i++){
        if(this.editableTabs[i].content===content){
          flag=true
          break
        }
      }
      if(flag===false){
        let newTabName=++this.tabIndex
        this.editableTabs.push({
          title: title,
          name: newTabName,
          content: content,
        })
        this.editableTabsValue = newTabName
      }
    },
    removeTab: function (targetName){
      const tabs = this.editableTabs
      let activeName = this.editableTabsValue
      if (activeName === targetName) {
        tabs.forEach((tab, index) => {
          if (tab.name === targetName) {
            const nextTab = tabs[index + 1] || tabs[index - 1]
            if (nextTab) {
              activeName = nextTab.name
            }
          }
        })
      }
      this.editableTabsValue = activeName
      this.editableTabs = tabs.filter((tab) => tab.name !== targetName)
    }
  }
}
</script>

<style scoped>
.container {
  height: 100%;
  width: 100%;
  position: fixed;
}

.header {
  height: 8%;
  width: 100%;
  padding: 0;
}

.main {
  height: 80%;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: start;
  padding: 0;
}

.el-menu {
  height: 100%;
  width: 100%;
}

.img {
  padding: 0 0 10px 0;
}

.aside {
  margin: 0 0 0 0;
  padding: 0 0 0 0;
}
</style>