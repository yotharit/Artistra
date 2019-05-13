package com.yotharit.artistra.ui.popout

import com.yotharit.artistra.common.base.BaseMvpPresenter

class PopPresenter(view : PopContractor.View) : BaseMvpPresenter<PopContractor.View>(view),
    PopContractor.Presenter {

    override fun start() {

    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: PopContractor.View): PopPresenter {
            return PopPresenter(view)
        }
    }

}
