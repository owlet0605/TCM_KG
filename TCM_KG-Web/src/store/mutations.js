export default {
    login(state, user){
        state.token = user.userToken
        user.userId=user.userId.toString()
        user.userImg='http://localhost:8080/api/file/userImg/'+user.userImg
        state.user.userId=user.userId
        state.user.userName=user.userName
        state.user.userEmail=user.userEmail
        state.user.userPhone=user.userPhone
        state.user.userStatus=user.userStatus
        state.user.userImg=user.userImg
        window.sessionStorage.setItem('user', JSON.stringify(user))
        window.sessionStorage.setItem('token', user.userToken)
    },

    logout(state){
        state.token=''
        state.user.userId=""
        state.user.userName=""
        state.user.userEmail=""
        state.user.userPhone=""
        state.user.userStatus=""
        state.user.userImg=""
        window.sessionStorage.removeItem('user')
        window.sessionStorage.removeItem('token')
    },

    changeUser(state, user){
        user.userId=user.userId.toString()
        user.userImg='http://localhost:8080/api/file/userImg/'+user.userImg
        state.user.userId=user.userId
        state.user.userName=user.userName
        state.user.userEmail=user.userEmail
        state.user.userPhone=user.userPhone
        state.user.userStatus=user.userStatus
        state.user.userImg=user.userImg
        window.sessionStorage.setItem('user', JSON.stringify(user))
    },

    adminLogin(state, admin){
        state.adminLogin=true
        state.admin.adminId=admin.adminId.toString()
        state.admin.adminName=admin.adminName
        state.admin.adminAudit=admin.adminAudit
        state.admin.adminResult=admin.adminResult
        window.sessionStorage.setItem('admin', JSON.stringify(admin))
        window.sessionStorage.setItem('adminLogin', 'true')
    },

    adminLogout(state){
        state.adminLogin=false
        state.admin.adminId=''
        state.admin.adminName=''
        state.admin.adminAudit=''
        state.admin.adminResult=''
        window.sessionStorage.removeItem('admin')
        window.sessionStorage.removeItem('adminLogin')

    },

    changeAdmin(state, admin){
        state.admin.adminId=admin.adminId.toString()
        state.admin.adminName=admin.adminName
        state.admin.adminAudit=admin.adminAudit
        state.admin.adminResult=admin.adminResult
        window.sessionStorage.setItem('admin', JSON.stringify(admin))
    }
}