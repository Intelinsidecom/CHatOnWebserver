package com.sec.chaton.p028e;

import android.content.Intent;
import android.os.Bundle;

/* compiled from: InterlockedIntentSort.java */
/* renamed from: com.sec.chaton.e.i */
/* loaded from: classes.dex */
public class C0682i {

    /* renamed from: a */
    static InterfaceC0679f f2328a = new C0678e();

    /* renamed from: a */
    public static InterfaceC0679f m3048a(Intent intent) {
        String type = intent.getType();
        if (type == null) {
            return f2328a;
        }
        Bundle extras = intent.getExtras();
        if (type.equalsIgnoreCase("text/x-vcard") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0681h(intent);
        }
        if (type.equalsIgnoreCase("text/x-vCalendar") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0680g(intent);
        }
        if (type.startsWith("text/") && extras.containsKey("android.intent.extra.TEXT")) {
            return new C0676c(intent);
        }
        if (type.startsWith("image/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0674a(intent);
        }
        if (type.startsWith("video/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0675b(intent);
        }
        if (type.startsWith("audio/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C0677d(intent);
        }
        return f2328a;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.net.Uri m3047a(android.net.Uri r7, java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p028e.C0682i.m3047a(android.net.Uri, java.lang.String, java.lang.String):android.net.Uri");
    }
}
