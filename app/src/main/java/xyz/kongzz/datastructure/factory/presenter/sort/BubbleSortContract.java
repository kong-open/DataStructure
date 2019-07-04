package xyz.kongzz.datastructure.factory.presenter.sort;

import xyz.kongzz.datastructure.factory.presenter.BaseContract;

/**
 * @author Kong
 * @date 2019-07-04
 * @desc
 */
public interface BubbleSortContract  {
    interface Presenter extends BaseContract.Presenter {
        void startBubbleSort(Integer[] sourceData);
    }

    interface View extends BaseContract.View<BubbleSortContract.Presenter> {
        void onStepBubbleSort(int fromPosition, int toPosition);
        void onBubbleSortDone();
    }
}
