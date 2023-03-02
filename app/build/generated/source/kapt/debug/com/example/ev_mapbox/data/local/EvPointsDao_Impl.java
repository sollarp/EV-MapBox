package com.example.ev_mapbox.data.local;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.ev_mapbox.data.remote.dto.AddressInfo;
import com.example.ev_mapbox.data.remote.dto.Connections;
import java.lang.Boolean;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class EvPointsDao_Impl implements EvPointsDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<EvPointsEntity> __insertionAdapterOfEvPointsEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAll;

  public EvPointsDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfEvPointsEntity = new EntityInsertionAdapter<EvPointsEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `evPointsDb` (`ID`,`data_last_verified`,`data_provider_id`,`data_quality_level`,`data_created`,`data_last_status_update`,`number_of_points`,`is_recently_verified`,`operator_id`,`status_type_id`,`submission_status_type_id`,`uuid`,`usage_cost`,`usage_type_id`,`connection`,`address_info`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EvPointsEntity value) {
        if (value.getID() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getID());
        }
        if (value.getDateLastVerified() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDateLastVerified());
        }
        if (value.getDataProviderID() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, value.getDataProviderID());
        }
        if (value.getDataQualityLevel() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getDataQualityLevel());
        }
        if (value.getDateCreated() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDateCreated());
        }
        if (value.getDateLastStatusUpdate() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getDateLastStatusUpdate());
        }
        if (value.getNumberOfPoints() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getNumberOfPoints());
        }
        final Integer _tmp = value.getIsRecentlyVerified() == null ? null : (value.getIsRecentlyVerified() ? 1 : 0);
        if (_tmp == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindLong(8, _tmp);
        }
        if (value.getOperatorID() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindLong(9, value.getOperatorID());
        }
        if (value.getStatusTypeID() == null) {
          stmt.bindNull(10);
        } else {
          stmt.bindLong(10, value.getStatusTypeID());
        }
        if (value.getSubmissionStatusTypeID() == null) {
          stmt.bindNull(11);
        } else {
          stmt.bindLong(11, value.getSubmissionStatusTypeID());
        }
        if (value.getUUID() == null) {
          stmt.bindNull(12);
        } else {
          stmt.bindString(12, value.getUUID());
        }
        if (value.getUsageCost() == null) {
          stmt.bindNull(13);
        } else {
          stmt.bindString(13, value.getUsageCost());
        }
        if (value.getUsageTypeID() == null) {
          stmt.bindNull(14);
        } else {
          stmt.bindLong(14, value.getUsageTypeID());
        }
        final String _tmp_1 = ConnectionConverter.INSTANCE.fromArrayList(value.getConnections());
        if (_tmp_1 == null) {
          stmt.bindNull(15);
        } else {
          stmt.bindString(15, _tmp_1);
        }
        final String _tmp_2 = AddressConverter.INSTANCE.fromArrayList(value.getAddressInfo());
        if (_tmp_2 == null) {
          stmt.bindNull(16);
        } else {
          stmt.bindString(16, _tmp_2);
        }
      }
    };
    this.__preparedStmtOfDeleteAll = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM evPointsDb";
        return _query;
      }
    };
  }

  @Override
  public void insert(final List<EvPointsEntity> evPointDetails) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEvPointsEntity.insert(evPointDetails);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Object deleteAll(final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAll.acquire();
        __db.beginTransaction();
        try {
          _stmt.executeUpdateDelete();
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
          __preparedStmtOfDeleteAll.release(_stmt);
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<EvPointsEntity>> getEvPoints() {
    final String _sql = "SELECT * FROM evPointsDb";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"evPointsDb"}, new Callable<List<EvPointsEntity>>() {
      @Override
      public List<EvPointsEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfID = CursorUtil.getColumnIndexOrThrow(_cursor, "ID");
          final int _cursorIndexOfDateLastVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "data_last_verified");
          final int _cursorIndexOfDataProviderID = CursorUtil.getColumnIndexOrThrow(_cursor, "data_provider_id");
          final int _cursorIndexOfDataQualityLevel = CursorUtil.getColumnIndexOrThrow(_cursor, "data_quality_level");
          final int _cursorIndexOfDateCreated = CursorUtil.getColumnIndexOrThrow(_cursor, "data_created");
          final int _cursorIndexOfDateLastStatusUpdate = CursorUtil.getColumnIndexOrThrow(_cursor, "data_last_status_update");
          final int _cursorIndexOfNumberOfPoints = CursorUtil.getColumnIndexOrThrow(_cursor, "number_of_points");
          final int _cursorIndexOfIsRecentlyVerified = CursorUtil.getColumnIndexOrThrow(_cursor, "is_recently_verified");
          final int _cursorIndexOfOperatorID = CursorUtil.getColumnIndexOrThrow(_cursor, "operator_id");
          final int _cursorIndexOfStatusTypeID = CursorUtil.getColumnIndexOrThrow(_cursor, "status_type_id");
          final int _cursorIndexOfSubmissionStatusTypeID = CursorUtil.getColumnIndexOrThrow(_cursor, "submission_status_type_id");
          final int _cursorIndexOfUUID = CursorUtil.getColumnIndexOrThrow(_cursor, "uuid");
          final int _cursorIndexOfUsageCost = CursorUtil.getColumnIndexOrThrow(_cursor, "usage_cost");
          final int _cursorIndexOfUsageTypeID = CursorUtil.getColumnIndexOrThrow(_cursor, "usage_type_id");
          final int _cursorIndexOfConnections = CursorUtil.getColumnIndexOrThrow(_cursor, "connection");
          final int _cursorIndexOfAddressInfo = CursorUtil.getColumnIndexOrThrow(_cursor, "address_info");
          final List<EvPointsEntity> _result = new ArrayList<EvPointsEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final EvPointsEntity _item;
            final Integer _tmpID;
            if (_cursor.isNull(_cursorIndexOfID)) {
              _tmpID = null;
            } else {
              _tmpID = _cursor.getInt(_cursorIndexOfID);
            }
            final String _tmpDateLastVerified;
            if (_cursor.isNull(_cursorIndexOfDateLastVerified)) {
              _tmpDateLastVerified = null;
            } else {
              _tmpDateLastVerified = _cursor.getString(_cursorIndexOfDateLastVerified);
            }
            final Integer _tmpDataProviderID;
            if (_cursor.isNull(_cursorIndexOfDataProviderID)) {
              _tmpDataProviderID = null;
            } else {
              _tmpDataProviderID = _cursor.getInt(_cursorIndexOfDataProviderID);
            }
            final Integer _tmpDataQualityLevel;
            if (_cursor.isNull(_cursorIndexOfDataQualityLevel)) {
              _tmpDataQualityLevel = null;
            } else {
              _tmpDataQualityLevel = _cursor.getInt(_cursorIndexOfDataQualityLevel);
            }
            final String _tmpDateCreated;
            if (_cursor.isNull(_cursorIndexOfDateCreated)) {
              _tmpDateCreated = null;
            } else {
              _tmpDateCreated = _cursor.getString(_cursorIndexOfDateCreated);
            }
            final String _tmpDateLastStatusUpdate;
            if (_cursor.isNull(_cursorIndexOfDateLastStatusUpdate)) {
              _tmpDateLastStatusUpdate = null;
            } else {
              _tmpDateLastStatusUpdate = _cursor.getString(_cursorIndexOfDateLastStatusUpdate);
            }
            final Integer _tmpNumberOfPoints;
            if (_cursor.isNull(_cursorIndexOfNumberOfPoints)) {
              _tmpNumberOfPoints = null;
            } else {
              _tmpNumberOfPoints = _cursor.getInt(_cursorIndexOfNumberOfPoints);
            }
            final Boolean _tmpIsRecentlyVerified;
            final Integer _tmp;
            if (_cursor.isNull(_cursorIndexOfIsRecentlyVerified)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(_cursorIndexOfIsRecentlyVerified);
            }
            _tmpIsRecentlyVerified = _tmp == null ? null : _tmp != 0;
            final Integer _tmpOperatorID;
            if (_cursor.isNull(_cursorIndexOfOperatorID)) {
              _tmpOperatorID = null;
            } else {
              _tmpOperatorID = _cursor.getInt(_cursorIndexOfOperatorID);
            }
            final Integer _tmpStatusTypeID;
            if (_cursor.isNull(_cursorIndexOfStatusTypeID)) {
              _tmpStatusTypeID = null;
            } else {
              _tmpStatusTypeID = _cursor.getInt(_cursorIndexOfStatusTypeID);
            }
            final Integer _tmpSubmissionStatusTypeID;
            if (_cursor.isNull(_cursorIndexOfSubmissionStatusTypeID)) {
              _tmpSubmissionStatusTypeID = null;
            } else {
              _tmpSubmissionStatusTypeID = _cursor.getInt(_cursorIndexOfSubmissionStatusTypeID);
            }
            final String _tmpUUID;
            if (_cursor.isNull(_cursorIndexOfUUID)) {
              _tmpUUID = null;
            } else {
              _tmpUUID = _cursor.getString(_cursorIndexOfUUID);
            }
            final String _tmpUsageCost;
            if (_cursor.isNull(_cursorIndexOfUsageCost)) {
              _tmpUsageCost = null;
            } else {
              _tmpUsageCost = _cursor.getString(_cursorIndexOfUsageCost);
            }
            final Integer _tmpUsageTypeID;
            if (_cursor.isNull(_cursorIndexOfUsageTypeID)) {
              _tmpUsageTypeID = null;
            } else {
              _tmpUsageTypeID = _cursor.getInt(_cursorIndexOfUsageTypeID);
            }
            final List<Connections> _tmpConnections;
            final String _tmp_1;
            if (_cursor.isNull(_cursorIndexOfConnections)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getString(_cursorIndexOfConnections);
            }
            _tmpConnections = ConnectionConverter.INSTANCE.fromString(_tmp_1);
            final AddressInfo _tmpAddressInfo;
            final String _tmp_2;
            if (_cursor.isNull(_cursorIndexOfAddressInfo)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getString(_cursorIndexOfAddressInfo);
            }
            _tmpAddressInfo = AddressConverter.INSTANCE.fromString(_tmp_2);
            _item = new EvPointsEntity(_tmpID,_tmpDateLastVerified,_tmpDataProviderID,_tmpDataQualityLevel,_tmpDateCreated,_tmpDateLastStatusUpdate,_tmpNumberOfPoints,_tmpIsRecentlyVerified,_tmpOperatorID,_tmpStatusTypeID,_tmpSubmissionStatusTypeID,_tmpUUID,_tmpUsageCost,_tmpUsageTypeID,_tmpConnections,_tmpAddressInfo);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
