package com.esercizi.mvvmcounter.model

class CounterRepo {

    private var counter : Counter = Counter(0,0) // Stato iniziale

    fun incrementCounter() : Counter {
        counter = counter.copy(
            // Creo un nuovo oggetto copiato al precedente
            currentValue = counter.currentValue + 1,
            maxValue = maxOf(counter.currentValue + 1, counter.maxValue)
        )
        return counter
    }

    fun decrementCounter() : Counter {
        counter = counter.copy(
            // Creo un nuovo oggetto copiato al precedente
            currentValue = (counter.currentValue - 1).coerceAtLeast(0)
        )
        return counter
    }

    fun resetCounter() : Counter {
        counter = counter.copy(
            currentValue = 0,
        )
        return counter
    }

    fun getCurrentCounter() : Counter = counter

}