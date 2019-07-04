package xyz.kongzz.datastructure.common.view.activity;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.BaseActivity;
import xyz.kongzz.datastructure.common.view.adapter.ViewPagerAdapter;
import xyz.kongzz.datastructure.common.view.helper.BottomNavigationViewHelper;

public class MainActivity extends BaseActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        ViewPager.OnPageChangeListener {

    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;
    @BindView(R.id.tv_title)
    TextView mTitle;
    @BindView(R.id.vp_content)
    ViewPager mVpContent;

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
        BottomNavigationViewHelper.disableShiftMode(mNavigation);
        // 添加对底部按钮点击的监听
        mNavigation.setOnNavigationItemSelectedListener(this);

        mVpContent.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mVpContent.addOnPageChangeListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                return setCurrentTab(0);
            case R.id.navigation_discover:
                return setCurrentTab(1);
            case R.id.navigation_mine:
                return setCurrentTab(2);
            default:
                return setCurrentTab(0);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                mNavigation.setSelectedItemId(R.id.navigation_home);
                break;
            case 1:
                mNavigation.setSelectedItemId(R.id.navigation_discover);
                break;
            case 2:
                mNavigation.setSelectedItemId(R.id.navigation_mine);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private boolean setCurrentTab(int postion) {
        mVpContent.setCurrentItem(postion);
        switch (postion) {
            case 0:
                mTitle.setText(R.string.title_home);
                return true;
            case 1:
                mTitle.setText(R.string.title_discover);
                return true;
            case 2:
                mTitle.setText(R.string.title_mine);
                return true;
            default:
                return false;
        }
    }
}
