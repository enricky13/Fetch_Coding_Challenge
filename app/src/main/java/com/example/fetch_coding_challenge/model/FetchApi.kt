package com.example.fetch_coding_challenge.model

import retrofit2.Call
import retrofit2.http.GET

interface FetchApi {
    @GET(FETCH_BASE)
    fun getFetchData(): Call<List<ListData>>

    companion object {
        const val FETCH_BASE = "hiring.json"
    }
}