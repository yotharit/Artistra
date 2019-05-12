package com.yotharit.artistra.ui.main.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpFragment

class FeedFragment : BaseMvpFragment<FeedContractor.Presenter>() , FeedContractor.View {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun getLayoutView(): Int {
        return R.layout.feed_layout
    }

    override fun createPresenter() {
        FeedPresenter.createPresenter(this)
    }

    override fun bindView(view: View?) {

    }

    override fun setupView() {

    }

    override fun restoreArgument(bundle: Bundle?) {

    }

    override fun initialize() {

    }

    override fun restoreInstanceState(savedInstanceState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }


}