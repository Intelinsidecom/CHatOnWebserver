package com.sec.chaton.p062h;

import android.content.Intent;
import android.os.Bundle;
import com.sec.chaton.util.C4904y;

/* compiled from: InterlockedIntentSort.java */
/* renamed from: com.sec.chaton.h.h */
/* loaded from: classes.dex */
public class C2362h {

    /* renamed from: a */
    static InterfaceC2355a f8393a = new C2363i();

    /* renamed from: a */
    public static InterfaceC2355a m10319a(Intent intent) {
        String type = intent.getType();
        if (C4904y.f17872b) {
            C4904y.m18639b("intent type: " + type, "InterlockedIntentSort");
        }
        if (type == null) {
            return f8393a;
        }
        Bundle extras = intent.getExtras();
        if (type.equalsIgnoreCase("text/x-vcard") && extras.containsKey("android.intent.extra.STREAM")) {
            return C2359e.m10315a(intent);
        }
        if (type.equalsIgnoreCase("text/x-vCalendar") && extras.containsKey("android.intent.extra.STREAM")) {
            return C2358d.m10313a(intent);
        }
        if (type.equals("text/plain") && extras.containsKey("android.intent.extra.STREAM")) {
            return C2360f.m10316a(intent);
        }
        if (type.startsWith("text/") && extras.containsKey("android.intent.extra.TEXT")) {
            return C2364j.m10320a(intent);
        }
        if (type.startsWith("image/") && extras.containsKey("android.intent.extra.STREAM")) {
            return C2361g.m10317a(intent);
        }
        if (type.startsWith("video/") && extras.containsKey("android.intent.extra.STREAM")) {
            return C2365k.m10321a(intent);
        }
        if (type.startsWith("audio/") && extras.containsKey("android.intent.extra.STREAM")) {
            return C2357c.m10312a(intent);
        }
        if (type.startsWith("application/chaton-applink")) {
            return C2356b.m10311a(intent);
        }
        if (type.startsWith("application/") && extras.containsKey("android.intent.extra.STREAM")) {
            return C2360f.m10316a(intent);
        }
        return f8393a;
    }

    /* JADX WARN: Removed duplicated region for block: B:83:0x00cf A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri m10318a(android.net.Uri r7, java.lang.String r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 359
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.p062h.C2362h.m10318a(android.net.Uri, java.lang.String, java.lang.String):android.net.Uri");
    }
}
