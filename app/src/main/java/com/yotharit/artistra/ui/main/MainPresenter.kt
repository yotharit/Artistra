package com.yotharit.artistra.ui.main

import com.yotharit.artistra.common.base.BaseMvpPresenter

class MainPresenter(view : MainContractor.View) :  BaseMvpPresenter<MainContractor.View>(view),
     MainContractor.Presenter {

    override fun start() {

    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: MainContractor.View): MainPresenter {
            return MainPresenter(view)
        }
    }

}
