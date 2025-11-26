package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.net.Uri;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;

/* compiled from: MessageOptions.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ca */
/* loaded from: classes.dex */
public class C4146ca {

    /* renamed from: a */
    private static C5086i f15429a;

    /* renamed from: b */
    private static Uri f15430b;

    /* renamed from: a */
    public static C5086i m16388a(Context context, Uri uri) {
        if (uri.equals(f15430b)) {
            return f15429a;
        }
        try {
            f15429a = C3870p.m14893b(context, uri);
            f15430b = uri;
            return f15429a;
        } catch (C5111c e) {
            C3890m.m14995a("Mms/MessageOptions", e.getMessage(), e);
            return null;
        }
    }
}
