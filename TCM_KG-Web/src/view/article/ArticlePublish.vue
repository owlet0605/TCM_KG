<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row>
          <el-breadcrumb :separator-icon="ArrowRight">
            <el-breadcrumb-item :to="{ name: 'ArticleHome' }">
              中药资讯
            </el-breadcrumb-item>
            <el-breadcrumb-item>发布资讯</el-breadcrumb-item>
          </el-breadcrumb>
        </el-row>
        <el-divider/>
        <el-row class="title-box">
          <input type="text" class="title" v-model="article.articleTitle" placeholder="请输入标题..." />
          <el-select v-model="article.articleTypeId" placeholder="资讯类型">
            <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
            />
          </el-select>
          <el-button type="text" @click="publish">提交</el-button>
        </el-row>
        <mavon-editor v-model="article.articleContext" class="editor" ref=md @imgAdd="imgAdd" @imgDel="imgDel"/>
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
import {articleAdd, articleUploadImg, showAllArticleTypeNonPage} from "@/api/article";
import {ElNotification} from "element-plus";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "ArticlePublish",
  computed: {
    ArrowRight() {
      return ArrowRight
    }
  },
  components: {SystemFooter, SystemHeader},
  data() {
    return {
      article: {
        articleUserId: "",
        articleTypeId: "",
        articleTitle: "",
        articleContext: ""
      },
      options: [],
      img_file: [],
      key: Math.random().toString(36).slice(-8)
    }
  },
  created() {
    showAllArticleTypeNonPage().then(res=>{
      if(res.data.code===200){
        for(let i=0; i<res.data.object.length; i++){
          let articleType=res.data.object[i]
          this.options.push({
            value: articleType.articleTypeId,
            label: articleType.articleTypeTag
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    // 绑定@imgAdd event
    imgAdd(pos, file) {
      this.img_file[pos] = file;
      console.log("插入图片")
      articleUploadImg(file, this.key).then((res) => {
        if(res.data.code===200){
          let url = res.data.object;
          this.$refs.md.$img2Url(pos, url);
        }
        else{
          ElNotification({
            title: '错误',
            message: '图片插入失败',
            type: 'error',
          })
        }
      })
    },
    imgDel(pos) {
      delete this.img_file[pos];
    },
    publish: function (){
      this.article.articleUserId=this.$store.getters['user'].userId
      if(this.article.articleTitle===""){
        ElNotification({
          title: '错误',
          message: '咨询标题不可为空',
          type: 'error',
        })
      }
      else if(this.article.articleTypeId===""){
        ElNotification({
          title: '错误',
          message: '资讯类型不可为空',
          type: 'error',
        })
      }
      else if(this.article.articleContext===""){
        ElNotification({
          title: '错误',
          message: '资讯正文不可为空',
          type: 'error',
        })
      }
      else{
        articleAdd(this.article, this.key).then(res=>{
          if(res.data.code===200){
            ElNotification({
              title: '成功',
              message: '资讯发布成功',
              type: 'success',
            })
            this.$router.push({
              name: 'ArticleHome'
            })
          }
          else{
            ElNotification({
              title: '错误',
              message: '资讯发布失败',
              type: 'error',
            })
          }
        })
        console.log(this.article.articleContext)
      }
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
  display: flex;
  justify-content: center;
  align-items: start;
  padding: 0px 20px 20px 20px;
  background-image: url("../../assets/login-background.png");
  background-size: cover;
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
  width: 80%;
  height: 800px;
  background-color: #fff;
  padding: 25px 25px 25px 25px;
}

.editor {
  height: 650px;
}

.title-box {
  display: grid;
  grid-template-columns: 22fr 2fr;
}

.title {
  background: none;
  color: #303133;
  text-indent: 0px;
  outline: none;
  font-size: 16px;
  font-weight: bold;
  display: block;

  border: none;
  border-bottom: 1px solid #e0e0e0;
  border-radius: 0;
  line-height: 1;
  overflow: visible;
  margin-bottom: 15px;
  padding: 4px;
}

.title:focus {
  border-color: #409eff;
}
</style>