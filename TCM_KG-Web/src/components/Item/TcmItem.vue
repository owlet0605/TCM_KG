<template>
  <el-card :body-style="{ padding: '0px' }">
    <el-image style="width: 200px; height: 200px" :src="this.tcmImg" :fit="cover" />
    <div style="padding: 10px">
      <el-link :underline="false" @click="showDetail"><h3 class="name" v-html="tcm.tcmNameZh"></h3></el-link>
    </div>
  </el-card>
</template>

<script>
export default {
  name: "TcmItem",
  props: ['tcm'],
  data() {
    return {
      tcmImg: 'http://localhost:8080/api/file/tcm/'+this.tcm.tcmId+".jpg"
    }
  },
  methods: {
    showDetail: function (){
      this.$router.push({
        name: 'TcmDetail',
        query: {
          tid: this.tcm.tcmId
        }
      })
    }
  }
}
</script>

<style scoped>
.el-card {
  margin: 0px 0px 10px 0px;
}

.name {
  margin: 0;
}
</style>