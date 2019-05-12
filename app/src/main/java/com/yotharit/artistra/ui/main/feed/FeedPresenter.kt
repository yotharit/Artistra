package com.yotharit.artistra.ui.main.feed

import com.yotharit.artistra.common.base.BaseMvpPresenter

class FeedPresenter(view: FeedContractor.View) : BaseMvpPresenter<FeedContractor.View>(view),
    FeedContractor.Presenter {

    override fun start() {

    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: FeedContractor.View): FeedPresenter {
            return FeedPresenter(view)
        }
    }

}
