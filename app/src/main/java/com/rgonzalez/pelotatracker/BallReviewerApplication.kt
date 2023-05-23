package com.rgonzalez.pelotatracker

import android.app.Application
import com.rgonzalez.pelotatracker.data.balls
import com.rgonzalez.pelotatracker.repositories.BallRepository

class BallReviewerApplication : Application() {
    val ballRepository: BallRepository by lazy {
        BallRepository(balls)
    }
}