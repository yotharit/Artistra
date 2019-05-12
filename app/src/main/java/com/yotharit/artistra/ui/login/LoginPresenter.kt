package com.yotharit.artistra.ui.login

import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.yotharit.artistra.common.base.BaseMvpPresenter

class LoginPresenter(view: LoginContractor.View) : BaseMvpPresenter<LoginContractor.View>(view),
    LoginContractor.Presenter {

    private var mAuth: FirebaseAuth? = null

    override fun start() {
        mAuth = FirebaseAuth.getInstance()
    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: LoginContractor.View): LoginPresenter {
            return LoginPresenter(view)
        }
    }

    override fun requestLogin(username: String, password: String) {
        Log.d("DDDFASIOGMOAS","LOGIN")
        mAuth!!.signInWithEmailAndPassword(username, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    view.login()
                } else {
                    view.loginFailed("Incorrect Username / Password")
                }
            }
    }
}