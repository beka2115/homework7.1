package com.example.homework71.data.base



import com.example.homework71.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import java.io.IOException

abstract class BaseRepository {
    protected fun <T> doRequest(response : suspend ()-> T )= flow{
        emit(Resource.Loading())
        try {
            val data = response()
            emit(Resource.Success(data))
        }catch (ioException: IOException){
            emit(Resource.Error(ioException.localizedMessage?:"Unknown exception"))
        }
    }.flowOn(Dispatchers.IO)
}

