package com.example.mediatorlivedataexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel(){
    private var _firstPlayerScore = MutableLiveData<Float>(0f)
    val firstPlayerScore: LiveData<Float>
        get()  = _firstPlayerScore

    private var _secondPlayerScore = MutableLiveData<Float>(0f)
    val secondPlayerScore: LiveData<Float>
        get()  = _secondPlayerScore

    //region
    val currentScore = MediatorLiveData<Float>()

    init{
        currentScore.addSource(_firstPlayerScore) { value ->
            currentScore.setValue(value)
        }
        currentScore.addSource(_secondPlayerScore) { value ->
            currentScore.setValue(value)
        }
    }
    //endregion

    fun setFirstPlayerScore(score: Float){
        _firstPlayerScore.value = score
    }

    fun setSecondPlayerScore(score: Float){
        _secondPlayerScore.value = score
    }
}