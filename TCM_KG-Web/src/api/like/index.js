import axios from "axios";
import store from "@/store";
import {ElMessageBox} from "element-plus";
import router from "@/router";

// axios.defaults.baseURL = "http://localhost:8080/api";
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

export const likeAdd=(id, userId, type)=>{
    let fd=new FormData();
    fd.append("likeId","0");
    fd.append("likeUserId",userId);
    fd.append("likeType", type);
    if(type==="article"){
        fd.append("likeArticleId",id);
    }
    else if(type==="comment"){
        fd.append("likeCommentId",id);
    }
    return axios.post('/like/add',fd)
}

export const likeDelete=(id, userId, type)=>{
    let fd=new FormData();
    fd.append("likeUserId",userId);
    fd.append("likeType", type);
    if(type==="article"){
        fd.append("likeArticleId",id);
    }
    else if(type==="comment"){
        fd.append("likeCommentId",id);
    }
    return axios.post('/like/delete',fd)
}

export const showLikes=(userId, page)=>{
    return axios({
        url: '/like/show',
        params: {
            userId: userId,
            page: page
        }
    })
}

export const likeIf=(id, userId, type)=>{
    let fd=new FormData();
    fd.append("likeUserId",userId);
    fd.append("likeType", type);
    if(type==="article"){
        fd.append("likeArticleId",id);
    }
    else if(type==="comment"){
        fd.append("likeCommentId",id);
    }
    return axios.post('/like/if',fd)
}