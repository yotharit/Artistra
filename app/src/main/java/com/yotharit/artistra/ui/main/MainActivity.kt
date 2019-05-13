package com.yotharit.artistra.ui.main

import android.os.Bundle
import android.view.View
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity
import com.yotharit.artistra.ui.main.adapter.MainFragmentAdapter
import kotlinx.android.synthetic.main.main_layout.*

class MainActivity : BaseMvpActivity<MainContractor.Presenter>(), MainContractor.View, View.OnClickListener {

    override fun initialize() {

    }


    override fun createPresenter() {
        MainPresenter.createPresenter(this)
        presenter.start()
    }

    override fun getLayoutView(): Int {
        return R.layout.main_layout
    }

    override fun bindView() {

    }

    override fun setupView() {
        pager.adapter = MainFragmentAdapter(supportFragmentManager)
        navigationTab.setViewPager(pager)
    }


    override fun restoreArgument(extras: Bundle?) {
    }


    override fun restoreInstanceState(savedInstanceState: Bundle?) {
    }

    override fun restoreView() {
    }

    override fun saveInstanceState(outState: Bundle?) {
    }

    override fun onClick(v: View?) {
        when (v) {

        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
