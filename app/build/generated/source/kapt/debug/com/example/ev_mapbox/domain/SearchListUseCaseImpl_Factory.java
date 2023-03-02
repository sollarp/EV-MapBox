package com.example.ev_mapbox.domain;

import com.example.ev_mapbox.data.repository.ISearchListRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class SearchListUseCaseImpl_Factory implements Factory<SearchListUseCaseImpl> {
  private final Provider<ISearchListRepository> searchListRepositoryProvider;

  private final Provider<CoroutineDispatcher> dispatcherProvider;

  public SearchListUseCaseImpl_Factory(Provider<ISearchListRepository> searchListRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    this.searchListRepositoryProvider = searchListRepositoryProvider;
    this.dispatcherProvider = dispatcherProvider;
  }

  @Override
  public SearchListUseCaseImpl get() {
    return newInstance(searchListRepositoryProvider.get(), dispatcherProvider.get());
  }

  public static SearchListUseCaseImpl_Factory create(
      Provider<ISearchListRepository> searchListRepositoryProvider,
      Provider<CoroutineDispatcher> dispatcherProvider) {
    return new SearchListUseCaseImpl_Factory(searchListRepositoryProvider, dispatcherProvider);
  }

  public static SearchListUseCaseImpl newInstance(ISearchListRepository searchListRepository,
      CoroutineDispatcher dispatcher) {
    return new SearchListUseCaseImpl(searchListRepository, dispatcher);
  }
}
