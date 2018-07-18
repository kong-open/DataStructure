package xyz.kongzz.datastructure.factory.presenter.home;

import xyz.kongzz.datastructure.factory.presenter.BasePresenter;

/**
 * 作者:Kong
 * 时间:2018/7/1814:54
 * 描述:这是 HomePresenter
 */

public class HomePresenter extends BasePresenter<HomeContract.View>
        implements HomeContract.Presenter{

    public HomePresenter(HomeContract.View view) {
        super(view);
    }
}
