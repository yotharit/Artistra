package com.yotharit.artistra.ui.main.calendar

import com.yotharit.artistra.common.base.BaseMvpPresenter

class CalendarPresenter(view: CalendarContractor.View) : BaseMvpPresenter<CalendarContractor.View>(view),
    CalendarContractor.Presenter {

    override fun start() {

    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: CalendarContractor.View): CalendarPresenter {
            return CalendarPresenter(view)
        }
    }

}
