package top.wefor.materialstart.ui;

import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import top.wefor.materialstart.R;

/**
 * Created on 16/6/16 00:42.
 *
 * @author ice, GitHub: https://github.com/XunMengWinter
 */
public class CommonActivity extends BaseActivity {
    @BindView(R.id.poem_title_tv) TextView mPoemTitleTv;
    @BindView(R.id.poem_content_tv) TextView mPoemContentTv;

    SearchView mSearchView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_common;
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_common, menu);
        mSearchView = (SearchView) menu.findItem(R.id.action_search).getActionView();

        mSearchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                setTitle(R.string.activity_common);
                return false;
            }
        });

        mSearchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTitle("");
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
