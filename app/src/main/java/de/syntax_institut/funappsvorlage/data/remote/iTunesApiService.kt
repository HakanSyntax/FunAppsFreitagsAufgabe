package de.syntax_institut.funappsvorlage.data.remote

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import de.syntax_institut.funappsvorlage.data.datamodels.SearchResult
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://itunes.apple.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface SearchApiService {

    @GET("search")
    suspend fun getResults(
        @Query("term") term: String,): SearchResult
}

object SearchApi {
    val retrofitService: SearchApiService by lazy { retrofit.create(SearchApiService::class.java) }
}
