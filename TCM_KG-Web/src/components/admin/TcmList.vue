<template>
  <el-table :data="tcms" style="width: 100%">
    <el-table-column label="TID" prop="tcmId" />
    <el-table-column label="中药名" prop="tcmNameZh" />
    <el-table-column label="拼音" prop="tcmPinyin" />
    <el-table-column label="英文名" prop="tcmNameEn" />
    <el-table-column label="归经" prop="tcmInductive" />
    <el-table-column label="性味" prop="tcmTaste" />
    <el-table-column align="right">
      <template #header>
        <el-input v-model="str" size="small">
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
            title="添加中药">
          <el-form :model="addForm" label-width="100px" :rules="rules">
            <el-form-item label="中药名" prop="tcmNameZh">
              <el-input v-model="addForm.tcmNameZh"></el-input>
            </el-form-item>
            <el-form-item label="拼音" prop="tcmPinyin">
              <el-input v-model="addForm.tcmPinyin"></el-input>
            </el-form-item>
            <el-form-item label="别名" prop="tcmAlias">
              <el-input v-model="addForm.tcmAlias"></el-input>
            </el-form-item>
            <el-form-item label="英文名" prop="tcmNameEn">
              <el-input v-model="addForm.tcmNameEn"></el-input>
            </el-form-item>
            <el-form-item label="归经" prop="tcmInductive">
              <el-input v-model="addForm.tcmInductive"></el-input>
            </el-form-item>
            <el-form-item label="性味" prop="tcmTaste">
              <el-input v-model="addForm.tcmTaste"></el-input>
            </el-form-item>
            <el-form-item label="来源" prop="tcmCome">
              <el-input v-model="addForm.tcmCome" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="植物形态" prop="tcmPlant">
              <el-input v-model="addForm.tcmPlant" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="产地分布" prop="tcmDistribution">
              <el-input v-model="addForm.tcmDistribution" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="采收加工" prop="tcmProduce">
              <el-input v-model="addForm.tcmProduce" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="药材性状" prop="tcmTraits">
              <el-input v-model="addForm.tcmTraits" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="功效作用" prop="tcmFunction">
              <el-input v-model="addForm.tcmFunction" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="临床应用" prop="tcmClinical">
              <el-input v-model="addForm.tcmClinical" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="药理研究" prop="tcmPharmacological">
              <el-input v-model="addForm.tcmPharmacological" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="化学成分" prop="tcmChemical">
              <el-input v-model="addForm.tcmChemical" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="使用禁忌" prop="tcmNote">
              <el-input v-model="addForm.tcmNote" type="textarea"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="tcmAdd">添加</el-button>
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
            title="修改中药信息">
          <el-form :model="changeForm" label-width="100px" :rules="rules">
            <el-form-item label="TID" prop="tcmId">
              <el-text>{{changeForm.tcmId}}</el-text>
            </el-form-item>
            <el-form-item label="中药名" prop="tcmNameZh">
              <el-input v-model="changeForm.tcmNameZh"></el-input>
            </el-form-item>
            <el-form-item label="拼音" prop="tcmPinyin">
              <el-input v-model="changeForm.tcmPinyin"></el-input>
            </el-form-item>
            <el-form-item label="别名" prop="tcmAlias">
              <el-input v-model="changeForm.tcmAlias"></el-input>
            </el-form-item>
            <el-form-item label="英文名" prop="tcmNameEn">
              <el-input v-model="changeForm.tcmNameEn"></el-input>
            </el-form-item>
            <el-form-item label="归经" prop="tcmInductive">
              <el-input v-model="changeForm.tcmInductive"></el-input>
            </el-form-item>
            <el-form-item label="性味" prop="tcmTaste">
              <el-input v-model="changeForm.tcmTaste"></el-input>
            </el-form-item>
            <el-form-item label="来源" prop="tcmCome">
              <el-input v-model="changeForm.tcmCome"></el-input>
            </el-form-item>
            <el-form-item label="植物形态" prop="tcmPlant">
              <el-input v-model="changeForm.tcmPlant" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="产地分布" prop="tcmDistribution">
              <el-input v-model="changeForm.tcmDistribution" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="采收加工" prop="tcmProduce">
              <el-input v-model="changeForm.tcmProduce" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="药材性状" prop="tcmTraits">
              <el-input v-model="changeForm.tcmTraits" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="功效作用" prop="tcmFunction">
              <el-input v-model="changeForm.tcmFunction" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="临床应用" prop="tcmClinical">
              <el-input v-model="changeForm.tcmClinical" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="药理研究" prop="tcmPharmacological">
              <el-input v-model="changeForm.tcmPharmacological" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="化学成分" prop="tcmChemical">
              <el-input v-model="changeForm.tcmChemical" type="textarea"></el-input>
            </el-form-item>
            <el-form-item label="使用禁忌" prop="tcmNote">
              <el-input v-model="changeForm.tcmNote" type="textarea"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="warning" @click="this.changeVisible=false">取消</el-button>
              <el-button type="primary" @click="change">修改</el-button>
            </el-form-item>
          </el-form>
        </el-dialog>
        <el-button
            size="small"
            type="danger"
            @click="tcmDel(scope.row)"
        >删除</el-button>
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
import {getTcm, selectTcm, showAllTcm, tcmChange, tcmDelete, tcmInsert} from "@/api/tcm";
import {ElMessageBox, ElNotification} from "element-plus";
import {userDelete} from "@/api/user";

