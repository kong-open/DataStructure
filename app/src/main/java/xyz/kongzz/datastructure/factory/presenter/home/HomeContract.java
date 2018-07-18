package xyz.kongzz.datastructure.factory.presenter.home;

import xyz.kongzz.datastructure.factory.presenter.BaseContract;

/**
 * 作者:Kong
 * 时间:2018/7/1814:52
 * 描述:这是 HomeContract
 */

public interface HomeContract {
    interface Presenter extends BaseContract.Presenter{

    }

    interface View extends  BaseContract.View<Presenter>{

    }
}
