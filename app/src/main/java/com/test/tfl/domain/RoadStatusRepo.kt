package com.test.tfl.domain

import com.test.tfl.data.model.RoadModel
import com.test.tfl.data.service.ApiManagerImpl
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RoadStatusRepo @Inject constructor(private val apiManager: ApiManagerImpl) {

    fun execute(roadName: String): Single<List<RoadModel>> {
        return apiManager
            .getRoadStatus(roadName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}