package com.example.ev_mapbox.di;

import android.content.Context;
import com.example.ev_mapbox.data.local.EvPointDataBase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DatabaseModule_ProvideDataBaseFactory implements Factory<EvPointDataBase> {
  private final Provider<Context> appContextProvider;

  public DatabaseModule_ProvideDataBaseFactory(Provider<Context> appContextProvider) {
    this.appContextProvider = appContextProvider;
  }

  @Override
  public EvPointDataBase get() {
    return provideDataBase(appContextProvider.get());
  }

  public static DatabaseModule_ProvideDataBaseFactory create(Provider<Context> appContextProvider) {
    return new DatabaseModule_ProvideDataBaseFactory(appContextProvider);
  }

  public static EvPointDataBase provideDataBase(Context appContext) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideDataBase(appContext));
  }
}
