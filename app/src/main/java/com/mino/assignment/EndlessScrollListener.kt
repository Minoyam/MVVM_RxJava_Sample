package com.mino.assignment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

open class EndlessScrollListener(
    private val manager: LinearLayoutManager,
    private val lastItemListener: (Int) -> Unit

) : RecyclerView.OnScrollListener() {

    private var page = 1
    private var visibleItemCount: Int = 0
    private var totalItemCount: Int = 0
    private var pastVisibleItems: Int = 0
    var searchBoolean = true

    fun clear() {
        page = 1
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy < 0)
            return

        visibleItemCount = manager.childCount
        totalItemCount = manager.itemCount
        pastVisibleItems = manager.findFirstVisibleItemPosition()
            if ((visibleItemCount + pastVisibleItems >= totalItemCount) && searchBoolean) {
                page++
                lastItemListener(page)
        }
    }
}