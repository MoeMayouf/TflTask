package com.test.tfl.data.service

import com.test.tfl.data.model.RoadModel
import io.reactivex.Observable
import io.reactivex.Single

interface ApiManager {

    fun getRoadStatus(roadName: String): Single<List<RoadModel>>
}