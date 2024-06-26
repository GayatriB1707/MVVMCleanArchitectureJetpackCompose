package com.example.features

import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.core.helpers.map
import com.example.core.helpers.safeFlowBuilder
import com.example.feature.posts.data.datasources.remote.response.GetPostApiResponse
import com.example.features.domain.entity.PostEntity
import com.example.features.domain.mapper.toPostsEntities
import com.example.features.domain.repo.PostRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PostRepoImplTest(private val dummyApiService: DummyApiService) : PostRepo {
    override suspend fun getAllPosts(): Flow<Either<Failure, List<PostEntity>>> {

        return safeFlowBuilder { dummyApiService.getAllPosts() }.map { value ->
            when (value) {
                is Either.Left -> value
                is Either.Right -> value.map(GetPostApiResponse::toPostsEntities)
            }
        }
    }
}