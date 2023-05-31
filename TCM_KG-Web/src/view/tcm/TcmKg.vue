<template>
  <el-container>
    <el-header>
      <SystemHeader/>
    </el-header>
    <el-main>
      <div class="detail">
        <el-row>
          <el-col :span="4">
            <el-row>
              <el-input v-model="text" placeholder="搜索..." class="search">
                <template #append>
                  <el-button slot="append" type="primary" @click="searchText"><el-icon><Search/></el-icon>搜索</el-button>
                </template>
              </el-input>
            </el-row>
            <el-row>
              <el-col :span="6">
                <el-button @click="this.dialogFormVisible=true">
                  <el-icon><Filter /></el-icon>
                </el-button>
                <el-dialog v-model="dialogFormVisible" title="筛选条件">
                  <el-form :model="form" label-width="100px">
                    <el-form-item label="四性">
                      <el-checkbox-group v-model="form.property">
                        <el-checkbox-button v-for="property in properties" :label="property">
                          {{property}}
                        </el-checkbox-button>
                      </el-checkbox-group>
                    </el-form-item>
                    <el-form-item label="五味">
                      <el-checkbox-group v-model="form.taste">
                        <el-checkbox-button v-for="taste in tastes" :label="taste">
                          {{taste}}
                        </el-checkbox-button>
                      </el-checkbox-group>
                    </el-form-item>
                    <el-form-item label="采收季节">
                      <el-checkbox-group v-model="form.season">
                        <el-checkbox-button v-for="season in seasons" :label="season">
                          {{season}}
                        </el-checkbox-button>
                      </el-checkbox-group>
                    </el-form-item>
                    <el-form-item label="归经">
                      <el-checkbox-group v-model="form.inductive">
                        <el-checkbox-button v-for="inductive in inductives" :label="inductive">
                          {{inductive}}
                        </el-checkbox-button>
                      </el-checkbox-group>
                    </el-form-item>
                    <el-form-item label="功效">
                      <el-checkbox-group v-model="form.func">
                        <el-checkbox-button v-for="func in funcs" :label="func">
                          {{func}}
                        </el-checkbox-button>
                      </el-checkbox-group>
                    </el-form-item>
                    <el-form-item label="产地">
                      <el-checkbox-group v-model="form.distribution">
                        <el-checkbox-button v-for="distribution in distributions" :label="distribution">
                          {{distribution}}
                        </el-checkbox-button>
                      </el-checkbox-group>
                    </el-form-item>
                  </el-form>
                  <template #footer>
              <span class="dialog-footer">
                <el-button @click="dialogFormVisible = false">撤销</el-button>
                <el-button type="primary" @click="searchBy">确定</el-button>
              </span>
                  </template>
                </el-dialog>
              </el-col>
              <el-col :span="6">
                <el-tooltip
                    effect="dark"
                    content="对中药信息纠错"
                    placement="top"
                >
                  <el-icon color="#FFA500" size="20px" @click="correctVisible=true" class="correct"><WarnTriangleFilled /></el-icon>
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
              <el-col :span="4" :offset="8">
                <el-switch
                    v-model="is2D"
                    class="ml-2"
                    inline-prompt
                    style="--el-switch-on-color: #13ce66; --el-switch-off-color: #ff4949"
                    active-text="2D展示"
                    inactive-text="3D展示"
                />
              </el-col>
            </el-row>
            <br>
            <el-row><el-text>节点类型</el-text></el-row>
            <el-row>
              <el-col :span="8"><el-button round bg @click="searchTcmNode" style="background-color: #BA55D3;border: none">中药材</el-button></el-col>
              <el-col :span="8"><el-button round bg @click="searchNameNode" style="background-color: #FFA500;border: none">中药名</el-button></el-col>
              <el-col :span="8"><el-button round bg @click="searchTasteNode" style="background-color: #FFB6C1;border: none">五味</el-button></el-col>
            </el-row>
            <div class="diver"></div>
            <el-row>
              <el-col :span="8"><el-button round bg @click="searchDistributionNode" style="background-color: #FF4500;border: none">分布</el-button></el-col>
              <el-col :span="8"><el-button round bg @click="searchAliasNode" style="background-color: #87CEEB;border: none">别名</el-button></el-col>
              <el-col :span="8"><el-button round bg @click="searchFunctionNode" style="background-color: #EEE8AA;border: none">功能</el-button></el-col>
            </el-row>
            <div class="diver"></div>
            <el-row>
              <el-col :span="8"><el-button round bg @click="searchPropertyNode" style="background-color: #98FB98;border: none">四性</el-button></el-col>
              <el-col :span="8"><el-button round bg @click="searchInductiveNode" style="background-color: #00BFFF;border: none">归经</el-button></el-col>
              <el-col :span="8"><el-button round bg @click="searchSeasonNode" style="background-color: #FFF8DC;border: none">采收季节</el-button></el-col>
            </el-row>
            <br><br>
            <el-row><el-text>关系类型</el-text></el-row>
            <el-row>
              <el-col :span="6"><el-button round @click="searchAlias">别名</el-button></el-col>
              <el-col :span="6"><el-button round @click="searchFunction">功能</el-button></el-col>
              <el-col :span="6"><el-button round @click="searchInclude">包含</el-button></el-col>
              <el-col :span="6"><el-button round @click="searchDistribution">地区分布</el-button></el-col>
            </el-row>
            <div class="diver"></div>
            <el-row>
              <el-col :span="6"><el-button round @click="searchInductive">归经</el-button></el-col>
              <el-col :span="6"><el-button round @click="searchProperty">药性</el-button></el-col>
              <el-col :span="6"><el-button round @click="searchTaste">药味</el-button></el-col>
              <el-col :span="6"><el-button round @click="searchSeason">采收季节</el-button></el-col>
            </el-row>
          </el-col>
          <el-col :span="19" :offset="1">
            <Tcm2D v-if="is2D" :data="data"/>
            <Tcm3D v-else :data="data"/>
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
import SystemHeader from "@/components/header/SystemHeader.vue";
import {Filter, Search, WarnTriangleFilled} from "@element-plus/icons-vue";
import neo4j from "neo4j-driver";
import Tcm2D from "@/components/tcmKg/Tcm2D.vue";
import Tcm3D from "@/components/tcmKg/Tcm3D.vue";
import SystemFooter from "@/components/footer/SystemFooter.vue";
import {resultInsert} from "@/api/result";
import {ElNotification} from "element-plus";

