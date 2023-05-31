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


export const showChatLinks=(userId)=>{
    let fd=new FormData()
    fd.append("fromUserId",userId)
    return axios.post('/chat/links',fd)
}

export const showChatMessages=(chatLinkId)=>{
    let fd=new FormData()
    fd.append("chatLinkId",chatLinkId)
    return axios.post('/chat/messages',fd)
}

export const linkOn=(fromUserId, toUserId)=>{
    let fd=new FormData()
    fd.append("fromUserId", fromUserId)
    fd.append("toUserId", toUserId)
    return axios.post('/chat/on',fd)
}

export const sendMessage=(chatMessage)=>{
    let fd=new FormData()
    fd.append("chatMessageId",'0')
    fd.append("chatLinkId", chatMessage.chatLinkId)
    fd.append("chatMessageContent", chatMessage.chatMessageContent)
    fd.append("chatMessageType","text")
    fd.append("chatMessageLatest", '1')
    fd.append("fromUserId", chatMessage.fromUserId)
    fd.append("toUserId", chatMessage.toUserId)
    return axios.post('/chat/send',fd)
}

export const getLastedMessage=(chatLinkId)=>{
    let fd=new FormData()
    fd.append("chatLinkId", chatLinkId)
    return axios.post('/chat/lastedMessage',fd)
}

export const updateWindows=(userId, chatLinkId)=>{
    let fd=new FormData()
    fd.append("chatLinkId", chatLinkId)
    fd.append("fromUserId", userId)
    return axios.post("/chat/update", fd)
}

export const getUnreadNumber=(userId)=>{
    let fd=new FormData()
    fd.append("toUserId", userId)
    return axios.post('/chat/unreadNumber',fd)
}

export const resetWindows=(userId)=>{
    let fd=new FormData()
    fd.append("fromUserId", userId)
    return axios.post('/chat/reset',fd)
}

export const getUnreadList=(userId)=>{
    let fd=new FormData()
    fd.append("fromUserId", userId)
    return axios.post('/chat/unreadList',fd)
}