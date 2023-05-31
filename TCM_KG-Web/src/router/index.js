import {createRouter, createWebHistory} from "vue-router";
import UserLogin from '@/view/user/UserLogin.vue'
import UserRegister from "@/view/user/UserRegister.vue";
import Home from "@/view/Home.vue";
import PwdForget from "@/view/user/PwdForget.vue";
import EmailCode from "@/view/email/EmailCode.vue";
import PwdChange from "@/view/user/PwdChange.vue";
import TcmHome from "@/view/tcm/TcmHome.vue";
import UserHome from "@/view/user/UserHome.vue";
import UserArticle from "@/view/user/UserArticle.vue";
import UserCollect from "@/view/user/UserCollect.vue";
import UserLike from "@/view/user/UserLike.vue";
import UserSearch from "@/view/user/UserSearch.vue";
import UserConcern from "@/view/user/UserConcern.vue";
import UserFan from "@/view/user/UserFan.vue";
import ChangeInfo from "@/view/user/ChangeInfo.vue";
import PwdConfirm from "@/view/user/PwdConfirm.vue";
import EmailChange from "@/view/email/EmailChange.vue";
import PhoneChange from "@/view/phone/PhoneChange.vue";
import TcmDetail from "@/view/tcm/TcmDetail.vue";
import ArticleDetail from "@/view/article/ArticleDetail.vue";
import ArticleTypeDetail from "@/view/article/ArticleTypeDetail.vue";
import Empty from "@/components/Empty.vue";
import PwdChangeSecurity from "@/view/user/PwdChangeSecurity.vue";
import PwdChangeSuccess from "@/view/user/PwdChangeSuccess.vue";
import EmailConfirm from "@/view/email/EmailConfirm.vue";
import EmailChangeSuccess from "@/view/email/EmailChangeSuccess.vue";
import PhoneConfirm from "@/view/phone/PhoneConfirm.vue";
import PhoneChangeSuccess from "@/view/phone/PhoneChangeSuccess.vue";
import TcmKg from "@/view/tcm/TcmKg.vue";
import TcmMap from "@/view/tcm/TcmMap.vue";
import ArticleHome from "@/view/article/ArticleHome.vue";
import ArticleType from "@/view/article/ArticleType.vue";
import HotArticles from "@/view/article/HotArticles.vue";
import ArticlePublish from "@/view/article/ArticlePublish.vue";
import AdminLogin from "@/view/admin/AdminLogin.vue";
import AdminHome from "@/view/admin/AdminHome.vue";
import Chat from "@/view/user/Chat.vue";
import UserHistory from "@/view/user/UserHistory.vue";
import TcmProvince from "@/view/tcm/TcmProvince.vue";
import store from "@/store";
import {resetWindows, updateWindows} from "@/api/chat";

