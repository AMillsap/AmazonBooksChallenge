package com.example.amazonbookschallenge.datasource.remote

import com.example.amazonbookschallenge.model.amazonResponse.AmazonResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface AmazonService
{
    companion object{
        fun getAmazonCallService() =
            RetrofitHelper.retrofitInstance.create(AmazonService::class.java)
    }

    @GET("books.json")
    fun getAmazonList()
            : Deferred<ArrayList<AmazonResult>>
}