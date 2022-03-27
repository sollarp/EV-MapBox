package com.example.evmapbox.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.evmapbox.domain.model.DataResult
import com.example.evmapbox.domain.use_case.GetEvPointUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class EvPointViewModel @Inject constructor(
    private val getEvPointUseCase: GetEvPointUseCase
): ViewModel() {
    private val _state = MutableLiveData(EvListState())
    val state: LiveData<EvListState>
    get() = _state



    private suspend fun getPoints() {
        getEvPointUseCase().also { result ->
            when (result) {
                is DataResult.Success -> {
                    _state.value = EvListState(points = result.data)
                    println(result.data)
                }
                is DataResult.Error -> {
                    _state.value = EvListState(error = result.e.message ?: "An unexpected error")
                }
            }
        }
    }
}