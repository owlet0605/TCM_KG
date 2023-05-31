<template>
  <el-container class="el-container">
    <el-header class="el-header">
      <SystemHeader/>
    </el-header>
    <el-main class="el-main">
      <div class="detail">
        <el-row>
          <el-col :span="20">
            <el-breadcrumb :separator-icon="ArrowRight">
              <el-breadcrumb-item :to="{ path: './' }">
                主页
              </el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: './TcmHome' }">
                中药材查询
              </el-breadcrumb-item>
              <el-breadcrumb-item>{{tcm.tcmNameZh}}</el-breadcrumb-item>
            </el-breadcrumb>
          </el-col>
          <el-col :span="1" :offset="3">
            <el-tooltip
                effect="dark"
                content="对中药信息纠错"
                placement="top"
            >
              <el-icon color="#FFA500" size="20px" @click="correctVisible=true"><WarnTriangleFilled /></el-icon>
            </el-tooltip>
            <el-dialog
                v-model="correctVisible"
                title="纠正"
                center
                destroy-on-close
            >
              <el-form :model="correctForm">
                <el-form-item label="对象" prop="object">
                  <el-input v-model="correctForm.object"></el-input>
                </el-form-item>
                <el-form-item label="理由" prop="reason">
                  <el-input v-model="correctForm.reason" type="textarea"></el-input>
                </el-form-item>
              </el-form>
              <el-button type="primary" size="large" @click="correct">提交</el-button>
            </el-dialog>
          </el-col>
        </el-row>
        <div class="context">
          <el-row>
            <h1 class="title">{{tcm.tcmNameZh}}</h1>
          </el-row>
          <div class="tcm">
            <el-row class="tcm-item">
              <strong>【中药名】</strong>{{tcm.tcmNameZh}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【拼音】</strong>{{tcm.tcmPinyin}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【别名】</strong>{{tcm.tcmAlias}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【英文名】</strong>{{tcm.tcmNameEn}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【来源】</strong>{{tcm.tcmCome}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【植物形态】</strong>{{tcm.tcmPlant}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【产地分布】</strong>{{tcm.tcmDistribution}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【采收加工】</strong>{{tcm.tcmProduce}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【药材性状】</strong>{{tcm.tcmTraits}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【归经】</strong>{{tcm.tcmInductive}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【性味】</strong>{{tcm.tcmTaste}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【功效作用】</strong>{{tcm.tcmFunction}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【临床应用】</strong>{{tcm.tcmClinical}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【药理研究】</strong>{{tcm.tcmPharmacological}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【化学成分】</strong>{{tcm.tcmChemical}}
            </el-row>
            <el-row class="tcm-item">
              <strong>【使用禁忌】</strong>{{tcm.tcmNote}}
            </el-row>
          </div>
        </div>
      </div>
    </el-main>
    <el-footer class="el-footer">
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import {ArrowRight, WarnTriangleFilled} from '@element-plus/icons-vue'
import SystemHeader from "@/components/header/SystemHeader.vue";
import {getTcm} from "@/api/tcm";
import {ElNotification} from "element-plus";
import {correctInsert, resultInsert} from "@/api/result";
import SystemFooter from "@/components/footer/SystemFooter.vue";
export default {
  name: "TcmDetail",
  computed: {
    ArrowRight() {
      return ArrowRight
    }
  },
  components: {SystemFooter, WarnTriangleFilled, SystemHeader},
  data() {
    return {
      tcm: {
        tcmId: "",
        tcmNameZh: "",
        tcmNameEn: "",
        tcmPinyin: "",
        tcmCome: "",
        tcmTraits: "",
        tcmPlant: "",
        tcmDistribution: "",
        tcmProduce: "",
        tcmInductive: "",
        tcmTaste: "",
        tcmNote: "",
        tcmFunction: "",
        tcmClinical: "",
        tcmAlias: "",
        tcmPharmacological: "",
        tcmChemical: ""
      },
      correctVisible: false,
      correctForm: {
        object: '',
        reason: ''
      }
    }
  },
  created() {
    getTcm(this.$route.query.tid).then(res=>{
      if(res.data.code===200){
        this.tcm.tcmId=res.data.object.tcmId
        this.tcm.tcmNameZh=res.data.object.tcmNameZh
        this.tcm.tcmNameEn=res.data.object.tcmNameEn
        this.tcm.tcmPinyin=res.data.object.tcmPinyin
        this.tcm.tcmCome=res.data.object.tcmCome
        this.tcm.tcmTraits=res.data.object.tcmTraits
        this.tcm.tcmPlant=res.data.object.tcmPlant
        this.tcm.tcmDistribution=res.data.object.tcmDistribution
        this.tcm.tcmProduce=res.data.object.tcmProduce
        this.tcm.tcmInductive=res.data.object.tcmInductive
        this.tcm.tcmTaste=res.data.object.tcmTaste
        this.tcm.tcmNote=res.data.object.tcmNote
        this.tcm.tcmFunction=res.data.object.tcmFunction
        this.tcm.tcmClinical=res.data.object.tcmClinical
        this.tcm.tcmAlias=res.data.object.tcmAlias
        this.tcm.tcmPharmacological=res.data.object.tcmPharmacological
        this.tcm.tcmChemical=res.data.object.tcmChemical
      }
    })
  },
  methods: {
    correct: function (){
      resultInsert(this.$store.getters['user'].userId, this.tcm.tcmId, 'correct', this.correctForm.object, this.correctForm.reason).then(res=>{
        if(res.data.code===200){
          ElNotification({
            title: '纠错成功',
            message: '您的纠错申请已提交，管理员将确认后进行操作',
            type: 'success',
          })
          this.reportVisible=false
        }
        else{
          ElNotification({
            title: '纠错失败',
            message: '您的纠错申请未发送出去，请您稍后再试',
            type: 'error',
          })
        }
      }).catch(e=>{
        console.log(e)
      })
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
  width: 60%;
  background-color: #fff;
  padding: 25px 25px 25px 25px;
}

.title {
  margin: 0 auto 30px auto;
  text-align: center;
}

.context {
  border-style: ridge;
  padding: 25px 10px 25px 10px;
  margin: 10px;
}

.tcm {
  padding: 0px 10px 10px 10px;
}

.tcm-item {
  margin: 0px 0px 10px 0px;
}

.el-breadcrumb {
  padding: 0 0 0 15px;
}

</style>