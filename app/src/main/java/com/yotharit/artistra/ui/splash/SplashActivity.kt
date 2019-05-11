package com.yotharit.artistra.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity
import com.yotharit.artistra.ui.landing.LandingActivity


class SplashActivity : BaseMvpActivity<SplashContractor.Presenter>(), SplashContractor.View {

    private val SPLASH_DELAY = 2000L
    private val mHandler = Handler()
    private val mLauncher = Launcher()

    override fun createPresenter() {
        SplashPresenter.createPresenter(this)
    }

    override fun getLayoutView(): Int {
        return R.layout.splash_screen
    }

    override fun bindView() {
    }

    override fun setupView() {
    }

    override fun restoreArgument(extras: Bundle?) {
    }

    override fun initialize() {
    }

    override fun restoreInstanceState(savedInstanceState: Bundle?) {
    }

    override fun restoreView() {
    }

    override fun saveInstanceState(outState: Bundle?) {
    }

    override fun onStart() {
        super.onStart()
        mHandler.postDelayed(mLauncher, SPLASH_DELAY)
    }

    override fun onStop() {
        super.onStop()
        mHandler.removeCallbacks(mLauncher)
    }

    override fun sendSplash() {
        startActivity(Intent(this, LandingActivity::class.java))
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
        finish()
    }

    private inner class Launcher : Runnable {
        override fun run() {
            presenter.requestSplash()
        }
    }

}