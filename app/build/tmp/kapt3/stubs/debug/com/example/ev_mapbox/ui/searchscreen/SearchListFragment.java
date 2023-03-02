package com.example.ev_mapbox.ui.searchscreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.ev_mapbox.databinding.FragmentSearchlistBinding;
import com.example.ev_mapbox.domain.model.ItemDataConverter;
import com.example.ev_mapbox.util.Constants;
import dagger.hilt.android.AndroidEntryPoint;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J<\u0010\u0018\u001a\u00020\u00192\u0016\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J$\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\b\u0010(\u001a\u00020\u000fH\u0016J\u001a\u0010)\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006*"}, d2 = {"Lcom/example/ev_mapbox/ui/searchscreen/SearchListFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/ev_mapbox/databinding/FragmentSearchlistBinding;", "binding", "getBinding", "()Lcom/example/ev_mapbox/databinding/FragmentSearchlistBinding;", "viewModel", "Lcom/example/call_mapbox_api/ui/searchscreen/SearchListViewModel;", "getViewModel", "()Lcom/example/call_mapbox_api/ui/searchscreen/SearchListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createAdapterObserver", "", "view", "Landroid/view/View;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewLifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "createSearchListFragmentDirections", "Landroidx/navigation/NavDirections;", "createSearchRecycleAdapter", "Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter;", "items", "Ljava/util/ArrayList;", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "Lkotlin/collections/ArrayList;", "itemDataConverter", "Lkotlin/Function1;", "Lcom/example/ev_mapbox/domain/model/ItemDataConverter;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class SearchListFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy viewModel$delegate = null;
    private com.example.ev_mapbox.databinding.FragmentSearchlistBinding _binding;
    
    public SearchListFragment() {
        super();
    }
    
    private final com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel getViewModel() {
        return null;
    }
    
    private final com.example.ev_mapbox.databinding.FragmentSearchlistBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void createAdapterObserver(android.view.View view, androidx.recyclerview.widget.RecyclerView recyclerView, androidx.lifecycle.LifecycleOwner viewLifecycleOwner) {
    }
    
    private final com.example.ev_mapbox.ui.searchscreen.SearchRecycleAdapter createSearchRecycleAdapter(java.util.ArrayList<com.example.ev_mapbox.data.local.EvPointsEntity> items, kotlin.jvm.functions.Function1<? super com.example.ev_mapbox.data.local.EvPointsEntity, com.example.ev_mapbox.domain.model.ItemDataConverter> itemDataConverter, android.view.View view) {
        return null;
    }
    
    private final androidx.navigation.NavDirections createSearchListFragmentDirections() {
        return null;
    }
}