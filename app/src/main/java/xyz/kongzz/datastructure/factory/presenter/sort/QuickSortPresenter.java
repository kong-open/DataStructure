package xyz.kongzz.datastructure.factory.presenter.sort;

import xyz.kongzz.datastructure.factory.presenter.BasePresenter;

/**
 * 作者:Kong
 * 时间:2018/7/2514:31
 * 描述:这是 QuickSortPresenter
 */

public class QuickSortPresenter extends BasePresenter<QuickSortContract.View>
        implements QuickSortContract.Presenter {

    // TODO 快速排序时，设置延时，方便动画展示

    private QuickSortContract.View mView;

    private int total = 0;

    public QuickSortPresenter(QuickSortContract.View view) {
        super(view);
        mView = getView();
    }

    @Override
    public void startQuickSort(Integer[] sourceData) {
        quickSort(sourceData, 0, sourceData.length - 1);
        mView.onQuickSortDone(sourceData);
    }


    /**
     * 一次比较（以中间元素为间隔，小的在左边，大的在右边）
     */
    private void quickSort(Integer[] a, int low, int high) {
        //1,找到递归算法的出口
        if (low > high) {
            return;
        }
        total++;
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[low];

        //4，完成一趟排序
        while (i < j) {
            //4.1 ，从右往左找到第一个小于key的数
            while (i < j && a[j] > key) {
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while (i < j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }

        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;

        mView.onStepQuickSort(low, i);

        //5, 对key左边的数快排
        quickSort(a, low, i - 1);

        //6, 对key右边的数快排
        quickSort(a, i + 1, high);
    }
}
