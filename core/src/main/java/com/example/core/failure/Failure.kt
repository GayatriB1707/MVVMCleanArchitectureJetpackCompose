package com.example.core.failure

sealed class Failure {
    object NetworkFailure : Failure()
    class ServerFailure(val errorCode: Int, val errorMessage: String?) : Failure()
}