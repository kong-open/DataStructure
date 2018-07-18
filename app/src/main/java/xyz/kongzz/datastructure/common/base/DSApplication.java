package xyz.kongzz.datastructure.common.base;

import android.app.Application;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.github.anzewei.parallaxbacklayout.ParallaxHelper;

import net.qiujuer.genius.kit.handler.Run;
import net.qiujuer.genius.kit.handler.runable.Action;

/**
 * 作者:Kong
 * 时间:2018/7/1810:40
 * 描述:这是 DSApplication
 */

public class DSApplication extends Application{

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        // 初始化滑动返回组件
        registerActivityLifecycleCallbacks(ParallaxHelper.getInstance());
    }

    /**
     * 外部获取单例
     *
     * @return Application
     */
    public static Application getInstance() {
        return instance;
    }

    /**
     * 显示一个Toast
     *
     * @param msg 字符串
     */
    public static void showToast(final String msg) {
        // Toast 只能在主线程中显示，所有需要进行线程转换，
        // 保证一定是在主线程进行的show操作
        Run.onUiAsync(new Action() {
            @Override
            public void call() {
                // 这里进行回调的时候一定就是主线程状态了
                Toast.makeText(instance, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 显示一个Toast
     *
     * @param msgId 传递的是字符串的资源
     */
    public static void showToast(@StringRes int msgId) {
        showToast(instance.getString(msgId));
    }
}
