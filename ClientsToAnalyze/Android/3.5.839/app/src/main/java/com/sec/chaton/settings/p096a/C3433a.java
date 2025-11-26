package com.sec.chaton.settings.p096a;

import android.content.Context;
import com.sec.chaton.p055d.EnumC2125f;
import com.sec.chaton.settings.downloads.AmsItemHelper;
import com.sec.common.util.C5048n;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AmsItemHelper.java */
/* renamed from: com.sec.chaton.settings.a.a */
/* loaded from: classes.dex */
public class C3433a {

    /* renamed from: a */
    private static final String f12844a = C3433a.class.getSimpleName();

    /* renamed from: b */
    private static final List<AmsItemHelper.OnAmsItemInstalled> f12845b = new ArrayList();

    /* renamed from: c */
    private static final List<InterfaceC3459c> f12846c = new ArrayList();

    /* renamed from: a */
    public static File m13699a(Context context, EnumC2125f enumC2125f, String str) {
        return new File(m13701c(context, enumC2125f, str), str);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0107  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m13700b(android.content.Context r9, com.sec.chaton.p055d.EnumC2125f r10, java.lang.String r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.settings.p096a.C3433a.m13700b(android.content.Context, com.sec.chaton.d.f, java.lang.String):void");
    }

    /* renamed from: c */
    public static File m13701c(Context context, EnumC2125f enumC2125f, String str) {
        File fileM19190a = C5048n.m19190a(context);
        File file = null;
        switch (enumC2125f) {
            case Background:
                file = new File(fileM19190a, "amsBackgroundItem");
                break;
            case Stamp:
                file = new File(fileM19190a, "amsStampItem/" + str);
                break;
            case Template:
                file = new File(fileM19190a, "amsTemplateItem");
                break;
        }
        if (file != null && !file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
