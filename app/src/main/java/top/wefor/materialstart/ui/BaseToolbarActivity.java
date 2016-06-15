package top.wefor.materialstart.ui;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import butterknife.BindView;
import top.wefor.materialstart.R;

/**
 * 对应主题 <style name="AppTheme.NoActionBar">
 * <p/>
 * Created on 3/18/16 09:44 23:51.
 *
 * @author ice, GitHub: https://github.com/XunMengWinter
 */
public abstract class BaseToolbarActivity extends BaseActivity {

    @BindView(R.id.toolbar) protected Toolbar mToolbar;
    @BindView(R.id.app_bar_layout) protected AppBarLayout mAppBarLayout;

    /**
     * Initialize the toolbar in the layout
     *
     * @param savedInstanceState savedInstanceState
     */
    @Override
    protected void initToolbar(Bundle savedInstanceState) {
        if (mToolbar == null || mAppBarLayout == null) return;
        setSupportActionBar(mToolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mAppBarLayout.setElevation(6.6f);
        }
    }

    /**
     * 隐藏整个标题栏
     */
    protected void hideToolBar() {
        if (mAppBarLayout != null)
            mAppBarLayout.setVisibility(View.GONE);
        else if (mToolbar != null)
            mToolbar.setVisibility(View.GONE);
    }

}
