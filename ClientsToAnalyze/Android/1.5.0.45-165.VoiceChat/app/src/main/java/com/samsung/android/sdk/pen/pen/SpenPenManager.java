package com.samsung.android.sdk.pen.pen;

import android.content.Context;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenPenInterface;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class SpenPenManager {
    private static final String PLUGIN_TYPE = "Pen";
    public static final String SPEN_BRUSH = "com.samsung.android.sdk.pen.pen.preload.Brush";
    public static final String SPEN_CHINESE_BRUSH = "com.samsung.android.sdk.pen.pen.preload.ChineseBrush";
    public static final String SPEN_INK_PEN = "com.samsung.android.sdk.pen.pen.preload.InkPen";
    public static final String SPEN_MAGIC_PEN = "com.samsung.android.sdk.pen.pen.preload.MagicPen";
    public static final String SPEN_MARKER = "com.samsung.android.sdk.pen.pen.preload.Marker";
    public static final String SPEN_PENCIL = "com.samsung.android.sdk.pen.pen.preload.Pencil";
    private Context mContext;
    private InstallListener mListener;

    public interface InstallListener {
        void onInstalled(String str);

        void onUninstalled(String str);
    }

    public SpenPenManager(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mContext = context;
    }

    public void setListener(InstallListener listener) {
        this.mListener = listener;
        if (this.mListener != null) {
            SpenPluginManager.getInstance(this.mContext).setListener(new SpenPluginManager.PluginListener() { // from class: com.samsung.android.sdk.pen.pen.SpenPenManager.1
                @Override // com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager.PluginListener
                public void onInstalled(String pluginType, String packageName) {
                    if (pluginType.equals(SpenPenManager.PLUGIN_TYPE)) {
                        SpenPenManager.this.mListener.onInstalled(packageName);
                    }
                }

                @Override // com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager.PluginListener
                public void onUninstalled(String pluginType, String packageName) {
                    if (pluginType.equals(SpenPenManager.PLUGIN_TYPE)) {
                        SpenPenManager.this.mListener.onUninstalled(packageName);
                    }
                }
            });
        }
    }

    public String getPrivateKeyHint(SpenPenInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenPluginInfo> penList = SpenPluginManager.getInstance(this.mContext).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : penList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return SpenPluginManager.getInstance(this.mContext).getPrivateKeyHint(pluginInfo);
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Pen");
    }

    public List<SpenPenInfo> getPenInfoList() {
        List<SpenPluginInfo> penList = SpenPluginManager.getInstance(this.mContext).getPluginList(PLUGIN_TYPE);
        List<SpenPenInfo> outputList = new ArrayList<>();
        for (SpenPluginInfo info : penList) {
            SpenPenInfo penInfo = new SpenPenInfo();
            penInfo.name = info.pluginNameUri;
            penInfo.className = String.valueOf(info.packageName) + "." + info.canonicalClassName;
            penInfo.version = info.version;
            penInfo.iconImageUri = info.iconImageUri;
            penInfo.hasPrivateKey = info.hasPrivateKey;
            outputList.add(penInfo);
        }
        if (outputList.isEmpty()) {
            return null;
        }
        return outputList;
    }

    public SpenPen createPen(SpenPenInfo info) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenPluginInfo> penList = SpenPluginManager.getInstance(this.mContext).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : penList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return new SpenPen(this.mContext, (SpenPenInterface) SpenPluginManager.getInstance(this.mContext).loadPlugin(this.mContext, pluginInfo, ""));
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Pen");
    }

    public SpenPen createPen(SpenPenInfo info, String key) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        List<SpenPluginInfo> penList = SpenPluginManager.getInstance(this.mContext).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : penList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return new SpenPen(this.mContext, (SpenPenInterface) SpenPluginManager.getInstance(this.mContext).loadPlugin(this.mContext, pluginInfo, key));
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Pen");
    }

    public SpenPen createPen(String className) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenPluginInfo> penList = SpenPluginManager.getInstance(this.mContext).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : penList) {
            if (className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName)) {
                return new SpenPen(this.mContext, (SpenPenInterface) SpenPluginManager.getInstance(this.mContext).loadPlugin(this.mContext, pluginInfo, ""));
            }
        }
        throw new ClassNotFoundException("Can not find " + className + " Pen");
    }

    public SpenPen createPen(String className, String key) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'packageName' or 'className' is null");
        }
        List<SpenPluginInfo> penList = SpenPluginManager.getInstance(this.mContext).getPluginList(PLUGIN_TYPE);
        for (SpenPluginInfo pluginInfo : penList) {
            if (className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName)) {
                return new SpenPen(this.mContext, (SpenPenInterface) SpenPluginManager.getInstance(this.mContext).loadPlugin(this.mContext, pluginInfo, key));
            }
        }
        throw new ClassNotFoundException("Can not find " + className + " Pen");
    }

    public void destroyPen(SpenPen pen) {
        if (pen == null || pen.getPenObject() == null) {
            throw new IllegalStateException("E_INVALID_STATE : parameter 'pen' is null");
        }
        SpenPluginManager.getInstance(this.mContext).unloadPlugin(pen.getPenObject());
        pen.close();
    }

    public void close() {
        this.mContext = null;
        this.mListener = null;
    }
}
