package xyz.kongzz.datastructure.common.base;

import android.app.Application;

import com.github.anzewei.parallaxbacklayout.ParallaxHelper;

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
}
