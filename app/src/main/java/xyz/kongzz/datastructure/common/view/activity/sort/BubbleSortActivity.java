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
import xyz.kongzz.datastructure.factory.presenter.sort.BubbleSortContract;
import xyz.kongzz.datastructure.factory.presenter.sort.BubbleSortPresenter;
import xyz.kongzz.datastructure.utils.GsonUtils;

/**
 * @author Kong
 * @date 2019-07-04
 * @desc
 */
@ParallaxBack(edge = ParallaxBack.Edge.LEFT, layout = ParallaxBack.Layout.PARALLAX)
public class BubbleSortActivity extends PresenterToolbarActivity<BubbleSortContract.Presenter>
        implements BubbleSortContract.View {

    Integer[] sourceData = {23, 12, 13, 49, 44, 26, 17, 38};

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
    protected BubbleSortPresenter initPresenter() {
        return new BubbleSortPresenter(this);
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_bubble_sort;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        setTitle("冒泡排序");
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
        tvStart.setText("冒泡排序之前： " + GsonUtils.GsonString(sourceData));
    }

    @OnClick(R.id.bt_do_sort)
    public void onBtDoSortClicked() {
        // 进行快速排序
        mPresenter.startBubbleSort(sourceData);
    }

    @Override
    public void onStepBubbleSort(int fromPosition, int toPosition) {
        Log.e("onStepBubbleSort","fromPosition: " + fromPosition + ", toPosition: " + toPosition);
        mAdapter.notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onBubbleSortDone() {
        tvEnd.setText("冒泡排序之后： " + GsonUtils.GsonString(sourceData));
    }


}
