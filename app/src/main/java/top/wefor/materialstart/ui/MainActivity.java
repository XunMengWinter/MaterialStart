package top.wefor.materialstart.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindDrawable;
import butterknife.BindView;
import top.wefor.materialstart.R;
import top.wefor.materialstart.utils.PixelUtil;

/**
 * Created on 16/6/15 23:57.
 *
 * @author ice, GitHub: https://github.com/XunMengWinter
 */
public class MainActivity extends BaseToolbarActivity {
    @BindView(R.id.banner_imageView) ImageView mBannerImageView;
    @BindView(R.id.title_tv) AppCompatTextView mTitleTv;
    @BindView(R.id.collapsing_toolbar) CollapsingToolbarLayout mCollapsingToolbar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;

    @BindDrawable(R.mipmap.bg_ice) Drawable mIceBg;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
        // 配合插件 Android ButterKnife Zelezny 一键生成控件变量。
    }

    @Override
    protected void initViews(Bundle savedInstanceState) {
//        mCollapsingToolbar.setExpandedTitleColor(0x00123456); // 展开时隐藏标题
        hideBack(); //隐藏标题栏上的返回按钮

//        setTitle("123");//更改标题
//        mTitleTv.setText("123"); //更改标题

        mBannerImageView.setImageDrawable(mIceBg);
        mBannerImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("Hey : ) ");
            }
        });

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);

        final ArrayList<String> strings = new ArrayList<>();
        for (int i = 1; i < 33; i++) {
            String name = "Mom say click text will see a poem  " + i + " :) ";
            strings.add(name);
        }

        mRecyclerView.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                int dp16 = PixelUtil.dpToPx(MainActivity.this, 16);
                TextView textView = new TextView(MainActivity.this);
                textView.setPadding(dp16, dp16, dp16, dp16);

                return new RecyclerView.ViewHolder(textView) {
                    @Override
                    public String toString() {
                        return super.toString();
                    }
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                TextView textView = (TextView) holder.itemView;
                textView.setText(strings.get(position));

                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        go(CommonActivity.class);
                    }
                });
            }

            @Override
            public int getItemCount() {
                return strings.size();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                go(SettingsActivity.class);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
