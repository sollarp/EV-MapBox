// Generated by view binder compiler. Do not edit!
package com.example.ev_mapbox.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ev_mapbox.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CardviewBinding implements ViewBinding {
  @NonNull
  private final CardView rootView;

  @NonNull
  public final TextView city;

  @NonNull
  public final TextView location;

  @NonNull
  public final TextView postcode;

  @NonNull
  public final TextView street;

  private CardviewBinding(@NonNull CardView rootView, @NonNull TextView city,
      @NonNull TextView location, @NonNull TextView postcode, @NonNull TextView street) {
    this.rootView = rootView;
    this.city = city;
    this.location = location;
    this.postcode = postcode;
    this.street = street;
  }

  @Override
  @NonNull
  public CardView getRoot() {
    return rootView;
  }

  @NonNull
  public static CardviewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CardviewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.cardview, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CardviewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.city;
      TextView city = ViewBindings.findChildViewById(rootView, id);
      if (city == null) {
        break missingId;
      }

      id = R.id.location;
      TextView location = ViewBindings.findChildViewById(rootView, id);
      if (location == null) {
        break missingId;
      }

      id = R.id.postcode;
      TextView postcode = ViewBindings.findChildViewById(rootView, id);
      if (postcode == null) {
        break missingId;
      }

      id = R.id.street;
      TextView street = ViewBindings.findChildViewById(rootView, id);
      if (street == null) {
        break missingId;
      }

      return new CardviewBinding((CardView) rootView, city, location, postcode, street);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
