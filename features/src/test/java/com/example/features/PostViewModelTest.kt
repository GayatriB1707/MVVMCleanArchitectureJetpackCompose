package com.example.features

import app.cash.turbine.test
import assertk.assertThat
import assertk.assertions.isEqualTo
import com.example.core.failure.Failure
import com.example.core.helpers.Either
import com.example.features.domain.entity.PostEntity
import com.example.features.presentation.PostViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class PostViewModelTest {
    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    lateinit var getAllPostsUseCases: GetAllPostsUseCasesTest

    @InjectMocks
    lateinit var postViewModel: PostViewModel

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test loading posts success`() = testScope.runTest {
        // Arrange
        val mockPosts = listOf(PostEntity("1", "", ""))
        `when`(getAllPostsUseCases.invoke()).thenReturn(flowOf(Either.Right(mockPosts)))

        postViewModel.allItems.test {
            postViewModel.allItems
            assertThat(awaitItem().size).isEqualTo(1)
            awaitComplete()

        }
    }

    @Test
    fun `test loading posts failure`() = testScope.runTest {
        val failure = Failure.NetworkFailure
        `when`(getAllPostsUseCases.invoke()).thenReturn(flowOf(Either.Left(failure)))
        postViewModel.allItems.test {
            postViewModel.allItems
            assertThat(awaitItem().size).isEqualTo(0)
            awaitComplete()
        }
    }
}
