package com.slavetny.findphotos.presentation.screen.photosearch

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.slavetny.findphotos.R
import com.slavetny.findphotos.domain.extensions.observeNotNull
import com.slavetny.findphotos.domain.extensions.onDone
import com.slavetny.findphotos.presentation.adapter.HistoryPhotoAdapter
import com.slavetny.findphotos.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_photo_search.*
import org.koin.android.viewmodel.ext.android.viewModel

class PhotoSearchFragment :
    BaseFragment<PhotoSearchViewModel>(R.layout.fragment_photo_search) {

    override val viewModel: PhotoSearchViewModel by viewModel()
    private val adapter = HistoryPhotoAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        photoSearchField.onDone {
            viewModel.getPhotoByName(photoSearchField.text.toString())
        }

        observePhoto()
        observeHistoryPhoto()
        setupRecyclerView()
    }

    private fun observePhoto() {
        viewModel.photoLiveData.observeNotNull(viewLifecycleOwner) { photos ->
            if (photos.results.isNotEmpty()) {
                val photo = photos.results[0]

                viewModel.insertHistoryPhoto(photo.id, photo.urls.regular, photoSearchField.text.toString())
                viewModel.getAllHistoryPhoto()
            }
        }
    }

    private fun observeHistoryPhoto() {
        viewModel.historyPhotoLiveData.observeNotNull(viewLifecycleOwner) {
            adapter.attachData(it.asReversed())
        }
    }

    private fun setupRecyclerView() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
    }
}