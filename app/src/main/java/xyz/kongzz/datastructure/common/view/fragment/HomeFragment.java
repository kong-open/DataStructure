package xyz.kongzz.datastructure.common.view.fragment;

import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.PresenterFragment;
import xyz.kongzz.datastructure.factory.presenter.home.HomeContract;

/**
 * 作者:Kong
 * 时间:2018/7/1614:32
 * 描述:这是 HomeFragment
 */

public class HomeFragment extends PresenterFragment<HomeContract.Presenter>
        implements HomeContract.View {

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected HomeContract.Presenter initPresenter() {
        return null;
    }


}
