package com.example.features.domain.repo

import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.features.domain.entity.PostEntity
import kotlinx.coroutines.flow.Flow

interface  PostRepo {
    suspend fun getAllPosts(): Flow<Either<Failure, List<PostEntity>>>
}