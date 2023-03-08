package com.example.ev_mapbox.ui.homescreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;
import androidx.fragment.app.*;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavDirections;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel;
import com.example.ev_mapbox.R;
import com.example.ev_mapbox.databinding.FragmentMapbarBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u000fH\u0016J\u001a\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\""}, d2 = {"Lcom/example/ev_mapbox/ui/homescreen/MapBarFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "binding", "getBinding", "()Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "viewModel", "Lcom/example/call_mapbox_api/ui/searchscreen/SearchListViewModel;", "getViewModel", "()Lcom/example/call_mapbox_api/ui/searchscreen/SearchListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addMarkers", "", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "pointItems", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "createMapBarFragmentDirections", "Landroidx/navigation/NavDirections;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "app_debug"})
public final class MapBarFragment extends androidx.fragment.app.Fragment {
    private com.example.ev_mapbox.databinding.FragmentMapbarBinding _binding;
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MapBarFragment() {
        super();
    }
    
    private final com.example.ev_mapbox.databinding.FragmentMapbarBinding getBinding() {
        return null;
    }
    
    private final com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel getViewModel() {
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
    
    private final void addMarkers(com.google.android.gms.maps.GoogleMap googleMap, java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity> pointItems) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final androidx.navigation.NavDirections createMapBarFragmentDirections() {
        return null;
    }
}