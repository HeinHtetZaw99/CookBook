package com.domain.interactors

import com.domain.executor.PostExecutionThread
import com.domain.executor.ThreadExecutor
import com.domain.model.MealSnapshotVO
import com.domain.repository.MealSnapShotRepository
import com.domain.rxusecase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMealSnapShots @Inject constructor(
    private val mealSnapShotRepository: MealSnapShotRepository,
    postExecutionThread: PostExecutionThread,
    threadExecutor: ThreadExecutor
) : SingleUseCase<List<MealSnapshotVO>, GetMealSnapShots.Params>(
    postExecutionThread,
    threadExecutor
) {
    override fun provideSingle(params: Params): Single<List<MealSnapshotVO>> {
        return mealSnapShotRepository.getMealSnapShotsByCategory(
            category = params.categoryName
        )
    }

    data class Params(
        val categoryName: String
    )
}