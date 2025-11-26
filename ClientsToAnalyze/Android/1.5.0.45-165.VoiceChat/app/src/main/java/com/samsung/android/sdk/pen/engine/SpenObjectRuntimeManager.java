package com.samsung.android.sdk.pen.engine;

import android.app.Activity;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenObjectRuntimeInterface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SpenObjectRuntimeManager {
    private static final String PLUGIN_TYPE = "ObjectRuntime";
    private Activity mActivity;
    private InstallListener mListener;

    public interface InstallListener {
        void onInstalled(String str);

        void onUninstalled(String str);
    }

    public SpenObjectRuntimeManager(Activity actvity) {
        if (actvity == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mActivity = actvity;
    }

    public void setListener(InstallListener listener) {
        this.mListener = listener;
        if (this.mListener != null) {
            SpenPluginManager.getInstance(this.mActivity).setListener(new SpenPluginManager.PluginListener() { // from class: com.samsung.android.sdk.pen.engine.SpenObjectRuntimeManager.1
                @Override // com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager.PluginListener
                public void onInstalled(String pluginType, String packageName) {
                    if (pluginType.equals(SpenObjectRuntimeManager.PLUGIN_TYPE)) {
                        SpenObjectRuntimeManager.this.mListener.onInstalled(packageName);
                    }
                }

                @Override // com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager.PluginListener
                public void onUninstalled(String pluginType, String packageName) {
                    if (pluginType.equals(SpenObjectRuntimeManager.PLUGIN_TYPE)) {
                        SpenObjectRuntimeManager.this.mListener.onUninstalled(packageName);
                    }
                }
            });
        }
    }

    public String getPrivateKeyHint(SpenObjectRuntimeInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenPluginInfo> pluginList = SpenPluginManager.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : pluginList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                try {
                    return SpenPluginManager.getInstance(this.mActivity).getPrivateKeyHint(pluginInfo);
                } catch (InstantiationException e) {
                    throw new InstantiationException("SpenPluginManager.getInstance Error");
                }
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " ObjectRuntime");
    }

    public List<SpenObjectRuntimeInfo> getObjectRuntimeInfoList() {
        List<SpenPluginInfo> orList = SpenPluginManager.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE);
        List<SpenObjectRuntimeInfo> outputList = new ArrayList<>();
        for (SpenPluginInfo info : orList) {
            SpenObjectRuntimeInfo ObjectRuntimeInfo = new SpenObjectRuntimeInfo();
            ObjectRuntimeInfo.name = info.pluginNameUri;
            ObjectRuntimeInfo.className = String.valueOf(info.packageName) + "." + info.canonicalClassName;
            ObjectRuntimeInfo.version = info.version;
            ObjectRuntimeInfo.iconImageUri = info.iconImageUri;
            ObjectRuntimeInfo.hasPrivateKey = info.hasPrivateKey;
            outputList.add(ObjectRuntimeInfo);
        }
        if (outputList.isEmpty()) {
            return null;
        }
        return outputList;
    }

    public SpenObjectRuntime createObjectRuntime(SpenObjectRuntimeInfo info) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenPluginInfo> orList = SpenPluginManager.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : orList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return new SpenObjectRuntime((SpenObjectRuntimeInterface) SpenPluginManager.getInstance(this.mActivity).loadPlugin(this.mActivity, pluginInfo, ""));
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " ObjectRuntime");
    }

    public SpenObjectRuntime createObjectRuntime(SpenObjectRuntimeInfo info, String privateKey) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenPluginInfo> orList = SpenPluginManager.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : orList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return new SpenObjectRuntime((SpenObjectRuntimeInterface) SpenPluginManager.getInstance(this.mActivity).loadPlugin(this.mActivity, pluginInfo, privateKey));
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " ObjectRuntime");
    }

    public SpenObjectRuntime createObjectRuntime(String className) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenPluginInfo> orList = SpenPluginManager.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : orList) {
            if (className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName)) {
                return new SpenObjectRuntime((SpenObjectRuntimeInterface) SpenPluginManager.getInstance(this.mActivity).loadPlugin(this.mActivity, pluginInfo, ""));
            }
        }
        throw new ClassNotFoundException("Can not find " + className + " ObjectRuntime");
    }

    public SpenObjectRuntime createObjectRuntime(String className, String privateKey) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenPluginInfo> orList = SpenPluginManager.getInstance(this.mActivity).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : orList) {
            if (className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName)) {
                return new SpenObjectRuntime((SpenObjectRuntimeInterface) SpenPluginManager.getInstance(this.mActivity).loadPlugin(this.mActivity, pluginInfo, privateKey));
            }
        }
        throw new ClassNotFoundException("Can not find " + className + " ObjectRuntime");
    }

    public void unload(SpenObjectRuntime objectRuntime) {
        if (objectRuntime == null || objectRuntime.getObjectRuntimeObject() == null) {
            throw new IllegalStateException("E_INVALID_STATE : ObjectRuntime is not loaded");
        }
        SpenPluginManager.getInstance(this.mActivity).unloadPlugin(objectRuntime.getObjectRuntimeObject());
    }

    public void close() {
        this.mActivity = null;
        this.mListener = null;
    }
}
