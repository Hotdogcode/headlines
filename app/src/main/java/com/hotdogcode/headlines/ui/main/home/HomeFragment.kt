package com.hotdogcode.headlines.ui.main.home


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.hotdogcode.headlines.R
import com.hotdogcode.headlines.adapters.NewsListAdapter
import com.hotdogcode.headlines.data.model.api.News
import com.hotdogcode.headlines.ui.splash.SplashViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.Collections.addAll

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    lateinit var viewModel: HomeViewModel
    lateinit var adapter:NewsListAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NewsListAdapter()
        val layoutManager :RecyclerView.LayoutManager = LinearLayoutManager(activity)
        newsList.layoutManager = layoutManager
        newsList.adapter = adapter
        viewModel.t.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
//        viewModel.fetch()
    }
}
