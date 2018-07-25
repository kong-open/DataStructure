package xyz.kongzz.datastructure.factory.presenter.sort;

import xyz.kongzz.datastructure.factory.presenter.BasePresenter;

/**
 * 作者:Kong
 * 时间:2018/7/2514:31
 * 描述:这是 QuickSortPresenter
 */

public class QuickSortPresenter extends BasePresenter<QuickSortContract.View>
        implements QuickSortContract.Presenter {

    public QuickSortPresenter(QuickSortContract.View view) {
        super(view);
    }

    /**
     * 记录一个23，让出自己位置，将小得放进来
     * <p>
     * 23, 12, 13, 44, 65, 26, 17, 38, 59
     * <p>
     * 17, 12, 13, 44, 65, 26, 17, 38, 59
     * <p>
     * 17, 12, 13, 44, 65, 26, 44, 38, 59
     * <p>
     * 一趟以后得 17, 12, 13, 23, 65, 26, 44, 38, 59
     * <p>
     * 一趟=[17, 12, 13, 44, 65, 26, 44, 38, 59]
     * I/info    (27284): 一趟=[17, 12, 13, 44, 65, 26, 44, 38, 59]
     * I/info    (27284): 一趟=[13, 12, 13, 23, 65, 26, 44, 38, 59]
     * I/info    (27284): 一趟=[12, 12, 17, 23, 65, 26, 44, 38, 59]
     * I/info    (27284): 一趟=[12, 13, 17, 23, 59, 26, 44, 38, 59]
     * I/info    (27284): 一趟=[12, 13, 17, 23, 38, 26, 44, 38, 65]
     * I/info    (27284): 一趟=[12, 13, 17, 23, 26, 26, 44, 59, 65]
     */


    @Override
    public void startQuickSort(int[] sourceData) {
        sort(sourceData, 0, sourceData.length - 1);
        final QuickSortContract.View view = getView();
        view.onQuickSortDone(sourceData);
    }

    /**
     * 一次比较（以中间元素为间隔，小的在左边，大的在右边）
     */
    public static int partition(int a[], int low, int high) {
        int privotKey = a[low];// 比较元素，选择区间最小标号那个
        while (low < high) {
            // 1. 先从最右边开始比较
            while (low < high && a[high] >= privotKey) {
                high--;
            }

            // 换位置
            int _temp;
            _temp = a[low];
            a[low] = a[high];
            a[high] = _temp;

            // 2. 然后再从左边开始比较
            while (low < high && a[low] <= privotKey) {
                low++;
            }

            // 换位置
            _temp = a[low];
            a[low] = a[high];
            a[high] = _temp;
        }
        // 返回中间分隔线元素
        return low;
    }


    public static void sort(int[] sourceData, int low, int high) {
        if (low < high) {
            // 一次排序，得到中间分隔点
            int middle = partition(sourceData, low, high);
            // 左侧较小元素集排序
            sort(sourceData, low, middle - 1);
            // 右侧较大元素集排序
            sort(sourceData, middle + 1, high);
        }
    }
}
