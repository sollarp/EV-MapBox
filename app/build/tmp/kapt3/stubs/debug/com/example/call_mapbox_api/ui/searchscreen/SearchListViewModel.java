package com.example.call_mapbox_api.ui.searchscreen;

import androidx.lifecycle.*;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.ev_mapbox.domain.ISearchListUseCase;
import com.example.ev_mapbox.domain.model.ItemDataConverter;
import com.example.ev_mapbox.domain.model.LoadingState;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.*;
import javax.inject.Inject;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u001e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t0\u00062\u0006\u0010\u001f\u001a\u00020\fH\u0002J\u0011\u0010 \u001a\u00020!H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\"J\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u000e\u0010$\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010%\u001a\u00020!2\u0006\u0010&\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082D\u00a2\u0006\u0002\n\u0000R \u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/example/call_mapbox_api/ui/searchscreen/SearchListViewModel;", "Landroidx/lifecycle/ViewModel;", "searchListUseCase", "Lcom/example/ev_mapbox/domain/ISearchListUseCase;", "(Lcom/example/ev_mapbox/domain/ISearchListUseCase;)V", "_connectionItems", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/ev_mapbox/domain/model/ItemDataConverter;", "_listOfItem", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "_queryLiveData", "", "_searchPointsLiveData", "Landroidx/lifecycle/LiveData;", "connectionItems", "getConnectionItems", "()Landroidx/lifecycle/LiveData;", "debouncePeriod", "", "listOfItems", "getListOfItems", "loadingStateLiveData", "Lcom/example/ev_mapbox/domain/model/LoadingState;", "pointsMediatorData", "Landroidx/lifecycle/MediatorLiveData;", "getPointsMediatorData", "()Landroidx/lifecycle/MediatorLiveData;", "searchJob", "Lkotlinx/coroutines/Job;", "fetchPointsByQuery", "query", "getAllPoints", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDetailItems", "onSearchQuery", "setDetailItems", "item", "app_debug"})
public final class SearchListViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.ev_mapbox.domain.ISearchListUseCase searchListUseCase = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>> _listOfItem = null;
    private final androidx.lifecycle.MutableLiveData<com.example.ev_mapbox.domain.model.ItemDataConverter> _connectionItems = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MediatorLiveData<java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>> pointsMediatorData = null;
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _queryLiveData = null;
    private androidx.lifecycle.LiveData<java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>> _searchPointsLiveData;
    private kotlinx.coroutines.Job searchJob;
    private final long debouncePeriod = 800L;
    private final androidx.lifecycle.MutableLiveData<com.example.ev_mapbox.domain.model.LoadingState> loadingStateLiveData = null;
    
    @javax.inject.Inject()
    public SearchListViewModel(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.domain.ISearchListUseCase searchListUseCase) {
        super();
    }
    
    private final androidx.lifecycle.LiveData<java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>> getListOfItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.example.ev_mapbox.domain.model.ItemDataConverter> getConnectionItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MediatorLiveData<java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>> getPointsMediatorData() {
        return null;
    }
    
    private final java.lang.Object getAllPoints(kotlin.coroutines.Continuation<? super kotlin.Unit> continuation) {
        return null;
    }
    
    public final void setDetailItems(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.domain.model.ItemDataConverter item) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.example.ev_mapbox.domain.model.ItemDataConverter> getDetailItems() {
        return null;
    }
    
    public final void onSearchQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity>> fetchPointsByQuery(java.lang.String query) {
        return null;
    }
}