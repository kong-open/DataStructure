package xyz.kongzz.datastructure.common.base;

import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import xyz.kongzz.datastructure.R;

/**
 * 作者:Kong
 * 时间:2018/7/2514:44
 * 描述:这是 专门显示toolbar的activity
 */

public abstract class ToolbarActivity extends BaseActivity {
    protected Toolbar mToolbar;

    @Override
    protected void initWidget() {
        super.initWidget();
        initToolbar((Toolbar) findViewById(R.id.toolbar));
    }


    /**
     * 初始化toolbar
     * @param toolbar Toolbar
     */
    public void initToolbar(Toolbar toolbar) {
        mToolbar = toolbar;
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        initTitleNeedBack();
    }

    protected void initTitleNeedBack(){
        // 设置左上角的返回按钮
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
    }
}
