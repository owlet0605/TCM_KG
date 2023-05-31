<template>
  <div class="echarts" ref="echarts" style="width: 1120px;height:675px;"></div>
</template>

<script>
import * as echarts from 'echarts'

export default {
  name: "Tcm2D",
  props: ['data'],
  watch:{
    data: {
      handler(newValue,oldValue){
        this.echartsData=this.data.node
        this.nodesRelation=this.data.relation
        this.getGraph();
      },
      deep:true
    }
  },
  mounted() {
    this.echartsData=this.data.node
    this.nodesRelation=this.data.relation
    this.getGraph()
  },
  data() {
    return {
      echartsData: [],
      nodesRelation: [],
      myChart: ""
    }
  },
  methods: {
    getGraph() {
      if(this.myChart) {
        this.initGraph();
      }else {
        this.myChart = echarts.init(this.$refs.echarts);
        this.initGraph();
      }
    },
    // onDelete() {
    //   this.connect();
    //   const session = this.$neo4j.getSession();
    //   let cypher = `match p=(n:Person)-[]->(m:Person) delete p `;
    //   session.run(cypher);
    //   cypher = `MATCH (n:Person) delete n`;
    //   session.run(cypher).then(() => {
    //     session.close()
    //   });
    //   this.query();
    // },
    initGraph() {
      let option = {
        tooltip: {
          formatter: x => {
            return [x.data.name];
          }
        },
        animationDurationUpdate: 1500,
        animationEasingUpdate: 'quinticInOut',
        label: {
          show: true,
          textStyle: {
            fontSize: 12
          },
        },
        series: [
          {
            type: 'graph',
            layout: 'force',
            force: {
              edgeLength: 40,
              repulsion: 50,
              gravity: 0.1
            },
            symbolSize: 50,
            focusNodeAdjacency: true,
            draggable: true,
            roam: true,
            label: {
              show: true
            },
            edgeSymbol: ['circle', 'arrow'],
            edgeSymbolSize: [4, 10],
            edgeLabel: {
              fontSize: 20
            },
            data: this.echartsData,
            links: this.nodesRelation,
            lineStyle: {
              opacity: 0.9,
              width: 2,
              curveness: 0
            }
          }
        ]
      };
      this.myChart.setOption(option)
    }
    // onSubmit() {
    //   this.$refs.neo4jform.validate((valid) => {
    //     if (valid) {
    //       this.connect();
    //       const session = this.$neo4j.getSession();
    //       let cypher = `Merge (n:Person{name: '${this.formInline.startNode}'})
    //       Merge (m:Person{name: '${this.formInline.endNode}'}) Merge (n)-[r:${this.formInline.relationName}]->(m)`;
    //       session.run(cypher).then(() => {
    //         this.formInline = {
    //           startNode: '',
    //           endNode: '',
    //           relationName: ''
    //         };
    //         this.query();
    //       }).then(() => {
    //         session.close()
    //       });
    //     }
    //   })
    // },

  }
}
</script>

<style scoped>
.echarts {
    background-color: #333;
    flex: 1;
  }
</style>
