package dev.waceramercythird.workoutLog.viewmodel

import androidx.lifecycle.MutableLiveData
import dev.waceramercythird.workoutLog.ExerciseCategory
import dev.waceramercythird.workoutLog.repository.ExerciseRepository

class ExerciseViewModel {
    var exerciseRepository = ExerciseRepository()
    var exerciseCategoryLiveData = MutableLiveData<ExerciseCategory>()
    var errorLiveData = MutableLiveData<String>()

    fun fetchExerciseCategories(accessToken: String){
        viewModelScope.launch{
            var response = exerciseRepository.fetchExerciseCategories(accessToken)
            if(response.isSuccessful) {
                exerciseCategoryLiveData.postValue(response.body())
            }
            else{
                errorLiveData.postValue(response.errorBody?.string())
            }
            }
        }
    }
}