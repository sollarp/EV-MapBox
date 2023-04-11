package com.example.ev_mapbox.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ev_mapbox.data.local.EvPointsEntity;
import com.google.android.gms.maps.model.LatLng;

@kotlin.Metadata(mv = {1, 7, 1}, k = 2, d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u001a\u0014\u0010\u0012\u001a\u00020\u0005*\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u001a\u0012\u0010\u0016\u001a\u00020\u0005*\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0010\u00a8\u0006\u0018"}, d2 = {"getNavigationIntent", "Landroid/content/Intent;", "latLng", "Lcom/google/android/gms/maps/model/LatLng;", "hideKeyboard", "", "view", "Landroid/view/View;", "context", "Landroid/content/Context;", "navigationIntentUri", "Landroid/net/Uri;", "searchPoints", "", "Lcom/example/ev_mapbox/data/local/EvPointsEntity;", "letter", "", "addresses", "showKeyboardDelayed", "Landroid/widget/EditText;", "delayMillis", "", "showToast", "message", "app_debug"})
public final class ExtensionsKt {
    
    @org.jetbrains.annotations.NotNull()
    public static final android.content.Intent getNavigationIntent(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLng latLng) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.net.Uri navigationIntentUri(@org.jetbrains.annotations.Nullable()
    com.google.android.gms.maps.model.LatLng latLng) {
        return null;
    }
    
    public static final void hideKeyboard(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    public static final void showKeyboardDelayed(@org.jetbrains.annotations.NotNull()
    android.widget.EditText $this$showKeyboardDelayed, long delayMillis) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity> searchPoints(@org.jetbrains.annotations.NotNull()
    java.lang.String letter, @org.jetbrains.annotations.NotNull()
    java.util.List<com.example.ev_mapbox.data.local.EvPointsEntity> addresses) {
        return null;
    }
    
    public static final void showToast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$showToast, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}