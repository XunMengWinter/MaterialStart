package top.wefor.materialstart.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import top.wefor.materialstart.R;

/**
 * 设置
 * <p/>
 * Created by ice on 16/3/28 16:53.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref_settings);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, final Preference preference) {
        if (preference != null) {//通过标题的资源id来唯一标识
            switch (preference.getTitleRes()) {
                case R.string.pref_title_switch:
                    return true;
                case R.string.pref_title_about:
                    String url = "http://www.jianshu.com/users/e36e60b5af17/latest_articles";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                    return true;
                case R.string.pref_title_text_size:
                    return true;
            }
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

}
