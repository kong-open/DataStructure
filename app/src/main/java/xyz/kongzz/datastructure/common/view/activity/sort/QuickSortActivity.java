package xyz.kongzz.datastructure.common.view.activity.sort;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.github.anzewei.parallaxbacklayout.ParallaxBack;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.OnClick;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.PresenterToolbarActivity;
import xyz.kongzz.datastructure.common.view.adapter.RecycleViewAdapter;
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

    Integer sourceData[] = {23, 12, 13, 49, 44, 26, 17, 38};

    @BindView(R.id.tv_start)
    TextView tvStart;
    @BindView(R.id.tv_end)
    TextView tvEnd;
    @BindView(R.id.bt_do_sort)
    Button btDoSort;
    @BindView(R.id.rv_play)
    RecyclerView mRvPlay;

    ArrayList<Integer> mLists;

    RecycleViewAdapter mAdapter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_quick_sort;
    }

    @Override
    protected Presenter initPresenter() {
        return new QuickSortPresenter(this);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        setTitle("快速排序");
        mLists = new ArrayList<>(Arrays.asList(sourceData));

        mAdapter = new RecycleViewAdapter(mLists);
        LinearLayoutManager mManager = new LinearLayoutManager(this);
        mManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvPlay.setLayoutManager(mManager);
        mRvPlay.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        super.initData();
        tvStart.setText("快速排序之前： " + GsonUtil.GsonString(sourceData));
    }

    @OnClick(R.id.bt_do_sort)
    public void onBtDoSortClicked() {
        // 进行快速排序
        mPresenter.startQuickSort(sourceData);
    }

    @Override
    public void onStepQuickSort(int fromPosition, int toPosition) {
        Log.e("onStepQuickSort","fromPosition: " + fromPosition + ", toPosition: " + toPosition);
        mAdapter.notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onQuickSortDone(Integer[] sourceData) {
        tvEnd.setText("快速排序之后： " + GsonUtil.GsonString(sourceData));
    }
}
