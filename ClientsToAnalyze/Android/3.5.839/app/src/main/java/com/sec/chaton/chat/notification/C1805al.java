package com.sec.chaton.chat.notification;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.net.Uri;
import android.provider.Telephony;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.smsplugin.provider.C3947e;

/* compiled from: ScreenNotification2.java */
/* renamed from: com.sec.chaton.chat.notification.al */
/* loaded from: classes.dex */
class C1805al extends Thread {

    /* renamed from: a */
    final /* synthetic */ Long f6815a;

    /* renamed from: b */
    final /* synthetic */ ScreenNotification2 f6816b;

    C1805al(ScreenNotification2 screenNotification2, Long l) {
        this.f6816b = screenNotification2;
        this.f6815a = l;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    @SuppressLint({"NewApi"})
    public void run() {
        ContentResolver contentResolver = GlobalApplication.m18732r().getContentResolver();
        Uri uriWithAppendedId = ContentUris.withAppendedId(Telephony.Threads.CONTENT_URI, this.f6815a.longValue());
        ContentValues contentValues = new ContentValues(2);
        contentValues.put("read", (Integer) 1);
        contentValues.put("seen", (Integer) 1);
        contentResolver.update(uriWithAppendedId, contentValues, "(read=0 OR seen=0)", null);
        C3947e.m15263d(contentResolver, this.f6815a.longValue());
    }
}
