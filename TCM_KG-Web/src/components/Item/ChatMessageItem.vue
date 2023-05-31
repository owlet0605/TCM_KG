<template>
  <el-row>
    <div class="box">
      <el-row v-if="isFrom" class="right">
        <el-col :span="10" :offset="12" class="message_box">
          {{this.chatMessage.chatMessageContent}}
        </el-col>
        <el-col :span="2" class="img1">
          <el-avatar size="default"
                     :src="user.userImg"
          />
        </el-col>
      </el-row>
      <div v-else class="left">
        <el-row>
          <el-col :span="2" class="img2">
            <el-avatar size="default"
                       :src="user.userImg"
            />
          </el-col>
          <el-col :span="10" class="message_box">
            {{this.chatMessage.chatMessageContent}}
          </el-col>
        </el-row>
      </div>
    </div>
  </el-row>
</template>

<script>
import {getUser} from "@/api/user";

export default {
  name: "ChatMessageItem",
  props: ['chatMessage'],
  data() {
    return{
      user: {
        userId: this.chatMessage.fromUserId,
        userImg: '',
        userName: ''
      },
      isFrom: ''
    }
  },
  created() {
    this.isFrom=this.$store.getters['user'].userId===this.user.userId.toString()
    getUser(this.user.userId).then(res=>{
      if(res.data.code===200){
        this.user.userName=res.data.object.userName
        this.user.userImg='http://localhost:8080/api/file/userImg/'+ res.data.object.userImg
      }
    })
  }
}
</script>

<style scoped>
.box{
  width: 820px;
}

.right{
  text-align: right;
  padding: 10px 0 0 0;
}

.left{
  text-align: left;
  padding: 10px 0 0 0;
}

.img1 {
  padding: 0 10px 0 0;
}

.img2 {
  padding: 0 0 0 10px;
}

.message_box {
  background-color: #00BFFF;
  border-radius: 6px;
}
</style>