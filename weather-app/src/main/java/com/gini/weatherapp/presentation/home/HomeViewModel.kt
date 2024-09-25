package com.gini.weatherapp.presentation.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gini.weather.usecase.GetWeeklyWeatherUseCase
import com.gini.weatherapp.model.DailyWeather
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    private val getWeeklyWeatherUseCase: GetWeeklyWeatherUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            getWeeklyWeatherUseCase()
                .collectLatest {list->
                    Log.d("TAG", ": asdasdasd")
                    _state.update {
                        MainUiState(
                            weeklyWeather = list.map { weather -> DailyWeather(id = weather.id) },
                            isLoading = false
                        )
                    }
                }
        }
    }
}

data class MainUiState(
    val weeklyWeather: List<DailyWeather> = emptyList(),
    val isLoading: Boolean = true
)