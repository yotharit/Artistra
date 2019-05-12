package com.yotharit.artistra.ui.login

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class LoginContractor {

    interface Presenter : BaseMvpContractorPresenter {
        fun requestLogin(username : String, password : String)
    }

    interface View : BaseMvpContractorView<LoginContractor.Presenter> {
        fun login()
        fun loginFailed(error : String)
        fun showLoader()
        fun hideLoader()
    }

}