package com.example.ev_mapbox.ui.searchscreen;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ev_mapbox.R;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.ev_mapbox.databinding.ItemCardviewBinding;
import com.google.android.gms.maps.model.LatLng;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0017\u0018B%\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\u0014\u0010\u0014\u001a\u00020\r2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter$ViewHolder;", "evPointsEntity", "Ljava/util/ArrayList;", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "Lkotlin/collections/ArrayList;", "listener", "Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter$OnAdapterListener;", "(Ljava/util/ArrayList;Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter$OnAdapterListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateOrders", "newEvPointsEntity", "", "OnAdapterListener", "ViewHolder", "app_debug"})
public final class SearchRecycleAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.ev_mapbox.ui.searchscreen.SearchRecycleAdapter.ViewHolder> {
    private final java.util.ArrayList<com.example.ev_mapbox.data.local.EvPointsEntity> evPointsEntity = null;
    private final com.example.ev_mapbox.ui.searchscreen.SearchRecycleAdapter.OnAdapterListener listener = null;
    
    public SearchRecycleAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.ev_mapbox.data.local.EvPointsEntity> evPointsEntity, @org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.ui.searchscreen.SearchRecycleAdapter.OnAdapterListener listener) {
        super();
    }
    
    public final void updateOrders(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity> newEvPointsEntity) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.ev_mapbox.ui.searchscreen.SearchRecycleAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.ev_mapbox.ui.searchscreen.SearchRecycleAdapter.ViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter$OnAdapterListener;", "", "onClick", "", "address", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "app_debug"})
    public static abstract interface OnAdapterListener {
        
        public abstract void onClick(@org.jetbrains.annotations.NotNull()
        com.example.ev_mapbox.data.local.EvPointsEntity address);
    }
    
    @kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/example/ev_mapbox/databinding/ItemCardviewBinding;", "(Lcom/example/ev_mapbox/ui/searchscreen/SearchRecycleAdapter;Lcom/example/ev_mapbox/databinding/ItemCardviewBinding;)V", "getBinding", "()Lcom/example/ev_mapbox/databinding/ItemCardviewBinding;", "bind", "", "selectedLocation", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "app_debug"})
    public final class ViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final com.example.ev_mapbox.databinding.ItemCardviewBinding binding = null;
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        com.example.ev_mapbox.databinding.ItemCardviewBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.ev_mapbox.databinding.ItemCardviewBinding getBinding() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.ev_mapbox.data.local.EvPointsEntity selectedLocation) {
        }
    }
}