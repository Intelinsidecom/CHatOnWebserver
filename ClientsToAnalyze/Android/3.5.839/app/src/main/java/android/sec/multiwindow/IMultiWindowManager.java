package android.sec.multiwindow;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import java.util.List;

@Deprecated
/* loaded from: classes.dex */
public interface IMultiWindowManager {
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final String SERVICE_NAME = "multiwindow";

    boolean arrangeWindows(int i);

    Bitmap capture(ComponentName componentName);

    boolean exchangeSplitScreens();

    boolean finishAllWindow();

    boolean finishAppPid(int i);

    boolean getMultiLayout();

    List<ComponentName> getMultiWindowList();

    List<ComponentName> getMultiWindowList(ComponentName componentName);

    MultiWindowType getMultiWindowMode();

    ComponentName getPinupWindow();

    List<ComponentName> getPinupWindowList();

    ComponentName getResumedWindow();

    List<ComponentName> getRunningWindowList();

    List<ComponentName> getSplitList();

    List<ComponentName> getVisibleWindowList();

    IMultiWindow getWindowInstance(ComponentName componentName);

    IMultiWindow getWindowInstance(Intent intent);

    boolean isMultiWindow(ComponentName componentName);

    boolean isPermissionOff();

    boolean isPinup(ComponentName componentName);

    boolean isPinup(ComponentName componentName, int i);

    boolean isRunning(ComponentName componentName);

    boolean isVisible(ComponentName componentName);

    boolean notifyFinished(Activity activity);

    boolean notifyForceFinished(ComponentName componentName);

    boolean notifySIP(int i);

    boolean notifyStarted(Activity activity);

    boolean orientationChangeRestore(ComponentName componentName, int i);

    boolean postResume(Activity activity);

    IMultiWindow registerMultiWindow(ComponentName componentName);

    IMultiWindow registerMultiWindow(ComponentName componentName, int i, int i2);

    IMultiWindow registerMultiWindow(ComponentName componentName, int i, int i2, boolean z);

    IMultiWindow registerMultiWindow(ComponentName componentName, List<Point> list);

    boolean registerMultiWindowPair(ComponentName componentName, ComponentName componentName2);

    boolean removeMultiWindow(ComponentName componentName);

    boolean removeMultiWindowPair(ComponentName componentName, ComponentName componentName2);

    Bitmap screenShot(ComponentName componentName);

    boolean sendCreateAction(Activity activity);

    boolean sendDestroyAction(Activity activity);

    boolean sendFinishAction(Activity activity);

    boolean sendPauseAction(Activity activity);

    boolean sendResumeAction(Activity activity);

    boolean sendStartAction(Activity activity);

    boolean setMultiLayout(boolean z);

    boolean setMultiWindowMode(MultiWindowType multiWindowType);

    void setPreferenceValue(boolean z);

    void showSwitchWindowGuideDialog(Context context);

    boolean startLauncher();

    boolean startLauncher(ComponentName componentName);

    boolean startLauncher(Context context);

    boolean startLauncher(Context context, ComponentName componentName);

    boolean startSplitScreens(ComponentName componentName, ComponentName componentName2);

    boolean startSplitScreens(ComponentName componentName, Intent intent);

    boolean startSplitScreens(Intent intent, ComponentName componentName);

    boolean startSplitScreensForLauncher(ComponentName componentName, ComponentName componentName2);

    boolean unRegisterMultiWindow(ComponentName componentName);
}
