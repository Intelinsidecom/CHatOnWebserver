package com.samsung.android.sdk.pen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class Spen implements SsdkInterface {
    private static final int DEFAULT_MAX_CACHE_SIZE = 5;
    public static final int DEVICE_PEN = 0;
    public static final String SPEN_NATIVE_PACKAGE_NAME = "com.samsung.android.sdk.spen30";
    private static final String VERSION = "3.0.8";
    private static final int VERSION_LEVEL = 4;
    private static boolean mIsInitialized = false;

    private static native boolean SPenSdk_init(String str, int i, int i2);

    private static native boolean SPenSdk_init2(String str, int i, int i2, int i3);

    int B21433A29DE24(int input) {
        return (input * input) + input;
    }

    @SuppressLint({"SdCardPath"})
    boolean loadLibrary(String libraryName) {
        String latestLib = "/data/data/com.samsung.android.sdk.spen30/lib/lib" + libraryName + ".so";
        File libFilePath = new File(latestLib);
        if (libFilePath.exists()) {
            try {
                System.load(libFilePath.toString());
                return true;
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() {
        return 4;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public String getVersionName() {
        return VERSION;
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int type) {
        switch (type) {
            case 0:
                File path = new File("/sys/class/sec/sec_epen");
                return path.isDirectory();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // com.samsung.android.sdk.SsdkInterface
    public void initialize(Context context) throws NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, SsdkUnsupportedException {
        initialize(context, 5);
    }

    public void initialize(Context context, int maxCacheSize) throws NoSuchMethodException, PackageManager.NameNotFoundException, SecurityException, SsdkUnsupportedException {
        int width;
        int height;
        Log.d("Spen", "SpenSdk jar version = " + getVersionCode());
        if (context == null) {
            throw new IllegalArgumentException("context is invalid.");
        }
        File appFilesDir = context.getFilesDir();
        if (!appFilesDir.exists() && !appFilesDir.mkdirs()) {
            Log.e("Spen", "Cannot create application files directory");
            throw new IllegalStateException("Cannot create application directory.");
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        try {
            Point point = new Point();
            windowManager.getDefaultDisplay().getRealSize(point);
            width = point.x;
            height = point.y;
        } catch (NoSuchMethodError e) {
            try {
                Display display = windowManager.getDefaultDisplay();
                Method getRawW = Display.class.getMethod("getRawWidth", new Class[0]);
                Method getRawH = Display.class.getMethod("getRawHeight", new Class[0]);
                width = ((Integer) getRawW.invoke(display, new Object[0])).intValue();
                height = ((Integer) getRawH.invoke(display, new Object[0])).intValue();
            } catch (Exception e2) {
                try {
                    Point point2 = new Point();
                    windowManager.getDefaultDisplay().getSize(point2);
                    width = point2.x;
                    height = point2.y;
                } catch (NoSuchMethodError e3) {
                    Display display2 = windowManager.getDefaultDisplay();
                    width = display2.getWidth();
                    height = display2.getHeight();
                }
            }
        }
        if (mIsInitialized) {
            if (!SPenSdk_init2(appFilesDir.getAbsolutePath(), width, height, maxCacheSize)) {
                throw new IllegalStateException("SDK Cache directory is not initialized.");
            }
            Log.d("Spen", "initialize complete");
            return;
        }
        String strBrand = Build.BRAND;
        String strManufacturer = Build.MANUFACTURER;
        if (strBrand == null || strManufacturer == null) {
            throw new SsdkUnsupportedException("Vendor is not supported", 0);
        }
        if (strBrand.compareToIgnoreCase("Samsung") != 0 && strManufacturer.compareToIgnoreCase("Samsung") != 0) {
            throw new SsdkUnsupportedException("Vendor is not supported", 0);
        }
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo packageInfo = pm.getPackageInfo(SPEN_NATIVE_PACKAGE_NAME, 0);
            Log.d("Spen", "SpenSdk apk version = " + packageInfo.versionName);
            String[] packageVersion = packageInfo.versionName.split("\\.");
            String[] javaVersion = VERSION.split("\\.");
            int[] packageData = new int[4];
            int[] javaData = new int[4];
            for (int i = 0; i < 4; i++) {
                if (packageVersion.length <= i) {
                    packageData[i] = 0;
                } else if (packageVersion[i].isEmpty()) {
                    packageData[i] = 0;
                } else {
                    packageData[i] = Integer.parseInt(packageVersion[i]);
                }
            }
            for (int i2 = 0; i2 < 4; i2++) {
                if (javaVersion.length <= i2) {
                    javaData[i2] = 0;
                } else if (javaVersion[i2].isEmpty()) {
                    javaData[i2] = 0;
                } else {
                    javaData[i2] = Integer.parseInt(javaVersion[i2]);
                }
            }
            if (javaData[0] > packageData[0] || (javaData[0] == packageData[0] && javaData[1] > packageData[1])) {
                Log.d("Spen", "You SHOULD UPDATE SpenSdk apk file !!!!");
                throw new SsdkUnsupportedException("SpenSdk apk version is low.", 3);
            }
            Log.d("Spen", "Server UPDATE Check");
            if (!loadLibrary("SPenBase") || !loadLibrary("SPenPluginFW") || !loadLibrary("SPenInit") || !loadLibrary("SPenModel") || !loadLibrary("SPenSkia") || !loadLibrary("SPenEngine") || !loadLibrary("SPenBrush") || !loadLibrary("SPenChineseBrush") || !loadLibrary("SPenInkPen") || !loadLibrary("SPenMarker") || !loadLibrary("SPenPencil") || !loadLibrary("SPenNativePen") || !loadLibrary("SPenMagicPen") || !loadLibrary("SPenHSV") || !loadLibrary("SPenVIRecognition") || !loadLibrary("SPenVITextAll")) {
                throw new IllegalStateException();
            }
            Log.d("Spen", "SpenSdk Libraries are loaded.");
            if (!SPenSdk_init2(appFilesDir.getAbsolutePath(), width, height, maxCacheSize)) {
                throw new IllegalStateException("SDK Cache directory is not initialized.");
            }
            mIsInitialized = true;
            Log.d("Spen", "initialize complete");
        } catch (PackageManager.NameNotFoundException e4) {
            Log.d("Spen", "You SHOULD INSTALL SpenSdk apk file !!!!");
            throw new SsdkUnsupportedException("SpenSdk apk is not installed.", 2);
        }
    }
}
