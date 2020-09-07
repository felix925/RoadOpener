package jp.making.felix.roadopener.util

import com.github.mikephil.charting.formatter.ValueFormatter

class PieChartFormatter : ValueFormatter() {
    override fun getFormattedValue(value: Float): String {
        return value.toInt().toString()
    }
}