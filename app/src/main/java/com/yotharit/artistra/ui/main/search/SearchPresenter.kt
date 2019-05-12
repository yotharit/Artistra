package com.yotharit.artistra.ui.main.search

import com.yotharit.artistra.common.base.BaseMvpPresenter

class SearchPresenter(view: SearchContractor.View) : BaseMvpPresenter<SearchContractor.View>(view),
    SearchContractor.Presenter {

    override fun start() {

    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: SearchContractor.View): SearchPresenter {
            return SearchPresenter(view)
        }
    }

}
