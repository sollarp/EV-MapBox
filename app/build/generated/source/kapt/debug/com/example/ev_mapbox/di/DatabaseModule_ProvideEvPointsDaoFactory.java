package com.example.ev_mapbox.di;

import com.example.ev_mapbox.data.local.EvPointDataBase;
import com.example.ev_mapbox.data.local.EvPointsDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideEvPointsDaoFactory implements Factory<EvPointsDao> {
  private final Provider<EvPointDataBase> databaseProvider;

  public DatabaseModule_ProvideEvPointsDaoFactory(Provider<EvPointDataBase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public EvPointsDao get() {
    return provideEvPointsDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideEvPointsDaoFactory create(
      Provider<EvPointDataBase> databaseProvider) {
    return new DatabaseModule_ProvideEvPointsDaoFactory(databaseProvider);
  }

  public static EvPointsDao provideEvPointsDao(EvPointDataBase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideEvPointsDao(database));
  }
}
