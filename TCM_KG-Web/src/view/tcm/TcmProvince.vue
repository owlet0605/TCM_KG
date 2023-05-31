<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row>
          <el-col :span="10">
            <div ref="chart" style="width: 500px; height: 600px"></div>
          </el-col>
          <el-col :span="14">
            <el-row>
              <el-col :span="22"><h1>{{this.province}}产出中药: </h1></el-col>
              <el-col :span="2" class="click">
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
            <el-row>
              {{tcmContext}}
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

import * as echarts from "echarts";
import 上海 from "@/assets/json/上海.json";
import 河北 from "@/assets/json/河北.json";
import 山西 from "@/assets/json/山西.json";
import 内蒙古 from "@/assets/json/内蒙古.json";
import 辽宁 from "@/assets/json/辽宁.json";
import 吉林 from "@/assets/json/吉林.json";
import 黑龙江 from "@/assets/json/黑龙江.json";
import 江苏 from "@/assets/json/江苏.json";
import 浙江 from "@/assets/json/浙江.json";
import 安徽 from "@/assets/json/安徽.json";
import 福建 from "@/assets/json/福建.json";
import 江西 from "@/assets/json/江西.json";
import 山东 from "@/assets/json/山东.json";
import 河南 from "@/assets/json/河南.json";
import 湖北 from "@/assets/json/湖北.json";
import 湖南 from "@/assets/json/湖南.json";
import 广东 from "@/assets/json/广东.json";
import 广西 from "@/assets/json/广西.json";
import 海南 from "@/assets/json/海南.json";
import 四川 from "@/assets/json/四川.json";
import 贵州 from "@/assets/json/贵州.json";
import 云南 from "@/assets/json/云南.json";
import 西藏 from "@/assets/json/西藏.json";
import 陕西 from "@/assets/json/陕西.json";
import 甘肃 from "@/assets/json/甘肃.json";
import 青海 from "@/assets/json/青海.json";
import 宁夏 from "@/assets/json/宁夏.json";
import 新疆 from "@/assets/json/新疆.json";
import 北京 from "@/assets/json/北京.json";
import 天津 from "@/assets/json/天津.json";
import 重庆 from "@/assets/json/重庆.json";
import 香港 from "@/assets/json/香港.json";
import 澳门 from "@/assets/json/澳门.json";
import 台湾 from "@/assets/json/台湾.json";
import neo4j from "neo4j-driver";
import SystemHeader from "@/components/header/SystemHeader.vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";
import {WarnTriangleFilled} from "@element-plus/icons-vue";
import {resultInsert} from "@/api/result";
import {ElNotification} from "element-plus";

