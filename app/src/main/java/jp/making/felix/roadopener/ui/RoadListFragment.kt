package jp.making.felix.roadopener.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint
import jp.making.felix.roadopener.R
import jp.making.felix.roadopener.databinding.FragmentListBinding
import jp.making.felix.roadopener.viewModel.RoadListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RoadListFragment : Fragment(R.layout.fragment_list) {
    private val viewModel: RoadListViewModel by viewModels()
    lateinit var binding: FragmentListBinding
    lateinit var roadController: RoadController
    lateinit var pathController: PathController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        // RoadController {}で書けるが、可読性のためにあえて(onClick{})を用いる。
        roadController = RoadController(onClick = { road ->
            Log.d("some", "msg")
        })
        pathController = PathController(onClick = {
            viewModel.hash()
        })

        binding.apply {
            this.lifecycleOwner = viewLifecycleOwner
            roadRecycler.setController(roadController)
            pathRecycler.setController(pathController)
            fab.setOnClickListener { viewModel.hash() }
        }

        viewModel.roadData.observe(viewLifecycleOwner) {
            roadController.setData(it)
        }
        viewModel.pathData.observe(viewLifecycleOwner) {
            pathController.setData(it)
        }
    }

}