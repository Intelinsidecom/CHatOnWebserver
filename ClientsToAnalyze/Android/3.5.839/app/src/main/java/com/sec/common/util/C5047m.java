package com.sec.common.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import java.util.List;

/* compiled from: IntentUtils.java */
/* renamed from: com.sec.common.util.m */
/* loaded from: classes.dex */
public class C5047m {
    /* renamed from: a */
    public static boolean m19189a(Intent intent, int i) {
        return (intent.getFlags() & i) == i;
    }

    /* renamed from: a */
    public static boolean m19188a(Context context, Intent intent) {
        List<ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        return listQueryIntentActivities != null && listQueryIntentActivities.size() > 0;
    }
}
