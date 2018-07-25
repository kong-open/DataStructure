package xyz.kongzz.datastructure.common.view.activity.sort;

import android.widget.Button;
import android.widget.TextView;

import com.github.anzewei.parallaxbacklayout.ParallaxBack;

import butterknife.BindView;
import butterknife.OnClick;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.PresenterToolbarActivity;
import xyz.kongzz.datastructure.factory.presenter.sort.QuickSortContract;
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

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_quick_sort;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        setTitle("快速排序");
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
    protected QuickSortContract.Presenter initPresenter() {
        return new QuickSortPresenter(this);
    }
}
