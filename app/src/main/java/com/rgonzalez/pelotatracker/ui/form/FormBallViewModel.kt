package com.rgonzalez.pelotatracker.ui.form

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.pelotatracker.BallReviewerApplication
import com.rgonzalez.pelotatracker.data.model.BallModel
import com.rgonzalez.pelotatracker.repositories.BallRepository

class FormBallViewModel(private val repository: BallRepository) : ViewModel() {

    // declaring variables
    var type = MutableLiveData("")
    var color = MutableLiveData("")
    var status = MutableLiveData("")

    fun addBall(ball: BallModel) = repository.addBall(ball)

    fun createBall() {
        if(!validateBallData()) {
            status.value = WRONG_DATA
            return
        }
        val ball = BallModel(
            type.value!!,
            color.value!!
        )
        addBall(ball)
        Log.d("TAG", "$ball Created")
        status.value = BALL_CREATED
        clearData()
    }

    fun clearData() {
        type.value = ""
        color.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }


    private fun validateBallData(): Boolean {
        when {
            type.value.isNullOrEmpty() -> return false
            color.value.isNullOrEmpty() -> return false
        }

        return true
    }
    companion object {
        val Factory = viewModelFactory {
           initializer {
               val app = this[APPLICATION_KEY] as BallReviewerApplication
               FormBallViewModel(app.ballRepository)
           }
        }

        const val BALL_CREATED = "created"
        const val WRONG_DATA = "error"
        const val INACTIVE = ""
    }
}