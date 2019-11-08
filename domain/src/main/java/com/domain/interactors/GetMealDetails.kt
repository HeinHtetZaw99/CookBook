package com.domain.interactors

import com.domain.executor.PostExecutionThread
import com.domain.executor.ThreadExecutor
import com.domain.model.MealDetailsVO
import com.domain.repository.MealDetailsRepository
import com.domain.rxusecase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetMealDetails @Inject constructor(
    private val mealDetailsRepository: MealDetailsRepository,
    postExecutionThread: PostExecutionThread,
    threadExecutor: ThreadExecutor
) : SingleUseCase<MealDetailsVO, GetMealDetails.Params>(postExecutionThread, threadExecutor) {
    override fun provideSingle(params: Params): Single<MealDetailsVO> {
        return mealDetailsRepository.getMealDetails(mealID = params.mealID)
    }

    data class Params(
        val mealID: String
    )
}