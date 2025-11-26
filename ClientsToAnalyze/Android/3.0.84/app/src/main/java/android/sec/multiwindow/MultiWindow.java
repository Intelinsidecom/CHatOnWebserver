package android.sec.multiwindow;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.sec.multiwindow.Constants;
import android.view.WindowManager;

/* loaded from: classes.dex */
public class MultiWindow extends MultiWindowImpl implements IMultiWindow {
    protected static final String TAG = "MultiWindow";
    private Activity mActivity;
    private boolean mArrangeable;
    private Rect mDefaultSize;
    private Rect mMaximumSize;
    private Rect mMinimumSize;
    private int mWindowMode;

    private boolean checkMode(int i) {
        return mode(this.mWindowMode) == i;
    }

    private boolean checkOption(int i) {
        return (option(this.mWindowMode) & i) != 0;
    }

    private void setLastSize(Rect rect) {
        Bundle windowInfo = getWindowInfo();
        windowInfo.putParcelable(Constants.Intent.EXTRA_WINDOW_LAST_SIZE, rect);
        setWindowInfo(windowInfo);
    }

    private Rect getLastSize() {
        Rect rect = (Rect) getWindowInfo().getParcelable(Constants.Intent.EXTRA_WINDOW_LAST_SIZE);
        return rect != null ? rect : this.mDefaultSize;
    }

    private void setWindowMode(int i) {
        invoke("setWindowMode", Integer.valueOf(i), true);
    }

    private void updateWindowMode() {
        this.mWindowMode = ((Integer) invoke("getWindowMode", (Object[]) null)).intValue();
    }

    private void setWindowInfo(Bundle bundle) {
        invoke("setWindowInfo", bundle);
    }

    private Bundle getWindowInfo() {
        return (Bundle) invoke("getWindowInfo", (Object[]) null);
    }

    private void setWindowParams() {
        WindowManager.LayoutParams attributes = this.mActivity.getWindow().getAttributes();
        if (mode(this.mWindowMode) == Constants.WindowManagerPolicy.WINDOW_MODE_FREESTYLE) {
            Rect lastSize = getLastSize();
            attributes.x = lastSize.left;
            attributes.y = lastSize.top;
            attributes.width = lastSize.width();
            attributes.height = lastSize.height();
            attributes.gravity = 51;
        } else {
            attributes.x = 0;
            attributes.y = 0;
            attributes.width = -1;
            attributes.height = -1;
            attributes.gravity = 0;
        }
        this.mActivity.getWindow().setAttributes(attributes);
    }

    public static MultiWindow createInstance(Activity activity) {
        if (activity != null && activity.getPackageManager().hasSystemFeature(Constants.PackageManager.FEATURE_MULTIWINDOW)) {
            return new MultiWindow(activity);
        }
        return null;
    }

    private MultiWindow(Activity activity) {
        super(activity);
        this.mArrangeable = true;
        this.mActivity = activity;
        Class<?> cls = this.mActivity.getClass();
        putMethod(cls, this.mActivity, "getWindowMode", (Class[]) null);
        putMethod(cls, this.mActivity, "setWindowMode", new Class[]{Integer.TYPE, Boolean.TYPE});
        putMethod(cls, this.mActivity, "getWindowInfo", (Class[]) null);
        putMethod(cls, this.mActivity, "setWindowInfo", new Class[]{Bundle.class});
        Bundle windowInfo = getWindowInfo();
        this.mDefaultSize = (Rect) windowInfo.getParcelable(Constants.Intent.EXTRA_WINDOW_DEFAULT_SIZE);
        this.mMinimumSize = (Rect) windowInfo.getParcelable(Constants.Intent.EXTRA_WINDOW_MINIMUM_SIZE);
        Point point = new Point();
        this.mActivity.getWindowManager().getDefaultDisplay().getSize(point);
        this.mMaximumSize = new Rect(0, 0, point.x, point.y);
    }

    public boolean isNormalWindow() {
        updateWindowMode();
        return checkMode(Constants.WindowManagerPolicy.WINDOW_MODE_NORMAL);
    }

    public boolean isMultiWindow() {
        updateWindowMode();
        return checkMode(Constants.WindowManagerPolicy.WINDOW_MODE_FREESTYLE);
    }

    public boolean isPinup() {
        updateWindowMode();
        return checkMode(Constants.WindowManagerPolicy.WINDOW_MODE_FREESTYLE) && checkOption(Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP);
    }

    public boolean isMinimized() {
        updateWindowMode();
        return checkMode(Constants.WindowManagerPolicy.WINDOW_MODE_FREESTYLE) && checkOption(Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED);
    }

    public boolean normalWindow() {
        updateWindowMode();
        this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_MASK ^ (-1);
        this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_NORMAL;
        this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP ^ (-1);
        this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED ^ (-1);
        setWindowMode(this.mWindowMode);
        setWindowParams();
        return true;
    }

