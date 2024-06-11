package com.example.features.domain.use_cases

import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.core.usecase.UseCaseNoParams
import com.example.features.domain.entity.PostEntity
import com.example.features.domain.repo.PostRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetAllPostsUseCases @Inject constructor(private val postRepo: PostRepo) :
    UseCaseNoParams<List<PostEntity>> {
    override suspend fun invoke(): Flow<Either<Failure, List<PostEntity>>> {
        return postRepo.getAllPosts()
    }
}
