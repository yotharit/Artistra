package com.yotharit.artistra.ui.login

import com.yotharit.artistra.common.base.BaseMvpPresenter

class LoginPresenter(view: LoginContractor.View) : BaseMvpPresenter<LoginContractor.View>(view),
    LoginContractor.Presenter {

    override fun start() {

    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: LoginContractor.View): LoginPresenter {
            return LoginPresenter(view)
        }
    }

}