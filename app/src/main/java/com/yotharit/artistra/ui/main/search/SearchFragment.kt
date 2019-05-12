package com.yotharit.artistra.ui.main.search

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpFragment
import com.yotharit.artistra.ui.main.search.adapter.SearchAdapter
import com.yotharit.artistra.ui.main.search.model.EventModel
import com.yotharit.artistra.ui.main.search.model.QueryModel
import kotlinx.android.synthetic.main.search_layout.*
import java.lang.Exception

class SearchFragment : BaseMvpFragment<SearchContractor.Presenter>() , SearchContractor.View {

    private var data = ArrayList<EventModel>()
    var adapter = SearchAdapter(data)

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
        return R.layout.search_layout
    }

    override fun createPresenter() {
        SearchPresenter.createPresenter(this)
        presenter.start()
        showLoader()
    }

    override fun bindView(view: View?) {

    }

    override fun setupView() {

        searchRecyclerView.adapter = adapter
        searchRecyclerView.layoutManager = LinearLayoutManager(context)
        searchEditText.addTextChangedListener( object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                showLoader()
                presenter.requestData(s.toString())
            }
        })

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
        } catch (e : Exception){

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

}