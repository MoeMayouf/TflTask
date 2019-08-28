package com.test.tfl.data.service

import com.test.tfl.data.model.RoadModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("road/{road}/")
    fun getRoadStatus(
        @Path("road") roadName: String,
        @Query("app_id") appID: String,
        @Query("app_key") appKey: String
    ): Single<List<RoadModel>>
}