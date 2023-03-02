package com.example.ev_mapbox.data.local;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class EvPointLocalDataSource_Factory implements Factory<EvPointLocalDataSource> {
  private final Provider<EvPointsDao> evPointsDaoProvider;

  public EvPointLocalDataSource_Factory(Provider<EvPointsDao> evPointsDaoProvider) {
    this.evPointsDaoProvider = evPointsDaoProvider;
  }

  @Override
  public EvPointLocalDataSource get() {
    return newInstance(evPointsDaoProvider.get());
  }

  public static EvPointLocalDataSource_Factory create(Provider<EvPointsDao> evPointsDaoProvider) {
    return new EvPointLocalDataSource_Factory(evPointsDaoProvider);
  }

  public static EvPointLocalDataSource newInstance(EvPointsDao evPointsDao) {
    return new EvPointLocalDataSource(evPointsDao);
  }
}
