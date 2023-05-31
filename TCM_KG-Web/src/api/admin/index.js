import axios from "axios";
import store from "@/store";
import {ElMessageBox} from "element-plus";
import router from "@/router";

axios.defaults.baseURL = "http://localhost:8080/api/";

axios.interceptors.request.use(
    config => {
        if(store.state.token!==''){
            config.headers.token = store.state.token
        }
        return config;
    },
    err => {
        console.log(err);
    }
);

axios.interceptors.response.use(res => {
    return res;
}, error => {
    if(error.response.status===403){
        ElMessageBox.confirm(
            '该功能需要登陆后使用，是否跳转登录',
            '权限不足',
            {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning',
            }
        ).then(()=>{
            router.push({
                name: 'UserLogin'
            })
        }).catch(()=>{})
    }
})

export const adminLogin=(adminName, password)=>{
    let fd=new FormData()
    fd.append("adminName", adminName)
    fd.append("adminPassword", password)
    return axios.post('/admin/login',fd)
}

export const showAuditsHasDo=(adminId, page)=>{
    return axios({
        url: '/admin/auditsHas',
        params: {
            adminId: adminId,
            page: page
        }
    })
}

export const showAuditsNotDo=(adminId, page)=>{
    return axios({
        url: '/admin/auditsNot',
        params: {
            adminId: adminId,
            page: page
        }
    })
}

export const showResultHasDo=(adminId, page)=>{
    return axios({
        url: '/admin/resultsHas',
        params: {
            adminId: adminId,
            page: page
        }
    })
}

export const showResultNotDo=(adminId, page)=>{
    return axios({
        url: '/admin/resultsNot',
        params: {
            adminId: adminId,
            page: page
        }
    })
}