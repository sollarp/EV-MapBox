package com.example.ev_mapbox.ui.searchscreen

import androidx.lifecycle.*
import com.example.ev_mapbox.data.local.EvPointsEntity
import com.example.ev_mapbox.domain.ISearchListUseCase
import com.example.ev_mapbox.domain.model.ItemDataConverter
import com.example.ev_mapbox.domain.model.LoadingState
import com.example.ev_mapbox.util.searchPoints
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
    private val debouncePeriod = 800L
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
    }

    fun getAllPoints() {
        viewModelScope.launch(Dispatchers.IO) {
            if (_listOfItem.value.isNullOrEmpty()) {
                try {
                    searchListUseCase().collect { items ->
                        _listOfItem.postValue(items)
                        loadingStateLiveData.postValue(LoadingState.LOADING)
                    }
                } catch (e: Exception) {
                    loadingStateLiveData.postValue(LoadingState.ERROR)
                }
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
        searchJob = viewModelScope.launch(Dispatchers.IO) {
            if (query.isEmpty()) {
                getAllPoints()
            } else {
                delay(debouncePeriod)
                searchJob?.cancel()
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
            } catch (_: Exception) {
            }
        }
        return liveData
    }
}