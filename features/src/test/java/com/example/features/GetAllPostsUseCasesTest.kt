package com.example.features

import com.example.features.domain.repo.PostRepo
import com.example.features.domain.use_cases.GetAllPostsUseCases

open class GetAllPostsUseCasesTest(postRepoImplTest: PostRepo) :
    GetAllPostsUseCases(postRepoImplTest) {

}
