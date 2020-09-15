package jp.making.felix.roadopener.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import jp.making.felix.roadopener.R
import jp.making.felix.roadopener.databinding.FragmentDetailBinding
import jp.making.felix.roadopener.util.ClickPathListener
import jp.making.felix.roadopener.util.EpoxyPathController
import jp.making.felix.roadopener.viewModel.DetailViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail), ClickPathListener {
    lateinit var binding: FragmentDetailBinding
    private val viewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val controller = EpoxyPathController(
            lifecycleOwner = this,
            viewModel = viewModel,
            roadId = args.roadId,
            clickRoad = this
        )
        binding = FragmentDetailBinding.bind(view)

        binding.apply {
            detailFab.setOnClickListener {
                viewModel.insertPath(args.roadId, pathTitleInput.text.toString())
                pathTitleInput.setText("")
            }
            pathRecycler.setController(controller = controller)
        }

        viewModel.inputErrorText.observe(viewLifecycleOwner) {
            binding.pathInputField.error = it
        }
    }

    override fun onClick(pathId: Int) {
        viewModel.updatePathData(roadId = args.roadId, pathId = pathId)
    }
}