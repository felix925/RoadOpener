package jp.making.felix.roadopener.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import jp.making.felix.roadopener.R
import jp.making.felix.roadopener.databinding.FragmentListBinding
import jp.making.felix.roadopener.util.ClickRoadListener
import jp.making.felix.roadopener.util.EpoxyRoadController
import jp.making.felix.roadopener.viewModel.RoadListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RoadListFragment : Fragment(R.layout.fragment_list), ClickRoadListener {
    private val viewModel: RoadListViewModel by viewModels()
    lateinit var binding: FragmentListBinding
    lateinit var controller: EpoxyRoadController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        controller = EpoxyRoadController(
            lifecycleOwner = viewLifecycleOwner,
            viewModel = viewModel,
            clickRoad = this@RoadListFragment
        )

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            roadRecycler.layoutManager = GridLayoutManager(context, 2)
            vm = viewModel
            roadRecycler.setController(controller)
            fab.setOnClickListener {
                viewModel.insertRoad(roadTitleInput.text.toString())
                roadTitleInput.setText("")
            }
        }

        viewModel.inputErrorText.observe(viewLifecycleOwner) {
            binding.roadTitleField.error = it
        }

        viewModel.refreshRoadData.observe(viewLifecycleOwner) {
            controller.setData(it)
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.refreshAllRoadData()
    }

    override fun onClick(roadId: Int) {
        val action = RoadListFragmentDirections.actionListToDetail(roadId)
        findNavController().navigate(action)
    }
}