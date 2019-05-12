package com.yotharit.artistra.ui.register

import com.google.firebase.auth.FirebaseAuth
import com.yotharit.artistra.common.base.BaseMvpPresenter

class RegisterPresenter(view: RegisterContractor.View) : BaseMvpPresenter<RegisterContractor.View>(view),
    RegisterContractor.Presenter {

    private lateinit var mAuth: FirebaseAuth

    override fun start() {
        mAuth = FirebaseAuth.getInstance()
    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: RegisterContractor.View): RegisterPresenter {
            return RegisterPresenter(view)
        }
    }

    override fun requestRegister(username: String, password: String, name: String) {
        if(!username.equals("") && !password.equals("") && !name.equals("")){
            if (password.length > 6) {
                mAuth.createUserWithEmailAndPassword(username, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        view.registerSuccess()
                    } else {
                        view.registerFail(task.exception.toString())
                    }
                }
            } else {
                view.registerFail("Password must be longer than 6 character")
            }
        } else {
            view.registerFail("Please complete the form!")
        }

    }
}