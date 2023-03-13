package com.example.ev_mapbox.ui.homescreen;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavDirections;
import com.example.call_mapbox_api.ui.searchscreen.SearchListViewModel;
import com.example.ev_mapbox.R;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.ev_mapbox.databinding.FragmentMapbarBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\"H\u0002J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001eH\u0016J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020 H\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u000fH\u0016J\u001a\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020$2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00103\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u000fH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001a\u00a8\u00064"}, d2 = {"Lcom/example/ev_mapbox/ui/homescreen/MapBarFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "()V", "_binding", "Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "binding", "getBinding", "()Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/RelativeLayout;", "bottomSheetView", "lastClickedMarker", "Lcom/google/android/gms/maps/model/Marker;", "pointsEntity", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "textAddress", "Landroid/widget/TextView;", "textPointsCounter", "textTitle", "viewModel", "Lcom/example/call_mapbox_api/ui/searchscreen/SearchListViewModel;", "getViewModel", "()Lcom/example/call_mapbox_api/ui/searchscreen/SearchListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addMarkers", "", "googleMap", "Lcom/google/android/gms/maps/GoogleMap;", "createMapBarFragmentDirections", "Landroidx/navigation/NavDirections;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onMapReady", "map", "onMarkerClick", "", "marker", "onViewCreated", "view", "setCardViewTexts", "app_debug"})
public final class MapBarFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.GoogleMap.OnMarkerClickListener, com.google.android.gms.maps.OnMapReadyCallback {
    private com.example.ev_mapbox.databinding.FragmentMapbarBinding _binding;
    private final kotlin.Lazy viewModel$delegate = null;
    private android.widget.RelativeLayout bottomSheetView;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.RelativeLayout> bottomSheetBehavior;
    private java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity> pointsEntity;
    private com.google.android.gms.maps.model.Marker lastClickedMarker;
    private android.widget.TextView textAddress;
    private android.widget.TextView textPointsCounter;
    private android.widget.TextView textTitle;
    
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
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap map) {
    }
    
    @java.lang.Override()
    public boolean onMarkerClick(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
        return false;
    }
    
    private final void setCardViewTexts(com.google.android.gms.maps.model.Marker marker) {
    }
    
    private final void addMarkers(com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final androidx.navigation.NavDirections createMapBarFragmentDirections() {
        return null;
    }
}