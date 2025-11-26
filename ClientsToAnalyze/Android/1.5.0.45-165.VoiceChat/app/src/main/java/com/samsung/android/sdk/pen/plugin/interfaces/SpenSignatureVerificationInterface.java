package com.samsung.android.sdk.pen.plugin.interfaces;

import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import java.util.List;

/* loaded from: classes.dex */
public interface SpenSignatureVerificationInterface extends SpenPluginInterface {

    public interface ResultListener {
        void onResult(List<SpenObjectStroke> list, boolean z);
    }

    int getMinimumRequiredCount();

    int getRegisteredCount();

    void register(List<SpenObjectStroke> list) throws Exception;

    void request(List<SpenObjectStroke> list) throws Exception;

    void setResultListener(ResultListener resultListener) throws Exception;

    void unregisterAll();
}