export default {
  name: "TcmList",
  components: {Search, Plus},
  data() {
    return {
      rules: {
        tcmNameZh: [
          { required: true, message: '不为空', trigger: 'blur' },
        ],
        tcmPinyin: [
          { required: true, message: '不为空', trigger: 'blur' },
        ]
      },
      addVisible: false,
      addForm: {
        tcmNameZh: '',
        tcmNameEn: '',
        tcmPinyin: '',
        tcmCome: '',
        tcmTraits: '',
        tcmPlant: '',
        tcmDistribution: '',
        tcmProduce: '',
        tcmInductive: '',
        tcmTaste: '',
        tcmNote: '',
        tcmFunction: '',
        tcmClinical: '',
        tcmAlias: '',
        tcmPharmacological: '',
        tcmChemical: ''
      },
      changeVisible: false,
      changeForm: {
        tcmId: '',
        tcmNameZh: '',
        tcmNameEn: '',
        tcmPinyin: '',
        tcmCome: '',
        tcmTraits: '',
        tcmPlant: '',
        tcmDistribution: '',
        tcmProduce: '',
        tcmInductive: '',
        tcmTaste: '',
        tcmNote: '',
        tcmFunction: '',
        tcmClinical: '',
        tcmAlias: '',
        tcmPharmacological: '',
        tcmChemical: ''
      },
      tcms: [],
      page: 1,
      total: 0,
      str: ''
    }
  },
  created() {
    showAllTcm(this.page).then(res=>{
      this.total=res.data.object.total
      if(res.data.code===200){
        for(let i=0; i<res.data.object.list.length; i++){
          let tcm=res.data.object.list[i]
          this.tcms.push({
            tcmId: tcm.tcmId,
            tcmNameZh: tcm.tcmNameZh,
            tcmNameEn: tcm.tcmNameEn,
            tcmPinyin: tcm.tcmPinyin,
            tcmInductive: tcm.tcmInductive,
            tcmTaste: tcm.tcmTaste
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
      this.addForm.tcmNameZh=''
      this.addForm.tcmNameEn=''
      this.addForm.tcmPinyin=''
      this.addForm.tcmCome=''
      this.addForm.tcmTraits=''
      this.addForm.tcmPlant=''
      this.addForm.tcmDistribution=''
      this.addForm.tcmProduce=''
      this.addForm.tcmInductive=''
      this.addForm.tcmTaste=''
      this.addForm.tcmNote=''
      this.addForm.tcmFunction=''
      this.addForm.tcmClinical=''
      this.addForm.tcmAlias=''
      this.addForm.tcmPharmacological=''
      this.addForm.tcmChemical=''
    },
    search: function (){
      this.page=1
      if(this.str===''){
        this.changePage()
      }
      else{
        this.tcms=[]
        getTcm(this.str).then(res=>{
          if(res.data.code===200) {
            this.total=1
            let tcm = res.data.object
            this.tcms.push({
              tcmId: tcm.tcmId,
              tcmNameZh: tcm.tcmNameZh,
              tcmNameEn: tcm.tcmNameEn,
              tcmPinyin: tcm.tcmPinyin,
              tcmInductive: tcm.tcmInductive,
              tcmTaste: tcm.tcmTaste
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
    tcmAdd: function (){
      tcmInsert(this.addForm).then(res=>{
        if(res.data.code===200){
          ElNotification({
            title: '添加成功',
            message: res.data.msg,
            type: 'success',
          })
          this.addVisible=false
          this.changePage()
        }
        else{
          ElNotification({
            title: '添加失败',
            message: res.data.msg,
            type: 'error',
          })
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    openChange: function (val){
      this.changeVisible=true
      this.changeForm.tcmId=val.tcmId
      this.changeForm.tcmNameZh=val.tcmNameZh
      this.changeForm.tcmNameEn=val.tcmNameEn
      this.changeForm.tcmPinyin=val.tcmPinyin
      this.changeForm.tcmInductive=val.tcmInductive
      this.changeForm.tcmTaste=val.tcmTaste
      getTcm(val.tcmId).then(res=>{
        if(res.data.code===200) {
          this.changeForm.tcmAlias=res.data.object.tcmAlias
          this.changeForm.tcmCome=res.data.object.tcmCome
          this.changeForm.tcmTraits=res.data.object.tcmTraits
          this.changeForm.tcmPlant=res.data.object.tcmPlant
          this.changeForm.tcmDistribution=res.data.object.tcmDistribution
          this.changeForm.tcmProduce=res.data.object.tcmProduce
          this.changeForm.tcmNote=res.data.object.tcmNote
          this.changeForm.tcmFunction=res.data.object.tcmFunction
          this.changeForm.tcmClinical=res.data.object.tcmClinical
          this.changeForm.tcmPharmacological=res.data.object.tcmPharmacological
          this.changeForm.tcmChemical=res.data.object.tcmChemical
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    change: function (){
      tcmChange(this.changeForm).then(res=>{
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
    tcmDel: function (val){
      ElMessageBox.confirm(
          '中药将被删除. 是否继续?',
          'Warning',
          {
            confirmButtonText: '继续',
            cancelButtonText: '取消',
            type: 'warning',
          }
      ).then(()=>{
        tcmDelete(val.tcmId).then(res=>{
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
      this.tcms=[]
      showAllTcm(this.page).then(res=>{
        this.total=res.data.object.total
        if(res.data.code===200){
          for(let i=0; i<res.data.object.list.length; i++){
            let tcm=res.data.object.list[i]
            this.tcms.push({
              tcmId: tcm.tcmId,
              tcmNameZh: tcm.tcmNameZh,
              tcmNameEn: tcm.tcmNameEn,
              tcmPinyin: tcm.tcmPinyin,
              tcmInductive: tcm.tcmInductive,
              tcmTaste: tcm.tcmTaste
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