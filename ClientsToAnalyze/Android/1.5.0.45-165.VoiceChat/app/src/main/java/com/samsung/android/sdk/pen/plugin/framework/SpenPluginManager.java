package com.samsung.android.sdk.pen.plugin.framework;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import com.samsung.android.sdk.pen.pen.preload.Beautify;
import com.samsung.android.sdk.pen.pen.preload.NativePen;
import com.samsung.android.sdk.pen.plugin.framework.DoubleClassLoaderProxyBuilder;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenNativeHandleInterface;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPluginInterface;
import com.sec.spp.push.Config;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class SpenPluginManager {
    private static final String APK_PLUGIN_CHECK_INTENT = "com.samsung.android.sdk.pen.plugin.PICK";
    private static final int BINARY_TYPE_INDEX = 4;
    private static final int BINARY_TYPE_JAVA = 0;
    private static final int BINARY_TYPE_NATIVE = 1;
    private static final String[][] BUILTIN_PLUGIN_LIST = {new String[]{"Pen", "1", "SpenPenInterface", "1", "native", "0", "snote_popup_pensetting_pen", "snote_popup_pensetting_pen_select", "pen_preset_pen", "snote_popup_pensetting_pen_focus", "extraInfo", "InkPen", "com.samsung.android.sdk.pen.pen.preload", "InkPen"}, new String[]{"Pen", "1", "SpenPenInterface", "1", "native", "0", "snote_popup_pensetting_pencil", "snote_popup_pensetting_pencil_select", "pen_preset_pencil", "snote_popup_pensetting_pencil_focus", "extraInfo", "Pencil", "com.samsung.android.sdk.pen.pen.preload", "Pencil"}, new String[]{"Pen", "1", "SpenPenInterface", "1", "native", "0", "snote_popup_pensetting_brush", "snote_popup_pensetting_brush_select", "pen_preset_brush", "snote_popup_pensetting_brush_focus", "extraInfo", "Brush", "com.samsung.android.sdk.pen.pen.preload", "Brush"}, new String[]{"Pen", "1", "SpenPenInterface", "1", "native", "0", "snote_popup_pensetting_chinabrush", "snote_popup_pensetting_chinabrush_select", "pen_preset_chinabrush", "snote_popup_pensetting_chinabrush_focus", "extraInfo", "ChineseBrush", "com.samsung.android.sdk.pen.pen.preload", "ChineseBrush"}, new String[]{"Pen", "1", "SpenPenInterface", "1", "native", "0", "snote_popup_pensetting_marker", "snote_popup_pensetting_marker_select", "pen_preset_marker", "snote_popup_pensetting_marker_focus", "extraInfo", "Marker", "com.samsung.android.sdk.pen.pen.preload", "Marker"}, new String[]{"Pen", "1", "SpenPenInterface", "1", "native", "0", "snote_popup_pensetting_alpha", "snote_popup_pensetting_alpha_select", "pen_preset_alpha", "snote_popup_pensetting_alpha_focus", "extraInfo", "MagicPen", "com.samsung.android.sdk.pen.pen.preload", "MagicPen"}, new String[]{"Pen", "1", "SpenPenInterface", "1", "native", "0", "snote_popup_pensetting_chinabrush", "snote_popup_pensetting_chinabrush_select", "pen_preset_chinabrush", "snote_popup_pensetting_chinabrush_focus", "extraInfo", Beautify.TAG, "com.samsung.android.sdk.pen.pen.preload", Beautify.TAG}, new String[]{"ObjectRuntime", "1", "SpenObjectRuntimeInterface", "1", "java", "defaultIconImageURI", "0", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "extraInfo", "Video", "com.samsung.android.sdk.pen.objectruntime.preload", "Video"}, new String[]{"ObjectRuntime", "1", "SpenObjectRuntimeInterface", "1", "java", "defaultIconImageURI", "0", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "extraInfo", "SandPaper", "com.samsung.android.sdk.pen.objectruntime.preload", "SandPaper"}, new String[]{"ObjectRuntime", "1", "SpenObjectRuntimeInterface", "1", "java", "defaultIconImageURI", "0", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "extraInfo", "SnowPaper", "com.samsung.android.sdk.pen.objectruntime.preload", "SnowPaper"}, new String[]{"recognition", "1", "SpenLanguageRecognitionInterface", "1", "java", "0", "uriInfo", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "extraInfo", "Text", "com.samsung.text", "TextRecognitionPlugin"}, new String[]{"TextRecognition", "1", "SpenLanguageRecognitionInterface", "1", "java", "uriInfo", "1", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "1/4", "SpenText", "com.samsung.android.sdk.pen.recognition.preload", "TextRecognitionPlugin"}, new String[]{"EquationRecognition", "1", "SpenRecognitionInterface", "1", "java", "uriInfo", "1", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "1/4", "SpenEquation", "com.samsung.android.sdk.pen.recognition.preload", "EquationRecognitionPlugin"}, new String[]{"ShapeRecognition", "1", "SpenRecognitionInterface", "1", "java", "uriInfo", "1", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "1/4", "SpenShape", "com.samsung.android.sdk.pen.recognition.preload", "ShapeRecognitionPlugin"}, new String[]{"SignatureVerification", "1", "SpenSignatureVerificationInterface", "1", "java", "0", "uriInfo", "selectedIconImageURI", "presetIconImageURI", "focusedIconImageURI", "extraInfo", "SpenSignature", "com.samsung.android.sdk.pen.recognition.preload", "Signature"}};
    private static final int CLASS_NAME_INDEX = 13;
    private static final int EXTRA_INFO_INDEX = 10;
    private static final int FOCUSED_ICON_IMAGE_URI_INDEX = 9;
    private static final int HAS_PRIVATE_KEY_INDEX = 5;
    private static final int ICON_IMAGE_URI_INDEX = 6;
    private static final int INTERFACE_NAME_INDEX = 2;
    private static final int INTERFACE_VERSION_INDEX = 3;
    private static final String META_DATA_KEY_SPEN_PLUGIN_INFO = "SPEN_PLUGIN_INFO";
    private static final int PACKAGE_NAME_INDEX = 12;
    private static final int PLUGIN_NAME_URI_INDEX = 11;
    private static final int PRESET_ICON_IMAGE_URI_INDEX = 8;
    private static final int SELECTED_ICON_IMAGE_URI_INDEX = 7;
    private static final int TYPE_INDEX = 0;
    private static final int VERSION_INDEX = 1;
    private static SpenPluginManager mInstance;
    private List<SpenPluginInfo> mAPKPluginList;
    private List<SpenPluginInfo> mBuiltInPluginList;
    private JniPluginManager mJniPluginManager;
    private final ArrayList<SpenPluginObject> mLoadedPluginList = new ArrayList<>();
    private PackageReceiver mPackageReceiver;

    public static class PluginListener {
        private native void native_Installed(String str, String str2);

        private native void native_Uninstalled(String str, String str2);

        public void onInstalled(String pluginType, String packageName) {
            native_Installed(pluginType, packageName);
        }

        public void onUninstalled(String pluginType, String packageName) {
            native_Uninstalled(pluginType, packageName);
        }
    }

    private SpenPluginManager() {
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0297 A[Catch: all -> 0x000f, IOException -> 0x0265, NumberFormatException -> 0x0280, TRY_ENTER, TRY_LEAVE, TryCatch #5 {IOException -> 0x0265, NumberFormatException -> 0x0280, blocks: (B:35:0x00ce, B:36:0x00d8, B:38:0x00de, B:63:0x01db, B:65:0x01ed, B:67:0x024b, B:68:0x024e, B:69:0x0256, B:71:0x025c, B:82:0x0297, B:77:0x027d), top: B:92:0x00ce, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager getInstance(android.content.Context r21) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager.getInstance(android.content.Context):com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager");
    }

    public String getPrivateKeyHint(SpenPluginInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        String hint = null;
        synchronized (this.mLoadedPluginList) {
            Iterator it = this.mLoadedPluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenPluginObject o = it.next();
                if (info.packageName.equals(o.packageName) && info.canonicalClassName.equals(o.className)) {
                    hint = ((SpenPluginInterface) o.object).getPrivateKeyHint();
                    break;
                }
            }
        }
        return hint;
    }

    public List<SpenPluginInfo> getPluginList(String type) {
        Log.i("PluginManager", "getPluginList()");
        if (type == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'type' is null");
        }
        ArrayList<SpenPluginInfo> list = new ArrayList<>();
        for (SpenPluginInfo builtInPluginInfo : this.mBuiltInPluginList) {
            if (type.equals(builtInPluginInfo.type) || type.equals("all")) {
                list.add(builtInPluginInfo);
            }
        }
        for (SpenPluginInfo apkPluginInfo : this.mAPKPluginList) {
            if (type.equals(apkPluginInfo.type) || type.equals("all")) {
                list.add(apkPluginInfo);
            }
        }
        Log.i("PluginManager", "getPluginList() is completed.");
        return list;
    }

    public SpenPluginInfo getPluginInfo(String className) {
        Log.i("PluginManager", "getPluginInfo()");
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'uuid' is null");
        }
        for (SpenPluginInfo builtInPluginInfo : this.mBuiltInPluginList) {
            if (className.equals(String.valueOf(builtInPluginInfo.packageName) + "." + builtInPluginInfo.canonicalClassName)) {
                return builtInPluginInfo;
            }
        }
        for (SpenPluginInfo apkPluginInfo : this.mAPKPluginList) {
            if (className.equals(String.valueOf(apkPluginInfo.packageName) + "." + apkPluginInfo.canonicalClassName)) {
                SpenPluginInfo pluginInfo = new SpenPluginInfo();
                pluginInfo.type = apkPluginInfo.type;
                pluginInfo.version = apkPluginInfo.version;
                pluginInfo.interfaceName = apkPluginInfo.interfaceName;
                pluginInfo.interfaceVersion = apkPluginInfo.interfaceVersion;
                pluginInfo.binaryType = apkPluginInfo.binaryType;
                pluginInfo.hasPrivateKey = apkPluginInfo.hasPrivateKey;
                pluginInfo.iconImageUri = apkPluginInfo.iconImageUri;
                pluginInfo.selectedIconImageUri = apkPluginInfo.selectedIconImageUri;
                pluginInfo.presetIconImageUri = apkPluginInfo.presetIconImageUri;
                pluginInfo.focusedIconImageUri = apkPluginInfo.focusedIconImageUri;
                pluginInfo.extraInfo = apkPluginInfo.extraInfo;
                pluginInfo.packageName = apkPluginInfo.packageName;
                pluginInfo.canonicalClassName = apkPluginInfo.canonicalClassName;
                Log.i("PluginManager", "getPluginInfo() is completed");
                return pluginInfo;
            }
        }
        Log.i("PluginManager", "getPluginInfo() returns false");
        return null;
    }

    public Object loadPlugin(Context context, SpenPluginInfo info, String key) throws Exception {
        Object object;
        Log.i("PluginManager", "loadPlugin()");
        if (context == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null Context");
        }
        if (this.mJniPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null JniPluginManager");
        }
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        boolean checkBuiltIn = false;
        ClassLoader pluginClassLoader = null;
        synchronized (this.mLoadedPluginList) {
            Iterator it = this.mLoadedPluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenPluginObject o = it.next();
                if (info.packageName.equals(o.packageName) && info.canonicalClassName.equals(o.className)) {
                    pluginClassLoader = o.classLoader;
                    break;
                }
            }
        }
        Iterator<SpenPluginInfo> it2 = this.mBuiltInPluginList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            SpenPluginInfo builtinPluginInfo = it2.next();
            if (info.packageName.equals(builtinPluginInfo.packageName) && info.canonicalClassName.equals(builtinPluginInfo.canonicalClassName)) {
                checkBuiltIn = true;
                break;
            }
        }
        if (checkBuiltIn) {
            String interfaceName = String.valueOf(SpenPluginInterface.class.getPackage().getName()) + "." + info.interfaceName;
            String className = String.valueOf(info.packageName) + "." + info.canonicalClassName;
            pluginClassLoader = context.getClassLoader();
            object = DoubleClassLoaderProxyBuilder.build(Class.forName(interfaceName, true, context.getClassLoader()), className, pluginClassLoader);
        } else {
            try {
                PackageManager pm = context.getPackageManager();
                if (pm == null) {
                    Log.d("PluginManager", "PackageManager is null");
                    return null;
                }
                ApplicationInfo ai = pm.getApplicationInfo(info.packageName, 128);
                String interfaceName2 = String.valueOf(SpenPluginInterface.class.getPackage().getName()) + "." + info.interfaceName;
                String className2 = ai.className;
                String pluginApkSourceDir = ai.sourceDir;
                if (pluginClassLoader == null) {
                    pluginClassLoader = new PathClassLoader(pluginApkSourceDir, ClassLoader.getSystemClassLoader());
                }
                object = DoubleClassLoaderProxyBuilder.build(Class.forName(interfaceName2, true, context.getClassLoader()), className2, pluginClassLoader);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (object != null) {
            SpenPluginObject pluginObject = new SpenPluginObject();
            pluginObject.type = info.type;
            pluginObject.binaryType = info.binaryType;
            pluginObject.packageName = info.packageName;
            pluginObject.className = info.canonicalClassName;
            pluginObject.object = object;
            pluginObject.dummyObject = null;
            if (pluginObject.binaryType == 1) {
                pluginObject.nativeHandle = ((SpenNativeHandleInterface) object).getNativeHandle();
            } else if (pluginObject.type.equals("Pen")) {
                NativePen pen = new NativePen();
                pen.construct();
                pen.setObject(pluginObject.object);
                pluginObject.dummyObject = pen;
                pluginObject.nativeHandle = pen.getNativeHandle();
            } else {
                pluginObject.nativeHandle = 0;
            }
            pluginObject.classLoader = pluginClassLoader;
            if (!((SpenPluginInterface) object).unlock(key)) {
                throw new IllegalArgumentException("E_INVALID_ARG : parameter 'key' is wrong");
            }
            synchronized (this.mLoadedPluginList) {
                this.mLoadedPluginList.add(pluginObject);
            }
            if (pluginObject.nativeHandle != 0) {
                this.mJniPluginManager.onLoad(pluginObject.nativeHandle, context);
            } else {
                ((SpenPluginInterface) object).onLoad(context);
            }
        }
        Log.i("PluginManager", "loadPlugin() is completed");
        return object;
    }

    public Object loadPlugin(Activity activity, SpenPluginInfo info, String key) throws Exception {
        Object object;
        Log.i("PluginManager", "loadPlugin()");
        if (activity == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null Activity");
        }
        if (this.mJniPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use loadPlugin by null JniPluginManager");
        }
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        boolean checkBuiltIn = false;
        ClassLoader pluginClassLoader = null;
        synchronized (this.mLoadedPluginList) {
            Iterator it = this.mLoadedPluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenPluginObject o = it.next();
                if (info.packageName.equals(o.packageName) && info.canonicalClassName.equals(o.className)) {
                    pluginClassLoader = o.classLoader;
                    break;
                }
            }
        }
        Iterator<SpenPluginInfo> it2 = this.mBuiltInPluginList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            SpenPluginInfo builtinPluginInfo = it2.next();
            if (info.packageName.equals(builtinPluginInfo.packageName) && info.canonicalClassName.equals(builtinPluginInfo.canonicalClassName)) {
                checkBuiltIn = true;
                break;
            }
        }
        if (checkBuiltIn) {
            String interfaceName = String.valueOf(SpenPluginInterface.class.getPackage().getName()) + "." + info.interfaceName;
            String className = String.valueOf(info.packageName) + "." + info.canonicalClassName;
            pluginClassLoader = activity.getClassLoader();
            object = DoubleClassLoaderProxyBuilder.build(Class.forName(interfaceName, true, activity.getClassLoader()), className, pluginClassLoader);
        } else {
            try {
                PackageManager pm = activity.getPackageManager();
                if (pm == null) {
                    Log.d("PluginManager", "PackageManager is null");
                    return null;
                }
                ApplicationInfo ai = pm.getApplicationInfo(info.packageName, 128);
                String interfaceName2 = String.valueOf(SpenPluginInterface.class.getPackage().getName()) + "." + info.interfaceName;
                String className2 = ai.className;
                String pluginApkSourceDir = ai.sourceDir;
                if (pluginClassLoader == null) {
                    pluginClassLoader = new PathClassLoader(pluginApkSourceDir, ClassLoader.getSystemClassLoader());
                }
                object = DoubleClassLoaderProxyBuilder.build(Class.forName(interfaceName2, true, activity.getClassLoader()), className2, pluginClassLoader);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (object != null) {
            SpenPluginObject pluginObject = new SpenPluginObject();
            pluginObject.type = info.type;
            pluginObject.binaryType = info.binaryType;
            pluginObject.packageName = info.packageName;
            pluginObject.className = info.canonicalClassName;
            pluginObject.object = object;
            pluginObject.dummyObject = null;
            if (pluginObject.binaryType == 1) {
                pluginObject.nativeHandle = ((SpenNativeHandleInterface) object).getNativeHandle();
            } else if (pluginObject.type.equals("Pen")) {
                NativePen pen = new NativePen();
                pen.construct();
                pen.setObject(pluginObject.object);
                pluginObject.dummyObject = pen;
                pluginObject.nativeHandle = pen.getNativeHandle();
            } else {
                pluginObject.nativeHandle = 0;
            }
            pluginObject.classLoader = pluginClassLoader;
            if (!((SpenPluginInterface) object).unlock(key)) {
                throw new IllegalArgumentException("E_INVALID_ARG : parameter 'key' is wrong");
            }
            synchronized (this.mLoadedPluginList) {
                this.mLoadedPluginList.add(pluginObject);
            }
            if (pluginObject.nativeHandle != 0) {
                this.mJniPluginManager.onLoad(pluginObject.nativeHandle, activity);
            } else {
                ((SpenPluginInterface) object).onLoad(activity);
            }
        }
        Log.i("PluginManager", "loadPlugin() is completed");
        return object;
    }

    public void unloadPlugin(Object object) {
        Log.i("PluginManager", "unloadPlugin()");
        if (this.mJniPluginManager == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use unloadPlugin by null JniPluginManager");
        }
        if (object == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'object' is null");
        }
        DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler handler = (DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) Proxy.getInvocationHandler(object);
        if (handler == null) {
            throw new NullPointerException("E_INVALID_ARG : proxy handler of object is null");
        }
        String className = handler.instance.getClass().getName();
        boolean checkUnloaded = false;
        synchronized (this.mLoadedPluginList) {
            Iterator it = this.mLoadedPluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenPluginObject o = it.next();
                if (className.equals(String.valueOf(o.packageName) + "." + o.className)) {
                    checkUnloaded = true;
                    DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler h = (DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) Proxy.getInvocationHandler(o.object);
                    if (handler.instance.equals(h.instance)) {
                        if (o.nativeHandle != 0) {
                            this.mJniPluginManager.onUnload(o.nativeHandle);
                        } else {
                            ((SpenPluginInterface) object).onUnload();
                        }
                        this.mLoadedPluginList.remove(o);
                        o.object = null;
                    }
                }
            }
        }
        if (!checkUnloaded) {
            Log.i("PluginManager", "unloadPlugin() returns false");
            throw new IllegalArgumentException("E_INVALID_ARG : Data to unload does not found");
        }
        Log.i("PluginManager", "unloadPlugin() is completed");
    }

    public void setListener(PluginListener listener) {
        Log.i("PluginManager", "setListener()");
        if (this.mPackageReceiver == null) {
            throw new IllegalStateException("E_INVALID_STATE : Unable to Use setPluginListener by null PackageReceiver");
        }
        if (listener == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'listener' is null");
        }
        this.mPackageReceiver.setNotifyListener(listener);
        Log.i("PluginManager", "setPluginListener() is completed");
    }

    public int getNativeHandle(Object object) {
        Log.i("PluginManager", "getNativeHandle()");
        if (object == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'object' is null");
        }
        int ret = 0;
        DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler handler = (DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) Proxy.getInvocationHandler(object);
        String className = handler.instance.getClass().getName();
        synchronized (this.mLoadedPluginList) {
            Iterator it = this.mLoadedPluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenPluginObject o = it.next();
                if (className.equals(String.valueOf(o.packageName) + "." + o.className)) {
                    if (0 != 0) {
                        if (object.equals(o.object)) {
                            ret = o.nativeHandle;
                            break;
                        }
                    } else {
                        DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler h = (DoubleClassLoaderProxyBuilder.DoubleClassLoaderInvocationHandler) Proxy.getInvocationHandler(o.object);
                        if (handler.instance.equals(h.instance)) {
                            ret = o.nativeHandle;
                            break;
                        }
                    }
                }
            }
        }
        Log.i("PluginManager", "getNativeHandle() is completed. returns " + ret);
        return ret;
    }

    void updateAPKPluginList(Context context) throws PackageManager.NameNotFoundException {
        Intent intent = new Intent();
        intent.setAction(APK_PLUGIN_CHECK_INTENT);
        for (ResolveInfo resolveinfo : context.getPackageManager().queryIntentServices(intent, 0)) {
            boolean isExist = false;
            Iterator<SpenPluginInfo> it = this.mBuiltInPluginList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SpenPluginInfo info = it.next();
                if (resolveinfo.serviceInfo.applicationInfo.packageName.equals(String.valueOf(info.packageName) + "." + info.canonicalClassName)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                Iterator<SpenPluginInfo> it2 = this.mAPKPluginList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    SpenPluginInfo info2 = it2.next();
                    if (resolveinfo.serviceInfo.applicationInfo.packageName.equals(String.valueOf(info2.packageName) + "." + info2.canonicalClassName)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    SpenPluginInfo pluginInfo = new SpenPluginInfo();
                    String[] split = resolveinfo.serviceInfo.applicationInfo.packageName.split("\\.");
                    StringBuffer packageName = new StringBuffer();
                    for (int i = 0; i < split.length - 1; i++) {
                        packageName.append(split[i]);
                        packageName.append(".");
                    }
                    packageName.deleteCharAt(packageName.length() - 1);
                    pluginInfo.packageName = packageName.toString();
                    pluginInfo.canonicalClassName = split[split.length - 1];
                    try {
                        PackageManager pm = context.getPackageManager();
                        if (pm == null) {
                            Log.d("PluginManager", "PackageManager is null");
                        } else {
                            ApplicationInfo ai = pm.getApplicationInfo(resolveinfo.serviceInfo.applicationInfo.packageName, 128);
                            Bundle bundle = ai.metaData;
                            String pluginInfoData = bundle.getString(META_DATA_KEY_SPEN_PLUGIN_INFO);
                            if (pluginInfoData != null) {
                                String[] array = pluginInfoData.split(Config.KEYVALUE_SPLIT);
                                if (array.length == 14) {
                                    pluginInfo.type = array[0];
                                    pluginInfo.version = Integer.parseInt(array[1]);
                                    pluginInfo.interfaceName = array[2];
                                    pluginInfo.interfaceVersion = Integer.parseInt(array[3]);
                                    String binaryType = array[4];
                                    pluginInfo.hasPrivateKey = Boolean.parseBoolean(array[5]);
                                    pluginInfo.iconImageUri = array[6];
                                    pluginInfo.selectedIconImageUri = array[7];
                                    pluginInfo.presetIconImageUri = array[8];
                                    pluginInfo.focusedIconImageUri = array[9];
                                    pluginInfo.extraInfo = array[10];
                                    pluginInfo.pluginNameUri = array[11];
                                    if (binaryType.equals("native")) {
                                        pluginInfo.binaryType = 1;
                                    } else {
                                        pluginInfo.binaryType = 0;
                                    }
                                    this.mAPKPluginList.add(pluginInfo);
                                }
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    void deleteAPKPluginInfo(String className) {
        for (SpenPluginInfo info : this.mAPKPluginList) {
            if (className.equals(String.valueOf(info.packageName) + "." + info.canonicalClassName)) {
                this.mAPKPluginList.remove(info);
                return;
            }
        }
    }
}
