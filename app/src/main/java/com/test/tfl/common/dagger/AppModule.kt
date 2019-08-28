package com.test.tfl.common.dagger

import android.content.Context
import com.google.gson.Gson
import com.test.tfl.common.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(private val context: Context) {

    lateinit var mApplication: App

    fun AppModule(application: App) {
        mApplication = application
    }

    @Provides
    @Singleton
    fun providesApplication(): App {
        return mApplication
    }

    @Provides
    @Singleton
    fun context(): Context = context


    @Provides
    @Singleton
    fun gson(): Gson = Gson()

}