package com.sec.common;

import android.app.Application;
import android.content.Context;

/* loaded from: classes.dex */
public class CommonApplication extends Application {

    /* renamed from: a */
    private static Context f17993a;

    public CommonApplication() {
        f17993a = this;
    }

    /* renamed from: r */
    public static Context m18732r() {
        return f17993a;
    }
}
