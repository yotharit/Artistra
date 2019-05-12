package com.yotharit.artistra.ui.main.user

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class UserContractor {
    interface Presenter : BaseMvpContractorPresenter {

    }
    interface View : BaseMvpContractorView<UserContractor.Presenter> {

    }
}
