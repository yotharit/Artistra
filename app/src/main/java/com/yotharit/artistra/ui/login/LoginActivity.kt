package com.yotharit.artistra.ui.login

import android.os.Bundle
import android.view.View
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity

class LoginActivity : BaseMvpActivity<LoginContractor.Presenter>() , LoginContractor.View , View.OnClickListener {
    override fun initialize() {

    }


    override fun createPresenter() {
        LoginPresenter.createPresenter(this)
        presenter.start()
    }

    override fun getLayoutView(): Int {
        return R.layout.login_page_layout
    }

    override fun bindView() {

    }

    override fun setupView() {

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