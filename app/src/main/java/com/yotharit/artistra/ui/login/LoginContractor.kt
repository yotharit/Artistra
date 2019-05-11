package com.yotharit.artistra.ui.login

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class LoginContractor {

    interface Presenter : BaseMvpContractorPresenter {
        fun requestRegister()
        fun requestLogin()
    }

    interface View : BaseMvpContractorView<Presenter> {
        fun sendRegister()
        fun sendLogin()
    }


}