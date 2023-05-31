<template>
  <el-container class="el-container">
    <el-header class="el-header">
      <SystemHeader/>
    </el-header>
    <el-main class="el-main">
      <el-row>
        <el-col :span="15">
          <el-row>
            <el-input v-model="str" placeholder="搜索..." class="el-input">
              <template #append>
                <el-button slot="append" type="primary" @click="search"><el-icon><Search/></el-icon>搜索</el-button>
              </template>
            </el-input>
          </el-row>
          <el-row class="initial">
            <el-col :span="2"><span>首字母:</span></el-col>
            <el-col :span="22">
              <el-radio-group v-model="initials" @change="initial">
                <el-radio-button label="#" class="el-radio-button">#</el-radio-button>
                <el-radio-button label="a" class="el-radio-button">A</el-radio-button>
                <el-radio-button label="b" class="el-radio-button">B</el-radio-button>
                <el-radio-button label="c" class="el-radio-button">C</el-radio-button>
                <el-radio-button label="d" class="el-radio-button">D</el-radio-button>
                <el-radio-button label="e" class="el-radio-button">E</el-radio-button>
                <el-radio-button label="f" class="el-radio-button">F</el-radio-button>
                <el-radio-button label="g" class="el-radio-button">G</el-radio-button>
                <el-radio-button label="h" class="el-radio-button">H</el-radio-button>
                <el-radio-button label="i" class="el-radio-button">I</el-radio-button>
                <el-radio-button label="g" class="el-radio-button">J</el-radio-button>
                <el-radio-button label="k" class="el-radio-button">K</el-radio-button>
                <el-radio-button label="l" class="el-radio-button">L</el-radio-button>
                <el-radio-button label="m" class="el-radio-button">M</el-radio-button>
                <el-radio-button label="n" class="el-radio-button">N</el-radio-button>
                <el-radio-button label="o" class="el-radio-button">O</el-radio-button>
                <el-radio-button label="p" class="el-radio-button">P</el-radio-button>
                <el-radio-button label="q" class="el-radio-button">Q</el-radio-button>
                <el-radio-button label="r" class="el-radio-button">R</el-radio-button>
                <el-radio-button label="s" class="el-radio-button">S</el-radio-button>
                <el-radio-button label="t" class="el-radio-button">T</el-radio-button>
                <el-radio-button label="u" class="el-radio-button">U</el-radio-button>
                <el-radio-button label="v" class="el-radio-button">V</el-radio-button>
                <el-radio-button label="w" class="el-radio-button">W</el-radio-button>
                <el-radio-button label="x" class="el-radio-button">X</el-radio-button>
                <el-radio-button label="y" class="el-radio-button">Y</el-radio-button>
                <el-radio-button label="z" class="el-radio-button">Z</el-radio-button>
              </el-radio-group>
            </el-col>
          </el-row>
          <div v-if="total!==0" class="tcms">
            <el-row >
              <el-col
                  v-for="tcm in tcms"
                  :span="5"
                  :offset="1"
              >
                <TcmItem :tcm="tcm"></TcmItem>
              </el-col>
            </el-row>
            <el-pagination
                @current-change="changePage"
                v-model:current-page="this.page"
                :default-current-page="parseInt(this.page)"
                hide-on-single-page
                :page-size="20"
                background
                layout="prev, pager, next, jumper"
                :total="parseInt(this.total)"
                class="el-pagination"
            ></el-pagination>
          </div>
          <div v-else class="=tcms"><el-empty description="未找到相关中药材"></el-empty></div>
        </el-col>
        <el-col :span="7" :offset="1">
          <el-row>
            <el-col :span="2">
              <el-divider direction="vertical" class="el-divider"/>
            </el-col>
            <el-col :span="22" >
              <div class="inductive">
                <el-row><span>按归经分类:</span></el-row>
                <br>
                <el-row>
                  <el-radio-group v-model="inductives" @change="inductive">
                    <el-radio-button label="#">全部</el-radio-button>
                    <el-radio-button label="胃">胃经</el-radio-button>
                    <el-radio-button label="脾">脾经</el-radio-button>
                    <el-radio-button label="肾">肾经</el-radio-button>
                    <el-radio-button label="大肠">大肠经</el-radio-button>
                  </el-radio-group>
                </el-row>
                <el-row>
                  <el-radio-group v-model="inductives" @change="inductive">
                    <el-radio-button label="肺">肺经</el-radio-button>
                    <el-radio-button label="心">心经</el-radio-button>
                    <el-radio-button label="肝">肝经</el-radio-button>
                    <el-radio-button label="胆">胆经</el-radio-button>
                    <el-radio-button label="膀胱">膀胱经</el-radio-button>
                  </el-radio-group>
                </el-row>
                <el-row>
                  <el-radio-group v-model="inductives" @change="inductive">
                    <el-radio-button label="三焦">三焦经</el-radio-button>
                    <el-radio-button label="小肠">小肠经</el-radio-button>
                    <el-radio-button label="心包">心包经</el-radio-button>
                  </el-radio-group>
                </el-row>
              </div>
              <br>
              <div class="property">
                <el-row><span>按四性分类:</span></el-row>
                <br>
                <el-row>
                  <el-radio-group v-model="propertys" @change="property">
                    <el-radio-button label="#">全部</el-radio-button>
                    <el-radio-button label="寒">寒</el-radio-button>
                    <el-radio-button label="凉">凉</el-radio-button>
                    <el-radio-button label="温">温</el-radio-button>
                    <el-radio-button label="热">热</el-radio-button>
                  </el-radio-group>
                </el-row>
              </div>
              <br>
              <div class="taste">
                <el-row><span>按五味分类:</span></el-row>
                <br>
                <el-row>
                  <el-radio-group v-model="tastes" @change="taste">
                    <el-radio-button label="#">全部</el-radio-button>
                    <el-radio-button label="酸">酸</el-radio-button>
                    <el-radio-button label="苦">苦</el-radio-button>
                    <el-radio-button label="甘">甘</el-radio-button>
                    <el-radio-button label="辛">辛</el-radio-button>
                    <el-radio-button label="咸">咸</el-radio-button>
                  </el-radio-group>
                </el-row>
              </div>
            </el-col>
          </el-row>
        </el-col>
      </el-row>
    </el-main>
    <el-footer class="el-footer">
      <SystemFooter/>
    </el-footer>
  </el-container>
