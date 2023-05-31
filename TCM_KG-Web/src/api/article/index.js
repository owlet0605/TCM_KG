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

export const showArticlesOfType=(articleTypeId, page)=>{
    return axios({
        url: '/article/tag',
        params: {
            articleTypeId: articleTypeId,
            page: page
        }
    })
}

export const getArticleType=(articleTypeId)=>{
    let fd=new FormData();
    fd.append("articleTypeId", articleTypeId);
    return axios.post('/article/type',fd)
}

export const showArticles=(userId, page)=>{
    return axios({
        url: '/article/show',
        params: {
            userId: userId,
            page: page
        }
    })
}

export const articleAdd=(article, key)=>{
    let fd=new FormData();
    fd.append("articleId","0");
    fd.append("articleUserId",article.articleUserId);
    fd.append("articleTypeId",article.articleTypeId);
    fd.append("articleTitle",article.articleTitle);
    fd.append("articleContext",article.articleContext);
    fd.append("articleView","0");
    fd.append("articleComment","0");
    fd.append("articleLike","0");
    fd.append("articleCollect","0");
    fd.append("articleForward","0");
    fd.append("articleAudit","0");
    return axios.post('/article/add?key='+key,fd)
}

export const articleView=(userId, articleId)=>{
    let fd=new FormData();
    fd.append("historyUserId",userId);
    fd.append("historyArticleId",articleId);
    return axios.post('/article/view',fd)
}

export const articleDelete=(articleId)=>{
    let fd=new FormData();
    fd.append("articleId",articleId);
    return axios.post('/article/delete',fd)
}

export const articleSearch=(str, page)=>{
    return axios({
        url: '/article/search',
        params: {
            str: str,
            page: page
        }
    })
}

export const articleRecommend=(userId)=>{
    return axios({
        url: '/article/recommend',
        params: {
            userId: userId
        }
    })
}

export const hotArticle=()=>{
    return axios({
        url: '/article/hot'
    })
}

export const getArticle=(articleId)=>{
    let fd=new FormData();
    fd.append("articleId",articleId);
    return axios.post('/article/get',fd)
}

export const articleSearchOnUser=(userId, str, page)=>{
    return axios({
        url: '/article/searchOnUser',
        params: {
            userId: userId,
            str: str,
            page: page
        }
    })
}

export const articleAll=(page)=>{
    return axios({
        url: '/article/all',
        params:{
            page: page
        }
    })
}

export const showAllArticleType=(page)=>{
    return axios({
        url: '/article/typeAll',
        params: {
            page: page
        }
    })
}

export const showAllArticleTypeNonPage=()=>{
    return axios({
        url: '/article/typeAllNonPage'
    })
}

export const changeArticleAudit=(articleId, articleAudit)=>{
    let fd=new FormData()
    fd.append("articleId", articleId)
    fd.append("articleAudit", articleAudit)
    return axios.post('/article/changeAudit',fd)
}

export const articleTypeInsert=(articleType)=>{
    let fd=new FormData()
    fd.append("articleTypeId",'0')
    fd.append("articleTypeTag", articleType.articleTypeTag)
    fd.append("articleTypeDescribe", articleType.articleTypeDescribe)
    fd.append("articleTypeNum", '0')
    return axios.post('/article/typeAdd',fd)
}

export const articleTypeChange=(articleType)=>{
    let fd=new FormData()
    fd.append("articleTypeId",articleType.articleTypeId)
    fd.append("articleTypeTag", articleType.articleTypeTag)
    fd.append("articleTypeDescribe", articleType.articleTypeDescribe)
    return axios.post('/article/typeChange',fd)
}

export const articleTypeDelete=(articleTypeId)=>{
    let fd=new FormData()
    fd.append("articleTypeId", articleTypeId)
    return axios.post('/article/typeDelete',fd)
}

export const articleUploadImg=(file, key)=>{
    let fd=new FormData()
    fd.append("file", file)
    return axios.post('/article/adminUpdateImg?key='+key,fd)
}

export const showHistories=(userId, page)=>{
    return axios({
        url: '/article/history',
        params: {
            userId: userId,
            page: page
        }
    })
}