package com.example.call_mapbox_api.ui.searchscreen

import androidx.lifecycle.*
import com.example.call_mapbox_api.data.local.EvPointsEntity
import com.example.call_mapbox_api.domain.ISearchListUseCase
import com.example.call_mapbox_api.domain.model.ItemDataConverter
import com.example.call_mapbox_api.domain.model.LoadingState
import com.example.call_mapbox_api.util.searchPoints
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class SearchListViewModel
@Inject constructor(private val searchListUseCase: ISearchListUseCase) : ViewModel() {

    private val _listOfItem = MutableLiveData<List<EvPointsEntity>>()
    private val listOfItems: LiveData<List<EvPointsEntity>>
        get() = _listOfItem

    private val _connectionItems = MutableLiveData<ItemDataConverter>()
    val connectionItems: LiveData<ItemDataConverter>
        get() = _connectionItems

    val pointsMediatorData = MediatorLiveData<List<EvPointsEntity>>()
    private val _queryLiveData = MutableLiveData<String>()
    private var _searchPointsLiveData: LiveData<List<EvPointsEntity>>
    private var searchJob: Job? = null
    private val debouncePeriod = 700L
    val loadingStateLiveData = MutableLiveData<LoadingState>()

    init {
        _searchPointsLiveData = Transformations.switchMap(_queryLiveData) {
            fetchPointsByQuery(it)

        }
        pointsMediatorData.addSource(_listOfItem) {
            pointsMediatorData.value = it
        }

        pointsMediatorData.addSource(_searchPointsLiveData) {
            pointsMediatorData.value = it
        }

        viewModelScope.launch(Dispatchers.IO) {
            getAllPoints()
        }
    }

    private suspend fun getAllPoints() {
        if (_listOfItem.value.isNullOrEmpty()) {
            loadingStateLiveData.postValue(LoadingState.LOADING)
            try {
                searchListUseCase().collect { items ->
                    _listOfItem.postValue(items)
                }
            } catch (e: Exception) {
                loadingStateLiveData.postValue(LoadingState.ERROR)
            }
        }
    }

    fun setDetailItems(item: ItemDataConverter) {
        searchJob?.cancel()
        _connectionItems.value = item
    }

    fun getDetailItems(): MutableLiveData<ItemDataConverter> {
        return _connectionItems
    }

    fun onSearchQuery(query: String) {
        searchJob?.cancel()
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            delay(debouncePeriod)
            if (query.isEmpty()) {
                getAllPoints()
            } else {
                _queryLiveData.postValue(query)
            }
        }
    }

    private fun fetchPointsByQuery(query: String): MutableLiveData<List<EvPointsEntity>?> {
        val liveData = MutableLiveData<List<EvPointsEntity>?>()
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val orders = listOfItems.value?.let { searchPoints(query, it) }
                liveData.postValue(orders)
                loadingStateLiveData.postValue(LoadingState.LOADED)
            } catch (_: Exception) {
                loadingStateLiveData.postValue(LoadingState.ERROR)
            }
        }
        return liveData
    }
}