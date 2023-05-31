<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="3">
        <div @click="goUserHome">
          <el-avatar size="large"
                     :src="this.Img"
          />
        </div>
      </el-col>
      <el-col :span="17">
        <el-row>
          <el-text><h4 class="userName">{{user.userName}}</h4></el-text>
          <el-icon v-if="user.userSex==='男'" color="blue"><Male /></el-icon>
          <el-icon v-if="user.userSex==='女'" color="pink"><Female /></el-icon>
        </el-row>
        <el-row>
          <el-col :span="2"><el-text>粉丝: {{user.userFans}}</el-text></el-col>
          <el-col :span="2"><el-text>关注: {{user.userConcern}}</el-text></el-col>
        </el-row>
      </el-col>
      <el-col :span="1" class="concern">
        <el-button type="primary" size="large" v-if="!concernIs" @click="concernAdd">关注</el-button>
        <el-button type="primary" size="large" plain v-if="concernIs" @click="concernDel">已关注</el-button>
      </el-col>
    </el-row>
  </el-card>
</template>

<script>

import {concernByUser, concernDelete, concernIf} from "@/api/concern";

export default {
  name: "UserItem",
  props: ['user'],
  data() {
    return{
      Img: 'http://localhost:8080/api/file/userImg/'+this.user.userImg,
      checkConcern: ''
    }
  },
  created() {
    if(this.$store.getters['user'].userId===''){
      this.checkConcern=false
    }
    else{
      concernIf(this.user.userId, this.$store.getters['user'].userId).then(res=>{
        this.checkConcern=res.data.object
      })
    }
  },
  computed: {
    concernIs() {
      return this.checkConcern
    }
  },
  methods: {
    goUserHome: function (){
      this.$router.push({
        name: 'UserHome',
        query: {
          id: this.user.userId
        }
      })
    },
    concernAdd: function (){
      concernByUser(this.user.userId, this.$store.getters['user'].userId)
    },
    concernDel: function (){
      concernDelete(this.user.userId, this.$store.getters['user'].userId)
    }
  }
}
</script>

<style scoped>
.el-card {
  margin: 0 0 10px 0;
  width: 800px;
}

.concern {
  text-align: right;
  padding: 10px 20px 10px 20px;
}

.box-card {
  margin: 0 0 5px 10px;
}
</style>