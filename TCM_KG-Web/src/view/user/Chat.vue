<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row>
          <el-col :span="6" class="list">
            <el-menu
                :default-active="active"
                text-color="#2d4b73"
                background-color="#ebddcb"
            >
              <el-menu-item v-for="chatLink in chatLinks" @click="show(chatLink.chatLinkId)">
                <ChatLinkItem :chatLink="chatLink"/>
              </el-menu-item>
            </el-menu>
          </el-col>
          <el-col :span="18">
            <div class="message">
              <el-row v-for="chatMessage in getMessages">
                <ChatMessageItem :chatMessage="chatMessage"/>
              </el-row>
            </div>
            <el-row class="send">
              <el-col :span="19">
                <el-form :model="chatMessage" >
                  <el-form-item>
                    <el-input v-model="chatMessage.chatMessageContent" type="textarea" />
                  </el-form-item>
                </el-form>
              </el-col>
              <el-col :span="2" :offset="1">
                <el-button plain @click="send">发送</el-button>
              </el-col>
            </el-row>
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
import SystemFooter from "@/components/footer/SystemFooter.vue";
import {resetWindows, sendMessage, showChatLinks, showChatMessages, updateWindows} from "@/api/chat";
import {ElNotification} from "element-plus";
import ChatLinkItem from "@/components/Item/ChatLinkItem.vue";
import ChatMessageItem from "@/components/Item/ChatMessageItem.vue";

export default {
  name: "Chat",
  components: {ChatMessageItem, ChatLinkItem, SystemFooter, SystemHeader},
  data() {
    return {
      chatLinks: [],
      chatMessages: [],
      active: '',
      websocket: '',
      chatMessage: {
        chatLinkId: this.$route.query.id,
        chatMessageContent: '',
        fromUserId: this.$store.getters['user'].userId,
        toUserId: ''
      }
    }
  },
  computed: {
    getMessages(){
      return this.chatMessages;
    }
  },
  created() {
    updateWindows(this.$store.getters['user'].userId, this.$route.query.id)

    showChatLinks(this.$store.getters['user'].userId).then(res=>{
      if(res.data.code===200){
        for(let i=0;i<res.data.object.length;i++){
          let chatLink=res.data.object[i]
          this.chatLinks.push(chatLink)
          console.log(chatLink)
          if(chatLink.chatLinkId.toString()===this.$route.query.id){
            this.active=i.toString()
            console.log(this.$store.getters['user'].userId)
            if(this.$store.getters['user'].userId===chatLink.fromUserId.toString()){
              this.chatMessage.toUserId=chatLink.toUserId
            }
            else{
              this.chatMessage.toUserId=chatLink.fromUserId
            }
          }
        }
      }
    }).catch(e=>{
      console.log(e)
    })

    if(this.$route.query.id!==undefined&&this.$route.query.id!==null){
      showChatMessages(this.$route.query.id).then(res=>{
        if(res.data.code===200){
          for(let i=0;i<res.data.object.length;i++){
            let chatMessage=res.data.object[i]
            this.chatMessages.push(chatMessage)
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    }

    this.connectWebSocket();
  },
  methods: {
    connectWebSocket: function(){
      let userId=this.$store.getters['user'].userId
      let _this=this
      if ('WebSocket'in window) {
        this.websocket = new WebSocket("ws://localhost:8080/websocket/" + userId);
      } else {
        alert('Not support websocket')
      }

      this.websocket.onerror = function() {
        ElNotification({
          title: '错误',
          message: '服务器连接错误，请稍后再试',
          type: 'error',
        })

        this.$router.go(-1)
      };
      //连接成功建立的回调方法
      this.websocket.onopen = function(event) {
        console.log(event)
      }
      //接收到消息的回调方法
      this.websocket.onmessage = function(event) {
        _this.chatMessages.push(JSON.parse(event.data))
      }
      //连接关闭的回调方法
      this.websocket.onclose = function() {
        console.log('关闭')
        this.windowChange()

      }
      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function() {
        this.closeIt()
      }
    },
    show: function (val){
      this.$router.push({
        name: 'Chat',
        query: {
          id: val
        }
      })
    },
    send: function (){
      sendMessage(this.chatMessage).then(res=>{
        if(res.data.code===200){
          this.chatMessage=''
          this.websocket.send(JSON.stringify(res.data.object));
        }
      })
    },
    windowChange: function (){
      resetWindows(this.$store.getters['user'].userId)
    },
    closeIt: function (){
      this.websocket.close();
      resetWindows(this.$store.getters['user'].userId)
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
  width: 70%;
  height: 600px;
  background-color: #fff;
  padding: 0;
}

.list {
  background-color: #ebddcb;
  height: 600px;
}

.message {
  background-color: #99a9bf;
  height: 520px;
}

.send {
  padding: 5px;
}
</style>