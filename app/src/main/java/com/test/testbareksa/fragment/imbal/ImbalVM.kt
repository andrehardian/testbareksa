package com.test.testbareksa.fragment.imbal

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.google.android.material.tabs.TabLayout
import com.test.testbareksa.R
import com.test.testbareksa.adapter.recycler.AdapterRecycler
import com.test.testbareksa.databinding.ImbalFragmentBinding
import com.test.testbareksa.utils.UtilsDummy
import javax.inject.Inject

class ImbalVM @Inject constructor(val utilsDummy: UtilsDummy) : ViewModel(),
    TabLayout.BaseOnTabSelectedListener<TabLayout.Tab> {
    private lateinit var context: Context
    private lateinit var dataBinding: ImbalFragmentBinding

    fun setChart(lineChart: LineChart) {
        val dataSets = ArrayList<ILineDataSet>()
        val labelMonth: MutableList<String> = ArrayList()
        labelMonth.add("Jul 19")
        labelMonth.add("Okt 19")
        labelMonth.add("Jan 20")
        labelMonth.add("Apr 20")
        labelMonth.add("Jul 20")

        dataSets.add(makeDataSet(3, ContextCompat.getColor(context, R.color.green2)))
        dataSets.add(makeDataSet(2, ContextCompat.getColor(context, R.color.magenta)))
        dataSets.add(makeDataSet(1, ContextCompat.getColor(context, R.color.green1)))

        val data = LineData(dataSets)

        val xAxisFormatter: ValueFormatter =
            IndexAxisValueFormatter(labelMonth)

        val xAxis: XAxis = lineChart.getXAxis()
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.granularity = 1f
        xAxis.valueFormatter = xAxisFormatter

        lineChart.setData(data)
        lineChart.legend.isEnabled = false
    }

    private fun makeDataSet(up: Int, color: Int): ILineDataSet {
        val values = ArrayList<Entry>()
        for (pos in 0..4) {
            values.add(Entry(pos.toFloat(), (pos * pos * up).toFloat()))
        }
        val set: LineDataSet

        set = LineDataSet(values, "")

        set.setDrawIcons(false)
        set.color = color
        set.setCircleColor(color)
        set.lineWidth = 1.2f
        set.circleRadius = 5f
        set.setDrawCircleHole(true)
        set.valueTextSize = 9f
        set.setDrawFilled(false)
        return set
    }

    fun init(dataBinding: ImbalFragmentBinding, context: Context) {
        this.context = context
        this.dataBinding = dataBinding
        setChart(dataBinding.lineChart)
        setTab(dataBinding.tabData)
        setupRecycler()
    }

    private fun setTab(tabData: TabLayout) {
        var tabNames = context.resources.getStringArray(R.array.tab_data)
        for (name in tabNames) {
            var tab = tabData.newTab()
            tab.setText(name)
            tabData.addTab(tab)
        }
        tabData.addOnTabSelectedListener(this)

    }

    override fun onTabSelected(p0: TabLayout.Tab?) {
        setupRecycler()
    }

    private fun setupRecycler() {
        var listData = utilsDummy.prepareDummydata(context)
        dataBinding.recycler.adapter = AdapterRecycler(listData = listData)
    }

    override fun onTabReselected(p0: TabLayout.Tab?) {

    }

    override fun onTabUnselected(p0: TabLayout.Tab?) {
    }


}