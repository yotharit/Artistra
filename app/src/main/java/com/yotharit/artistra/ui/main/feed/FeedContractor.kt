package com.yotharit.artistra.ui.main.feed

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView
import com.yotharit.artistra.ui.main.search.model.QueryModel

class FeedContractor {
    interface Presenter : BaseMvpContractorPresenter {
        fun requestData(keyword : String)
        fun preparedData()
    }

    interface View : BaseMvpContractorView<FeedContractor.Presenter> {
        fun setData(send : QueryModel)
        fun showLoader()
        fun hideLoader()
    }
}