export default {
  name: "TcmProvince",
  components: {WarnTriangleFilled, SystemFooter, SystemHeader},
  data() {
    return{
      db:{
        uri : 'bolt://localhost:7687',
        user : 'neo4j',
        password : '200106050519r..'
      },
      mapData: [
          {
        name: '铁岭市',
        value: 24
      },{
        name: '抚顺市',
        value: 11
      },{
        name: '沈阳市',
        value: 46
      },{
        name: '本溪市',
        value: 33
      },{
        name: '丹东市',
        value: 43
      },{
        name: '鞍山市',
        value: 27
      },{
        name: '营口市',
        value: 11
      },{
        name: '大连市',
        value: 5
      },{
        name: '盘锦市',
        value: 7
      },{
        name: '锦州市',
        value: 19
      },{
        name: '阜新市',
        value: 12
      },{
        name: '朝阳市',
        value: 32
      },{
        name: '葫芦岛市',
        value: 15
      },{
        name: '辽阳市',
          value: 7
        }
      ],
      province: this.$route.query.province,
      json: '',
      provincesText: ['上海', '河北', '山西', '内蒙古', '辽宁', '吉林',
        '黑龙江', '江苏', '浙江', '安徽', '福建', '江西',
        '山东', '河南', '湖北', '湖南', '广东', '广西',
        '海南', '四川', '贵州', '云南', '西藏', '陕西',
        '甘肃', '青海', '宁夏', '新疆', '北京', '天津',
        '重庆', '香港', '澳门', '台湾'],
      jsonMap: [上海, 河北, 山西, 内蒙古, 辽宁, 吉林,
        黑龙江, 江苏, 浙江, 安徽, 福建, 江西,
        山东, 河南, 湖北, 湖南, 广东, 广西,
        海南, 四川, 贵州, 云南, 西藏, 陕西,
        甘肃, 青海, 宁夏, 新疆, 北京, 天津,
        重庆, 香港, 澳门, 台湾],
      tcms: [],
      tcmContext: '',
      correctVisible: false,
      correctForm: {
        object: '',
        reason: ''
      }
    }
  },
  created() {
    for(let i=0;i<this.provincesText.length;i++){
      if(this.provincesText[i]===this.province){
        this.json=this.jsonMap[i]
      }
    }
    this.makeData()
    console.log(this.tcms)
    console.log(this.tcmContext)
  },
  mounted() {
    this.initCharts()
  },
  methods: {
    initCharts() {
      const charts = echarts.init(this.$refs["chart"]);
      const option = {
        // 背景颜色
        backgroundColor: "#F3F3F3",
        layoutCenter: ['70%', '150%'],//距离左右，上下距离的百分比
        layoutSize:'300%',//map百分比大小
        //提示浮窗样式
        tooltip: {
          show: true,
          trigger: "item",
          alwaysShowContent: false,
          backgroundColor: "#0C121C",
          borderColor: "rgba(0, 0, 0, 0.16);",
          hideDelay: 100,
          triggerOn: "mousemove",
          formatter: function (e) {
            return '中药产出种类<br/>'+e.name + '：' + e.value
          },
          enterable: true,
          textStyle: {
            color: "#DADADA",
            fontSize: "12",
            width: 20,
            height: 30,
            overflow: "break",
          },
        },
        visualMap: {
          type: 'piecewise',
          pieces: [
            { min: 0, max: 10, label: '低', color: '#60f3ac80' },
            { min: 11, max: 20, label: '较低', color: '#00ccbb80' },
            { min: 21, max: 30, label: '中', color: '#009ac080' },
            { min: 31, max: 40, label: '较高', color: '#006faf80' },
            { min: 41, max: 50, label: '高', color: '#02428980' }
          ],
          left: 'left'
        },
        grid: {
          left: "14%",
          top: "10%",
          right: "0%",
          bottom: "0%"
        },
        geo: {
          map: 'china',
          show: true,
          roam: true,
          label: {
            normal: {
              show: true,
              color: 'rgba(0, 0, 249,0.5)',
              fontSize: '12'
            },
            emphasis: {
              show: true,
              color: '#999',
              fontSize: '12'
            }
          },
          itemStyle: {
            normal: {
              areaColor: '#fff',
              borderColor: '#c5c5c5'
              // borderColor: 'red'
            },
            emphasis: {
              areaColor: '#2b91b7c0' // 悬浮区背景
            }
          },
          regions: [
            { // 隐藏南海诸岛
              name: '南海诸岛',
              itemStyle: {
                // 隐藏地图
                normal: {
                  opacity: 0 // 为 0 时不绘制该图形
                }
              },
              label: {
                show: false // 隐藏文字
              }
            }
          ]
        },
        series:{
          type: 'map',
          mapType: 'china',
          geoIndex: 0,
          roam: true,
          label: {
            show: true,
            color: 'rgba(0, 0, 249,0.5)'
          },
          itemStyle: {
            emphasis: {
              areaColor: '#2b91b7c0'
            }
          },
          data: this.mapData
        }

      };
      option.geo.center=undefined
      // 地图注册，第一个参数的名字必须和option.geo.map一致
      echarts.registerMap("china",this.json)
      charts.setOption(option);
    },
    makeData: function (){
      const neo4j = require('neo4j-driver')
      const driver = neo4j.driver(this.db.uri, neo4j.auth.basic(this.db.user, this.db.password))
      const session = driver.session()
      let cypher = "MATCH (n)-[r:distribution]->(m) where properties(m).name='"+this.province+"' RETURN properties(n).name"
      session.run(cypher).then(res => {
        let records = res.records;
        for(let i=0; i<records.length; i++){
          this.tcmContext+=records[i]._fields[0].toString()
          if(i!==records.length-1){
            this.tcmContext+=','
          }
          this.tcms.push(records[i]._fields[0].toString())
        }
      })
    },
    correct: function (){
      resultInsert(this.$store.getters['user'].userId, "0", 'correct', this.correctForm.object, this.correctForm.reason).then(res=>{
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
  padding: 0px 20px 0px 20px;
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
  background-color: #fff;
  width: 80%;
}

.click {
  padding: 20px 0 0 0;
}
</style>