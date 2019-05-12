package com.yotharit.artistra.ui.main.feed

import android.util.Log
import com.yotharit.artistra.common.base.BaseMvpPresenter
import com.yotharit.artistra.ui.main.search.model.QueryModel
import com.yotharit.artistra.ui.main.search.model.SearchApi
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class FeedPresenter(view: FeedContractor.View) : BaseMvpPresenter<FeedContractor.View>(view),
    FeedContractor.Presenter {

    lateinit var retrofit: Retrofit
    lateinit var eventfulApi: SearchApi
    lateinit var compositeDisposable: CompositeDisposable

    private val APP_KEY = "6DZPh5KRBwhhS5jW"
    override fun start() {
        MoshiConverterFactory.create()
        retrofit = Retrofit.Builder()
            .baseUrl("http://api.eventful.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        eventfulApi = retrofit.create(SearchApi::class.java)

        compositeDisposable = CompositeDisposable()

        val response = eventfulApi.searchThai(
            APP_KEY, "Thailand", "Future",50
        ).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<QueryModel> {
                override fun onSuccess(t: QueryModel) {
                    view.setData(t)
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    Log.d("retrofit", e.toString())
                }
            })
    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: FeedContractor.View): FeedPresenter {
            return FeedPresenter(view)
        }
    }

    override fun requestData(keyword: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun preparedData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