</template>

<script>
import TcmItem from "@/components/Item/TcmItem.vue";
import SystemHeader from "@/components/header/SystemHeader.vue";
import {Search} from "@element-plus/icons-vue";
import {selectTcm, showAllTcm, showByInductive, showByInitial, showByProperty, showByTaste} from "@/api/tcm";
import SystemFooter from "@/components/footer/SystemFooter.vue";

export default {
  name: "TcmHome",
  components: {SystemFooter, Search, TcmItem, SystemHeader},
  data() {
    return{
      str: '',
      initials: '',
      inductives: '',
      tastes: '',
      propertys: '',
      mode: '',
      page: 1,
      total: 0,
      tcms:[]
    }
  },
  created() {
    this.mode=this.$route.query.mode===undefined?"original":this.$route.query.mode
    this.str=this.$route.query.str===undefined?'':this.$route.query.str
    this.initials=this.$route.query.initials===undefined?'':this.$route.query.initials
    this.inductives=this.$route.query.inductives===undefined?'':this.$route.query.inductives
    this.tastes=this.$route.query.tastes===undefined?'':this.$route.query.tastes
    this.propertys=this.$route.query.propertys===undefined?'':this.$route.query.propertys
    console.log(this.mode)
    console.log(this.str)
    this.changePage()
  },
  methods: {
    search: function (){
      this.mode="search"
      this.$router.push({
        name: 'TcmHome',
        query: {
          mode: this.mode,
          str: this.str
        }
      })
    },
    initial: function (){
      this.mode="initial"
      this.$router.push({
        name: 'TcmHome',
        query: {
          mode: this.mode,
          initials: this.initials
        }
      })
    },
    inductive: function (){
      this.mode="inductive"
      this.$router.push({
        name: 'TcmHome',
        query: {
          mode: this.mode,
          inductives: this.inductives
        }
      })
    },
    taste: function (){
      this.mode="taste"
      this.$router.push({
        name: 'TcmHome',
        query: {
          mode: this.mode,
          tastes: this.tastes
        }
      })
    },
    property: function (){
      this.mode="property"
      this.$router.push({
        name: 'TcmHome',
        query: {
          mode: this.mode,
          propertys: this.propertys
        }
      })
    },
    changePage: function () {
      this.tcms=[]
      if(this.mode==="original"){
        showAllTcm(this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0; i<res.data.object.list.length; i++){
              let tcm=res.data.object.list[i]
              this.tcms.push({
                tcmId: tcm.tcmId,
                tcmNameZh: tcm.tcmNameZh
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else if(this.mode==="initial"){
        showByInitial(this.initials, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0; i<res.data.object.list.length; i++){
              let tcm=res.data.object.list[i]
              this.tcms.push({
                tcmId: tcm.tcmId,
                tcmNameZh: tcm.tcmNameZh
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else if(this.mode==="inductive"){
        showByInductive(this.inductives, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0; i<res.data.object.list.length; i++){
              let tcm=res.data.object.list[i]
              this.tcms.push({
                tcmId: tcm.tcmId,
                tcmNameZh: tcm.tcmNameZh
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else if(this.mode==="taste"){
        showByTaste(this.tastes, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0; i<res.data.object.list.length; i++){
              let tcm=res.data.object.list[i]
              this.tcms.push({
                tcmId: tcm.tcmId,
                tcmNameZh: tcm.tcmNameZh
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else if(this.mode==="property"){
        showByProperty(this.propertys, this.page).then(res=>{
          this.total=res.data.object.total
          if(res.data.code===200){
            for(let i=0; i<res.data.object.list.length; i++){
              let tcm=res.data.object.list[i]
              this.tcms.push({
                tcmId: tcm.tcmId,
                tcmNameZh: tcm.tcmNameZh
              })
            }
          }
        }).catch(e=>{
          console.log(e)
        })
      }
      else if(this.mode==="search"){
        selectTcm(this.str, this.page).then(res=>{
          this.total=res.data.object.totalElements
          if(res.data.code===200){
            for(let i=0; i<res.data.object.content.length; i++){
              let tcm=res.data.object.content[i]
              this.tcms.push({
                tcmId: tcm.tcmId,
                tcmNameZh: tcm.tcmNameZh
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
  background-image: url("../../assets/login-background.png");
  background-size: cover;
  display: flex;
  justify-content: center;
  align-items: start;
  padding: 20px;
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

.el-divider {
  display: inline-block;
  width: 10px;
  height: 96em;
  margin: 0 8px;
  vertical-align: middle;
  position: relative;
}

.el-input {
  height: 40px;
  margin: 5px;
}

.el-radio-button {
  margin: 3px;
}

.tcms {
  text-align: center;
  background-color: #fff;
  border-radius: 6px;
  margin: 5px;
  padding: 15px 35px 15px 0px;
}

.el-pagination {
  width: 500px;
  padding: 25px 25px 5px 25px;

}

.initial {
  background-color: #fff;
  border-radius: 6px;
  margin: 5px;
  padding: 5px 10px 5px 10px;
}

.inductive {
  background-color: #fff;
  border-radius: 6px;
  margin: 5px;
  padding: 10px 5px 10px 35px;
}

.property {
  background-color: #fff;
  border-radius: 6px;
  margin: 5px;
  padding: 10px 5px 10px 35px;
}

.taste {
  background-color: #fff;
  border-radius: 6px;
  margin: 5px;
  padding: 10px 5px 10px 35px;
}
</style>