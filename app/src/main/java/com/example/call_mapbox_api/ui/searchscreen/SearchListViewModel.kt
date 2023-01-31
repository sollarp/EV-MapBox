package com.example.call_mapbox_api.ui.searchscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.call_mapbox_api.data.remote.EvPointsEntity
import com.example.call_mapbox_api.domain.ISearchListUseCase
import com.example.call_mapbox_api.util.ItemDataConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchListViewModel
@Inject constructor(private val searchListUseCase: ISearchListUseCase) : ViewModel() {

    private val _listOfItem = MutableLiveData<List<EvPointsEntity>>()
    val listOfItems: LiveData<List<EvPointsEntity>>
        get() = _listOfItem

    private val _connectionItems = MutableLiveData<ItemDataConverter>()
    val connectionItems: LiveData<ItemDataConverter>
        get() = _connectionItems

    init {
        viewModelScope.launch {
            getListUseCase()
        }
    }

    private suspend fun getListUseCase() {
        searchListUseCase().collect()  { items ->
            _listOfItem.value = items
        }
    }

    fun setDetailItems(item: ItemDataConverter) {
        _connectionItems.value = item
    }

    fun getDetailItems(): MutableLiveData<ItemDataConverter> {
        return _connectionItems
    }
}