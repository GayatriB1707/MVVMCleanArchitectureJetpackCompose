package com.example.features.domain.mapper

import com.example.feature.posts.data.datasources.remote.response.GetPostApiResponse
import com.example.features.domain.entity.PostEntity


fun GetPostApiResponse.toPostsEntities(): List<PostEntity> {
    return this.map { currentObject ->
        PostEntity(
            userID = currentObject.userId.toString(),
            postTitle = currentObject.title,
            postBody = currentObject.body)
    }}
