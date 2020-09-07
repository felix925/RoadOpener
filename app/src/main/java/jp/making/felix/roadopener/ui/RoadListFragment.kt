package jp.making.felix.roadopener.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import com.airbnb.epoxy.EpoxyController
import dagger.hilt.android.AndroidEntryPoint
import jp.making.felix.roadopener.ModelsRoadBindingModelBuilder
import jp.making.felix.roadopener.ModelsRoadBindingModel_
import jp.making.felix.roadopener.R
import jp.making.felix.roadopener.databinding.FragmentListBinding
import jp.making.felix.roadopener.viewModel.RoadListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class RoadListFragment : Fragment(R.layout.fragment_list) {
    private val viewModel: RoadListViewModel by viewModels()
    lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        binding.roadRecycler.layoutManager = GridLayoutManager(context, 2)
        binding.fab.setOnClickListener {
            viewModel.insertRoad()
        }

        /***
         *         Controllerを使わないで書いてみた
         *         クラスに分けると可読性が上がる。なぜなら、controller.setData(it)でデータを追加できるためだ。
         */
        viewModel.roadData.observe(viewLifecycleOwner) {
            binding.roadRecycler.withModels {
                it.forEach {
                    this.modelsRoad {
                        id(it.id)
                        title(it.title)
                        complete(it.complete)
                        notComplete(it.pathCount - it.complete)
                        onClick { _ ->
                            viewModel.insertPath(it)
                            Log.d("Click", it.id.toString())
                        }
                    }
                }
            }
        }
    }
}

inline fun EpoxyController.modelsRoad(modelInitializer: ModelsRoadBindingModelBuilder.() -> Unit) {
    ModelsRoadBindingModel_().apply {
        modelInitializer()
    }
        .addTo(this)
}