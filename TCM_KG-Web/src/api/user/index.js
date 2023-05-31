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

export const userLogin=(text, password)=>{
    let fd = new FormData();
    fd.append("text", text);
    fd.append("password", password);
    return axios.post("/user/login",fd)
}

export const userRegister=(user)=>{
    let fd = new FormData();
    fd.append("userId", "0");
    fd.append("userName", user.name);
    fd.append("userPassword", user.password1);
    fd.append("userSex", user.sex);
    fd.append("userEmail", user.email);
    fd.append("userPhone", user.phone);
    fd.append("userBirthday", user.birthday);
    fd.append("userFans", "0");
    fd.append("userConcern", "0");
    fd.append("userLike", "0");
    fd.append("userView", "0");
    return axios.post("/user/register",fd)
}

export const userDelete=(userId)=>{
    let fd=new FormData();
    fd.append("userId",userId);
    return axios.post('/user/delete',fd)
}

export const getUserByName=(userName)=>{
    let fd=new FormData();
    fd.append("userName",userName);
    return axios.post('/user/getUserByName',fd)
}

export const getUser=(userId)=>{
    let fd=new FormData();
    fd.append("userId",userId);
    return axios.post('/user/getUser',fd)
}

export const changePwd=(userId, password)=>{
    let fd=new FormData()
    fd.append("userId",userId);
    fd.append("userPassword",password);
    return axios.post('/user/pwd/change',fd)
}

export const confirmOldPwd=(userId, oldPwd)=>{
    let fd=new FormData();
    fd.append("userId",userId);
    fd.append("userPassword", oldPwd)
    return axios.post('/user/pwd/confirm',fd)
}

export const changeUserInfo=(user)=>{
    let fd=new FormData();
    fd.append("userId", user.userId);
    fd.append("userName", user.userName);
    fd.append("userSex",user.userSex);
    fd.append("userBirthday",user.userBirthday)
    return axios.post('/user/changeInfo',fd)
}

export const changeUserImg=(file, userId)=>{
    let fd=new FormData();
    fd.append("file", file);
    fd.append("userId", userId);
    return axios.post('/user/changeImg',fd)
}

export const changeUserEmail=(userId, userEmail)=>{
    let fd=new FormData();
    fd.append("userId",userId);
    fd.append("userEmail",userEmail);
    return axios.post('/user/changeEmail',fd)
}

export  const changeUserPhone=(userId, userPhone)=>{
    let fd=new FormData();
    fd.append("userId",userId);
    fd.append("userPhone",userPhone);
    return axios.post('/user/changePhone',fd)
}

export const sendEmailCode=(email)=>{
    let fd=new FormData();
    fd.append("userEmail",email);
    return axios.post('/user/email/send',fd)
}

export const confirmEmailCode=(email, code)=>{
    let fd=new FormData();
    fd.append("userEmail",email);
    fd.append("code",code);
    return axios.post('/user/email/confirm',fd)
}

export const sendPhoneCode=(phone)=>{
    let fd=new FormData();
    fd.append("phone", phone);
    return axios.post('/user/phone/send',fd)
}

export const confirmPhoneCode=(phone, code)=>{
    let fd=new FormData();
    fd.append("phone", phone);
    fd.append("code", code);
    return axios.post('/user/phone/confirm',fd)
}

export const showConcerns=(userId, page)=>{
    return axios({
        url: '/user/concerns',
        params: {
            userId: userId,
            page: page
        }
    })
}

export const showFans=(userId, page)=>{
    return axios({
        url: '/user/fans',
        params: {
            userId: userId,
            page: page
        }
    })
}

export const showAllUser=(page)=>{
    return axios({
        url: '/user/all',
        params: {
            page: page
        }
    })
}

export const changeUserStatus=(userId, userStatus)=>{
    let fd=new FormData()
    fd.append("userId", userId)
    fd.append("userStatus", userStatus)
    return axios.post('/user/changeStatus',fd)
}

export const changeUserSecurity=(userId, userSecurity)=>{
    let fd=new FormData()
    fd.append("userId", userId)
    fd.append("userStatus", userSecurity)
    return axios.post('/user/changeSecurity',fd)
}