    public boolean multiWindow() {
        return multiWindow(false, false);
    }

    public boolean multiWindow(boolean z) {
        return multiWindow(z, false);
    }

    public boolean multiWindow(boolean z, boolean z2) {
        return multiWindow(z, z2, Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_UNKNOWN);
    }

    public boolean multiWindow(boolean z, boolean z2, int i) {
        updateWindowMode();
        if (!getMultiWindowEnabled() || isMultiWindow()) {
            return false;
        }
        this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_MASK ^ (-1);
        this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_FREESTYLE;
        if (z) {
            this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP;
        } else {
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP ^ (-1);
        }
        if (z2) {
            this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED;
        } else {
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED ^ (-1);
        }
        if (i == Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_UNKNOWN) {
            if (getArrange(this.mActivity.getResources().getConfiguration()) == Constants.Configuration.ARRANGE_SPLITED) {
                this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK ^ (-1);
                this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_A;
            }
        } else {
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK ^ (-1);
            this.mWindowMode |= i;
        }
        setWindowParams();
        setWindowMode(this.mWindowMode);
        return true;
    }

    public boolean pinup(boolean z) {
        if (!isMultiWindow()) {
            return false;
        }
        updateWindowMode();
        if (!getMultiWindowEnabled()) {
            return false;
        }
        if (z) {
            this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP;
        } else {
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP ^ (-1);
        }
        setWindowMode(this.mWindowMode);
        setWindowParams();
        return true;
    }

    public boolean minimize(boolean z) {
        if (!isMultiWindow()) {
            return false;
        }
        updateWindowMode();
        if (!getMultiWindowEnabled()) {
            return false;
        }
        if (z == isMinimized()) {
            return true;
        }
        if (z) {
            this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED;
            this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP;
        } else {
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED ^ (-1);
        }
        setWindowMode(this.mWindowMode);
        setWindowParams();
        return true;
    }

    public boolean setRect(Rect rect) {
        if (rect == null || rect.height() < this.mMinimumSize.height() || rect.width() < this.mMinimumSize.width() || rect.height() > this.mMaximumSize.height() || rect.width() > this.mMaximumSize.width()) {
            return false;
        }
        updateWindowMode();
        setLastSize(rect);
        setWindowParams();
        return true;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    public Rect getRect() {
        if (!isMultiWindow()) {
            return this.mMaximumSize;
        }
        updateWindowMode();
        return getLastSize();
    }

    public boolean setMultiWindowEnabled(boolean z) {
        updateWindowMode();
        if (z) {
            this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_RESIZE;
        } else {
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_MASK ^ (-1);
            this.mWindowMode |= Constants.WindowManagerPolicy.WINDOW_MODE_NORMAL;
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_PINUP ^ (-1);
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_MINIMIZED ^ (-1);
            this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_RESIZE ^ (-1);
        }
        setWindowMode(this.mWindowMode);
        setWindowParams();
        return true;
    }

    public boolean getMultiWindowEnabled() {
        updateWindowMode();
        return checkOption(Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_COMMON_RESIZE);
    }

    public boolean setArrangeable(boolean z) {
        this.mArrangeable = z;
        return true;
    }

    public boolean getArrangeable() {
        return this.mArrangeable;
    }

    public int getZone() {
        updateWindowMode();
        return this.mWindowMode & Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK;
    }

    public void setZone(int i) {
        updateWindowMode();
        this.mWindowMode &= Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK ^ (-1);
        setWindowMode(this.mWindowMode | (Constants.WindowManagerPolicy.WINDOW_MODE_OPTION_SPLIT_ZONE_MASK & i));
    }

    @Deprecated
    public boolean isStartedAsPinup() {
        return false;
    }

    @Deprecated
    public MultiWindow(Context context, IMultiWindowService iMultiWindowService, Intent intent) {
        super(context);
        this.mArrangeable = true;
    }

    @Deprecated
    public MultiWindow(Context context, IMultiWindowService iMultiWindowService, ComponentName componentName) {
        super(context);
        this.mArrangeable = true;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean start() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean finish(int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean finish() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean maximize() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean restore() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean restore(int i) {
        return true;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean minimize() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean minimize(int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean isMaximized() {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean isMaximized(int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean isStartingSplitScreen(ComponentName componentName) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean relayout(Rect rect) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public Rect getRect(int i) {
        return new Rect();
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public int getWidth() {
        return -1;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public int getHeight() {
        return -1;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean setMinimumSize(int i, int i2) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public Point getMinimumSize() {
        return new Point(-1, -1);
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean fitToHalf(int i) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean pinUp(boolean z) {
        return false;
    }

    @Override // android.sec.multiwindow.IMultiWindow
    @Deprecated
    public boolean pinUp(boolean z, int i) {
        return false;
    }

    @Deprecated
    protected static boolean isEnabledComponentName(Context context, ComponentName componentName) {
        return true;
    }
}
