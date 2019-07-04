package xyz.kongzz.datastructure.common.view.fragment;

import android.content.Intent;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.PresenterFragment;
import xyz.kongzz.datastructure.common.view.activity.sort.BubbleSortActivity;
import xyz.kongzz.datastructure.common.view.activity.sort.QuickSortActivity;
import xyz.kongzz.datastructure.factory.presenter.home.HomeContract;
import xyz.kongzz.datastructure.factory.presenter.sort.BubbleSortContract;

/**
 * 作者:Kong
 * 时间:2018/7/1614:32
 * 描述:这是 HomeFragment
 */

public class HomeFragment extends PresenterFragment<HomeContract.Presenter>
        implements HomeContract.View {

    @BindView(R.id.bt_sort)
    Button mBtSort;

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomeContract.Presenter initPresenter() {
        return null;
    }

    @OnClick(R.id.bt_sort)
    public void onBtSortClicked() {
        Intent intent = new Intent(getActivity(), BubbleSortActivity.class);
        startActivity(intent);
    }
}
