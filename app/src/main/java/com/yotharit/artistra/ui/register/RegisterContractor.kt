package com.yotharit.artistra.ui.register

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class RegisterContractor {

    interface Presenter : BaseMvpContractorPresenter {
        fun requestRegister(username : String, password : String, name : String)
    }
    interface View : BaseMvpContractorView<RegisterContractor.Presenter> {
        fun hideLoader()
        fun showLoader()
        fun registerSuccess()
        fun registerFail(error : String)
    }
}