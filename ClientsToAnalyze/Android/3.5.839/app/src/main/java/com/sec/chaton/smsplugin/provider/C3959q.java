package com.sec.chaton.smsplugin.provider;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import java.util.regex.Pattern;

/* compiled from: PluginTelephony.java */
/* renamed from: com.sec.chaton.smsplugin.provider.q */
/* loaded from: classes.dex */
public final class C3959q implements InterfaceC3957o {

    /* renamed from: a */
    public static final Uri f14249a = Uri.parse("content://mms");

    /* renamed from: b */
    public static final Uri f14250b = Uri.withAppendedPath(f14249a, "report-request");

    /* renamed from: c */
    public static final Uri f14251c = Uri.withAppendedPath(f14249a, "report-status");

    /* renamed from: d */
    public static final Pattern f14252d = Pattern.compile("\\s*(\"[^\"]*\"|[^<>\"]+)\\s*<([^<>]+)>\\s*");

    /* renamed from: e */
    public static final Pattern f14253e = Pattern.compile("\\s*\"([^\"]*)\"\\s*");

    /* renamed from: a */
    public static boolean m15277a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Patterns.PHONE.matcher(str).matches();
    }
}
