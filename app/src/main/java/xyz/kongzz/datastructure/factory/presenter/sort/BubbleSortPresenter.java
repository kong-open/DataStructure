package xyz.kongzz.datastructure.factory.presenter.sort;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import xyz.kongzz.datastructure.factory.presenter.BasePresenter;

/**
 * @author Kong
 * @date 2019-07-04
 * @desc
 */
public class BubbleSortPresenter extends BasePresenter<BubbleSortContract.View>
        implements BubbleSortContract.Presenter {

    private BubbleSortContract.View mView;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    int i = (int) msg.obj;
                    Log.e("BubbleSort", "调用了");
                    mView.onStepBubbleSort(i, i + 1);
                    break;
                case 1:
                    mView.onBubbleSortDone();
                    break;
                default:
                    break;
            }

            return false;
        }
    });

    public BubbleSortPresenter(BubbleSortContract.View view) {
        super(view);
        mView = view;
    }

    @Override
    public void startBubbleSort(final Integer[] sourceData) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i, j, temp;
                int len = sourceData.length;
                for (j = 0; j < len - 1; j++) {
                    for (i = 0; i < len - 1 - j; i++) {
                        if (sourceData[i] > sourceData[i + 1]) {
                            temp = sourceData[i];
                            sourceData[i] = sourceData[i + 1];
                            sourceData[i + 1] = temp;

                            Message message = mHandler.obtainMessage();
                            message.what = 0;
                            message.obj = i;
                            mHandler.sendMessage(message);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }
                }
                mHandler.sendEmptyMessage(1);
            }
        }).start();
    }
}
