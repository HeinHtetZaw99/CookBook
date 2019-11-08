package com.domain.interactors

import com.domain.executor.PostExecutionThread
import com.domain.executor.ThreadExecutor
import com.domain.model.CategoryVO
import com.domain.repository.CategoryRepository
import com.domain.rxusecase.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

class GetCategories @Inject constructor(
    private val categoryRepository: CategoryRepository,
    postExecutionThread: PostExecutionThread,
    threadExecutor: ThreadExecutor
) : SingleUseCase<List<CategoryVO>, GetCategories.Params>(postExecutionThread, threadExecutor) {
    override fun provideSingle(params: Params): Single<List<CategoryVO>> {
        return categoryRepository.getMealCategory()
    }

    data class Params(
        val dummy: String
    )
}