<template>
  <div ref="graph" id="graph"></div>
</template>

<script>
import ForceGraph3D from "3d-force-graph";
export default {
  name: "Tcm3D",
  props: ['data'],
  watch:{
    data: {
      handler(newValue,oldValue){
        this.initGraph ()
      },
      deep:true
    }
  },
  data() {
    return {
      myGraph: null,
      graphData: null,
    };
  },
  mounted() {
    this.initGraph ()
  },
  methods: {
    async initGraph() {
      /********************************************** 1.创建图 **********************************************/
      this.myGraph = ForceGraph3D({
        controlType: "trackball",                                                                 // orbit沿2d轨迹绕着拖动，fly 固定不动
        rendererConfig:{ antialias: true, alpha: true }
      })(this.$refs.graph)
          /*------------------------------------------- 画布配置 -------------------------------------------*/
          .backgroundColor("black")                                                           // 背景颜色，支持内置颜色和RGB
          .width(this.$refs.graph.parentElement.offsetWidth )                                       // 画布宽度(充满父级容器)
          .height(this.$refs.graph.parentElement.offsetHeight)                           // 画布高度(充满父级容器)
          .showNavInfo(true)                                                               // 是否显示底部导航提示信息
          /*------------------------------------------- 节点配置 -------------------------------------------*/
          .nodeRelSize(5)                                                                           // 节点大小（支持数值）
          //.nodeVal(node => node.size * 0.05)                                                        // 节点大小（支持回调）
          .nodeColor(node=>node.color)
          .nodeOpacity(1)                                                                           // 节点透明度：回调函数处理（根据label划分）
          .nodeLabel(node => node.label+'<br>'+node.name)             // 节点标签显示内容（鼠标滑到节点显示，也可以使用回调函数）
          .onNodeHover(node => this.$refs.graph.style.cursor = node ? 'pointer' : null)     // 鼠标滑到节点上改变指针
          .onNodeClick(node => {                                                            // 点击节点事件（视角转移到该节点）
            // Aim at node from outside it
            const distance = 40;
            const distRatio = 1 + distance / Math.hypot(node.x, node.y, node.z);
            this.myGraph.cameraPosition(
                {x: node.x * distRatio, y: node.y * distRatio, z: node.z * distRatio}, // new position
                node, // lookAt ({ x, y, z })
                3000  // ms transition duration)
            )
          })
          /*------------------------------------------- 边的配置 -------------------------------------------*/
          .linkVisibility(true)                                                                    // 是否显示边
          .linkLabel(r => r.type)                                                      // 边的标签显示（鼠标滑到边上显示）
          .linkDirectionalArrowLength(3.5)                                                         // 边的指向箭头长度
          .linkDirectionalArrowRelPos(1)                                                           // 边的标签显示（鼠标滑到边上显示）
          .linkCurvature(0.25)                                                                     // 边的透明度
          .linkDirectionalParticles(5)                                                             // 边粒子：数量
          .linkDirectionalParticleSpeed(1)                                                         // 边粒子：移动速度
          .linkDirectionalParticleWidth(0.3)                                                       // 边粒子：大小
          .linkColor(()=>'RGB(170,170,170)')                                                       // 边颜色
          .linkAutoColorBy(r => r.type)                                                            // 边颜色自动化分
          .linkOpacity(0.5)                                                                        // 边透明度（越小越透明）

      /********************************************** 2.加载数据 **********************************************/
      const node_info = {}
      const rel_info = {}
      this.data.node.map(res=>{
        node_info[res.id] = {
          label: res.label,
          name: res.name,
          color: res.itemStyle.color
        };
      })
      this.data.relation.map(res=>{
        rel_info[res.id] = {
          source: res.source,
          target: res.target,
          type: res.type
        }
      })
      const links = Object.values(rel_info);
      /** 构造3D-Graph数据的节点 */
      const nodes = Object.entries(node_info).map(entry=>{
        return {id:entry[0], label:entry[1].label, name:entry[1].name, color: entry[1].color}
      })
      this.myGraph.graphData({
        nodes: nodes, links: links
      })
      /********************************************** 3.动态设置 **********************************************/
      /*  修改边长度,同d3引擎用法  */
      this.myGraph.d3Force('link').distance(400);
    }
  }
};
</script>

<style scoped>
#graph{
  background-color: #333;
  width: 1120px;
  height:675px;
}
</style>

