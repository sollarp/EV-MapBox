package com.example.evmapbox.domain.use_case

import com.example.evmapbox.domain.model.EvPointItems
import com.example.evmapbox.domain.repository.EvMapRepo
import com.example.evmapbox.util.Resource
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetEvItemsUseCase @Inject constructor(
    private val evMapRepo: EvMapRepo
) {
    operator fun invoke(coinId: String):
            kotlinx.coroutines.flow.Flow<Resource<List<EvPointItems>>> = flow {
        try {
            emit(Resource.Loading())
            //val coin = evMapRepo.getResponse()
            emit(Resource.Success())
        } catch(e: HttpException) {
            emit(Resource.Error())
        } catch(e: IOException) {
            emit(Resource.Error())
        }
    }

}