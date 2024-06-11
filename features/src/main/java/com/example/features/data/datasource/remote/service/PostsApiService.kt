package com.example.features.data.datasource.remote.service

import com.example.core.constants.AppConstants
import com.example.feature.posts.data.datasources.remote.response.GetPostApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface PostsApiService {
    @GET(AppConstants.GET_POSTS)
    suspend fun getAllPosts(): Response<GetPostApiResponse>
}
