package com.example.fetch_coding_challenge

import com.example.fetch_coding_challenge.model.ListData

class MainPresenter(
    private val view: MainContract.View?,
    private var interactor: MainContract.Interactor?
) :
    MainContract.Presenter, MainContract.InteractorOutput {
    override fun onViewCreated() {
        interactor?.getData(this)
    }

    override fun dataFetched(listData: List<ListData>) {
        val sortedList = listData.filter { !it.name.isNullOrBlank() }
            .sortedWith(
                compareBy(
                    { it.listId },
                    { it.name?.filter { nameChar -> nameChar.isDigit() }?.toInt() })
            )

        view?.displayList(FetchAdapter(sortedList))
    }

    override fun dataFetchFail(failMessage: String) {
        view?.displayError(failMessage)
    }

    override fun onDestroy() {
        interactor = null
    }

}