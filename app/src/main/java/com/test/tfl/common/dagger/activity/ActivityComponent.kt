package com.test.tfl.common.dagger.activity

import com.test.tfl.common.dagger.session.SessionComponent
import com.test.tfl.presentation.roadstatus.RoadStatusActivity
import dagger.Component

@Component(dependencies = [SessionComponent::class])
@ActivityScope
interface ActivityComponent : SessionComponent {
    fun inject(target: RoadStatusActivity)
}