package com.samsung.android.sdk.pen.recognition;

import android.content.Context;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginInfo;
import com.samsung.android.sdk.pen.plugin.framework.SpenPluginManager;
import com.samsung.android.sdk.pen.plugin.interfaces.SpenSignatureVerificationInterface;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class SpenSignatureVerificationManager {
    public static final String SPEN_SIGNATURE = "com.samsung.android.sdk.pen.recognition.preload.Signature";
    private Context mContext;
    private List<SpenPluginInfo> mPluginList = null;
    private SpenPluginManager mPluginManager;

    public SpenSignatureVerificationManager(Context context) {
        this.mContext = null;
        this.mPluginManager = null;
        if (context == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'context' is null");
        }
        this.mPluginManager = SpenPluginManager.getInstance(context);
        this.mContext = context;
    }

    public List<SpenSignatureVerificationInfo> getInfoList() {
        List<SpenPluginInfo> tempList = this.mPluginManager.getPluginList("SignatureVerification");
        if (tempList == null) {
            return null;
        }
        ArrayList<SpenSignatureVerificationInfo> outputList = new ArrayList<>();
        for (SpenPluginInfo info : tempList) {
            SpenSignatureVerificationInfo signatureInfo = new SpenSignatureVerificationInfo();
            signatureInfo.name = info.pluginNameUri;
            signatureInfo.version = info.version;
            signatureInfo.className = String.valueOf(info.packageName) + "." + info.canonicalClassName;
            signatureInfo.iconImageUri = info.iconImageUri;
            signatureInfo.hasPrivateKey = info.hasPrivateKey;
            outputList.add(signatureInfo);
        }
        this.mPluginList = tempList;
        return outputList;
    }

    public String getPrivateKeyHint(SpenSignatureVerificationInfo info) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        if (this.mPluginList == null) {
            throw new IllegalStateException("E_INVALID_STATE : candidateList is not made yet");
        }
        for (SpenPluginInfo pluginInfo : this.mPluginList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                return this.mPluginManager.getPrivateKeyHint(pluginInfo);
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Signature Verification");
    }

    public SpenSignatureVerification createSignatureVerification(SpenSignatureVerificationInfo info) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        if (this.mPluginList == null) {
            throw new IllegalStateException("E_INVALID_STATE : candidateList is not made yet");
        }
        for (SpenPluginInfo pluginInfo : this.mPluginList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                try {
                    return new SpenSignatureVerification(this.mContext, (SpenSignatureVerificationInterface) this.mPluginManager.loadPlugin(this.mContext, pluginInfo, ""));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("SignatureRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Signature Verification");
    }

    public SpenSignatureVerification createSignatureVerification(SpenSignatureVerificationInfo info, String key) throws Exception {
        if (info == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'info' is null");
        }
        if (this.mPluginList == null) {
            throw new IllegalStateException("E_INVALID_STATE : candidateList is not made yet");
        }
        for (SpenPluginInfo pluginInfo : this.mPluginList) {
            if (info.className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName) && info.name.equals(pluginInfo.pluginNameUri) && info.version == pluginInfo.version) {
                try {
                    return new SpenSignatureVerification(this.mContext, (SpenSignatureVerificationInterface) this.mPluginManager.loadPlugin(this.mContext, pluginInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("SignatureRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("Can not find " + info.name + " Signature Verification");
    }

    public SpenSignatureVerification createSignatureVerification(String className) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'className' is null");
        }
        List<SpenPluginInfo> tempList = this.mPluginManager.getPluginList("SignatureVerification");
        if (tempList == null) {
            throw new SpenCreationFailureException("There is no available SpenSignatureVerification engine");
        }
        if (this.mPluginList != null && !this.mPluginList.isEmpty()) {
            this.mPluginList.clear();
        }
        this.mPluginList = tempList;
        for (SpenPluginInfo pluginInfo : this.mPluginList) {
            if (className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName)) {
                try {
                    return new SpenSignatureVerification(this.mContext, (SpenSignatureVerificationInterface) this.mPluginManager.loadPlugin(this.mContext, pluginInfo, ""));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("SignatureRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("Can not find " + className + " Signature Verification");
    }

    public SpenSignatureVerification createSignatureVerification(String className, String key) throws Exception {
        if (className == null) {
            throw new IllegalArgumentException("E_INVALID_ARG : parameter 'packageName' or 'className' is null");
        }
        List<SpenPluginInfo> tempList = this.mPluginManager.getPluginList("SignatureVerification");
        if (tempList == null) {
            throw new SpenCreationFailureException("There is no available SpenSignatureVerification engine");
        }
        if (this.mPluginList != null && !this.mPluginList.isEmpty()) {
            this.mPluginList.clear();
        }
        this.mPluginList = tempList;
        for (SpenPluginInfo pluginInfo : this.mPluginList) {
            if (className.equals(String.valueOf(pluginInfo.packageName) + "." + pluginInfo.canonicalClassName)) {
                try {
                    return new SpenSignatureVerification(this.mContext, (SpenSignatureVerificationInterface) this.mPluginManager.loadPlugin(this.mContext, pluginInfo, key));
                } catch (UndeclaredThrowableException e) {
                    throw new SpenCreationFailureException("SignatureRecognizer is not loaded");
                }
            }
        }
        throw new ClassNotFoundException("Can not find " + className + " Signature Verification");
    }

    public void destroySignatureVerification(SpenSignatureVerification verification) {
        if (verification == null || verification.getPluginObject() == null) {
            throw new IllegalArgumentException("E_INVALID_STATE : parameter 'verification' is null");
        }
        this.mPluginManager.unloadPlugin(verification.getPluginObject());
    }

    public void close() {
        this.mContext = null;
        this.mPluginManager = null;
        if (this.mPluginList != null) {
            if (!this.mPluginList.isEmpty()) {
                this.mPluginList.clear();
            }
            this.mPluginList = null;
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        this.mContext = null;
        this.mPluginManager = null;
        if (this.mPluginList != null) {
            if (!this.mPluginList.isEmpty()) {
                this.mPluginList.clear();
            }
            this.mPluginList = null;
        }
    }
}
