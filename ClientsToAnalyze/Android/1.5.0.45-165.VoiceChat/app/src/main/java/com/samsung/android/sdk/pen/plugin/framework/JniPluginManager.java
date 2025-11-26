package com.samsung.android.sdk.pen.plugin.framework;

import android.content.Context;
import java.util.ArrayList;

/* loaded from: classes.dex */
class JniPluginManager {
    public native ArrayList<Object> onCommand(int i, int i2, ArrayList<Object> arrayList);

    public native void onLoad(int i, Context context);

    public native void onUnload(int i);

    JniPluginManager() {
    }
}