const routes =[
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/Empty',
        name: 'Empty',
        component: Empty
    },
    {
        path: '/user/login',
        name: 'UserLogin',
        component: UserLogin
    },
    {
        path: '/user/register',
        name: 'UserRegister',
        component: UserRegister
    },
    {
        path: '/email/codeSend',
        name: 'EmailCode',
        component: EmailCode
    },
    {
        path: '/email/confirm',
        name: 'EmailConfirm',
        meta: {
            requireAuth: true
        },
        component: EmailConfirm
    },
    {
        path: '/user/pwdForget',
        name: 'PwdForget',
        component: PwdForget
    },
    {
        path: '/user/rePwd',
        name: 'PwdChange',
        component: PwdChange
    },
    {
        path: '/pwd/change',
        name: 'PwdChangeSecurity',
        meta: {
            requireAuth: true
        },
        component: PwdChangeSecurity
    },
    {
        path: '/user/home',
        name: 'UserHome',
        meta: {
            requireAuth: true
        },
        component: UserHome
    },
    {
        path: '/user/articles',
        name: 'UserArticle',
        meta: {
            requireAuth: true
        },
        component: UserArticle
    },
    {
        path: '/user/collects',
        name: 'UserCollect',
        meta: {
            requireAuth: true
        },
        component: UserCollect
    },
    {
        path: '/user/likes',
        name: 'UserLike',
        meta: {
            requireAuth: true
        },
        component: UserLike
    },
    {
        path: '/user/search',
        name: 'UserSearch',
        meta: {
            requireAuth: true
        },
        component: UserSearch
    },
    {
        path: '/user/concerns',
        name: 'UserConcern',
        meta: {
            requireAuth: true
        },
        component: UserConcern
    },
    {
        path: '/user/histories',
        name: 'UserHistory',
        meta: {
            requireAuth: true
        },
        component: UserHistory
    },
    {
        path: '/user/fans',
        name: 'UserFan',
        meta: {
            requireAuth: true
        },
        component: UserFan
    },
    {
        path: '/user/changeInfo',
        name: 'ChangeInfo',
        meta: {
            requireAuth: true
        },
        component: ChangeInfo
    },
    {
        path: '/pwd/confirm',
        name: 'PwdConfirm',
        meta: {
            requireAuth: true
        },
        component: PwdConfirm
    },
    {
        path: '/email/change',
        name: 'EmailChange',
        meta: {
            requireAuth: true
        },
        component: EmailChange
    },
    {
        path: '/phone/confirm',
        name: 'PhoneConfirm',
        meta: {
            requireAuth: true
        },
        component: PhoneConfirm
    },
    {
        path: '/phone/change',
        name: 'PhoneChange',
        meta: {
            requireAuth: true
        },
        component: PhoneChange
    },
    {
        path: '/tcm/home',
        name: 'TcmHome',
        component: TcmHome
    },
    {
        path: '/tcm/detail',
        name: 'TcmDetail',
        component: TcmDetail
    },
    {
        path: '/article/detail',
        name: 'ArticleDetail',
        component: ArticleDetail
    },
    {
        path: '/articleType/detail',
        name: 'ArticleTypeDetail',
        component: ArticleTypeDetail
    },
    {
        path: '/pwd/success',
        name: 'PwdChangeSuccess',
        meta: {
            requireAuth: true
        },
        component: PwdChangeSuccess
    },
    {
        path: '/email/success',
        name: 'EmailChangeSuccess',
        meta: {
            requireAuth: true
        },
        component: EmailChangeSuccess
    },
    {
        path: '/phone/success',
        name: 'PhoneChangeSuccess',
        meta: {
            requireAuth: true
        },
        component: PhoneChangeSuccess
    },
    {
        path: '/tcm/Kg',
        name: 'TcmKg',
        component: TcmKg
    },
    {
        path: '/tcm/Map',
        name: 'TcmMap',
        component: TcmMap
    },
    {
        path: '/tcm/province',
        name: 'TcmProvince',
        component: TcmProvince
    },
    {
        path: '/article/Home',
        name: 'ArticleHome',
        component: ArticleHome
    },
    {
        path: '/articleType/list',
        name: 'ArticleType',
        component: ArticleType
    },
    {
        path: '/article/publish',
        name: 'ArticlePublish',
        meta: {
            requireAuth: true
        },
        component: ArticlePublish
    },
    {
        path: '/article/hot',
        name: 'HotArticles',
        component: HotArticles
    },
    {
        path: '/admin/login',
        name: 'AdminLogin',
        component: AdminLogin
    },
    {
        path: '/admin/home',
        name: 'AdminHome',
        component: AdminHome
    },
    {
        path: '/chat/list/',
        name: 'Chat',
        meta: {
            requireAuth: true,
            windows: true
        },
        component: Chat
    }
]

const router=createRouter({
    history: createWebHistory(),
    routes,
})

router.beforeEach((to, from, next) => {
    if(!to.meta.windows){
        if (store.state.user.userId!==undefined&&store.state.user.userId!==''){
            resetWindows(store.state.user.userId);
        }
    }

    if(to.meta.requireAuth){
        console.log(1)
        if (store.state.user.userId===undefined||store.state.user.userId==='') {
            console.log(3)
            next({ path: '/user/login' })
        } else {
            next()
        }
    }
    else{
        if(to.path==='/admin/home'){
            if(store.state.admin.adminId===''){
                next({path: '/admin/login'})
            }
            else{
                next()
            }
        }
        else{
            next()
        }
    }

})
export default router

