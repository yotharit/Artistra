package com.yotharit.artistra.ui.splash

import android.app.Activity
import com.yotharit.artistra.common.base.BaseMvpPresenter

class SplashPresenter(view: SplashContractor.View) : BaseMvpPresenter<SplashContractor.View>(view), SplashContractor.Presenter {
    val activity = Activity()

    override fun start() {
    }

    override fun stop() {
    }

    companion object {
        fun createPresenter(view: SplashContractor.View): SplashPresenter {
            return SplashPresenter(view)
        }
    }

    override fun requestSplash() {
        if (!activity.isFinishing) {
            view.sendSplash()
        }
    }

}