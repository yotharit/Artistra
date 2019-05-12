package com.yotharit.artistra.ui.main

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class MainContractor {
    interface Presenter : BaseMvpContractorPresenter {

    }
    interface View : BaseMvpContractorView<MainContractor.Presenter> {

    }
}