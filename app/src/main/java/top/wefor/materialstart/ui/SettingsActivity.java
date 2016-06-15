package top.wefor.materialstart.ui;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.FrameLayout;

import butterknife.BindView;
import top.wefor.materialstart.R;

/**
 * Created on 16/6/16 01:15.
 *
 * @author ice, GitHub: https://github.com/XunMengWinter
 */
public class SettingsActivity extends BaseActivity {

    @BindView(R.id.fragment_container) FrameLayout mFragmentContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_fragment;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
        FragmentManager fm = getFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new SettingsFragment(); // 由于SettingsFragment非support v4,所以activity不能使用BaseSingleFragmentActivity.
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commitAllowingStateLoss();
        }
    }

}
