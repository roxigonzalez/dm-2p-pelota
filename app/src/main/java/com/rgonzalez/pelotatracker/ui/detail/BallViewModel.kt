package com.rgonzalez.pelotatracker.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.pelotatracker.BallReviewerApplication
import com.rgonzalez.pelotatracker.data.model.BallModel
import com.rgonzalez.pelotatracker.repositories.BallRepository


class BallViewModel(private val repository: BallRepository):ViewModel() {
    private val ballModelLiveData = MutableLiveData<BallModel>()

    // declaring variables
    var type = MutableLiveData("")
    var color = MutableLiveData("")

    fun setBallModel(ballModel: BallModel){
        type.value = ballModel.type
        color.value = ballModel.color

    }

    fun getBallModel(): LiveData<BallModel> {
        return ballModelLiveData
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BallReviewerApplication
                BallViewModel(app.ballRepository)
            }
        }
    }

}