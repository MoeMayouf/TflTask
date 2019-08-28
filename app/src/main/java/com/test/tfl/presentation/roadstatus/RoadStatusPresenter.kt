package com.test.tfl.presentation.roadstatus

import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import com.test.tfl.R
import com.test.tfl.data.model.RoadModel
import com.test.tfl.domain.RoadStatusRepo
import com.test.tfl.presentation.base.BasePresenter
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class RoadStatusPresenter @Inject constructor(
    private val roadStatusRepo: RoadStatusRepo
) :
    BasePresenter<RoadStatusPresenter.RoadView>() {

    private val compositeDisposable = CompositeDisposable()

    fun getRoadStatus(roadName: String) {

        view?.showLoading()
        compositeDisposable.add(
            roadStatusRepo.execute(roadName)
                .subscribe({
                    view?.showRoadStatus(it)
                },
                    {
                        if (it is HttpException) {
                            when (val responseCode = it.code()) {
                                404 -> view?.showIdNotRecognizedError(roadName)
                                429 -> view?.showAuthenticationError()
                                else -> view?.showError("HTTP EXCEPTION $responseCode")
                            }
                        } else {
                            view?.showError(it.message!!)
                        }
                    }
                ))

    }

    interface RoadView : View {
        fun showLoading()
        fun showRoadStatus(roadModel: List<RoadModel>)
        fun showError(message: String)
        fun showIdNotRecognizedError(roadName: String)
        fun showAuthenticationError()
    }

}
