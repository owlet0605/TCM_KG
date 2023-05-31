<template>
  <div style="width: 100%">
    <el-row>
      <el-card class="card">
        <el-row>
          <el-col :span="2">
            <el-avatar size="large"> {{this.$store.getters['admin'].adminName}}</el-avatar>
          </el-col>
          <el-col :span="2">
            <text><h3>{{this.$store.getters['admin'].adminName}}</h3></text>
          </el-col>
          <el-col :span="2" :offset="12">
            <el-statistic title="待审核资讯" :value="this.$store.getters['admin'].adminAudit" />
          </el-col>
          <el-col :span="2">
            <el-statistic title="待处理事件" :value="this.$store.getters['admin'].adminResult" />
          </el-col>
        </el-row>
      </el-card>
    </el-row>
    <el-row :gutter="16" class="data">
      <el-col :span="4">
        <el-statistic :value="userNum">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              用户总数
              <el-tooltip
                  effect="dark"
                  content="已注册使用中药知识图谱可视化系统的用户数量"
                  placement="top"
              >
                <el-icon style="margin-left: 4px" :size="12">
                  <Warning />
                </el-icon>
              </el-tooltip>
            </div>
          </template>
        </el-statistic>
      </el-col>
      <el-col :span="4">
        <el-statistic :value="tcmNum">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              中药总数
              <el-tooltip
                  effect="dark"
                  content="中药知识图谱可视化系统已收录的中药种类数量"
                  placement="top"
              >
                <el-icon style="margin-left: 4px" :size="12">
                  <Warning />
                </el-icon>
              </el-tooltip>
            </div>
          </template>
        </el-statistic>
      </el-col>
      <el-col :span="4">
        <el-statistic :value="articleNum">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              资讯总数
              <el-tooltip
                  effect="dark"
                  content="中药知识图谱可视化系统中已发布的资讯数量"
                  placement="top"
              >
                <el-icon style="margin-left: 4px" :size="12">
                  <Warning />
                </el-icon>
              </el-tooltip>
            </div>
          </template>
        </el-statistic>
      </el-col>
      <el-col :span="4">
        <el-statistic value="5299">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              知识图谱节点数
              <el-tooltip
                  effect="dark"
                  content="中药知识图谱存储的节点数目"
                  placement="top"
              >
                <el-icon style="margin-left: 4px" :size="12">
                  <Warning />
                </el-icon>
              </el-tooltip>
            </div>
          </template>
        </el-statistic>
      </el-col>
      <el-col :span="4">
        <el-statistic value="14129">
          <template #title>
            <div style="display: inline-flex; align-items: center">
              知识图谱关系数
              <el-tooltip
                  effect="dark"
                  content="中药知识图谱存储的关系数目"
                  placement="top"
              >
                <el-icon style="margin-left: 4px" :size="12">
                  <Warning />
                </el-icon>
              </el-tooltip>
            </div>
          </template>
        </el-statistic>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import {Warning} from "@element-plus/icons-vue";
import {showAllUser} from "@/api/user";
import {showAllTcm} from "@/api/tcm";
import {articleAll} from "@/api/article";

export default {
  name: "AdminTotal",
  components: {Warning},
  data() {
    return {
      userNum: 0,
      tcmNum: 0,
      articleNum: 0
    }
  },
  created() {
    showAllUser(1).then(res=>{
      this.userNum=res.data.object.total
    }).catch(e=>{
      console.log(e)
    })

    showAllTcm(1).then(res=>{
      this.tcmNum=res.data.object.total
    }).catch(e=>{
      console.log(e)
    })

    articleAll(1).then(res=>{
      this.articleNum=res.data.object.total
    }).catch(e=>{
      console.log(e)
    })
  }
}
</script>

<style scoped>
.card {
  width: 100%;
  padding: 10px;
  margin: 0 0 10px 0;
}

.data {
  text-align: center;
}
</style>