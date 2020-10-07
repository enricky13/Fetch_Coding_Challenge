package com.example.fetch_coding_challenge

import com.example.fetch_coding_challenge.model.ListData

interface MainContract {
    interface View {
        fun displayList(adapter: FetchAdapter)
        fun displayError(message: String)
    }

    interface Presenter {
        fun onViewCreated()
        fun onDestroy()
    }

    interface Interactor {
        fun getData(interactorOutput: InteractorOutput)
    }

    interface InteractorOutput {
        fun dataFetched(listData: List<ListData>)
        fun dataFetchFail(failMessage: String)
    }
}