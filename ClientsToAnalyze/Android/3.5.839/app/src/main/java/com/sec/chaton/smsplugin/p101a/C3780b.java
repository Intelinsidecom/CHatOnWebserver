package com.sec.chaton.smsplugin.p101a;

import android.content.Context;
import android.net.Uri;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;

/* compiled from: MmsPartExport.java */
/* renamed from: com.sec.chaton.smsplugin.a.b */
/* loaded from: classes.dex */
class C3780b {

    /* renamed from: a */
    private static C5086i f13548a;

    /* renamed from: b */
    private static Uri f13549b;

    /* renamed from: a */
    public static C5086i m14200a(Context context, Uri uri) {
        if (uri == null) {
            return null;
        }
        if (uri.equals(f13549b)) {
            return f13548a;
        }
        try {
            f13548a = C3870p.m14893b(context, uri);
            f13549b = uri;
            return f13548a;
        } catch (C5111c e) {
            C3890m.m14995a("Mms/MmsPartExport", e.getMessage(), e);
            return null;
        }
    }
}
