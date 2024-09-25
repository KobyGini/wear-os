package com.gini.weatherapp.presentation.home

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
){

    val state by viewModel.state.collectAsStateWithLifecycle()
    LazyColumn {
        items(state.weeklyWeather){
            LocationComponent(it)
        }
    }
}