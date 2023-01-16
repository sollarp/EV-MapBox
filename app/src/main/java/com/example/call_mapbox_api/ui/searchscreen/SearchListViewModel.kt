package com.example.call_mapbox_api.ui.searchscreen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.call_mapbox_api.domain.ISearchListUseCase
import com.example.call_mapbox_api.model.EvPointDetails
import com.example.call_mapbox_api.util.ItemDataConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchListViewModel
@Inject constructor(private val searchListUseCase: ISearchListUseCase) : ViewModel() {

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
        searchListUseCase.invoke().collect { items ->
            listOfItems.postValue(items)
        }
    }

    fun setDetailItems(item: ItemDataConverter) {
        connectionItems.value = item
    }

    fun getDetailItems(): MutableLiveData<ItemDataConverter> {
        return connectionItems
    }
}