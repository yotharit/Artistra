package com.yotharit.artistra.ui.splash

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView


class SplashContractor {

    interface Presenter : BaseMvpContractorPresenter {
        fun requestSplash()
    }

    interface View : BaseMvpContractorView<Presenter> {
        fun sendSplash()
    }

}