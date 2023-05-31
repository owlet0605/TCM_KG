<template>
  <el-table :data="articleTypes" style="width: 100%">
    <el-table-column label="ATID" prop="articleTypeId" />
    <el-table-column label="标签名" prop="articleTypeTag" />
    <el-table-column label="所含资讯数" prop="articleTypeNum" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="str" size="small" placeholder="输入ATID" style="width: 200px">
          <template #append>
            <el-button @click="search"><el-icon><Search/></el-icon></el-button>
          </template>
        </el-input>
        <el-button @click="openAdd">
          <el-icon><Plus/></el-icon>
        </el-button>
        <el-dialog
            v-model="addVisible"
            center
            destroy-on-close
            title="添加资讯种类">
          <el-form :model="addForm" label-width="100px" :rules="rules">
            <el-form-item label="标签名" prop="articleTypeTag">
              <el-input v-model="addForm.articleTypeTag" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="标签介绍" prop="articleTypeDescribe">
              <el-input v-model="addForm.articleTypeDescribe" type="textarea"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="articleTypeAdd">添加</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
      </template>
      <template #default="scope">
        <el-button
            size="small"
            type="warning"
            @click="openChange(scope.row)"
        >详情</el-button>
        <el-dialog
            v-model="changeVisible"
            center
            destroy-on-close
            title="资讯种类详情">
          <el-form :model="changeForm" label-width="100px" :rules="rules">
            <el-form-item label="ATID" prop="articleTypeId">
              <el-text>{{changeForm.articleTypeId}}</el-text>
            </el-form-item>
            <el-form-item label="标签名" prop="articleTypeTag">
              <el-input v-model="changeForm.articleTypeTag" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="标签介绍" prop="articleTypeDescribe">
              <el-input v-model="changeForm.articleTypeDescribe" type="textarea"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="warning" @click="this.changeVisible=false">取消</el-button>
              <el-button type="primary" @click="change">修改</el-button>
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
      :page-size="20"
      background
      layout="prev, pager, next, jumper"
      :total="parseInt(this.total)"
  ></el-pagination>
</template>

<script>
import {Plus, Search} from "@element-plus/icons-vue";
import {ElNotification} from "element-plus";
import {
  articleTypeChange,
  articleTypeDelete,
  articleTypeInsert,
  getArticleType,
  showAllArticleType
} from "@/api/article";

export default {
  name: "ArticleTypeList",
  components: {Search, Plus},
  data() {
    return {
      rules: {
        articleTypeTag: [
          { required: true, message: '不为空', trigger: 'blur' },
        ],
        articleTypeDescribe: [
          { required: true, message: '不为空', trigger: 'blur' },
        ]
      },
      addVisible: false,
      addForm: {
        articleTypeTag: '',
        articleTypeDescribe: ''
      },
      changeVisible: false,
      changeForm: {
        articleTypeId: '',
        articleTypeTag: '',
        articleTypeDescribe: ''
      },
      articleTypes: [],
      page: 1,
      total: 0,
      str: ''
    }
  },
  created() {
    showAllArticleType(this.page).then(res=>{
      this.total=res.data.object.total
      if(res.data.code===200){
        for(let i=0; i<res.data.object.list.length; i++){
          let articleType=res.data.object.list[i]
          this.articleTypes.push({
            articleTypeId: articleType.articleTypeId,
            articleTypeTag: articleType.articleTypeTag,
            articleTypeDescribe: articleType.articleTypeDescribe,
            articleTypeNum: articleType.articleTypeNum
          })
        }
      }
    }).catch(e=>{
      console.log(e)
    })
  },
  methods: {
    openAdd: function (){
      this.addVisible=true
    },
    search: function (){
      this.page=1
      if(this.str===''){
        this.changePage()
      }
      else{
        this.tcms=[]
        getArticleType(this.str).then(res=>{
          if(res.data.code===200) {
            this.total=1
            let articleType=res.data.object
            this.articleTypes.push({
              articleTypeId: articleType.articleTypeId,
              articleTypeTag: articleType.articleTypeTag,
              articleTypeDescribe: articleType.articleTypeDescribe,
              articleTypeNum: articleType.articleTypeNum
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
    articleTypeAdd: function (){
      articleTypeInsert(this.addForm).then(res=>{
        if(res.data.code===200){
          ElNotification({
            title: '添加成功',
            message: '资讯类型添加成功',
            type: 'success',
          })
          this.addVisible=false
          this.changePage()
        }
        else{
          ElNotification({
            title: '添加失败',
            message: '稍后再试',
            type: 'error',
          })
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    openChange: function (val){
      this.changeVisible=true
      this.changeForm.articleTypeId=val.articleTypeId
      this.changeForm.articleTypeTag=val.articleTypeTag
      getArticleType(val.articleTypeId).then(res=>{
        if(res.data.code===200) {
          this.changeForm.articleTypeDescribe=res.data.object.articleTypeDescribe
        }
      }).catch(e=>{
        console.log(e)
      })

    },
    change: function (){
      articleTypeChange(this.changeForm).then(res=>{
        if(res.data.code===200){
          ElNotification({
            title: '修改成功',
            message: res.data.msg,
            type: 'success',
          })
          this.changeVisible=false
          this.changePage()
        }
        else{
          ElNotification({
            title: '修改失败',
            message: res.data.msg,
            type: 'error',
          })
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    changePage: function () {
      this.tcms = []
      showAllArticleType(this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0; i<res.data.object.list.length; i++){
            let articleType=res.data.object.list[i]
            this.articleTypes.push({
              articleTypeId: articleType.articleTypeId,
              articleTypeTag: articleType.articleTypeTag,
              articleTypeDescribe: articleType.articleTypeDescribe,
              articleTypeNum: articleType.articleTypeNum
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