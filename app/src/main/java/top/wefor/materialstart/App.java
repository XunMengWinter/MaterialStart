package top.wefor.materialstart;

import android.app.Application;
import android.text.TextUtils;

import top.wefor.materialstart.utils.Toaster;

/**
 * Created on 3/24/16 10:21 23:02.
 *
 * @author ice, GitHub: https://github.com/XunMengWinter
 */
public class App extends Application {

    private static App sApp;
    private Toaster mToaster;

    /**
     * 单例模式获取 Application
     */
    public static App getInstance() {
        if (sApp == null) {
            sApp = new App();
        }
        return sApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }

    /**
     * show toast
     *
     * @param msg
     */
    public void showToast(String msg) {

        if (!TextUtils.isEmpty(msg)) {
            if (mToaster == null)
                mToaster = new Toaster();
            mToaster.showToast(msg);
        }
    }

}
