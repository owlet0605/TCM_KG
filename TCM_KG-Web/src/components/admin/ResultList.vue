<template>
  <el-table :data="results" style="width: 100%">
    <el-table-column label="ResultID" prop="resultId" />
    <el-table-column label="用户ID" prop="resultUserId" />
    <el-table-column label="类型" prop="resultType" />
    <el-table-column label="处理时间" prop="resultTime" />
    <el-table-column label="状态" prop="resultHave">
      <template #default="scope">
        <el-tag type="warning" v-if="scope.row.resultHave===0">未处理</el-tag>
        <el-tag type="success" v-if="scope.row.resultHave===1">已处理</el-tag>
      </template>
    </el-table-column>
    <el-table-column align="right">
      <template #header>
        <el-switch
            v-model="has"
            class="ml-2"
            inline-prompt
            style="--el-switch-on-color: #ff4949; --el-switch-off-color: #13ce66"
            active-text="未处理"
            inactive-text="已处理"
        />
      </template>
      <template #default="scope">
        <el-button
            size="small"
            type="warning"
            v-if="scope.row.resultHave===0"
            @click="showIt(scope.row)"
        >详情</el-button>
        <el-dialog v-model="showVisible" title="处理详情">
          <el-form :model="showDetail" label-width="100px">
            <el-form-item label="用户" prop="resultUserId">
              <el-text>{{showDetail.resultUserId}}</el-text>
            </el-form-item>
            <el-form-item label="类型" prop="resultType">
              <el-text>{{showDetail.resultType}}</el-text>
            </el-form-item>
            <el-form-item label="对象" prop="resultObject">
              <el-text>{{showDetail.resultObject}}</el-text>
            </el-form-item>
            <el-form-item label="对象ID" prop="resultObject">
              <el-text>{{showDetail.resultObjectId}}</el-text>
            </el-form-item>
            <el-form-item label="理由" prop="resultReason">
              <el-text>{{showDetail.resultReason}}</el-text>
            </el-form-item>
            <el-form-item>
              <el-button type="warning" @click="this.showVisible=false">取消</el-button>
              <el-button type="primary" @click="doIt">处理</el-button>
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
import {showResultHasDo, showResultNotDo} from "@/api/admin";
import {doResult, showDetail} from "@/api/result";

export default {
  name: "ResultList",
  data() {
    return{
      results: [],
      page: 1,
      total: 0,
      has: false,
      resultId: '',
      showVisible: false,
      showDetail: {
        resultId: '',
        resultUserId: '',
        resultObjectId: '',
        resultObject: '',
        resultType: '',
        resultReason: ''
      },
    }
  },
  watch: {
    has: {
      handler(newValue,oldValue){
        if(this.has===false){
          this.results=[]
          showResultNotDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
            this.total=res.data.object.total
            if(res.data.code===200){
              for(let i=0;i<res.data.object.list.length;i++){
                let result=res.data.object.list[i]
                this.results.push({
                  resultId: result.resultId,
                  resultUserId: result.resultUserId,
                  resultType: result.resultType,
                  resultTime: result.resultTime,
                  resultHave: result.resultHave
                })
              }
            }
          }).catch(e=>{
            console.log(e)
          })
        }
        else{
          this.results=[]
          showResultHasDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
            this.total=res.data.object.total
            if(res.data.code===200){
              for(let i=0;i<res.data.object.list.length;i++){
                let result=res.data.object.list[i]
                this.results.push({
                  resultId: result.resultId,
                  resultUserId: result.resultUserId,
                  resultType: result.resultType,
                  resultTime: result.resultTime,
                  resultHave: result.resultHave
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
      showResultNotDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0;i<res.data.object.list.length;i++){
            let result=res.data.object.list[i]
            this.results.push({
              resultId: result.resultId,
              resultUserId: result.resultUserId,
              resultType: result.resultType,
              resultTime: result.resultTime,
              resultHave: result.resultHave
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    }
    else{
      showResultHasDo(this.$store.getters['admin'].adminId, this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0;i<res.data.object.list.length;i++){
            let result=res.data.object.list[i]
            this.results.push({
              resultId: result.resultId,
              resultUserId: result.resultUserId,
              resultType: result.resultType,
              resultTime: result.resultTime,
              resultHave: result.resultHave
            })
          }
        }
      }).catch(e=>{
        console.log(e)
      })
    }
  },
  methods: {
    showIt: function (val){
      this.showVisible=true
      this.resultId=val.resultId
      showDetail(val.resultId).then(res=>{
        if(res.data.code===200){
          this.showDetail.resultId=res.data.object.resultId
          this.showDetail.resultUserId=res.data.object.resultUserId
          this.showDetail.resultType=res.data.object.resultType
          this.showDetail.resultObjectId=res.data.object.resultObjectId
          this.showDetail.resultObject=res.data.object.resultObject
          this.showDetail.resultReason=res.data.object.resultReason
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    doIt: function (){
      this.showVisible=false
      doResult(this.resultId).then(res=>{
        if(res.data.code===200){
          this.store.dispatch('changeAdmin',{
            admin: res.data.object
          })
          this.change()
        }
      })
    },
    changePage: function (){
      if(this.has===false){
        showResultNotDo(this.store.getters['admin'].adminId, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0;i<res.data.object.list.length;i++){
              let result=res.data.object.list[i]
              this.results.push({
                resultId: result.resultId,
                resultUserId: result.resultUserId,
                resultType: result.resultType,
                resultTime: result.resultTime,
                resultHave: result.resultHave
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else{
        showResultHasDo(this.store.getters['admin'].adminId, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0;i<res.data.object.list.length;i++){
              let result=res.data.object.list[i]
              this.results.push({
                resultId: result.resultId,
                resultUserId: result.resultUserId,
                resultType: result.resultType,
                resultTime: result.resultTime,
                resultHave: result.resultHave
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