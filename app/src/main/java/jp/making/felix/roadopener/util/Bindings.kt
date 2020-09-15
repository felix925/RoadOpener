package jp.making.felix.roadopener.util

import android.graphics.Color
import androidx.databinding.BindingAdapter
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

@BindingAdapter(value = ["bind:complete", "bind:notComplete"])
fun setPieData(view: PieChart, complete: Int, notComplete: Int) {
    val color = listOf(Color.rgb(150, 240, 150), Color.GRAY)
    val pieDataSet = PieDataSet(
        listOf(
            PieEntry(complete.toFloat(), "完了"),
            PieEntry(notComplete.toFloat(), "未完了")
        ), ""
    )
    val desc = Description()
    desc.text = ""

    pieDataSet.sliceSpace = 5f
    pieDataSet.selectionShift = 1f
    pieDataSet.colors = color
    pieDataSet.valueTextSize = 15f
    pieDataSet.setDrawValues(true)
    pieDataSet.valueFormatter = PieChartFormatter()
    view.setDrawEntryLabels(false)
    view.description = desc
    view.data = PieData(pieDataSet)
    view.animateX(500)
    view.invalidate()
}