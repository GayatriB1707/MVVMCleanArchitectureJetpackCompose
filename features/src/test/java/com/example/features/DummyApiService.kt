package com.example.features

import com.example.feature.posts.data.datasources.remote.response.GetPostApiResponse
import com.example.features.data.datasource.remote.service.PostsApiService
import retrofit2.Response

class DummyApiService: PostsApiService {
    override suspend fun getAllPosts(): Response<GetPostApiResponse> {
       return Response.success(GetPostApiResponse().apply { addAll(listOf(
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
           GetPostApiResponse.GetPostApiResponseItem(id = 1, title = "title", body = "body", userId = 1),
       )) })
    }
}