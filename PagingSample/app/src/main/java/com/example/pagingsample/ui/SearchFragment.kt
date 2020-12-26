package com.example.pagingsample.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pagingsample.databinding.FragmentSearchBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class SearchFragment: DaggerFragment() {

    companion object{
        const val TAG = "SearchFragment"
    }

    private var _vBinding: FragmentSearchBinding? = null
    private val vBinding
        get() = _vBinding!!

    @Inject lateinit var factory: ViewModelProviderFactory
    private val mViewModel by lazy{ViewModelProvider(requireActivity(), factory).get(MainViewModel::class.java)}
    private val iAdapter by lazy{ImageAdapter(requireContext())}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _vBinding = FragmentSearchBinding.inflate(inflater, container, false)
        return vBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setAdapter()
        setSearchView()
        setObserver()
    }

    private fun setAdapter(){
        vBinding.rvImages.apply{
            adapter = iAdapter
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun setSearchView(){
        vBinding.sv.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d(TAG, "onQueryTextSubmit()...")
                mViewModel.dispose()
                mViewModel.query(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    private fun setObserver(){
        mViewModel.liveImagePagedListWrapper.observe(viewLifecycleOwner) {
            Log.d(TAG, "new LiveData<PagedList<Image>> created: $it")
            it.observe(viewLifecycleOwner) { pagedList ->
                iAdapter.submitList(pagedList)
            }
        }
    }
}

