package com.yotharit.artistra.ui.login

import com.yotharit.artistra.common.base.BaseMvpPresenter

class LoginPresenter(view : LoginContractor.View) : BaseMvpPresenter<LoginContractor.View>(view) , LoginContractor.Presenter {

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun stop() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun createPresenter(view: LoginContractor.View): LoginPresenter {
            return LoginPresenter(view)
        }
    }

    override fun requestRegister() {

    }

    override fun requestLogin() {

    }
}