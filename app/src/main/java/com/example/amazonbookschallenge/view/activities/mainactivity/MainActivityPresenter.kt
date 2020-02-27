package com.example.amazonbookschallenge.view.activities.mainactivity

import com.example.amazonbookschallenge.datasource.remote.AmazonService
import com.example.amazonbookschallenge.model.amazonResponse.AmazonResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivityPresenter: MainActivityContract.Presenter
{
    lateinit var viewContract : MainActivityContract.View

    override fun attatchView(view: MainActivityContract.View)
    {
        viewContract = view
    }

    override fun requestNewList() : ArrayList<AmazonResult>
    {
        val service = AmazonService.getAmazonCallService()
        var response = ArrayList<AmazonResult>()
        CoroutineScope(Dispatchers.IO).launch {
            val amazonRequest = service.getAmazonList()
            withContext(Dispatchers.Main) {
                response = amazonRequest.await()
            }
        }
        return response
    }
}