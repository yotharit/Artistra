package com.yotharit.artistra.ui.main.search

import com.yotharit.artistra.common.base.BaseMvpContractorPresenter
import com.yotharit.artistra.common.base.BaseMvpContractorView
import com.yotharit.artistra.ui.main.search.model.QueryModel

class SearchContractor {

    interface Presenter : BaseMvpContractorPresenter {
        fun requestData(keyword : String)
        fun preparedData()
    }

    interface View : BaseMvpContractorView<SearchContractor.Presenter> {
        fun setData(send : QueryModel)
        fun showLoader()
        fun hideLoader()
    }
}
