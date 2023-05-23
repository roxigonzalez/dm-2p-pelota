package com.rgonzalez.pelotatracker.repositories

import com.rgonzalez.pelotatracker.data.model.BallModel

class BallRepository(private val balls:MutableList<BallModel>){
    fun getBalls() = balls

    fun addBall(ball: BallModel) {
        balls.add(0, ball)
    }
}