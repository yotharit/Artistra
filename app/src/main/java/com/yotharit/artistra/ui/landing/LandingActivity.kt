package com.yotharit.artistra.ui.landing

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity
import com.yotharit.artistra.ui.login.LoginActivity
import kotlinx.android.synthetic.main.login_layout.*

class LandingActivity : BaseMvpActivity<LandingContractor.Presenter>(), LandingContractor.View, View.OnClickListener {

    override fun initialize() {

    }

    override fun createPresenter() {
        LandingPresenter.createPresenter(this)
        presenter.start()
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

    override fun login() {
        val intent = (Intent(this, LoginActivity::class.java))
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    override fun accessToMainScreen() {
//        val intent = (Intent(this, SignUpActivity::class.java))
//        startActivity(intent)
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

    }
}