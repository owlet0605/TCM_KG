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

export const commentAdd=(comment)=>{
    let fd=new FormData();
    fd.append("commentId","0");
    fd.append("commentUserId",comment.commentUserId);
    fd.append("commentContext",comment.commentContext);
    fd.append("commentLike","0");
    fd.append("commentTopId",comment.commentTopId);
    fd.append("commentForId",comment.commentForId);
    fd.append("commentArticleId",comment.commentArticleId);
    return axios.post('/comment/add',fd)
}

export const commentDelete=(commentId)=>{
    let fd=new FormData();
    fd.append("commentId",commentId);
    return axios.post('/comment/delete',fd)
}

export const showComments=(commentArticleId, page)=>{
    let fd=new FormData();
    fd.append("commentArticleId",commentArticleId);
    return axios.post('/comment/show?page='+page,fd)
}

export const showCommentsOfTop=(commentId, commentArticleId, page)=>{
    let fd=new FormData();
    fd.append("commentId",commentId);
    fd.append("commentArticleId",commentArticleId);
    return axios.post('/comment/show/sub?page='+page,fd)
}

export const getComment=(commentId)=>{
    let fd=new FormData()
    fd.append("commentId", commentId)
    return axios.post('/comment/get',fd)
}