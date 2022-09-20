package dev.waceramercythird.workoutLog.repository

import dev.waceramercythird.workoutLog.ApiClient
import dev.waceramercythird.workoutLog.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class ExerciseRepository {
    var apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun fetchExerciseCategories(accessToken:String)
    = withContext(Dispatchers.IO) {
        return@withContext apiClient.fetchExerciseCategories(accessToken)

        }


}