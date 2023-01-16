package com.example.call_mapbox_api.ui.searchscreen

import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.call_mapbox_api.MyApplication
import com.example.call_mapbox_api.domain.ISearchListUseCase
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.model.ItemDataConverter
import kotlinx.coroutines.launch

class SearchListViewModel(
    //private val searchListRepository: SearchListRepository,
    private val searchListUseCase: ISearchListUseCase,
) : ViewModel() {

    var listOfItems = MutableLiveData<List<EvPointDetails>>()
    var connectionItems = MutableLiveData<ItemDataConverter>()

    init {
        viewModelScope.launch {
            getListUseCase()
        }
    }
    // import androidx.lifecycle.asLiveData
    // searchListUseCase.invoke().asLiveData()
    suspend fun getListUseCase() {
        searchListUseCase.invoke().collect{
                items -> listOfItems.postValue(items)
                    }
    }

    fun setDetailItems(item: ItemDataConverter) {
        connectionItems.value = item
    }

    fun getDetailItems(): MutableLiveData<ItemDataConverter> {
        return connectionItems
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