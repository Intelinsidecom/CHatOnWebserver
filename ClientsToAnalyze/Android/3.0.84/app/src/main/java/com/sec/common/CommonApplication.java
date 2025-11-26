package com.sec.common;

import android.app.Application;
import android.content.Context;

/* loaded from: classes.dex */
public class CommonApplication extends Application {

    /* renamed from: a */
    private static Context f11795a;

    public CommonApplication() {
        f11795a = this;
    }

    /* renamed from: l */
    public static Context m11493l() {
        return f11795a;
    }
}
