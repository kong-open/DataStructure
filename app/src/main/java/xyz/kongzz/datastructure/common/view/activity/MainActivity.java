package xyz.kongzz.datastructure.common.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import butterknife.BindView;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.BaseActivity;
import xyz.kongzz.datastructure.common.view.fragment.DiscoverFragment;
import xyz.kongzz.datastructure.common.view.fragment.HomeFragment;
import xyz.kongzz.datastructure.common.view.fragment.MineFragment;
import xyz.kongzz.datastructure.common.view.helper.BottomNavigationViewHelper;
import xyz.kongzz.datastructure.common.view.helper.NavHelper;

public class MainActivity extends BaseActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        NavHelper.OnTabChangedListener<Integer> {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;
    @BindView(R.id.tv_title)
    TextView mTitle;

    private NavHelper<Integer> mNavHelper;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        super.initData();
        // 从底部导中接管我们的Menu，然后进行手动的触发第一次点击
        Menu menu = mNavigation.getMenu();
        // 触发首次选中Home
        menu.performIdentifierAction(R.id.navigation_home, 0);
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        // 初始化底部辅助工具类
        mNavHelper = new NavHelper<>(this, R.id.lay_container,
                getSupportFragmentManager(), this);
        mNavHelper.add(R.id.navigation_home, new NavHelper.Tab<>(HomeFragment.class, R.string.title_home))
                .add(R.id.navigation_discover, new NavHelper.Tab<>(DiscoverFragment.class, R.string.title_discover))
                .add(R.id.navigation_mine, new NavHelper.Tab<>(MineFragment.class, R.string.title_mine));

        BottomNavigationViewHelper.disableShiftMode(mNavigation);
        // 添加对底部按钮点击的监听
        mNavigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // 转接事件流到工具类中
        return mNavHelper.performClickMenu(item.getItemId());
    }

    @Override
    public void onTabChanged(NavHelper.Tab<Integer> newTab, NavHelper.Tab<Integer> oldTab) {
        // 从额外字段中取出我们的Title资源Id
        mTitle.setText(newTab.extra);
    }
}
