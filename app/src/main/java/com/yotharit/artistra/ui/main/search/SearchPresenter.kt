package com.yotharit.artistra.ui.main.search

import android.util.Log
import com.yotharit.artistra.common.base.BaseMvpPresenter
import com.yotharit.artistra.ui.main.search.model.QueryModel
import com.yotharit.artistra.ui.main.search.model.SearchApi
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class SearchPresenter(view: SearchContractor.View) : BaseMvpPresenter<SearchContractor.View>(view),
    SearchContractor.Presenter {

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

        val response = eventfulApi.autoSearch(
            APP_KEY, "This Week", 20
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
                    Log.d("retrofit",e.toString())
                }
            })
    }

    override fun stop() {

    }

    companion object {
        fun createPresenter(view: SearchContractor.View): SearchPresenter {
            return SearchPresenter(view)
        }
    }

    override fun requestData(keyword: String) {
        eventfulApi.searchByKeyword(APP_KEY, keyword).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<QueryModel> {
                override fun onSuccess(t: QueryModel) {
                    view.setData(t)
                }

                override fun onSubscribe(d: Disposable) {
                    compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                    Log.d("retrofit",e.toString())
                }
            })

    }

    override fun preparedData() {

    }


}
