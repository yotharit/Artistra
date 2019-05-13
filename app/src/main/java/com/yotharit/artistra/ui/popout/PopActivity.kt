package com.yotharit.artistra.ui.popout

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.yotharit.artistra.R
import com.yotharit.artistra.common.base.BaseMvpActivity
import kotlinx.android.synthetic.main.pop_layout.*

class PopActivity : BaseMvpActivity<PopContractor.Presenter>(), PopContractor.View, View.OnClickListener {
    override fun initialize() {

    }

    var title: String = ""
    var shortDate: String = ""
    var shortMonth: String = ""
    var place: String = ""
    var venue: String = ""
    var description: String = ""
    var imageUrl: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = intent.getStringExtra("title")
        shortDate = intent.getStringExtra("shortDate")
        shortMonth = intent.getStringExtra("shortMonth")
        place = intent.getStringExtra("place")
        venue = intent.getStringExtra("venue")
        description = intent.getStringExtra("description")
        imageUrl = intent.getStringExtra("imageUrl")

    }

    override fun createPresenter() {
        PopPresenter.createPresenter(this)
        presenter.start()
    }

    override fun getLayoutView(): Int {
        return R.layout.pop_layout
    }

    override fun bindView() {

    }

    override fun setupView() {

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

        }
    }

    override fun onStart() {
        super.onStart()
        Glide.with(this).load(imageUrl).into(imageView)
        tvShortMonth.text = shortMonth
        tvShortDate.text = shortDate
        tvPlace.text = place
        tvEventName.text = title
        tvVenue.text = venue
        tvDescription.text = description
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }
}
