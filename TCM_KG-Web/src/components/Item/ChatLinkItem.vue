<template>
  <el-row class="item">
    <el-col :span="4" class="img">
      <el-avatar size="default"
                 :src="user.userImg"
      />
    </el-col>
    <el-col :span="19" :offset="1">
      <div class="name">
        {{user.userName}}
      </div>
      <div class="message">
        {{lastedContent}}
      </div>
    </el-col>
  </el-row>
</template>

<script>
import {getUser} from "@/api/user";
import {getLastedMessage} from "@/api/chat";

export default {
  name: "ChatLinkItem",
  props: ['chatLink'],
  data() {
    return {
      user: {
        userId: '',
        userName: '',
        userImg: ''
      },
      lastedContent: ''
    }
  },
  created() {

    if(this.chatLink.fromUserId.toString()===this.$store.getters['user'].userId){
      this.user.userId=this.chatLink.toUserId
    }
    else{
      this.user.userId=this.chatLink.fromUserId
    }

    getUser(this.user.userId).then(res=>{
      this.user.userName=res.data.object.userName
      this.user.userImg='http://localhost:8080/api/file/userImg/'+ res.data.object.userImg
    })

    getLastedMessage(this.chatLink.chatLinkId).then(res=>{
      if(res.data.code===200){
        this.lastedContent=res.data.object.chatMessageContent
      }
    })
  }

}
</script>

<style scoped>
.name {
  font-size: 15px;
  height: 20px;
}

.img {
  padding: 0 0 15px 0;
}

.message {
  font-size: 13px;
  height: 20px;
}

.item{
  width: 100%
}
</style>