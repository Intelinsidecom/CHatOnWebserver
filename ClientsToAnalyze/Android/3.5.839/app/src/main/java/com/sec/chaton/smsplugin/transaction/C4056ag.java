package com.sec.chaton.smsplugin.transaction;

import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import com.sec.chaton.smsplugin.p111h.C3896s;

/* compiled from: SmsRetrieveService.java */
/* renamed from: com.sec.chaton.smsplugin.transaction.ag */
/* loaded from: classes.dex */
class C4056ag extends ContentObserver {

    /* renamed from: a */
    final /* synthetic */ SmsRetrieveService f14627a;

    /* renamed from: b */
    private final Context f14628b;

    /* renamed from: c */
    private final int f14629c;

    /* renamed from: d */
    private final Intent f14630d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4056ag(SmsRetrieveService smsRetrieveService, Context context, Intent intent, int i, Handler handler) {
        super(handler);
        this.f14627a = smsRetrieveService;
        this.f14628b = context;
        this.f14630d = intent;
        this.f14629c = i;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        C3896s.m15044b("DB Changed", SmsRetrieveService.f14590b);
        if (this.f14627a.m15576a(this.f14628b, this.f14630d)) {
            this.f14628b.getContentResolver().unregisterContentObserver(this);
        }
        super.onChange(z);
        SmsReceiver.m15543a(this.f14627a, this.f14629c);
    }
}
