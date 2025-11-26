package android.sec.multiwindow;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.sec.multiwindow.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MultiWindowManager extends MultiWindowImpl implements IMultiWindowManager {
    private static final int MAX_RUNNING_TASK = 1000;
    public static final String TAG = "MultiWindowManager";
    private ArrayList<String> mSupportAppList;
    public static final int FLAG_STYLE_FREE = Constants.WindowManagerPolicy.WINDOW_MODE_FREESTYLE;
    public static final int FLAG_STYLE_PINUP = Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP;
    public static final int FLAG_STYLE_MINIMIZE = Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED;
    public static final int FLAG_STYLE_POPUP = Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_NO_DECORATION;
    public static final int ARRANGE_MODE_SPLIT = Constants.Configuration.ARRANGE_SPLITED;
    public static final int ARRANGE_MODE_CASCADE = Constants.Configuration.ARRANGE_CASCADE;
    public static final int ZONE_MASK = Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK;
    public static final int ZONE_A = Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_A;
    public static final int ZONE_B = Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_B;
    public static final int ZONE_UNKNOWN = Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_UNKNOWN;
    private static MultiWindowManager mSelf = null;
    private static boolean sQueried = false;
    private static boolean sIsMultiWindowEnabled = false;
    private static boolean sStyleQueried = false;
    private static boolean sIsMultiWindowPhoneStyle = false;

    public static MultiWindowManager getSelf(Context context) {
        if (context == null) {
            return null;
        }
        if (mSelf == null) {
            mSelf = new MultiWindowManager(context);
        }
        return mSelf;
    }

    public MultiWindowManager(Context context) throws Resources.NotFoundException {
        super(context);
        this.mSupportAppList = new ArrayList<>();
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        putMethod(activityManager.getClass(), activityManager, "getFrontActivityPosition", (Class[]) null);
        isMultiWindowPhoneStyle(context);
        loadDefaultConfig();
    }

    public Rect getFrontActivityPosition() {
        return (Rect) invoke("getFrontActivityPosition", new Object[0]);
    }

    public Intent makeIntent(int i, Rect rect) {
        Intent intent = new Intent();
        if (((((((((FLAG_STYLE_FREE | FLAG_STYLE_PINUP) | FLAG_STYLE_MINIMIZE) | FLAG_STYLE_POPUP) | ZONE_A) | ZONE_B) | ZONE_UNKNOWN) ^ (-1)) & i) == 0 && (FLAG_STYLE_FREE & i) != 0) {
            if (sIsMultiWindowPhoneStyle) {
                i &= ((FLAG_STYLE_PINUP | FLAG_STYLE_MINIMIZE) | FLAG_STYLE_POPUP) ^ (-1);
            }
            intent.putExtra(Constants.Intent.EXTRA_WINDOW_MODE, i);
        }
        if (!sIsMultiWindowPhoneStyle && rect != null) {
            intent.putExtra(Constants.Intent.EXTRA_WINDOW_POSITION, rect);
        }
        return intent;
    }

    public void arrange(int i) {
        Intent intent = new Intent(Constants.Intent.ACTION_ARRANGE_WINDOWS);
        intent.putExtra(Constants.Intent.EXTRA_ARRANGE_MODE, i);
        this.mContext.sendBroadcast(intent);
    }

    @Deprecated
    public void arrangeSplit() {
        arrange(Constants.Configuration.ARRANGE_SPLITED);
    }

    @Deprecated
    public void arrangeCascade() {
        arrange(Constants.Configuration.ARRANGE_CASCADE);
    }

    @Deprecated
    public void minimizeAll() {
        arrange(Constants.Configuration.ARRANGE_MINIMIZED_ALL);
    }

    @Deprecated
    public void restoreAll() {
        arrange(Constants.Configuration.ARRANGE_RESTORED_ALL);
    }

    @Deprecated
    public boolean arrangeTemplate(int i) {
        return false;
    }

    public List<ActivityInfo> getRegisteredList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory(Constants.Intent.CATEGORY_MULTIWINDOW_LAUNCHER);
        PackageManager packageManager = this.mContext.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(intent, 128)) {
            if (resolveInfo != null) {
                arrayList.add(resolveInfo.activityInfo);
                arrayList2.add(resolveInfo.activityInfo.packageName);
            }
        }
        if (sIsMultiWindowPhoneStyle) {
            for (ResolveInfo resolveInfo2 : packageManager.queryIntentActivities(new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER"), 0)) {
                if (!arrayList2.contains(resolveInfo2.activityInfo.packageName) && this.mSupportAppList.contains(resolveInfo2.activityInfo.packageName)) {
                    arrayList.add(resolveInfo2.activityInfo);
                }
            }
        }
        return arrayList;
    }

    public List<ActivityManager.RunningTaskInfo> getRunningList(int i) {
        return ((ActivityManager) this.mContext.getSystemService("activity")).getRunningTasks(MAX_RUNNING_TASK, i, null);
    }

    public static boolean isMultiWindowServiceEnabled(Context context) {
        if (context == null) {
            return false;
        }
        if (!sQueried) {
            sQueried = true;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                sIsMultiWindowEnabled = packageManager.hasSystemFeature(Constants.PackageManager.FEATURE_MULTIWINDOW);
            }
        }
        return sIsMultiWindowEnabled;
    }

    public static boolean isMultiWindowPhoneStyle(Context context) {
        if (context == null) {
            return false;
        }
        if (!sStyleQueried) {
            sStyleQueried = true;
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                sIsMultiWindowPhoneStyle = packageManager.hasSystemFeature(Constants.PackageManager.FEATURE_MULTIWINDOW_PHONE);
            }
        }
        return sIsMultiWindowPhoneStyle;
    }

    public void loadDefaultConfig() throws Resources.NotFoundException {
        for (String str : this.mContext.getResources().getStringArray(R.array.config_default_vm_number)) {
            this.mSupportAppList.add(str);
        }
    }

    @Deprecated
    public MultiWindowManager(Context context, Handler handler) {
        this(context);
    }

    @Deprecated
    private List<Bundle> getMultiWindowInfos(int i) {
        return null;
    }

    @Deprecated
    public static IMultiWindowManager getInstance(Context context) {
        return null;
    }

    @Deprecated
    public static IMultiWindowService getService() {
        return null;
    }

    @Deprecated
    public List<Bundle> getMultiWindowInfos() {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean setMultiWindowMode(MultiWindowType multiWindowType) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public MultiWindowType getMultiWindowMode() {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public IMultiWindow getWindowInstance(ComponentName componentName) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public IMultiWindow getWindowInstance(Intent intent) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public Bitmap screenShot(ComponentName componentName) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public IMultiWindow registerMultiWindow(ComponentName componentName) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public IMultiWindow registerMultiWindow(ComponentName componentName, int i, int i2) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public IMultiWindow registerMultiWindow(ComponentName componentName, int i, int i2, boolean z) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public IMultiWindow registerMultiWindow(ComponentName componentName, List<Point> list) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean unRegisterMultiWindow(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean removeMultiWindow(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean registerMultiWindowPair(ComponentName componentName, ComponentName componentName2) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean removeMultiWindowPair(ComponentName componentName, ComponentName componentName2) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public List<ComponentName> getMultiWindowList() {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public List<ComponentName> getMultiWindowList(ComponentName componentName) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public List<ComponentName> getRunningWindowList() {
        return new ArrayList();
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public List<ComponentName> getVisibleWindowList() {
        return new ArrayList();
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public List<ComponentName> getPinupWindowList() {
        return new ArrayList();
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public List<ComponentName> getSplitList() {
        return new ArrayList();
    }

    @Deprecated
    public List<ComponentName> getMultiWindowListOwnerList() {
        return null;
    }

    @Deprecated
    public boolean removeMultiWindowOwnerItem(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean isMultiWindow(ComponentName componentName) {
        return false;
    }

    @Deprecated
    public boolean isMultiWindow(ComponentName componentName, ComponentName componentName2) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean isRunning(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean isVisible(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean isPinup(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean isPinup(ComponentName componentName, int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public ComponentName getResumedWindow() {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public ComponentName getPinupWindow() {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean finishAllWindow() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean finishAppPid(int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean notifyStarted(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean notifyFinished(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean notifyForceFinished(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public Bitmap capture(ComponentName componentName) {
        return null;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean postResume(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean sendCreateAction(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean sendStartAction(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean sendResumeAction(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean sendPauseAction(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean sendFinishAction(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean sendDestroyAction(Activity activity) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startLauncher() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startLauncher(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startLauncher(Context context) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startLauncher(Context context, ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startSplitScreens(ComponentName componentName, ComponentName componentName2) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startSplitScreens(ComponentName componentName, Intent intent) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startSplitScreens(Intent intent, ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean startSplitScreensForLauncher(ComponentName componentName, ComponentName componentName2) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean exchangeSplitScreens() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean setMultiLayout(boolean z) {
        return true;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean getMultiLayout() {
        return true;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean isPermissionOff() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean arrangeWindows(int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean orientationChangeRestore(ComponentName componentName, int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public boolean notifySIP(int i) {
        return true;
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public void setPreferenceValue(boolean z) {
    }

    @Override // android.sec.multiwindow.IMultiWindowManager
    @Deprecated
    public void showSwitchWindowGuideDialog(Context context) {
    }
}
