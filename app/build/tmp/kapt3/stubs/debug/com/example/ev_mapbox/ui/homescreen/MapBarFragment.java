package com.example.ev_mapbox.ui.homescreen;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavDirections;
import com.example.ev_mapbox.ui.searchscreen.SearchListViewModel;
import com.example.ev_mapbox.R;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.example.ev_mapbox.databinding.FragmentMapbarBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

<<<<<<< HEAD
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0017H\u0002J\b\u0010(\u001a\u00020)H\u0002J\b\u0010*\u001a\u00020&H\u0002J\b\u0010+\u001a\u00020,H\u0002J$\u0010-\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u0001012\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020&H\u0016J\u0010\u00105\u001a\u00020&2\u0006\u0010\'\u001a\u00020\u0017H\u0016J\u0010\u00106\u001a\u00020,2\u0006\u00107\u001a\u00020\u0013H\u0016J\b\u00108\u001a\u00020,H\u0016J\u0010\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020;H\u0016J\u001a\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0010\u0010>\u001a\u00020&2\u0006\u00107\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001f\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b!\u0010\"\u00a8\u0006?"}, d2 = {"Lcom/example/ev_mapbox/ui/homescreen/MapBarFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationClickListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationButtonClickListener;", "()V", "REQUEST_LOCATION_PERMISSION", "", "_binding", "Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "binding", "getBinding", "()Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/RelativeLayout;", "bottomSheetView", "lastClickedMarker", "Lcom/google/android/gms/maps/model/Marker;", "locationButton", "Landroid/view/View;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "pointsEntity", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "textAddress", "Landroid/widget/TextView;", "textPointsCounter", "textTitle", "viewModel", "Lcom/example/ev_mapbox/ui/searchscreen/SearchListViewModel;", "getViewModel", "()Lcom/example/ev_mapbox/ui/searchscreen/SearchListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addMarkers", "", "googleMap", "createMapBarFragmentDirections", "Landroidx/navigation/NavDirections;", "enableMyLocation", "isPermissionGranted", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onMapReady", "onMarkerClick", "marker", "onMyLocationButtonClick", "onMyLocationClick", "location", "Landroid/location/Location;", "onViewCreated", "view", "setCardViewTexts", "app_debug"})
=======
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020*H\u0002J$\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020$H\u0016J\u0010\u00104\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015H\u0016J\u0010\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u0013H\u0016J\b\u00107\u001a\u00020*H\u0016J\u0010\u00108\u001a\u00020$2\u0006\u00109\u001a\u00020:H\u0016J\u001a\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020,2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0010\u0010=\u001a\u00020$2\u0006\u00106\u001a\u00020\u0013H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\n8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b\u001f\u0010 \u00a8\u0006>"}, d2 = {"Lcom/example/ev_mapbox/ui/homescreen/MapBarFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/gms/maps/GoogleMap$OnMarkerClickListener;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationClickListener;", "Lcom/google/android/gms/maps/GoogleMap$OnMyLocationButtonClickListener;", "()V", "REQUEST_LOCATION_PERMISSION", "", "_binding", "Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "binding", "getBinding", "()Lcom/example/ev_mapbox/databinding/FragmentMapbarBinding;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroid/widget/RelativeLayout;", "bottomSheetView", "lastClickedMarker", "Lcom/google/android/gms/maps/model/Marker;", "map", "Lcom/google/android/gms/maps/GoogleMap;", "pointsEntity", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "textAddress", "Landroid/widget/TextView;", "textPointsCounter", "textTitle", "viewModel", "Lcom/example/ev_mapbox/ui/searchscreen/SearchListViewModel;", "getViewModel", "()Lcom/example/ev_mapbox/ui/searchscreen/SearchListViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "addMarkers", "", "googleMap", "createMapBarFragmentDirections", "Landroidx/navigation/NavDirections;", "enableMyLocation", "isPermissionGranted", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onMapReady", "onMarkerClick", "marker", "onMyLocationButtonClick", "onMyLocationClick", "location", "Landroid/location/Location;", "onViewCreated", "view", "setCardViewTexts", "app_debug"})
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
public final class MapBarFragment extends androidx.fragment.app.Fragment implements com.google.android.gms.maps.GoogleMap.OnMarkerClickListener, com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener, com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener {
    private com.example.ev_mapbox.databinding.FragmentMapbarBinding _binding;
    private final kotlin.Lazy viewModel$delegate = null;
    private android.widget.RelativeLayout bottomSheetView;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<android.widget.RelativeLayout> bottomSheetBehavior;
    private java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity> pointsEntity;
    private com.google.android.gms.maps.model.Marker lastClickedMarker;
    private android.widget.TextView textAddress;
    private android.widget.TextView textPointsCounter;
    private android.widget.TextView textTitle;
    private final int REQUEST_LOCATION_PERMISSION = 1;
    private com.google.android.gms.maps.GoogleMap map;
<<<<<<< HEAD
    private android.view.View locationButton;
=======
>>>>>>> f5019a83a0aab9bb8a4ae62d2b533adc9407a059
    
    public MapBarFragment() {
        super();
    }
    
    private final com.example.ev_mapbox.databinding.FragmentMapbarBinding getBinding() {
        return null;
    }
    
    private final com.example.ev_mapbox.ui.searchscreen.SearchListViewModel getViewModel() {
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
    
    private final boolean isPermissionGranted() {
        return false;
    }
    
    private final void enableMyLocation() {
    }
    
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
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
    
    @java.lang.Override()
    public boolean onMyLocationButtonClick() {
        return false;
    }
    
    @java.lang.Override()
    public void onMyLocationClick(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
    }
}