package com.sec.chaton.interlocked;

import android.content.Intent;
import android.os.Bundle;

/* loaded from: classes.dex */
public class InterlockedIntentSort {

    /* renamed from: a */
    static InterlockWithNative f1913a = new C0241a();

    /* JADX WARN: Removed duplicated region for block: B:60:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static android.net.Uri m2393a(android.net.Uri r7, java.lang.String r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.interlocked.InterlockedIntentSort.m2393a(android.net.Uri, java.lang.String, java.lang.String):android.net.Uri");
    }

    /* renamed from: a */
    public static InterlockWithNative m2394a(Intent intent) {
        String type = intent.getType();
        Bundle extras = intent.getExtras();
        return (type.equalsIgnoreCase("text/x-vcard") && extras.containsKey("android.intent.extra.STREAM")) ? new InterlockedContact(intent) : (type.equalsIgnoreCase("text/x-vCalendar") && extras.containsKey("android.intent.extra.STREAM")) ? new InterlockedCalendar(intent) : (type.startsWith("text/") && extras.containsKey("android.intent.extra.TEXT")) ? new InterlockedText(intent) : (type.startsWith("image/") && extras.containsKey("android.intent.extra.STREAM")) ? new InterlockedImage(intent) : (type.startsWith("video/") && extras.containsKey("android.intent.extra.STREAM")) ? new InterlockedVideo(intent) : (type.startsWith("audio/") && extras.containsKey("android.intent.extra.STREAM")) ? new InterlockedAudio(intent) : f1913a;
    }
}
