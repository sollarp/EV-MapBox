package com.example.ev_mapbox.data.remote;

import com.example.ev_mapbox.data.OpenMapApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class EvPointRemoteDataSource_Factory implements Factory<EvPointRemoteDataSource> {
  private final Provider<OpenMapApi> openMapApiProvider;

  public EvPointRemoteDataSource_Factory(Provider<OpenMapApi> openMapApiProvider) {
    this.openMapApiProvider = openMapApiProvider;
  }

  @Override
  public EvPointRemoteDataSource get() {
    return newInstance(openMapApiProvider.get());
  }

  public static EvPointRemoteDataSource_Factory create(Provider<OpenMapApi> openMapApiProvider) {
    return new EvPointRemoteDataSource_Factory(openMapApiProvider);
  }

  public static EvPointRemoteDataSource newInstance(OpenMapApi openMapApi) {
    return new EvPointRemoteDataSource(openMapApi);
  }
}
