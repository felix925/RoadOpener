package jp.making.felix.roadopener.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import jp.making.felix.roadopener.R
import jp.making.felix.roadopener.viewModel.RoadListViewModel

@AndroidEntryPoint
class RoadListFragment : Fragment() {
    private val roadListViewModel: RoadListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        roadListViewModel.hash()
    }

}