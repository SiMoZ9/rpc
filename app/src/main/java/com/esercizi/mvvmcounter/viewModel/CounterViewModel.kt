package com.esercizi.mvvmcounter.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.esercizi.mvvmcounter.model.Counter
import com.esercizi.mvvmcounter.model.CounterRepo

class CounterViewModel : ViewModel() {

    private val counterRepo = CounterRepo()
    private val _counter = MutableLiveData<Counter>(counterRepo.getCurrentCounter())

    val inputCounter : LiveData<Counter> = _counter

    fun incrementCounter() {
        _counter.value = counterRepo.incrementCounter()
    }

    fun decrementCounter() {
        _counter.value = counterRepo.decrementCounter()
    }

    fun resetCounter() {
        _counter.value = counterRepo.resetCounter()
    }

}