export default {
  name: "TcmKg",
  components: {SystemFooter, WarnTriangleFilled, Filter, Tcm3D, Tcm2D, Search, SystemHeader},
  mounted() {
    let cypher = 'MATCH (n)-[r]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
        'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
    this.search(cypher);
  },
  data() {
    return {
      text: "",
      is2D: true,
      dialogFormVisible: false,
      form: {
        property: [],
        taste: [],
        season: [],
        inductive: [],
        func: [],
        distribution: [],
      },
      properties: [
          '温','寒','凉','热'
      ],
      tastes:[
          '辛','酸','甘','苦','咸'
      ],
      seasons:[
          '春','夏','秋','冬'
      ],
      inductives:[
          '胃经','脾经','肾经','肺经','心经','肝经','胆经','大肠经','小肠经','膀胱经','三焦经','心包经'
      ],
      funcs:[
          '清热','止血','解表','祛风湿','泻下','利水渗湿','活血化瘀','补虚','收涩','安神','平肝息风','化痰止咳平喘',
          '化湿','温里','理气','驱虫','消食','开窍','涌吐','杀虫止痒','拔毒生肌'
      ],
      distributions:[
          '北京','天津','上海','重庆','河北','山西','辽宁','吉林','黑龙江','江苏','浙江','安徽', '福建','江西',
          '山东','河南','湖北','湖南','广东','海南','四川','贵州','云南','陕西', '甘肃','青海','台湾','内蒙古',
          '广西','西藏','宁夏','新疆','香港','澳门'
      ],
      db:{
        uri : 'bolt://localhost:7687',
        user : 'neo4j',
        password : '200106050519r..'
      },
      data: {
        node: [],
        relation: []
      },
      correctVisible: false,
      correctForm: {
        object: '',
        reason: ''
      }
    }
  },
  methods: {
    searchText: function (){
      let where="properties(n).name='"+this.text+"' OR properties(m).name='"+this.text+"'"
      let cypher = 'MATCH (n)-[r]->(m) WHERE ' + where + ' RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType'
      this.search(cypher);
    },
    async searchBy() {
      this.data.node = []
      this.data.relation = []
      this.dialogFormVisible = false
      let record = []
      if (this.form.property.length !== 0) {
        let where = ""
        for (let i = 0; i < this.form.property.length; i++) {
          if (i === 0) {
            where = "properties(m).name='" + this.form.property[i] + "'"
          } else {
            where += " OR properties(m).name='" + this.form.property[i] + "'"
          }
        }
        let cypher = 'MATCH (n)-[r]->(m) WHERE ' + where + ' RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
            'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType'
        await this.searchAdd(cypher).then(res=>{
          record = res
        })
      }
      if (this.form.taste.length !== 0) {
        let where = ""
        for (let i = 0; i < this.form.taste.length; i++) {
          if (i === 0) {
            where = "properties(m).name='" + this.form.taste[i] + "'"
          } else {
            where += " OR properties(m).name='" + this.form.taste[i] + "'"
          }
        }
        let cypher = 'MATCH (n)-[r]->(m) WHERE ' + where + ' RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
            'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType'
        await this.searchAdd(cypher).then(res=>{
          if (record.length === 0) {
            record = res
          } else {
            let newRecord = []
            for (let i = 0; i < record.length; i++) {
              for (let j = 0; j < res.length; j++) {
                if (record[i]._fields[0].low.toString() === res[j]._fields[0].low.toString()) {
                  newRecord.push(record[i])
                  newRecord.push(res[j])
                }
              }
            }
            record = Array.from(new Set(newRecord.map(JSON.stringify))).map(JSON.parse)
          }
        })
      }
      if (this.form.season.length !== 0) {
        let where = ""
        for (let i = 0; i < this.form.season.length; i++) {
          if (i === 0) {
            where = "properties(m).name='" + this.form.season[i] + "'"
          } else {
            where += " OR properties(m).name='" + this.form.season[i] + "'"
          }
        }
        let cypher = 'MATCH (n)-[r]->(m) WHERE ' + where + ' RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
            'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType'
        await this.searchAdd(cypher).then(records=>{
          if (record.length === 0) {
            record = records
          } else {
            let newRecord = []
            for (let i = 0; i < record.length; i++) {
              for (let j = 0; j < records.length; j++) {
                if (record[i]._fields[0].low.toString() === records[j]._fields[0].low.toString()) {
                  newRecord.push(record[i])
                  newRecord.push(records[j])
                }
              }
            }
            record = Array.from(new Set(newRecord.map(JSON.stringify))).map(JSON.parse)
          }
        })
      }
      if (this.form.inductive.length !== 0) {
        let where = ""
        for (let i = 0; i < this.form.inductive.length; i++) {
          if (i === 0) {
            where = "properties(m).name='" + this.form.inductive[i] + "'"
          } else {
            where += " OR properties(m).name='" + this.form.inductive[i] + "'"
          }
        }
        let cypher = 'MATCH (n)-[r]->(m) WHERE ' + where + ' RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
            'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType'
        await this.searchAdd(cypher).then(records=>{
          if (record.length === 0) {
            record = records
          } else {
            let newRecord = []
            for (let i = 0; i < record.length; i++) {
              for (let j = 0; j < records.length; j++) {
                if (record[i]._fields[0].low.toString() === records[j]._fields[0].low.toString()) {
                  newRecord.push(record[i])
                  newRecord.push(records[j])
                }
              }
            }
            record = Array.from(new Set(newRecord.map(JSON.stringify))).map(JSON.parse)
          }
        })
      }
      if (this.form.distribution.length !== 0) {
        let where = ""
        for (let i = 0; i < this.form.distribution.length; i++) {
          if (i === 0) {
            where = "properties(m).name='" + this.form.distribution[i] + "'"
          } else {
            where += " OR properties(m).name='" + this.form.distribution[i] + "'"
          }
        }
        let cypher = 'MATCH (n)-[r]->(m) WHERE ' + where + ' RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
            'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType'
        await this.searchAdd(cypher).then(records=>{
          if (record.length === 0) {
            record = records
          } else {
            let newRecord = []
            for (let i = 0; i < record.length; i++) {
              for (let j = 0; j < records.length; j++) {
                if (record[i]._fields[0].low.toString() === records[j]._fields[0].low.toString()) {
                  newRecord.push(record[i])
                  newRecord.push(records[j])
                }
              }
            }
            record = Array.from(new Set(newRecord.map(JSON.stringify))).map(JSON.parse)
          }
        })
      }
      if (this.form.func.length !== 0) {
        let where = ""
        for (let i = 0; i < this.form.func.length; i++) {
          if (i === 0) {
            if (this.form.func[i] === '清热') {
              where = "properties(m).name='清虚热' OR properties(m).name='清热解毒' OR properties(m).name='清热泻火' OR properties(m).name='清热凉血' OR properties(m).name='清热燥湿'"
            } else if (this.form.func[i] === '止血') {
              where = "properties(m).name='收敛止血' OR properties(m).name='凉血止血' OR properties(m).name='化瘀止血' OR properties(m).name='温经止血'"
            } else if (this.form.func[i] === '解表') {
              where = "properties(m).name='辛温解表' OR properties(m).name='辛凉解表'"
            } else if (this.form.func[i] === '祛风湿') {
              where = "properties(m).name='祛风湿散寒' OR properties(m).name='祛风湿清热' OR properties(m).name='祛风湿强筋骨'"
            } else if (this.form.func[i] === '泻下') {
              where = "properties(m).name='攻下' OR properties(m).name='润下' OR properties(m).name='峻下逐水'"
            } else if (this.form.func[i] === '利水渗湿') {
              where = "properties(m).name='利水消肿' OR properties(m).name='利尿通淋' OR properties(m).name='利湿退黄'"
            } else if (this.form.func[i] === '活血化瘀') {
              where = "properties(m).name='活血止痛' OR properties(m).name='活血调经' OR properties(m).name='活血疗养' OR properties(m).name='破血消癥'"
            } else if (this.form.func[i] === '补虚') {
              where = "properties(m).name='补气' OR properties(m).name='补阳' OR properties(m).name='补血' OR properties(m).name='补阴'"
            } else if (this.form.func[i] === '收涩') {
              where = "properties(m).name='固表止汗' OR properties(m).name='敛肺涩肠' OR properties(m).name='固精缩尿止带'"
            } else if (this.form.func[i] === '安神') {
              where = "properties(m).name='重镇安神' OR properties(m).name='养心安神'"
            } else if (this.form.func[i] === '平肝息风') {
              where = "properties(m).name='平抑肝阳' OR properties(m).name='息风止痉'"
            } else if (this.form.func[i] === '化痰止咳平喘') {
              where = "properties(m).name='温化寒痰' OR properties(m).name='清化热痰' OR properties(m).name='止咳平喘'"
            } else {
              where += "properties(m).name='" + this.form.func[i] + "'"
            }
          } else {
            if (this.form.func[i] === '清热') {
              where = " OR properties(m).name='清虚热' OR properties(m).name='清热解毒' OR properties(m).name='清热泻火' OR properties(m).name='清热凉血' OR properties(m).name='清热燥湿'"
            } else if (this.form.func[i] === '止血') {
              where = " OR properties(m).name='收敛止血' OR properties(m).name='凉血止血' OR properties(m).name='化瘀止血' OR properties(m).name='温经止血'"
            } else if (this.form.func[i] === '解表') {
              where = " OR properties(m).name='辛温解表' OR properties(m).name='辛凉解表'"
            } else if (this.form.func[i] === '祛风湿') {
              where = " OR properties(m).name='祛风湿散寒' OR properties(m).name='祛风湿清热' OR properties(m).name='祛风湿强筋骨'"
            } else if (this.form.func[i] === '泻下') {
              where = " OR properties(m).name='攻下' OR properties(m).name='润下' OR properties(m).name='峻下逐水'"
            } else if (this.form.func[i] === '利水渗湿') {
              where = " OR properties(m).name='利水消肿' OR properties(m).name='利尿通淋' OR properties(m).name='利湿退黄'"
            } else if (this.form.func[i] === '活血化瘀') {
              where = " OR properties(m).name='活血止痛' OR properties(m).name='活血调经' OR properties(m).name='活血疗养' OR properties(m).name='破血消癥'"
            } else if (this.form.func[i] === '补虚') {
              where = " OR properties(m).name='补气' OR properties(m).name='补阳' OR properties(m).name='补血' OR properties(m).name='补阴'"
            } else if (this.form.func[i] === '收涩') {
              where = " OR properties(m).name='固表止汗' OR properties(m).name='敛肺涩肠' OR properties(m).name='固精缩尿止带'"
            } else if (this.form.func[i] === '安神') {
              where = " OR properties(m).name='重镇安神' OR properties(m).name='养心安神'"
            } else if (this.form.func[i] === '平肝息风') {
              where = " OR properties(m).name='平抑肝阳' OR properties(m).name='息风止痉'"
            } else if (this.form.func[i] === '化痰止咳平喘') {
              where = " OR properties(m).name='温化寒痰' OR properties(m).name='清化热痰' OR properties(m).name='止咳平喘'"
            } else {
              where += " OR properties(m).name='" + this.form.func[i] + "'"
            }
          }
        }
        let cypher = 'MATCH (n)-[r]->(m) WHERE ' + where + ' RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
            'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType'
        await this.searchAdd(cypher).then(records=>{
          if (record.length === 0) {
            record = records
          } else {
            let newRecord = []
            for (let i = 0; i < record.length; i++) {
              for (let j = 0; j < records.length; j++) {
                if (record[i]._fields[0].low.toString() === records[j]._fields[0].low.toString()) {
                  newRecord.push(record[i])
                  newRecord.push(records[j])
                }
              }
            }
            record = Array.from(new Set(newRecord.map(JSON.stringify))).map(JSON.parse)
          }
        })
      }
      let nodes = [];
      for (let i = 0; i < record.length; i++) {
        let r=JSON.stringify(record[i])
        nodes.push({
          name: record[i]._fields[2].toString(),
          id: record[i]._fields[0].low.toString(),
          label: record[i]._fields[1].toString()
        })
        nodes.push({
          name: record[i]._fields[5].toString(),
          id: record[i]._fields[3].low.toString(),
          label: record[i]._fields[4].toString()
        })
        this.data.relation.push({
          source: record[i]._fields[0].low.toString(),
          target: record[i]._fields[3].low.toString(),
          id: record[i]._fields[6].low.toString(),
          type: record[i]._fields[7].toString(),
          lineStyle: {
            curveness: 0
          },
          label: {
            show: true,
            formatter: function () {
              return record[i]._fields[7].toString()
            }
          }
        });
      }
      let newNodes = Array.from(new Set(nodes.map(JSON.stringify))).map(JSON.parse)
      newNodes.forEach((node) => {
        let color = () => {
          if (node.label === "中药材") {
            return '#BA55D3'
          } else if (node.label === "中药名") {
            return '#FFA500'
          } else if (node.label === "五味") {
            return '#FFB6C1'
          } else if (node.label === "分布") {
            return '#FF4500'
          } else if (node.label === "别名") {
            return '#87CEEB'
          } else if (node.label === "功能") {
            return '#EEE8AA'
          } else if (node.label === "四性") {
            return '#98FB98'
          } else if (node.label === "归经") {
            return '#00BFFF'
          }
          return '#FFF8DC';
        }
        this.data.node.push({
          id: node.id,
          name: node.name,
          label: node.label,
          x: Math.random() * 100,
          y: Math.random() * 100,
          itemStyle: {
            color: color()
          }
        });
      })
    },
    searchNode: function (cypher) {
      this.data.node = []
      this.data.relation = []
      const neo4j = require('neo4j-driver')
      const driver = neo4j.driver(this.db.uri, neo4j.auth.basic(this.db.user, this.db.password))
      const session = driver.session()
      session.run(cypher).then(res => {
        let records = res.records;
        for (let i = 0; i < records.length; i++) {
          let color = () => {
            if (records[i]._fields[1].toString() === "中药材") {
              return '#BA55D3'
            } else if (records[i]._fields[1].toString() === "中药名") {
              return '#FFA500'
            } else if (records[i]._fields[1].toString() === "五味") {
              return '#FFB6C1'
            } else if (records[i]._fields[1].toString() === "分布") {
              return '#FF4500'
            } else if (records[i]._fields[1].toString() === "别名") {
              return '#87CEEB'
            } else if (records[i]._fields[1].toString() === "功能") {
              return '#EEE8AA'
            } else if (records[i]._fields[1].toString() === "四性") {
              return '#98FB98'
            } else if (records[i]._fields[1].toString() === "归经") {
              return '#00BFFF'
            }
            return '#FFF8DC';
          }
          this.data.node.push({
            id: records[i]._fields[0].toString(),
            name: records[i]._fields[2].toString(),
            label: records[i]._fields[1].toString(),
            x: Math.random() * 100,
            y: Math.random() * 100,
            itemStyle: {
              color: color()
            }
          });
        }
      }).then(() => {
        session.close()
      });
    },
    searchTcmNode: function () {
      let cypher = 'MATCH (n:`中药材`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    searchNameNode: function () {
      let cypher = 'MATCH (n:`中药名`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    searchAliasNode: function () {
      let cypher = 'MATCH (n:`别名`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName LIMIT 2000'
      this.searchNode(cypher)
    },
    searchDistributionNode: function () {
      let cypher = 'MATCH (n:`分布`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    searchFunctionNode: function () {
      let cypher = 'MATCH (n:`功能`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    searchInductiveNode: function () {
      let cypher = 'MATCH (n:`归经`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    searchPropertyNode: function () {
      let cypher = 'MATCH (n:`四性`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    searchSeasonNode: function () {
      let cypher = 'MATCH (n:`采收季节`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    searchTasteNode: function () {
      let cypher = 'MATCH (n:`五味`) RETURN id(n) as node, labels(n) as nodeLabel, properties(n).name as nodeName'
      this.searchNode(cypher)
    },
    search: function (cypher) {
      this.data.node = []
      this.data.relation = []
      const neo4j = require('neo4j-driver')
      const driver = neo4j.driver(this.db.uri, neo4j.auth.basic(this.db.user, this.db.password))
      const session = driver.session()
      session.run(cypher).then(res => {
        let records = res.records;
        let nodes = [];
        for (let i = 0; i < records.length; i++) {
          nodes.push({
            name: records[i]._fields[2].toString(),
            id: records[i]._fields[0].toString(),
            label: records[i]._fields[1].toString()
          })
          nodes.push({
            name: records[i]._fields[5].toString(),
            id: records[i]._fields[3].toString(),
            label: records[i]._fields[4].toString()
          })
          this.data.relation.push({
            source: records[i]._fields[0].toString(),
            target: records[i]._fields[3].toString(),
            id: records[i]._fields[6].toString(),
            type: records[i]._fields[7].toString(),
            lineStyle: {
              curveness: 0
            },
            label: {
              show: true,
              formatter: function () {
                return records[i]._fields[7].toString()
              }
            }
          });
        }
        let newNodes = Array.from(new Set(nodes.map(JSON.stringify))).map(JSON.parse)
        newNodes.forEach((node) => {
          let color = () => {
            if (node.label === "中药材") {
              return '#BA55D3'
            } else if (node.label === "中药名") {
              return '#FFA500'
            } else if (node.label === "五味") {
              return '#FFB6C1'
            } else if (node.label === "分布") {
              return '#FF4500'
            } else if (node.label === "别名") {
              return '#87CEEB'
            } else if (node.label === "功能") {
              return '#EEE8AA'
            } else if (node.label === "四性") {
              return '#98FB98'
            } else if (node.label === "归经") {
              return '#00BFFF'
            }
            return '#FFF8DC';
          }
          this.data.node.push({
            id: node.id,
            name: node.name,
            label: node.label,
            x: Math.random() * 100,
            y: Math.random() * 100,
            itemStyle: {
              color: color()
            }
          });
        })
      }).then(() => {
        session.close()
      });
    },
    searchAlias: function () {
      let cypher = 'MATCH (n)-[r:alias]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    searchDistribution: function () {
      let cypher = 'MATCH (n)-[r:distribution]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    searchFunction: function () {
      let cypher = 'MATCH (n)-[r:function]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    searchInclude: function () {
      let cypher = 'MATCH (n)-[r:include]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    searchInductive: function () {
      let cypher = 'MATCH (n)-[r:inductive]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    searchProperty: function () {
      let cypher = 'MATCH (n)-[r:property]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    searchSeason: function () {
      let cypher = 'MATCH (n)-[r:season]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    searchTaste: function () {
      let cypher = 'MATCH (n)-[r:taste]->(m) RETURN id(n) as source, labels(n) as sourceLabel, properties(n).name as sourceName, ' +
          'id(m) as target, labels(m) as targetLabel, properties(m).name as targetName, id(r) as link, type(r) as relationType LIMIT 100'
      this.search(cypher)
    },
    async searchAdd(cypher) {
      const neo4j = require('neo4j-driver')
      const driver = neo4j.driver(this.db.uri, neo4j.auth.basic(this.db.user, this.db.password))
      const session = driver.session()
      let records=[]
      await session.run(cypher).then(res => {
        records=res.records
      })
      return records
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

.search {
  height: 40px;
  margin: 5px;
}

.detail {
  width: 90%;
  background-color: #fff;
  padding: 0px 25px 5px 25px;
}

.el-text {
  margin: 5px;
}

.diver {
  margin: 3px;
}

.correct {
  padding: 5px 0 0 0;
}
</style>

