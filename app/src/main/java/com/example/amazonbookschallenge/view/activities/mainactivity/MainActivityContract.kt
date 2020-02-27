package com.example.amazonbookschallenge.view.activities.mainactivity

import com.example.amazonbookschallenge.model.amazonResponse.AmazonResult

interface MainActivityContract
{
    interface View
    {
    }

    interface Presenter
    {
        fun attatchView(view : MainActivityContract.View)
        //fun requestNewList(): ArrayList<AmazonResult>

    }
}