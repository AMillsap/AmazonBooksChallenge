package com.example.amazonbookschallenge.view.activities.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amazonbookschallenge.R
import com.example.amazonbookschallenge.datasource.remote.AmazonService
import com.example.amazonbookschallenge.model.amazonResponse.AmazonResult
import com.example.amazonbookschallenge.view.adapters.AmazonAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity()
{
    val presenterContract = MainActivityPresenter() as MainActivityContract.Presenter
    val adapter by lazy { AmazonAdapter() }
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvAmazonList.layoutManager = LinearLayoutManager(this)
        rvAmazonList.adapter = adapter
        requestNewList()
    }

    fun requestNewList()
    {
        val service = AmazonService.getAmazonCallService()
        var response = ArrayList<AmazonResult>()
        CoroutineScope(Dispatchers.IO).launch {
            val amazonRequest = service.getAmazonList()
            withContext(Dispatchers.Main) {
                response = amazonRequest.await()
                adapter.addList(response)
            }
        }
    }
}
