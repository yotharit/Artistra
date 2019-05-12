package com.yotharit.artistra.ui.main.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpFragment
import com.yotharit.artistra.ui.main.feed.adapter.FeedAdapter
import com.yotharit.artistra.ui.main.search.model.EventModel
import com.yotharit.artistra.ui.main.search.model.QueryModel
import kotlinx.android.synthetic.main.feed_layout.*

class FeedFragment : BaseMvpFragment<FeedContractor.Presenter>(), FeedContractor.View {

    private var data = ArrayList<EventModel>()
    var adapter = FeedAdapter(data)

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
        feedRecyclerView.adapter = adapter
        feedRecyclerView.layoutManager = LinearLayoutManager(context)
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

    override fun setData(send: QueryModel) {
        var temp = ArrayList<EventModel>()
        try {
            temp.addAll(send.eventList.event)
            hideLoader()
        } catch (e: Exception) {

        }
        data.clear()
        data.addAll(temp)
        adapter.notifyDataSetChanged()
    }

    override fun showLoader() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        loader.visibility = View.GONE
    }

    override fun onStart() {
        super.onStart()
        showLoader()
        presenter.start()
    }
}