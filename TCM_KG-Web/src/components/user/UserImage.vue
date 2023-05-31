<template>
  <div>
    <el-form  label-position="top">
      <el-text><h3>修改头像</h3></el-text>
      <el-form-item label="当前头像">
        <el-image :src="img"/>
      </el-form-item>
      <el-form-item>
        <el-upload
            action="http://localhost:8080/api/user/changeImg"
            :show-file-list="false"
            :limit='1'
            :http-request="change"
            :before-upload="beforeAvatarUpload">
          <el-button>
            <el-icon><Picture /></el-icon>
            选择本地图片
          </el-button>
        </el-upload>
      </el-form-item>
    </el-form>
  </div>
  <div>

  </div>
</template>


<script>
import {Picture} from "@element-plus/icons-vue";
import {ElNotification} from "element-plus";
import {changeUserImg} from "@/api/user";

export default {
  name: "UserImage",
  components: {Picture},
  computed: {
    img(){
      return this.$store.getters['user'].userImg
    }
  },
  methods: {
    change: function (param){
      console.log(param)
      changeUserImg(param.file, this.$store.getters['user'].userId).then(res=>{
        if(res.data.code===200){
          this.userImg=res.data.object.userImg
          this.$store.dispatch('changeUser',{
            user: res.data.object
          })
        }
        else{
          ElNotification({
            title: '错误',
            message: res.data.msg,
            type: 'error',
          })
        }
      }).catch(e=>{
        console.log(e)
      })
    },
    beforeAvatarUpload(file) {
      const img_mimetype = ['image/jpeg', 'image/jpg', 'image/png']
      const isJPG = img_mimetype.includes(file.type);
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        ElNotification({
          title: '错误',
          message: '上传头像只能是图片格式!',
          type: 'error',
        })
        return false;
      }
      if (!isLt2M) {
        ElNotification({
          title: '错误',
          message: '上传头像图片大小不能超过 2MB!',
          type: 'error',
        })
        return false;
      }
      return isJPG && isLt2M;
    }
  }
}
</script>

<style scoped>
.el-text {
  margin: 0 auto 30px auto;
  text-align: center;
  color: #707070;
}

.el-image {
  height: 300px;
  width: 300px;
}
</style>