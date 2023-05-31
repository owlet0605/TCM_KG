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

export const concernByUser=(userId1, userId2)=>{
    let fd=new FormData();
    fd.append("concernedUserId",userId1);
    fd.append("concernUserId",userId2);
    return axios.post('/concern/add/user',fd)
}

export const concernDelete=(userId1, userId2)=>{
    let fd=new FormData();
    fd.append("concernedUserId",userId1);
    fd.append("concernUserId",userId2);
    return axios.post('/concern/delete',fd)
}

export const concernIf=(userId1, userId2)=>{
    let fd=new FormData();
    fd.append("concernedUserId",userId1);
    fd.append("concernUserId",userId2);
    return axios.post('/concern/if',fd)
}