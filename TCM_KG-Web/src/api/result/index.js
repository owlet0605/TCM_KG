import axios from "axios";
import store from "@/store";
import {ElMessageBox} from "element-plus";
import router from "@/router";

// axios.defaults.baseURL = "http://localhost:8080/api/";
//
// axios.interceptors.request.use(
//     config => {
//         if(store.state.token!==''){
//             config.headers.token = store.state.token
//         }
//         console.log(config);
//         return config;
//     },
//     err => {
//         console.log(err);
//     }
// );
//
// axios.interceptors.response.use(res => {
//     if (res.status >= 200 && res.status < 300) {
//         return res;
//     }
//     else {
//         if(res.status===403){
//             ElMessageBox.confirm(
//                 '该功能需要登陆后使用，是否跳转登录',
//                 '权限不足',
//                 {
//                     confirmButtonText: '确定',
//                     cancelButtonText: '取消',
//                     type: 'warning',
//                 }
//             ).then(()=>{
//                 router.push({
//                     name: 'UserLogin'
//                 })
//                 router.go(0)
//             }).catch(e=>{
//                 console.log(e)
//             })
//         }
//     }
// }, error => {
//     console.log(Promise.reject(error))
//     return Promise.reject(error);
// })

export const resultInsert=(userId, objectId, type, object, reason)=>{
    let fd=new FormData()
    fd.append("resultId", '0')
    fd.append("resultUserId", userId)
    fd.append("resultHave", '0')
    fd.append("resultReason", reason)
    fd.append("resultType", type)
    fd.append("resultObjectId", objectId)
    fd.append("resultObject", object)

    return axios.post('/result/insert',fd)
}

export const showDetail=(resultId)=>{
    let fd=new FormData()
    fd.append("resultId", resultId)
    return axios.post('/result/show',fd)
}

export const doResult=(resultId)=>{
    let fd=new FormData()
    fd.append("resultId",resultId)
    return axios.post('/result/do',fd)
}