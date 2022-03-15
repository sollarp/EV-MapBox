package com.example.evmapbox.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evmapbox.domain.model.EvPointItems
import com.example.evmapbox.domain.use_case.GetEvPointUseCase
import com.example.evmapbox.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class EvPointViewModel @Inject constructor(
    private val getEvPointUseCase: GetEvPointUseCase
): ViewModel() {
    private val _state = MutableLiveData(EvListState())
    val state: LiveData<EvListState>
    get() = _state

    init {
        getPoints()
    }

    private fun getPoints() {
        getEvPointUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = EvListState(points = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = EvListState(error = result.message ?: "An unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = EvListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}