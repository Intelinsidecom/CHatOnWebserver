package com.samsung.android.sdk.pen.plugin.interfaces;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public interface SpenPluginInterface extends SpenNativeHandleInterface {
    String getPrivateKeyHint();

    void getProperty(Bundle bundle);

    void onLoad(Context context) throws Exception;

    void onUnload();

    void setProperty(Bundle bundle);

    boolean unlock(String str);
}
