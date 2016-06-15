package top.wefor.materialstart.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;

import butterknife.ButterKnife;

/**
 * 对应主题 <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
 * <p/>
 * Created on 16/6/15 23:03.
 *
 * @author ice, GitHub: https://github.com/XunMengWinter
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int getLayoutId();

    protected abstract void initViews(Bundle savedInstanceState);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(this.getLayoutId());
        // 用ButterKnife绑定视图，
        // 配合 Android Studio 中的插件 Android ButterKnife Zelezny 自动命名所选layout中的所有带id的视图控件
        // 请注意删除子类自动生成的附带绑定视图的onCreate()方法以避免重复绑定(当然，不删也不会报错)。
        ButterKnife.bind(this);

        this.initToolbar(savedInstanceState);
        initActionBar(); //在initToolbar()完成后设置ActionBar
        this.initViews(savedInstanceState);
    }

    /**
     * 默认点击Actionbar的左上角返回按钮finish().
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 之所以不声明为 abstract 方法是因为主题自带ActionBar(即标题栏):
     * <style name="AppTheme" parent="Theme.AppCompat.Light.DarkActionBar">
     */
    protected void initToolbar(Bundle savedInstanceState) {

    }

    protected void initActionBar() {
        if (getSupportActionBar() != null) {
            // 默认左上角按钮可以点击
            getSupportActionBar().setHomeButtonEnabled(true);
            // 默认显示左上角返回按钮
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * 隐藏ActionBar左上角的返回按钮
     */
    protected void hideBack() {
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }


    /*下面的全是辅助方法，根据业务需求自行决策*/


    /**
     * 使用更为时尚的toast
     *
     * @param msg
     */
    protected void showToast(String msg) {
        if (!TextUtils.isEmpty(msg))
            Snackbar.make(getWindow().getDecorView(), msg, Snackbar.LENGTH_SHORT).show();
    }

    protected void showToast(@StringRes int resId) {
        if (resId != 0)
            Snackbar.make(getWindow().getDecorView(), resId, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * startActivity
     *
     * @param clazz
     */
    protected void go(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }

    /**
     * click View
     * startActivity
     *
     * @param clazz
     */
    protected void clickGo(View view, final Class<?> clazz) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BaseActivity.this, clazz);
                startActivity(intent);
            }
        });
    }

    protected void clickShow(View view, final String message) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (message != null)
                    showToast(message);
            }
        });
    }


}
