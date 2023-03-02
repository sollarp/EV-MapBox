package com.example.call_mapbox_api.ui.searchscreen;

import com.example.ev_mapbox.domain.ISearchListUseCase;
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
public final class SearchListViewModel_Factory implements Factory<SearchListViewModel> {
  private final Provider<ISearchListUseCase> searchListUseCaseProvider;

  public SearchListViewModel_Factory(Provider<ISearchListUseCase> searchListUseCaseProvider) {
    this.searchListUseCaseProvider = searchListUseCaseProvider;
  }

  @Override
  public SearchListViewModel get() {
    return newInstance(searchListUseCaseProvider.get());
  }

  public static SearchListViewModel_Factory create(
      Provider<ISearchListUseCase> searchListUseCaseProvider) {
    return new SearchListViewModel_Factory(searchListUseCaseProvider);
  }

  public static SearchListViewModel newInstance(ISearchListUseCase searchListUseCase) {
    return new SearchListViewModel(searchListUseCase);
  }
}
