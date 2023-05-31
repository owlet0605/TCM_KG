<template>
  <el-card class="box-card">
    <el-row>
      <el-col :span="2" class="img">
        <el-avatar size="large"> 123 </el-avatar>
      </el-col>
      <el-col :span="22" class="context">
        <el-row class="header">
          <el-link><el-text><h3 class="userName">123</h3></el-text></el-link>
          <el-button type="danger" size="small" class="delete"><el-icon><Delete /></el-icon></el-button>
        </el-row>
        <el-row class="comment">
          <el-text>
            我的评论
          </el-text>
        </el-row>
        <el-row class="num">
          <el-col :span="5"><el-text>2020-06-01 16:00:00</el-text></el-col>
          <el-col :span="2" :offset="15">
              <el-icon><Pointer /></el-icon>
              <el-text>100</el-text>
          </el-col>
          <el-col :span="1"><el-button text @click="doComment=true" class="for">回复</el-button></el-col>
        </el-row>
        <div v-if="total!==0" class="comments">
          <div v-if="all">
            <el-row v-for="comment in subComments">
              <CommentItem :comment="comment"></CommentItem>
            </el-row>
            <el-pagination
                v-model:current-page="this.page"
                :default-current-page="parseInt(this.page)"
                hide-on-single-page
                :page-size="10"
                background
                layout="prev, pager, next, jumper"
                :total="parseInt(this.total)"
            ></el-pagination>
          </div>
          <div v-else>
            <el-row v-for="i in 3">
              <CommentItem :comment="subComments[i]"></CommentItem>
            </el-row>
            <el-row>
              <el-text>共{{total}}条回复，</el-text>
              <el-link @click="all=true"><el-text>点击查看</el-text></el-link>
            </el-row>
          </div>
        </div>
        <div v-if="doComment" class="myComment">
          <el-row>
            <el-col :span="2">
              <el-avatar v-if="this.$store.getters['user'].userImg==='default.png'" size="large"> {{user.userName}} </el-avatar>
              <el-avatar v-else-if="this.$store.getters['user'].userImg===''" size="large">未登录</el-avatar>
              <el-avatar v-else
                         size="large"
                         src="https://localhost:8080/api/file/{{this.$store.getters['user'].userImg}}"
              />
            </el-col>
            <el-col :span="19">
              <el-form :model="myComment" >
                <el-form-item>
                  <el-input v-model="myComment.commentContext" type="textarea" />
                </el-form-item>
              </el-form>
            </el-col>
            <el-col :span="2" :offset="1">
              <el-button plain @click="commentForArticle" class="commentContext">发送</el-button>
            </el-col>
          </el-row>
        </div>
      </el-col>
    </el-row>
  </el-card>
</template>

<script>
import {Delete, Pointer} from "@element-plus/icons-vue";

export default {
  name: "Empty",
  components: {Pointer, Delete},
  data() {
    return {
      doComment: false,
      total: 10,
      subComments: [],
      page: 1,
      all: false,
      myComment: {
        commentContext: ''
      }
    }
  }
  // created() {
  //   this.$router.replace({
  //     name: this.$route.query.name,
  //     query: this.$route.query.query
  //   })
  // }
}
</script>

<style scoped>
.el-card {
  margin: 0 0 10px 0;
  width: 1000px;
}

.img {
  background-color: #87CEEB;
  padding: 10px 0 0 0;
  text-align: center;
}

.context {
  background-color: #99a9bf;
}

.delete {
  margin: 5px 10px 5px 5px;
}

.userName {
  margin: 5px 10px 5px 5px;
}

.comment {
  padding: 10px 20px 10px 20px;
}

.num {
  padding: 5px 20px 0 20px;
}

.for {
  padding: 0px 10px 10px 10px;
}

.comments {
  padding: 0px 20px 0 20px;
}

.myComment {
  border-style: ridge;
  padding: 10px 25px 5px 25px;
}
</style>