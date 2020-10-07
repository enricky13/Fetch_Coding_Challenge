package com.example.fetch_coding_challenge.model

import com.example.fetch_coding_challenge.MainContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainInteractor : MainContract.Interactor {

    override fun getData(interactorOutput: MainContract.InteractorOutput) {
        RetrofitSingleton.getService
            .getFetchData()
            .enqueue(object : Callback<List<ListData>> {
                override fun onResponse(
                    call: Call<List<ListData>>,
                    response: Response<List<ListData>>
                ) {
                    response.body()?.let {
                        interactorOutput.dataFetched(it)
                    }
                }

                override fun onFailure(call: Call<List<ListData>>, t: Throwable) {
                    interactorOutput.dataFetchFail(t.message ?: "No Failure Identified")
                }
            })
    }

}