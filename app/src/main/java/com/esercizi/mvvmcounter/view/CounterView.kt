package com.esercizi.mvvmcounter.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.esercizi.mvvmcounter.model.Counter
import com.esercizi.mvvmcounter.viewModel.CounterViewModel

@Composable
fun CounterView(modifier: Modifier = Modifier, viewModel: CounterViewModel) {

    val counter by viewModel.inputCounter.observeAsState(Counter(0, 0))

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Counter: ${counter.currentValue}",
            style = MaterialTheme.typography.displayMedium
        )

        Text(
            text = "Max: ${counter.maxValue}",
            style = MaterialTheme.typography.displayMedium
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = {
                    viewModel.incrementCounter()
                }
            ) {
                Text("+")
            }

            Button(
                onClick = {
                    viewModel.decrementCounter()
                }
            ) {
                Text("-")
            }

            Button(
                onClick = {
                    viewModel.resetCounter()
                }
            ) {
                Text("Reset")
            }
        }
    }
}