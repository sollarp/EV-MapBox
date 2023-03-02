package com.example.ev_mapbox.data.local;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class EvPointDataBase_Impl extends EvPointDataBase {
  private volatile EvPointsDao _evPointsDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(3) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `evPointsDb` (`ID` INTEGER, `data_last_verified` TEXT NOT NULL, `data_provider_id` INTEGER, `data_quality_level` INTEGER, `data_created` TEXT, `data_last_status_update` TEXT, `number_of_points` INTEGER, `is_recently_verified` INTEGER, `operator_id` INTEGER, `status_type_id` INTEGER, `submission_status_type_id` INTEGER, `uuid` TEXT, `usage_cost` TEXT, `usage_type_id` INTEGER, `connection` TEXT NOT NULL, `address_info` TEXT NOT NULL, PRIMARY KEY(`ID`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '46536ad6010e0a28011fd4be6353e754')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `evPointsDb`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEvPointsDb = new HashMap<String, TableInfo.Column>(16);
        _columnsEvPointsDb.put("ID", new TableInfo.Column("ID", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("data_last_verified", new TableInfo.Column("data_last_verified", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("data_provider_id", new TableInfo.Column("data_provider_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("data_quality_level", new TableInfo.Column("data_quality_level", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("data_created", new TableInfo.Column("data_created", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("data_last_status_update", new TableInfo.Column("data_last_status_update", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("number_of_points", new TableInfo.Column("number_of_points", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("is_recently_verified", new TableInfo.Column("is_recently_verified", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("operator_id", new TableInfo.Column("operator_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("status_type_id", new TableInfo.Column("status_type_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("submission_status_type_id", new TableInfo.Column("submission_status_type_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("uuid", new TableInfo.Column("uuid", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("usage_cost", new TableInfo.Column("usage_cost", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("usage_type_id", new TableInfo.Column("usage_type_id", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("connection", new TableInfo.Column("connection", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvPointsDb.put("address_info", new TableInfo.Column("address_info", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEvPointsDb = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEvPointsDb = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoEvPointsDb = new TableInfo("evPointsDb", _columnsEvPointsDb, _foreignKeysEvPointsDb, _indicesEvPointsDb);
        final TableInfo _existingEvPointsDb = TableInfo.read(_db, "evPointsDb");
        if (! _infoEvPointsDb.equals(_existingEvPointsDb)) {
          return new RoomOpenHelper.ValidationResult(false, "evPointsDb(com.example.ev_mapbox.data.local.EvPointsEntity).\n"
                  + " Expected:\n" + _infoEvPointsDb + "\n"
                  + " Found:\n" + _existingEvPointsDb);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "46536ad6010e0a28011fd4be6353e754", "b95e56a750218fbfbe49fdd1592d46ef");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "evPointsDb");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `evPointsDb`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(EvPointsDao.class, EvPointsDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public EvPointsDao evPointsDao() {
    if (_evPointsDao != null) {
      return _evPointsDao;
    } else {
      synchronized(this) {
        if(_evPointsDao == null) {
          _evPointsDao = new EvPointsDao_Impl(this);
        }
        return _evPointsDao;
      }
    }
  }
}
