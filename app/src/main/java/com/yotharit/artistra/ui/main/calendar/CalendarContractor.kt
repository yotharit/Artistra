package com.yotharit.artistra.ui.main.calendar

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView

class CalendarContractor {
    interface Presenter : BaseMvpContractorPresenter {

    }
    interface View : BaseMvpContractorView<CalendarContractor.Presenter> {

    }
}