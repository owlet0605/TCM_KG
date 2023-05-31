<template>
  <div ref="charts" style="width: 1000px; height: 675px"></div>
</template>

<script>
import * as echarts from "echarts";
import zh from "@/assets/json/中华人民共和国.json";

export default {
  name: "Map",
  props: ['mapData'],
  mounted() {
    this.$nextTick(() => {
      console.log(this.mapData)
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
            {min: 0, max: 5, label: '低', color: '#60f3ac80'},
            {min: 6, max: 10, label: '较低', color: '#00ccbb80'},
            {min: 11, max: 15, label: '中', color: '#009ac080'},
            {min: 16, max: 20, label: '较高', color: '#006faf80'},
            {min: 21, max: 25, label: '高', color: '#02428980'}
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
          formatter: '中药产出种类<br/>{b}：{c}',
          enterable: true,
          textStyle: {
            color: "#DADADA",
            fontSize: "12",
            width: 20,
            height: 30,
            overflow: "break",
          },

        },
        //地图配置
        geo: {
          map: "china",
          label: {
            normal: {
              show: true,
              textStyle: {
                color: "#fff",
              },
            },
            // 鼠标放上去的样式
            emphasis: {
              textStyle: {
                color: "#fff",
              },
            },
          },
          //地图区域的样式设置
          itemStyle: {
            normal: {
              borderColor: "rgba(147, 235, 248, 1)",
              borderWidth: 1,
              areaColor: {
                type: "radial",
                x: 0.5,
                y: 0.5,
                r: 0.8,
                colorStops: [
                  {
                    offset: 0,
                    color: "rgba(147, 235, 248, 0)", // 0% 处的颜色
                  },
                  {
                    offset: 1,
                    color: "rgba(147, 235, 248, .2)", // 100% 处的颜色
                  },
                ],
                globalCoord: false, // 缺省为 false
              },
              shadowColor: "rgba(128, 217, 248, 1)",
              shadowOffsetX: -2,
              shadowOffsetY: 2,
              shadowBlur: 10,
            },
            // 鼠标放上去高亮的样式
            emphasis: {
              areaColor: "#389BB7",
              borderWidth: 0,
            },
          },
        },
        roam: true,
        itemStyle: {
          normal: {
            areaColor: '#6FA7CE', //地图颜色
            borderColor: '#fff' //地图边线颜色
          },
          emphasis: {
            areaColor: '#B7DFED' //鼠标移入颜色
          }
        },
        series: {
          name: '各省生产总值分布',
          type: 'map',
          mapType: 'china',
          roam: false,
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
      echarts.registerMap("china", zh)
      charts.setOption(option);
      //点击事件
      charts.on('click', (e) => {
        this.clickIt(e.name)
      });
    },
    clickIt: function (val) {
      this.$router.push({
        name: 'TcmProvince',
        query: {
          province: 'val'
        }
      })
    }
  }
}
</script>

<style scoped>

</style>