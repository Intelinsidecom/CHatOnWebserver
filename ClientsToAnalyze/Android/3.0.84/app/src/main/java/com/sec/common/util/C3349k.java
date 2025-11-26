package com.sec.common.util;

import android.content.Context;
import android.content.Intent;

/* compiled from: IntentUtils.java */
/* renamed from: com.sec.common.util.k */
/* loaded from: classes.dex */
public class C3349k {
    /* renamed from: a */
    public static boolean m11799a(Intent intent, int i) {
        return (intent.getFlags() & i) == i;
    }

    /* renamed from: a */
    public static boolean m11798a(Context context, Intent intent) {
        return context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
