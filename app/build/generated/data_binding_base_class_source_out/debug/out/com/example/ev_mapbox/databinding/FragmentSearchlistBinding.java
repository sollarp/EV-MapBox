// Generated by view binder compiler. Do not edit!
package com.example.ev_mapbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ev_mapbox.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSearchlistBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final RecyclerView recycleSearch;

  @NonNull
  public final ItemSearchbarBinding searchbarFragment;

  private FragmentSearchlistBinding(@NonNull ConstraintLayout rootView,
      @NonNull RecyclerView recycleSearch, @NonNull ItemSearchbarBinding searchbarFragment) {
    this.rootView = rootView;
    this.recycleSearch = recycleSearch;
    this.searchbarFragment = searchbarFragment;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSearchlistBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSearchlistBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_searchlist, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSearchlistBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.recycle_search;
      RecyclerView recycleSearch = ViewBindings.findChildViewById(rootView, id);
      if (recycleSearch == null) {
        break missingId;
      }

      id = R.id.searchbar_fragment;
      View searchbarFragment = ViewBindings.findChildViewById(rootView, id);
      if (searchbarFragment == null) {
        break missingId;
      }
      ItemSearchbarBinding binding_searchbarFragment = ItemSearchbarBinding.bind(searchbarFragment);

      return new FragmentSearchlistBinding((ConstraintLayout) rootView, recycleSearch,
          binding_searchbarFragment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}