package com.sec.chaton.p032h;

import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C3250y;

/* compiled from: InterlockedIntentSort.java */
/* renamed from: com.sec.chaton.h.h */
/* loaded from: classes.dex */
public class C1505h {

    /* renamed from: a */
    static InterfaceC1498a f5540a = new C1506i();

    /* renamed from: a */
    public static InterfaceC1498a m6468a(Intent intent) {
        String type = intent.getType();
        if (C3250y.f11734b) {
            C3250y.m11450b("intent type: " + type, "InterlockedIntentSort");
        }
        if (type == null) {
            return f5540a;
        }
        Bundle extras = intent.getExtras();
        if (type.equalsIgnoreCase("text/x-vcard") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C1502e(intent);
        }
        if (type.equalsIgnoreCase("text/x-vCalendar") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C1501d(intent);
        }
        if (type.equals("text/plain") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C1503f(intent);
        }
        if (type.startsWith("text/") && extras.containsKey("android.intent.extra.TEXT")) {
            return new C1508k(intent);
        }
        if (type.startsWith("image/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C1504g(intent);
        }
        if (type.startsWith("video/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C1509l(intent);
        }
        if (type.startsWith("audio/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C1500c(intent);
        }
        if (type.startsWith("application/chaton-applink")) {
            return new C1499b(intent);
        }
        if (type.startsWith("application/") && extras.containsKey("android.intent.extra.STREAM")) {
            return new C1503f(intent);
        }
        return f5540a;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m6467a(android.net.Uri r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p032h.C1505h.m6467a(android.net.Uri, java.lang.String, java.lang.String):android.net.Uri");
    }
}
