package com.example.ev_mapbox.data.repository;

import com.example.ev_mapbox.data.local.EvPointLocalDataSource;
import com.example.ev_mapbox.data.remote.EvPointRemoteDataSource;
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
public final class SearchListRepositoryImpl_Factory implements Factory<SearchListRepositoryImpl> {
  private final Provider<EvPointRemoteDataSource> evPointDataSourceProvider;

  private final Provider<EvPointLocalDataSource> localDataSourceProvider;

  public SearchListRepositoryImpl_Factory(
      Provider<EvPointRemoteDataSource> evPointDataSourceProvider,
      Provider<EvPointLocalDataSource> localDataSourceProvider) {
    this.evPointDataSourceProvider = evPointDataSourceProvider;
    this.localDataSourceProvider = localDataSourceProvider;
  }

  @Override
  public SearchListRepositoryImpl get() {
    return newInstance(evPointDataSourceProvider.get(), localDataSourceProvider.get());
  }

  public static SearchListRepositoryImpl_Factory create(
      Provider<EvPointRemoteDataSource> evPointDataSourceProvider,
      Provider<EvPointLocalDataSource> localDataSourceProvider) {
    return new SearchListRepositoryImpl_Factory(evPointDataSourceProvider, localDataSourceProvider);
  }

  public static SearchListRepositoryImpl newInstance(EvPointRemoteDataSource evPointDataSource,
      EvPointLocalDataSource localDataSource) {
    return new SearchListRepositoryImpl(evPointDataSource, localDataSource);
  }
}
