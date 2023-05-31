import { createStore } from 'vuex'
import getters from "@/store/getters"
import mutations from "@/store/mutations";
import actions from "@/store/actions";

export default createStore({
    state: {
        token: window.sessionStorage.getItem('token')==null?'':window.sessionStorage.getItem('token'),
        adminLogin: window.sessionStorage.getItem('adminLogin')!=null,
        // user: {
        //     userId: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userId,
        //     userName: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userName,
        //     // userSex: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userSex,
        //     userEmail: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userEmail,
        //     userPhone: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userPhone,
        //     userStatus: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userStatus,
        //     // registerTime: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).registerTime,
        //     // userBirthday: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userBirthday,
        //     userImg: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userImg,
        //     // userFans: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userFans,
        //     // userConcern: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userConcern,
        //     // userLike: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userLike,
        //     // userView: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userView,
        // },
        user: {
            userId: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userId,
            userName: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userName,
            userEmail: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userEmail,
            userPhone: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userPhone,
            userStatus: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userStatus,
            userImg: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userImg,
            userSecurity: window.sessionStorage.getItem('user')==null?'':JSON.parse(window.sessionStorage.getItem('user')).userSecurity
        },
        admin: {
            adminId: '',
            adminName: '',
            adminAudit: '',
            adminResult: ''
        }
    },
    getters,
    mutations,
    actions,
    modules: {

    }
})




