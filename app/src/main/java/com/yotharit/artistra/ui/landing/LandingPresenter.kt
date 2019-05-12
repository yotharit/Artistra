package com.yotharit.artistra.ui.landing

import com.yotharit.artistra.common.base.BaseMvpPresenter
import com.google.firebase.auth.FirebaseAuth



class LandingPresenter(view : LandingContractor.View) : BaseMvpPresenter<LandingContractor.View>(view) , LandingContractor.Presenter {

    private var mAuth: FirebaseAuth? = null

    override fun start() {
        mAuth = FirebaseAuth.getInstance()
        if(mAuth!!.currentUser!=null){
            view.accessToMainScreen()
        }
        else {
            view.hideLoader()
        }
    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: LandingContractor.View): LandingPresenter {
            return LandingPresenter(view)
        }
    }

    override fun requestRegister() {
        view.register()
    }

    override fun requestLogin() {
        view.login()
    }
}