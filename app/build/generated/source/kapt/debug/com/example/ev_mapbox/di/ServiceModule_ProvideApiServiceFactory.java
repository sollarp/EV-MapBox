package com.example.ev_mapbox.di;

import com.example.ev_mapbox.data.OpenMapApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class ServiceModule_ProvideApiServiceFactory implements Factory<OpenMapApi> {
  private final Provider<Retrofit> retrofitProvider;

  public ServiceModule_ProvideApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public OpenMapApi get() {
    return provideApiService(retrofitProvider.get());
  }

  public static ServiceModule_ProvideApiServiceFactory create(Provider<Retrofit> retrofitProvider) {
    return new ServiceModule_ProvideApiServiceFactory(retrofitProvider);
  }

  public static OpenMapApi provideApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideApiService(retrofit));
  }
}
