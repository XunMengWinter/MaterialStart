package top.wefor.materialstart.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import butterknife.BindView;
import top.wefor.materialstart.R;

/**
 * 该类用于简化 含单个Fragment的Activity 的创建;
 * 注意: 继承自 BaseActivity
 * <p/>
 * Created by ice on 16/1/11.
 */
public abstract class BaseSingleFragmentActivity extends BaseActivity {

    @BindView(R.id.fragment_container) protected FrameLayout mFragmentContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment;
    }

    /**
     * 创建 Fragment;
     * 注意: 某些需要在Fragment创建完成前执行的动作请在此方法内执行
     */
    protected abstract Fragment createFragment(Bundle savedInstanceState);

    @Override
    protected void initViews(Bundle savedInstanceState) {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = createFragment(savedInstanceState);
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commitAllowingStateLoss();
        }
    }

}
