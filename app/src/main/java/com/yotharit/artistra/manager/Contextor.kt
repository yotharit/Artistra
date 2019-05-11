package com.yotharit.artistra.manager

import android.content.Context

class Contextor private constructor() {

    var context: Context? = null

    fun init(context: Context) {
        this.context = context
    }

    companion object {

        private var instance: Contextor? = null

        fun getInstance(): Contextor {
            if (instance == null)
                instance = Contextor()
            return instance!!
        }
    }

}
