package xyz.kongzz.datastructure.common.view.activity.sort;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;

import com.github.anzewei.parallaxbacklayout.ParallaxBack;
import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.PresenterToolbarActivity;
import xyz.kongzz.datastructure.common.view.helper.BarChartManager;
import xyz.kongzz.datastructure.factory.presenter.sort.QuickSortContract;
import xyz.kongzz.datastructure.factory.presenter.sort.QuickSortContract.Presenter;
import xyz.kongzz.datastructure.factory.presenter.sort.QuickSortPresenter;
import xyz.kongzz.datastructure.utils.GsonUtil;

/**
 * 这是快速排序
 */
@ParallaxBack(edge = ParallaxBack.Edge.LEFT, layout = ParallaxBack.Layout.PARALLAX)
public class QuickSortActivity extends PresenterToolbarActivity<QuickSortContract.Presenter>
        implements QuickSortContract.View {

    int sourceData[] = {23, 12, 13, 44, 65, 26, 17, 38, 59};

    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_end)
    TextView tvEnd;
    @BindView(R.id.bt_do_sort)
    Button btDoSort;
    @BindView(R.id.bc_play)
    BarChart mBarChart;

    BarChartManager mManager;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_quick_sort;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        setTitle("快速排序");

        //设置是否绘制chart边框的线
        mBarChart.setDrawBarShadow(false);
        //设置chart是否可以触摸
        mBarChart.setTouchEnabled(false);
        //设置是否可以拖拽
        mBarChart.setDragEnabled(false);
        //设置是否可以通过双击屏幕放大图表。默认是true
        mBarChart.setDoubleTapToZoomEnabled(false);
        //是否启用网格背景
        mBarChart.setDrawGridBackground(false);
        mBarChart.setHighlightPerDragEnabled(true);
        // no description text
        mBarChart.getDescription().setEnabled(false);
        //隐藏左边坐标轴横网格线
        mBarChart.getAxisLeft().setDrawGridLines(false);
        //隐藏右边坐标轴横网格线
        mBarChart.getAxisRight().setDrawGridLines(false);
        //隐藏X轴竖网格线
        mBarChart.getXAxis().setDrawGridLines(false);
        // 隐藏坐标轴
        mBarChart.getAxisRight().setEnabled(false);
        mBarChart.getAxisLeft().setEnabled(false);
        //取消legend
        mBarChart.getLegend().setEnabled(false);
        mBarChart.getXAxis().setEnabled(false);

        mManager = new BarChartManager(mBarChart);

        //设置x轴的数据
        ArrayList<Float> xValues = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            xValues.add((float) i);
        }

        //设置y轴的数据()
        List<List<Float>> yValues = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Float> yValue = new ArrayList<>();
            for (int j = 0; j <= 10; j++) {
                yValue.add((float) (Math.random() * 80));
            }
            yValues.add(yValue);
        }

        //颜色集合
        List<Integer> colours = new ArrayList<>();
        colours.add(Color.GREEN);
        colours.add(Color.BLUE);
        colours.add(Color.RED);
        colours.add(Color.CYAN);

        //线的名字集合
        List<String> names = new ArrayList<>();
        names.add("折线一");
        names.add("折线二");
        names.add("折线三");
        names.add("折线四");

        //创建多条折线的图表
        mManager.showBarChart(xValues, yValues.get(0), names.get(1), colours.get(3));
    }

    @Override
    protected void initData() {
        super.initData();
        tvStart.setText("快速排序之前： " + GsonUtil.GsonString(sourceData));
    }

    @OnClick(R.id.bt_do_sort)
    public void onViewClicked() {
        mPresenter.startQuickSort(sourceData);
    }

    @Override
    public void onQuickSortDone(int[] sourceData) {
        tvEnd.setText("快速排序之后： " + GsonUtil.GsonString(sourceData));
    }

    @Override
    protected Presenter initPresenter() {
        return new QuickSortPresenter(this);
    }
}
