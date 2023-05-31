<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div ref="charts" style="width: 1000px; height: 675px"></div>
    </el-main>
    <el-footer>
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import SystemHeader from "@/components/header/SystemHeader.vue";
import * as echarts from "echarts";
import zh from "@/assets/json/中华人民共和国.json"
import SystemFooter from "@/components/footer/SystemFooter.vue";
import neo4j from "neo4j-driver";


export default {
  name: "TcmMap",
  components: {SystemFooter, SystemHeader},
  data() {
    return {
      db:{
        uri : 'bolt://localhost:7687',
        user : 'neo4j',
        password : '200106050519r..'
      },
      mapData: [
        {
          name: '上海市',
          value: 1
        },
        {
          name: '贵州省',
          value: 139
        },{
          name: '河北省',
          value: 112
        },{
          name: '山西省',
          value: 70
        },{
          name: '内蒙古自治区',
          value: 65
        },{
          name: '辽宁省',
          value: 84
        },{
          name: '吉林省',
          value: 59
        },{
          name: '黑龙江省',
          value: 54
        },{
          name: '江苏省',
          value: 131
        },{
          name: '浙江省',
          value: 146
        },{
          name: '安徽省',
          value: 98
        },{
          name: '福建省',
          value: 172
        },{
          name: '江西省',
          value: 102
        },{
          name: '山东省',
          value: 94
        },{
          name: '河南省',
          value: 125
        },{
          name: '湖北省',
          value: 121
        },{
          name: '湖南省',
          value: 109
        },{
          name: '广东省',
          value: 260
        },{
          name: '广西壮族自治区',
          value: 252
        },{
          name: '海南省',
          value: 100
        },{
          name: '四川省',
          value: 211
        },{
          name: '云南省',
          value: 210
        },{
          name: '西藏自治区',
          value: 47
        },{
          name: '陕西省',
          value: 152
        },{
          name: '甘肃省',
          value: 99
        },{
          name: '青海省',
          value: 33
        },{
          name: '宁夏回族自治区',
          value: 14
        },{
          name: '新疆维吾尔自治区',
          value: 36
        },{
          name: '北京市',
          value: 1
        },{
          name: '天津市',
          value: 2
        },{
          name: '重庆市',
          value: 0
        },{
          name: '香港特别行政区',
          value: 0
        },{
          name: '澳门特别行政区',
          value: 0
        },{
          name: '台湾省',
          value: 112
        }],
      provinceData:[],
      provinces: ['上海市', '河北省', '山西省', '内蒙古自治区', '辽宁省', '吉林省',
                  '黑龙江省', '江苏省', '浙江省', '安徽省', '福建省', '江西省',
                  '山东省', '河南省', '湖北省', '湖南省', '广东省', '广西壮族自治区',
                  '海南省', '四川省', '贵州省', '云南省', '西藏自治区', '陕西省',
                  '甘肃省', '青海省', '宁夏回族自治区', '新疆维吾尔自治区', '北京市', '天津市',
                  '重庆市', '香港特别行政区', '澳门特别行政区', '台湾省'],
      provincesText: ['上海', '河北', '山西', '内蒙古', '辽宁', '吉林',
                      '黑龙江', '江苏', '浙江', '安徽', '福建', '江西',
                      '山东', '河南', '湖北', '湖南', '广东', '广西',
                      '海南', '四川', '贵州', '云南', '西藏', '陕西',
                      '甘肃', '青海', '宁夏', '新疆', '北京', '天津',
                      '重庆', '香港', '澳门', '台湾']
    }
  },
  created () {
    for(let i=0;i<this.provincesText.length;i++){
      let province=this.provincesText[i];
      this.makeData(province,i)
    }
  },
  mounted() {
    this.$nextTick(() => {
      this.initCharts();
    })
  },
  methods: {
    initCharts() {
      const charts = echarts.init(this.$refs["charts"]);
      const option = {
        // 背景颜色
        backgroundColor: "#F3F3F3",
        title: {
          text: '中药产地信息可视化',
          subtext: '',
          left: 'center'
        },
        visualMap: {
          type: 'piecewise',
          pieces: [
            { min: 0, max: 50, label: '低', color: '#60f3ac80' },
            { min: 51, max: 100, label: '较低', color: '#00ccbb80' },
            { min: 101, max: 150, label: '中', color: '#009ac080' },
            { min: 151, max: 200, label: '较高', color: '#006faf80' },
            { min: 201, max: 300, label: '高', color: '#02428980' }
          ],
          left: 'left'
        },
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
        geo: {
          map: 'china',
          show: true,
          roam: true,
          label: {
            show: true,
            color: 'rgba(0, 0, 249,0.5)',
            fontSize: '12'
          },
          itemStyle: {
            areaColor: '#fff',
            borderColor: '#c5c5c5'
            // borderColor: 'red'
          },
          emphasis: {
            itemStyle: {
              areaColor: '#2b91b7c0' // 悬浮区背景
            },
            label: {
              show: true,
              color: '#999',
              fontSize: '12'
            }
          },
          data: this.mapData
        },
        roam: true,
        series:{
          type: 'map',
          map: 'china',
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
      // 地图注册，第一个参数的名字必须和option.geo.map一致
      echarts.registerMap("china",zh)
      charts.setOption(option);
      //点击事件
      charts.on('click', (e)=>{
        this.clickIt(e.name)
      });
    },
    clickIt: function (val){
      for(let i=0;i<this.provinces.length;i++){
        if(val===this.provinces[i]){
          this.$router.push({
            name: 'TcmProvince',
            query: {
              province: this.provincesText[i]
            }
          })
        }
      }
    },
    makeData: function (val, index){
      const neo4j = require('neo4j-driver')
      const driver = neo4j.driver(this.db.uri, neo4j.auth.basic(this.db.user, this.db.password))
      const session = driver.session()
      let cypher = "MATCH (n)-[r:distribution]->(m) where properties(m).name='"+val+"' RETURN properties(n).name"
      session.run(cypher).then(res => {
        let records = res.records;
        // this.mapData.push({
        //   name: this.provinces[index],
        //   value: records.length
        // })
        let tcms=[]
        for(let i=0; i<records.length; i++){
          tcms.push(records[i]._fields[0].toString())
        }
        this.provinceData.push({
          name: val,
          value: tcms
        })
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
</style>