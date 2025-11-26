package com.sec.chaton.p021g;

import android.content.Intent;
import android.os.Bundle;

/* compiled from: InterlockedIntentSort.java */
/* renamed from: com.sec.chaton.g.f */
/* loaded from: classes.dex */
public class C0757f {

    /* renamed from: a */
    static InterfaceC0752a f2772a = new C0758g();

    /* renamed from: a */
    public static InterfaceC0752a m3254a(Intent intent) {
        String type = intent.getType();
        if (type == null) {
            return f2772a;
        }
        Bundle extras = intent.getExtras();
        if (type.equalsIgnoreCase("text/x-vcard") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0755d(intent);
        }
        if (type.equalsIgnoreCase("text/x-vCalendar") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0754c(intent);
        }
        if (type.startsWith("text/") && extras.containsKey("android.intent.extra.TEXT")) {
            return new C0759h(intent);
        }
        if (type.startsWith("image/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0756e(intent);
        }
        if (type.startsWith("video/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0760i(intent);
        }
        if (type.startsWith("audio/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0753b(intent);
        }
        return f2772a;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.net.Uri m3253a(android.net.Uri r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p021g.C0757f.m3253a(android.net.Uri, java.lang.String, java.lang.String):android.net.Uri");
    }
}
