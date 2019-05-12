package com.yotharit.artistra.ui.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity
import com.yotharit.artistra.ui.login.LoginActivity
import kotlinx.android.synthetic.main.register_layout.*

class RegisterActivity : BaseMvpActivity<RegisterContractor.Presenter>(), RegisterContractor.View,
    View.OnClickListener {
    override fun initialize() {

    }


    override fun createPresenter() {
        RegisterPresenter.createPresenter(this)
        presenter.start()
    }

    override fun getLayoutView(): Int {
        return R.layout.register_layout
    }

    override fun bindView() {

    }

    override fun setupView() {
        registerBtn.setOnClickListener(this)
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
            registerBtn -> {
                showLoader()
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                val name = etName.text.toString()
                presenter.requestRegister(username, password, name)
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    override fun hideLoader() {
        loader.visibility = View.GONE
    }

    override fun showLoader() {
        loader.visibility = View.VISIBLE
    }

    override fun registerSuccess() {
        val intent = (Intent(this, LoginActivity::class.java))
        startActivity(intent)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

    override fun registerFail(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
        hideLoader()
    }
}