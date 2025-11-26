package com.facebook;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.Date;

/* compiled from: Session.java */
/* renamed from: com.facebook.bo */
/* loaded from: classes.dex */
class ServiceConnectionC0492bo implements ServiceConnection {

    /* renamed from: a */
    final Messenger f1209a;

    /* renamed from: b */
    Messenger f1210b = null;

    /* renamed from: c */
    final /* synthetic */ C0478ba f1211c;

    ServiceConnectionC0492bo(C0478ba c0478ba) {
        this.f1211c = c0478ba;
        this.f1209a = new Messenger(new HandlerC0493bp(this.f1211c, this));
    }

    /* renamed from: a */
    public void m1801a() {
        Intent intentM1569a = C0442al.m1569a(C0478ba.m1750k());
        if (intentM1569a != null && C0478ba.f1169d.bindService(intentM1569a, new ServiceConnectionC0492bo(this.f1211c), 1)) {
            this.f1211c.m1760a(new Date());
        } else {
            m1799b();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        this.f1210b = new Messenger(iBinder);
        m1800c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        m1799b();
        C0478ba.f1169d.unbindService(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1799b() {
        if (this.f1211c.f1183r == this) {
            this.f1211c.f1183r = null;
        }
    }

    /* renamed from: c */
    private void m1800c() throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", this.f1211c.m1773o().m1532a());
        Message messageObtain = Message.obtain();
        messageObtain.setData(bundle);
        messageObtain.replyTo = this.f1209a;
        try {
            this.f1210b.send(messageObtain);
        } catch (RemoteException e) {
            m1799b();
        }
    }
}
