package xyz.kongzz.datastructure.factory.presenter.sort;

import xyz.kongzz.datastructure.factory.presenter.BaseContract;

/**
 * 作者:Kong
 * 时间:2018/7/2514:32
 * 描述:这是 QuickSortContract
 */

public interface QuickSortContract {
    interface Presenter extends BaseContract.Presenter {
        void startQuickSort(Integer[] sourceData);
    }

    interface View extends BaseContract.View<Presenter> {
        void onStepQuickSort(int fromPosition, int toPosition);
        void onQuickSortDone(Integer[] sourceData);
    }
}
