package com.yotharit.artistra.ui.main.user

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpFragment
import com.yotharit.artistra.ui.landing.LandingActivity
import kotlinx.android.synthetic.main.user_layout.*


class UserFragment : BaseMvpFragment<UserContractor.Presenter>(), UserContractor.View, View.OnClickListener {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun getLayoutView(): Int {
        return R.layout.user_layout
    }

    override fun createPresenter() {
        UserPresenter.createPresenter(this)
    }

    override fun bindView(view: View?) {
        val id = FirebaseAuth.getInstance().currentUser!!.uid
        val mRootRef = FirebaseDatabase.getInstance().reference
        val mUsersRef = mRootRef.child("user")
        val mChildRef = mUsersRef.child(id)
        mChildRef.child("name").addValueEventListener(object : ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
            }

            override fun onDataChange(p0: DataSnapshot) {
                val value = p0.getValue(String::class.java)
                if(value!=null){
                    tvUserName.text = value
                }
            }
        })
        logOutBtn.setOnClickListener(this)
    }

    override fun setupView() {

    }

    override fun restoreArgument(bundle: Bundle?) {

    }

    override fun initialize() {

    }

    override fun restoreInstanceState(savedInstanceState: Bundle?) {

    }

    override fun restoreView(savedInstanceState: Bundle?) {

    }

    override fun saveInstanceState(outState: Bundle?) {

    }

    override fun onClick(v: View?) {
        when (v) {
            logOutBtn -> {
                FirebaseAuth.getInstance().signOut()
                val intent: Intent = Intent(context, LandingActivity::class.java)
                startActivity(intent)
                activity!!.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                activity!!.finish()
            }
        }
    }
}