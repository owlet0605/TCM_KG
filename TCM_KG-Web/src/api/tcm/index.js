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

export const tcmInsert=(tcm)=>{
    let fd=new FormData()
    fd.append("tcmId","0")
    fd.append("tcmNameZh", tcm.tcmNameZh)
    fd.append("tcmNameEn", tcm.tcmNameEn)
    fd.append("tcmPinyin", tcm.tcmPinyin)
    fd.append("tcmInductive", tcm.tcmInductive)
    fd.append("tcmTaste", tcm.tcmTaste)
    fd.append("tcmAlias", tcm.tcmAlias)
    fd.append("tcmCome", tcm.tcmCome)
    fd.append("tcmTraits", tcm.tcmTraits)
    fd.append("tcmPlant", tcm.tcmPlant)
    fd.append("tcmDistribution", tcm.tcmDistribution)
    fd.append("tcmProduce", tcm.tcmProduce)
    fd.append("tcmNote", tcm.tcmNote)
    fd.append("tcmFunction", tcm.tcmFunction)
    fd.append("tcmClinical", tcm.tcmClinical)
    fd.append("tcmPharmacological", tcm.tcmPharmacological)
    fd.append("tcmChemical", tcm.tcmChemical)
    return axios.post('/tcm/insert',fd)
}

export const tcmDelete=(tcmId)=>{
    let fd=new FormData()
    fd.append("tcmId", tcmId)
    return axios.post('/tcm/delete',fd)
}

export const tcmChange=(tcm)=>{
    let fd=new FormData()
    fd.append("tcmId",tcm.tcmId)
    fd.append("tcmNameZh", tcm.tcmNameZh)
    fd.append("tcmNameEn", tcm.tcmNameEn)
    fd.append("tcmPinyin", tcm.tcmPinyin)
    fd.append("tcmInductive", tcm.tcmInductive)
    fd.append("tcmTaste", tcm.tcmTaste)
    fd.append("tcmAlias", tcm.tcmAlias)
    fd.append("tcmCome", tcm.tcmCome)
    fd.append("tcmTraits", tcm.tcmTraits)
    fd.append("tcmPlant", tcm.tcmPlant)
    fd.append("tcmDistribution", tcm.tcmDistribution)
    fd.append("tcmProduce", tcm.tcmProduce)
    fd.append("tcmNote", tcm.tcmNote)
    fd.append("tcmFunction", tcm.tcmFunction)
    fd.append("tcmClinical", tcm.tcmClinical)
    fd.append("tcmPharmacological", tcm.tcmPharmacological)
    fd.append("tcmChemical", tcm.tcmChemical)
    return axios.post('/tcm/change',fd)
}

export const showAllTcm=(page)=>{
    return axios({
        url: '/tcm/show/all',
        params: {
            page: page
        }
    })
}

export const showByInitial=(initial, page)=>{
    return axios({
        url: '/tcm/show/initial',
        params: {
            initial: initial,
            page: page
        }
    })
}

export const showByInductive=(inductive, page)=>{
    return axios({
        url: '/tcm/show/inductive',
        params:{
            inductive: inductive,
            page: page
        }
    })
}

export const showByTaste=(taste, page)=>{
    return axios({
        url: '/tcm/show/taste',
        params: {
            taste: taste,
            page: page
        }
    })
}

export const showByProperty=(property, page)=>{
    return axios({
        url: '/tcm/show/property',
        params: {
            property: property,
            page: page
        }
    })
}

export const selectTcm=(str, page)=>{
    return axios({
        url: '/tcm/select',
        params:{
            str: str,
            page: page
        }
    })
}

export const getTcm=(tcmId)=>{
    let fd=new FormData();
    fd.append("tcmId",tcmId);
    return axios.post('/tcm/get',fd)
}