package com.yotharit.artistra.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity
import com.yotharit.artistra.ui.landing.LandingActivity
import com.yotharit.artistra.ui.splash.SplashActivity
import kotlinx.android.synthetic.main.login_page_layout.*

class LoginActivity : BaseMvpActivity<LoginContractor.Presenter>(), LoginContractor.View, View.OnClickListener {

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
        loginBtn.setOnClickListener(this)
        hideLoader()
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
            loginBtn -> {
                showLoader()
                val username = etLoginUser.text.toString()
                val password = etLoginPassword.text.toString()
                presenter.requestLogin(username, password)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    override fun login() {
        val intent = (Intent(this, LandingActivity::class.java))
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

    override fun loginFailed(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        hideLoader()
    }

    override fun showLoader() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        loader.visibility = View.GONE
    }
}