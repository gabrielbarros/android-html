package app.androidhtml;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class JavascriptActivity extends AppCompatActivity {
    public Context context = this;
    public static String TAG = "myapp";
    public static ProgressDialog dialog;

    @JavascriptInterface
    public void log(String str) {
        Log.d(TAG, str);
    }

    @JavascriptInterface
    public String getModel() {
        return Build.MODEL;
    }

    @JavascriptInterface
    public String getVersion() {
        return Build.VERSION.RELEASE;
    }

    @JavascriptInterface
    public String getAppVersion() {
        String version = null;

        try {
            version = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0).versionName;
        }
        catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        return version;
    }

    @JavascriptInterface
    public String getDeviceImei() {
        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }

    @JavascriptInterface
    public String getString(String str) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(str, "string", packageName);
        return getString(resId);
    }

    @JavascriptInterface
    public void showToast(String str) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show();
    }

    @JavascriptInterface
    public void showLoading(String msg) {
        dialog = new ProgressDialog(context);
        dialog.setTitle("Aguarde");
        dialog.setMessage(msg);
        dialog.setIndeterminate(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    @JavascriptInterface
    public void hideLoading() {
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @JavascriptInterface
    public void vibrate(int time) {
        Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        v.vibrate(time);
    }

    @JavascriptInterface
    public void share(String text) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        startActivity(intent);
    }

    @JavascriptInterface
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @JavascriptInterface
    public void closeApp() {
        finish();
    }

    @JavascriptInterface
    public void prefSetString(String key, String value) {
        Pref.setString(context, key, value);
    }

    @JavascriptInterface
    public void prefSetInteger(String key, int value) {
        Pref.setInteger(context, key, value);
    }

    @JavascriptInterface
    public void prefSetBoolean(String key, boolean value) {
        Pref.setBoolean(context, key, value);
    }

    @JavascriptInterface
    public String prefGetString(String key) {
        return Pref.getString(context, key);
    }

    @JavascriptInterface
    public int prefGetInteger(String key) {
        return Pref.getInteger(context, key);
    }

    @JavascriptInterface
    public boolean prefGetBoolean(String key) {
        return Pref.getBoolean(context, key);
    }
}
