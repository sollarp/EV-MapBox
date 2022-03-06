package com.example.evmapbox.domain.use_case

import com.example.evmapbox.data.remote.OpenMapDto.toEvPointItems
import com.example.evmapbox.domain.model.EvPointItems
import com.example.evmapbox.domain.repository.EvMapRepo
import com.example.evmapbox.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEvPointUseCase @Inject constructor(
    private val evMapRepo: EvMapRepo
) {
    operator fun invoke(): Flow<Resource<List<EvPointItems>>> = flow {
        try {
            emit(Resource.Loading<List<EvPointItems>>())
            val coins = evMapRepo.getResponse().map { it.toEvPointItems() }
            emit(Resource.Success<List<EvPointItems>>(coins))
        } catch(e: HttpException) {
            emit(Resource.Error<List<EvPointItems>>(e.localizedMessage ?: "An unexpected error occured"))
        } catch(e: IOException) {
            emit(Resource.Error<List<EvPointItems>>("Couldn't reach server. Check your internet connection."))
        }
    }
}