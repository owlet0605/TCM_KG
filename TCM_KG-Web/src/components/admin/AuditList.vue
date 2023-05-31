<template>
  <el-table :data="audits" style="width: 100%">
    <el-table-column label="AuditID" prop="auditId" />
    <el-table-column label="资讯ID" prop="auditArticleId" />
    <el-table-column label="作者ID" prop="auditUserId" />
    <el-table-column label="审核时间" prop="auditTime" />
    <el-table-column label="状态" prop="auditHave">
      <template #default="scope">
        <el-tag type="warning" v-if="scope.row.auditHave===0">未审核</el-tag>
        <el-tag type="success" v-if="scope.row.auditHave===1">审核通过</el-tag>
        <el-tag type="danger" v-if="scope.row.auditHave===2">审核不通过</el-tag>
      </template>
    </el-table-column>
    <el-table-column align="right">
      <template #header>
        <el-switch
            v-model="has"
            class="ml-2"
            inline-prompt
            style="--el-switch-on-color: #ff4949; --el-switch-off-color: #13ce66"
            active-text="未审核"
            inactive-text="已审核"
        />
      </template>
      <template #default="scope">
        <el-button
            size="small"
            type="danger"
            v-if="scope.row.auditHave===0"
            @click="showIt(scope.row)"
        >详情</el-button>
        <el-dialog v-model="showVisible" title="审核详情">
          <el-form :model="showArticle" label-width="100px">
            <el-form-item label="TID" prop="articleId">
              <el-text>{{showArticle.articleId}}</el-text>
            </el-form-item>
            <el-form-item label="作者ID" prop="articleUserId">
              <el-text>{{showArticle.articleUserId}}</el-text>
            </el-form-item>
            <el-form-item label="资讯类型ID" prop="articleTypeId">
              <el-text>{{showArticle.articleTypeId}}</el-text>
            </el-form-item>
            <el-form-item label="题目" prop="articleTitle">
              <el-text>{{showArticle.articleTitle}}</el-text>
            </el-form-item>
            <el-form-item label="正文" prop="articleContext">
              <mavon-editor  v-html="getHtML()"
                             :subfield="false"
                             defaultOpen="preview"
                             :toolbarsFlag="false"
                             :editable="false"
              ></mavon-editor>
            </el-form-item>
            <el-form-item>
              <el-button type="warning" @click="this.showVisible=false">取消</el-button>
              <el-button type="primary" @click="agree">通过</el-button>
              <el-button type="primary" @click="refuse">拒绝</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
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
import {showAuditsHasDo, showAuditsNotDo} from "@/api/admin";
import {auditAgree, auditDetail, auditRefuse} from "@/api/audit";
import {marked} from "marked";

export default {
  name: "AuditList",
  data() {
    return{
      audits: [],
      page: 1,
      total: 0,
      has: false,
      auditId: '',
      showVisible: false,
      showArticle: {
        articleId: '',
        articleUserId: '',
        articleTypeId: '',
        articleTitle: '',
        articleContext: ''
      }
    }
  },
  watch:{
    has: {
      handler(newValue,oldValue){
        if(this.has===false){
          this.audits=[]
          showAuditsNotDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
            this.total=res.data.object.total
            if(res.data.code===200){
              for(let i=0;i<res.data.object.list.length;i++){
                let audit=res.data.object.list[i]
                this.audits.push({
                  auditId: audit.auditId,
                  auditArticleId: audit.auditArticleId,
                  auditUserId: audit.auditUserId,
                  auditTime: audit.auditTime,
                  auditHave: audit.auditHave
                })
              }
            }
          }).catch(e=>{
            console.log(e)
          })
        }
        else{
          this.audits=[]
          showAuditsHasDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
            this.total=res.data.object.total
            if(res.data.code===200){
              for(let i=0;i<res.data.object.list.length;i++){
                let audit=res.data.object.list[i]
                this.audits.push({
                  auditId: audit.auditId,
                  auditArticleId: audit.auditArticleId,
                  auditUserId: audit.auditUserId,
                  auditTime: audit.auditTime,
                  auditHave: audit.auditHave
                })
              }
            }
          }).catch(e=>{
            console.log(e)
          })
        }
      },
      deep:true
    }
  },
  created() {
    if(this.has===false){
      showAuditsNotDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0;i<res.data.object.list.length;i++){
            let audit=res.data.object.list[i]
            this.audits.push({
              auditId: audit.auditId,
              auditArticleId: audit.auditArticleId,
              auditUserId: audit.auditUserId,
              auditTime: audit.auditTime,
              auditHave: audit.auditHave
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    }
    else{
      showAuditsHasDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0;i<res.data.object.list.length;i++){
            let audit=res.data.object.list[i]
            this.audits.push({
              auditId: audit.auditId,
              auditArticleId: audit.auditArticleId,
              auditUserId: audit.auditUserId,
              auditTime: audit.auditTime,
              auditHave: audit.auditHave
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    }
  },
  methods: {
    getHtML: function (){
      return marked(this.showArticle.articleContext)
    },
    showIt: function (val){
      this.showVisible=true;
      this.auditId=val.auditId
      auditDetail(val.auditId).then(res=>{
        if(res.data.code===200){
          this.showArticle.articleId=res.data.object.articleId
          this.showArticle.articleUserId=res.data.object.articleUserId
          this.showArticle.articleTypeId=res.data.object.articleTypeId
          this.showArticle.articleTitle=res.data.object.articleTitle
          this.showArticle.articleContext=res.data.object.articleContext
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    agree: function (){
      this.showVisible=false
      auditAgree(this.auditId).then(res=>{
        if(res.data.code===200){
          this.store.dispatch('changeAdmin',{
            admin: res.data.object
          })
          this.changePage()
        }
      })
    },
    refuse: function (){
      this.showVisible=false
      auditRefuse(this.auditId).then(res=>{
        if(res.data.code===200){
          this.store.dispatch('changeAdmin',{
            admin: res.data.object
          })
          this.changePage()
        }
      })
    },
    changePage: function (){
      this.audits=[]
      if(this.has===false){
        showAuditsNotDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0;i<res.data.object.list.length;i++){
              let audit=res.data.object.list[i]
              this.audits.push({
                auditId: audit.auditId,
                auditArticleId: audit.auditArticleId,
                auditUserId: audit.auditUserId,
                auditTime: audit.auditTime,
                auditHave: audit.auditHave
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else{
        showAuditsHasDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0;i<res.data.object.list.length;i++){
              let audit=res.data.object.list[i]
              this.audits.push({
                auditId: audit.auditId,
                auditArticleId: audit.auditArticleId,
                auditUserId: audit.auditUserId,
                auditTime: audit.auditTime,
                auditHave: audit.auditHave
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
    }
  }
}
</script>

<style scoped>

</style>