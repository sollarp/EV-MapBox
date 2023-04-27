package com.soldevcode.evmapbox.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EvPointLocalDataSource @Inject constructor(
    private val evPointsDao: EvPointsDao
) {

    fun fetchPoints(): Flow<List<EvPointsEntity>> {
        return evPointsDao.getEvPoints()
    }

    fun updatePoints(evPointsDao: List<EvPointsEntity>) {
        this.evPointsDao.insert(evPointsDao)
    }
}
