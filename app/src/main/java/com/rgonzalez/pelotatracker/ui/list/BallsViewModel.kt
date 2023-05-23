package com.rgonzalez.pelotatracker.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.rgonzalez.pelotatracker.BallReviewerApplication
import com.rgonzalez.pelotatracker.data.model.BallModel
import com.rgonzalez.pelotatracker.repositories.BallRepository


class BallsViewModel(private val repository: BallRepository):ViewModel() {
    private val catModelLiveData = MutableLiveData<BallModel>()

    fun getBalls() = repository.getBalls()

    fun setBallModel(ballModel: BallModel) {
        catModelLiveData.value = ballModel
    }
    fun getBallModel(): LiveData<BallModel> {
        return catModelLiveData
    }
    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BallReviewerApplication
                BallsViewModel(app.ballRepository)
            }
        }
    }

}