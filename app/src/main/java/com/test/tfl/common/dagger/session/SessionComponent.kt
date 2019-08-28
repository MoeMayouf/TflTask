package com.test.tfl.common.dagger.session

import com.test.tfl.common.dagger.AppComponent
import com.test.tfl.common.dagger.CommonOkHttpClientBuilderModule
import com.test.tfl.common.dagger.roadstatus.RoadStatusModule
import com.test.tfl.common.dagger.roadstatus.SessionScope
import com.test.tfl.data.service.ApiManager
import com.test.tfl.data.service.ServiceApi
import dagger.Component

@Component(
    dependencies = [AppComponent::class],
    modules = [RoadStatusModule::class, CommonOkHttpClientBuilderModule::class]
)
@SessionScope
interface SessionComponent : AppComponent {
    fun apiManager(): ApiManager
    fun iService(): ServiceApi

}