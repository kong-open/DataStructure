package xyz.kongzz.datastructure.common.view.activity;

import android.content.Intent;
import android.widget.ImageView;

import com.fadai.particlesmasher.ParticleSmasher;
import com.fadai.particlesmasher.SmashAnimator;

import butterknife.BindView;
import xyz.kongzz.datastructure.R;
import xyz.kongzz.datastructure.common.base.BaseActivity;

/**
 * 作者:Kong
 * 时间:2018/7/2316:35
 * 描述:这是 SplashActivity
 */

public class SplashActivity extends BaseActivity {

    @BindView(R.id.iv_splash)
    ImageView ivSplash;

    private ParticleSmasher mSmasher;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mSmasher = new ParticleSmasher(this);
        ivSplash.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSmasher.with(ivSplash)
                        .setStyle(SmashAnimator.STYLE_EXPLOSION)
                        .setDuration(2000)
                        .setHorizontalMultiple(3)
                        .setVerticalMultiple(4)
                        .addAnimatorListener(new SmashAnimator.OnAnimatorListener() {
                            @Override
                            public void onAnimatorEnd() {
                                super.onAnimatorEnd();
                                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                                finish();
                            }
                        })
                        .start();
            }
        }, 1000);
    }
}
