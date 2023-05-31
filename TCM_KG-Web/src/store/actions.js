export default {
    login(context, payload){
        context.commit('login', payload.user)
        payload.success()
    },

    logout(context){
        context.commit('logout')
    },

    changeUser(context, payload){
        context.commit('changeUser', payload.user)
    },

    adminLogin(context, payload){
        context.commit('adminLogin', payload.admin)
    },

    adminLogout(context){
        context.commit('adminLogout')
    },

    changeAdmin(context, payload){
        context.commit('changeAdmin', payload.admin)
    }
}