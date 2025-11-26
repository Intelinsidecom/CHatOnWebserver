package com.facebook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

/* compiled from: GetTokenClient.java */
/* renamed from: com.facebook.ag */
/* loaded from: classes.dex */
final class ServiceConnectionC0437ag implements ServiceConnection {

    /* renamed from: a */
    final Context f1064a;

    /* renamed from: b */
    final String f1065b;

    /* renamed from: c */
    final Handler f1066c;

    /* renamed from: d */
    InterfaceC0439ai f1067d;

    /* renamed from: e */
    boolean f1068e;

    /* renamed from: f */
    Messenger f1069f;

    ServiceConnectionC0437ag(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f1064a = applicationContext != null ? applicationContext : context;
        this.f1065b = str;
        this.f1066c = new HandlerC0438ah(this);
    }

    /* renamed from: a */
    void m1565a(InterfaceC0439ai interfaceC0439ai) {
        this.f1067d = interfaceC0439ai;
    }

    /* renamed from: a */
    boolean m1566a() {
        Intent intent = new Intent("com.facebook.platform.PLATFORM_SERVICE");
        intent.addCategory("android.intent.category.DEFAULT");
        Intent intentM1576b = C0442al.m1576b(this.f1064a, intent);
        if (intentM1576b == null) {
            m1561a((Bundle) null);
            return false;
        }
        this.f1068e = true;
        this.f1064a.bindService(intentM1576b, this, 1);
        return true;
    }

    /* renamed from: b */
    void m1567b() {
        this.f1068e = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        this.f1069f = new Messenger(iBinder);
        m1564c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f1069f = null;
        this.f1064a.unbindService(this);
        m1561a((Bundle) null);
    }

    /* renamed from: c */
    private void m1564c() throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f1065b);
        Message messageObtain = Message.obtain((Handler) null, 65536);
        messageObtain.arg1 = 20121101;
        messageObtain.setData(bundle);
        messageObtain.replyTo = new Messenger(this.f1066c);
        try {
            this.f1069f.send(messageObtain);
        } catch (RemoteException e) {
            m1561a((Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1562a(Message message) {
        if (message.what == 65537) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                m1561a((Bundle) null);
            } else {
                m1561a(data);
            }
            this.f1064a.unbindService(this);
        }
    }

    /* renamed from: a */
    private void m1561a(Bundle bundle) {
        if (this.f1068e) {
            this.f1068e = false;
            InterfaceC0439ai interfaceC0439ai = this.f1067d;
            if (interfaceC0439ai != null) {
                interfaceC0439ai.mo1568a(bundle);
            }
        }
    }
}
