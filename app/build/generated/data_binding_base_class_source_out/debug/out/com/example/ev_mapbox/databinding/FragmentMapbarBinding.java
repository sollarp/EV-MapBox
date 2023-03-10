// Generated by view binder compiler. Do not edit!
package com.example.ev_mapbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ev_mapbox.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMapbarBinding implements ViewBinding {
  @NonNull
  private final CoordinatorLayout rootView;

  @NonNull
  public final Button button1;

  @NonNull
  public final Button button2;

  @NonNull
  public final ConstraintLayout conlayout;

  @NonNull
  public final ItemMapBinding mapFragment;

  @NonNull
  public final ItemSearchbarnewBinding searchbarFragment;

  @NonNull
  public final ItemToolbarBinding toolbarFragment;

  private FragmentMapbarBinding(@NonNull CoordinatorLayout rootView, @NonNull Button button1,
      @NonNull Button button2, @NonNull ConstraintLayout conlayout,
      @NonNull ItemMapBinding mapFragment, @NonNull ItemSearchbarnewBinding searchbarFragment,
      @NonNull ItemToolbarBinding toolbarFragment) {
    this.rootView = rootView;
    this.button1 = button1;
    this.button2 = button2;
    this.conlayout = conlayout;
    this.mapFragment = mapFragment;
    this.searchbarFragment = searchbarFragment;
    this.toolbarFragment = toolbarFragment;
  }

  @Override
  @NonNull
  public CoordinatorLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMapbarBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMapbarBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_mapbar, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMapbarBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button1;
      Button button1 = ViewBindings.findChildViewById(rootView, id);
      if (button1 == null) {
        break missingId;
      }

      id = R.id.button2;
      Button button2 = ViewBindings.findChildViewById(rootView, id);
      if (button2 == null) {
        break missingId;
      }

      id = R.id.conlayout;
      ConstraintLayout conlayout = ViewBindings.findChildViewById(rootView, id);
      if (conlayout == null) {
        break missingId;
      }

      id = R.id.map_fragment;
      View mapFragment = ViewBindings.findChildViewById(rootView, id);
      if (mapFragment == null) {
        break missingId;
      }
      ItemMapBinding binding_mapFragment = ItemMapBinding.bind(mapFragment);

      id = R.id.searchbar_fragment;
      View searchbarFragment = ViewBindings.findChildViewById(rootView, id);
      if (searchbarFragment == null) {
        break missingId;
      }
      ItemSearchbarnewBinding binding_searchbarFragment = ItemSearchbarnewBinding.bind(searchbarFragment);

      id = R.id.toolbar_fragment;
      View toolbarFragment = ViewBindings.findChildViewById(rootView, id);
      if (toolbarFragment == null) {
        break missingId;
      }
      ItemToolbarBinding binding_toolbarFragment = ItemToolbarBinding.bind(toolbarFragment);

      return new FragmentMapbarBinding((CoordinatorLayout) rootView, button1, button2, conlayout,
          binding_mapFragment, binding_searchbarFragment, binding_toolbarFragment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
