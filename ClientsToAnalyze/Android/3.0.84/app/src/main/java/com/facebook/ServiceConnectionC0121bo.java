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
class ServiceConnectionC0121bo implements ServiceConnection {

    /* renamed from: a */
    final Messenger f240a;

    /* renamed from: b */
    Messenger f241b = null;

    /* renamed from: c */
    final /* synthetic */ C0107ba f242c;

    ServiceConnectionC0121bo(C0107ba c0107ba) {
        this.f242c = c0107ba;
        this.f240a = new Messenger(new HandlerC0122bp(this.f242c, this));
    }

    /* renamed from: a */
    public void m358a() {
        Intent intentM125a = C0071al.m125a(C0107ba.m306k());
        if (intentM125a != null && C0107ba.f200d.bindService(intentM125a, new ServiceConnectionC0121bo(this.f242c), 1)) {
            this.f242c.m316a(new Date());
        } else {
            m356b();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        this.f241b = new Messenger(iBinder);
        m357c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        m356b();
        C0107ba.f200d.unbindService(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m356b() {
        if (this.f242c.f214r == this) {
            this.f242c.f214r = null;
        }
    }

    /* renamed from: c */
    private void m357c() throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("access_token", this.f242c.m330o().m89a());
        Message messageObtain = Message.obtain();
        messageObtain.setData(bundle);
        messageObtain.replyTo = this.f240a;
        try {
            this.f241b.send(messageObtain);
        } catch (RemoteException e) {
            m356b();
        }
    }
}
