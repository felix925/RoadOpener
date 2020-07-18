package jp.making.felix.roadopener.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jp.making.felix.roadopener.viewModel.RoadListViewModel

@AndroidEntryPoint
class RoadListFragment : Fragment() {
    private val roadListViewModel: RoadListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roadListViewModel.hash()
    }

}