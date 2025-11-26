package com.sec.chaton.smsplugin.transaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Messenger;

/* compiled from: SendTransaction.java */
@SuppressLint({"NewApi"})
/* renamed from: com.sec.chaton.smsplugin.transaction.ab */
/* loaded from: classes.dex */
public class RunnableC4051ab extends AbstractC4059aj implements Runnable {

    /* renamed from: a */
    private Thread f14607a;

    /* renamed from: f */
    private final Uri f14608f;

    /* renamed from: g */
    private final Messenger f14609g;

    /* renamed from: h */
    private final int f14610h;

    public RunnableC4051ab(Context context, int i, C4064ao c4064ao, String str, int i2, Messenger messenger) {
        super(context, i, c4064ao);
        this.f14610h = i2;
        this.f14609g = messenger;
        this.f14608f = Uri.parse(str);
        this.f14640c = str;
        m15695a(C4090z.m15708a(context));
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: a */
    public void mo15597a() {
        this.f14607a = new Thread(this);
        this.f14607a.start();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0237  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 715
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.transaction.RunnableC4051ab.run():void");
    }

    @Override // com.sec.chaton.smsplugin.transaction.AbstractC4059aj
    /* renamed from: b */
    public int mo15598b() {
        return 2;
    }
}
