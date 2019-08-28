package com.test.tfl.data.service

import com.test.tfl.common.Constants
import com.test.tfl.data.model.RoadModel
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApiManagerImpl @Inject constructor(private val serviceApi: ServiceApi) : ApiManager {
    override fun getRoadStatus(roadName: String): Single<List<RoadModel>> {
        return serviceApi.getRoadStatus(roadName, Constants.APP_ID, Constants.APP_KEY)
    }
}