package com.yotharit.artistra.ui.landing

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class LandingContractor {

    interface Presenter : BaseMvpContractorPresenter {
        fun requestRegister()
        fun requestLogin()
    }

    interface View : BaseMvpContractorView<Presenter> {
        fun sendRegister()
        fun sendLogin()
        fun login()
        fun accessToMainScreen()
        fun register()
        fun showLoader()
        fun hideLoader()
    }


}