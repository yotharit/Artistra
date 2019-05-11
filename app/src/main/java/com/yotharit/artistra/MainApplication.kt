package com.yotharit.artistra

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.yotharit.artistra.manager.Contextor
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class MainApplication : MultiDexApplication(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        Contextor.getInstance().init(applicationContext)
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder()
            .setDefaultFontPath("fonts/avenir.otf")
            .setFontAttrId(R.attr.fontPath)
            .build())
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}