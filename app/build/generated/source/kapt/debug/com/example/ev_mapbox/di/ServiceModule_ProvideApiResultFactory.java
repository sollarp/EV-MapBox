package com.example.ev_mapbox.di;

import com.example.ev_mapbox.data.OpenMapApi;
import com.example.ev_mapbox.domain.model.EvPointDetails;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import java.util.List;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.Nullable;

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
public final class ServiceModule_ProvideApiResultFactory implements Factory<Object> {
  private final Provider<OpenMapApi> openMapApiProvider;

  private final Provider<Continuation<? super List<EvPointDetails>>> continuationProvider;

  public ServiceModule_ProvideApiResultFactory(Provider<OpenMapApi> openMapApiProvider,
      Provider<Continuation<? super List<EvPointDetails>>> continuationProvider) {
    this.openMapApiProvider = openMapApiProvider;
    this.continuationProvider = continuationProvider;
  }

  @Override
  @Nullable
  public Object get() {
    return provideApiResult(openMapApiProvider.get(), continuationProvider.get());
  }

  public static ServiceModule_ProvideApiResultFactory create(
      Provider<OpenMapApi> openMapApiProvider,
      Provider<Continuation<? super List<EvPointDetails>>> continuationProvider) {
    return new ServiceModule_ProvideApiResultFactory(openMapApiProvider, continuationProvider);
  }

  @Nullable
  public static Object provideApiResult(OpenMapApi openMapApi,
      Continuation<? super List<EvPointDetails>> continuation) {
    return ServiceModule.INSTANCE.provideApiResult(openMapApi, continuation);
  }
}
