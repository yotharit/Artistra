package com.yotharit.artistra.ui.main.user

import com.yotharit.artistra.common.base.BaseMvpPresenter

class UserPresenter(view: UserContractor.View) : BaseMvpPresenter<UserContractor.View>(view),
    UserContractor.Presenter {

    override fun start() {

    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: UserContractor.View): UserPresenter {
            return UserPresenter(view)
        }
    }

}
