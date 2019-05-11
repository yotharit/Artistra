package com.yotharit.artistra.ui.login

import android.os.Bundle
import android.view.View
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity
import kotlinx.android.synthetic.main.login_layout.*

class LoginActivity : BaseMvpActivity<LoginContractor.Presenter>(), LoginContractor.View, View.OnClickListener {

    override fun initialize() {

    }


    override fun createPresenter() {
        LoginPresenter.createPresenter(this)
    }

    override fun getLayoutView(): Int {
        return R.layout.login_layout
    }

    override fun bindView() {

    }

    override fun setupView() {
        loginBtn.setOnClickListener(this)
        createAccountText.setOnClickListener(this)
    }


    override fun restoreArgument(extras: Bundle?) {
    }


    override fun restoreInstanceState(savedInstanceState: Bundle?) {
    }

    override fun restoreView() {
    }

    override fun saveInstanceState(outState: Bundle?) {
    }

    override fun sendRegister() {
        presenter.requestRegister()
    }

    override fun sendLogin() {
        presenter.requestLogin()
    }

    override fun onClick(v: View?) {
        when (v) {
            loginBtn -> {
                sendLogin()
            }
            createAccountText -> {
                sendRegister()
            }
        }
    }

}