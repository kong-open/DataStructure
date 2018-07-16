package xyz.kongzz.datastructure.view.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.BindView;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.base.BaseActivity;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.vp_content)
    ViewPager mVpContent;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                mVpContent.setCurrentItem(0);
                return true;
            case R.id.navigation_discover:
                mVpContent.setCurrentItem(1);
                return true;
            case R.id.navigation_mine:
                mVpContent.setCurrentItem(2);
                return true;
        }
        return false;
    }
}
