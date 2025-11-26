package com.samsung.android.sdk.pen.plugin.interfaces;

import com.samsung.android.sdk.pen.document.SpenObjectBase;
import java.util.List;

/* loaded from: classes.dex */
public interface SpenRecognitionInterface extends SpenPluginInterface {

    public interface ResultListener {
        void onResult(List<SpenObjectBase> list, List<SpenObjectBase> list2);
    }

    void request(List<SpenObjectBase> list) throws Exception;

    void setResultListener(ResultListener resultListener) throws Exception;
}
