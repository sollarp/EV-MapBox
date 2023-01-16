package com.example.call_mapbox_api.homescreen.ui

import androidx.lifecycle.*
import com.example.call_mapbox_api.homescreen.data.SearchListRepository
import com.example.call_mapbox_api.model.EvPointDetails
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.call_mapbox_api.MyApplication


class SearchListViewModel(
    private val searchListRepository: SearchListRepository,
) : ViewModel() {

    var listOfItems = MutableLiveData<List<EvPointDetails>>()

    init {
        viewModelScope.launch {
            getElements()
        }
    }

    suspend fun getElements() {
        return searchListRepository.getlatestList().collect { items ->
            listOfItems.postValue(items)
        }
    }
    //Define ViewModel factory in a companion object
    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                return SearchListViewModel(
                    MyApplication().getMyApp(),
                ) as T
            }
        }
    }
}