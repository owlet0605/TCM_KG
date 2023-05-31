<template>
  <el-table :data="articles" style="width: 100%">
    <el-table-column label="TID" prop="articleId" />
    <el-table-column label="标题" prop="articleTitle" />
    <el-table-column label="作者ID" prop="articleUserId" />
    <el-table-column label="资讯类型ID" prop="articleTypeId" />
    <el-table-column label="发布时间" prop="articleTime" />
    <el-table-column label="浏览量" prop="articleView" />
    <el-table-column label="点赞量" prop="articleLike" />
    <el-table-column label="收藏量" prop="articleCollect" />
    <el-table-column label="评论量" prop="articleComment" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="str" size="small" placeholder="输入TID">
          <template #append>
            <el-button @click="search"><el-icon><Search/></el-icon></el-button>
          </template>
        </el-input>
      </template>
      <template #default="scope">
        <el-button
            size="small"
            type="primary"
            @click="openContext(scope.row)"
        >正文</el-button>
        <el-dialog
            v-model="contextVisible"
            center
            destroy-on-close
            title="资讯正文">
          <el-form>
            <el-form-item>
              <mavon-editor  v-html="getHtML()"
                             :subfield="false"
                             defaultOpen="preview"
                             :toolbarsFlag="false"
                             :editable="false"
              ></mavon-editor>
            </el-form-item>
          </el-form>
        </el-dialog>
        <el-button
            size="small"
            type="danger"
            v-if="scope.row.articleAudit===1"
            @click="stopThisArticle(scope.row)"
        >封禁</el-button>
        <el-button
            size="small"
            type="success"
            v-if="scope.row.articleAudit===2"
            @click="startThisArticle(scope.row)"
        >解禁</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-pagination
      @current-change="changePage"
      v-model:current-page="this.page"
      :default-current-page="parseInt(this.page)"
      hide-on-single-page
      :page-size="10"
      background
      layout="prev, pager, next, jumper"
      :total="parseInt(this.total)"
  ></el-pagination>
</template>

<script>
import {Search} from "@element-plus/icons-vue";
import {articleAll, changeArticleAudit, getArticle} from "@/api/article";
import {marked} from "marked";
import {ElMessageBox} from "element-plus";
import {changeUserStatus} from "@/api/user";

export default {
  name: "ArticleList",
  components: {Search},
  data() {
    return{
      articles: [],
      page: 1,
      total: 0,
      str: '',
      contextVisible: false,
      context: ''
    }
  },
  created() {
    articleAll(this.page).then(res=>{
      this.total=res.data.object.total
      if(res.data.code===200){
        for(let i=0;i<res.data.object.list.length;i++){
          let article=res.data.object.list[i];
          this.articles.push({
            articleId: article.articleId,
            articleUserId: article.articleUserId,
            articleTypeId: article.articleTypeId,
            articleTitle: article.articleTitle,
            articleTime: article.articleTime,
            articleView: article.articleView,
            articleComment: article.articleComment,
            articleLike: article.articleLike,
            articleCollect: article.articleCollect,
            articleAudit: article.articleAudit
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    search: function (){
      this.page=1
      if(this.str===''){
        this.changePage()
      }
      else{
        this.articles=[]
        getArticle(this.str).then(res=>{
          if(res.data.code===200){
            this.total=1
            let article=res.data.object
            this.articles.push({
              articleId: article.articleId,
              articleUserId: article.articleUserId,
              articleTypeId: article.articleTypeId,
              articleTitle: article.articleTitle,
              articleTime: article.articleTime,
              articleView: article.articleView,
              articleComment: article.articleComment,
              articleLike: article.articleLike,
              articleCollect: article.articleCollect,
              articleAudit: article.articleAudit
            })
          }
          else{
            this.total=0
          }
        }).catch(e=>{
          console.log(e)
        })
      }
    },
    getHtML: function (){
      return marked(this.context)
    },
    openContext: function (val){
      getArticle(val.articleId).then(res=>{
        if(res.data.code===200){
          this.context=res.data.object.articleContext
        }
      }).catch(e=>{
        console.log(e)
      })
      this.contextVisible=true
    },
    stopThisArticle: function (val){
      ElMessageBox.confirm(
          '资讯将被封禁. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        changeArticleAudit(val.articleId, 2).then(res=>{
          if(res.data.code===200){
            this.page=1
            this.changePage()
          }
        }).catch(e=>{
          console.log(e)
        })
      })
    },
    startThisArticle: function (val){
      ElMessageBox.confirm(
          '资讯将被恢复. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        changeArticleAudit(val.articleId, 1).then(res=>{
          if(res.data.code===200){
            this.page=1
            this.changePage()
          }
        }).catch(e=>{
          console.log(e)
        })
      })
    },
    changePage: function (){
      this.articles=[]
      articleAll(this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0;i<res.data.object.list.length;i++){
            let article=res.data.object.list[i];
            this.articles.push({
              articleId: article.articleId,
              articleUserId: article.articleUserId,
              articleTypeId: article.articleTypeId,
              articleTitle: article.articleTitle,
              articleTime: article.articleTime,
              articleView: article.articleView,
              articleComment: article.articleComment,
              articleLike: article.articleLike,
              articleCollect: article.articleCollect,
              articleAudit: article.articleAudit
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    }
  }
}
</script>

<style scoped>

</style>