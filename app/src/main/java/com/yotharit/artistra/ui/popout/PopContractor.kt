package com.yotharit.artistra.ui.popout

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class PopContractor {
    interface Presenter : BaseMvpContractorPresenter {

    }
    interface View : BaseMvpContractorView<PopContractor.Presenter> {

    }
}
