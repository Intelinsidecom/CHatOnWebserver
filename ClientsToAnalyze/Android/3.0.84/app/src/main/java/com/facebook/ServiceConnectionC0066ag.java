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
final class ServiceConnectionC0066ag implements ServiceConnection {

    /* renamed from: a */
    final Context f95a;

    /* renamed from: b */
    final String f96b;

    /* renamed from: c */
    final Handler f97c;

    /* renamed from: d */
    InterfaceC0068ai f98d;

    /* renamed from: e */
    boolean f99e;

    /* renamed from: f */
    Messenger f100f;

    ServiceConnectionC0066ag(Context context, String str) {
        Context applicationContext = context.getApplicationContext();
        this.f95a = applicationContext != null ? applicationContext : context;
        this.f96b = str;
        this.f97c = new HandlerC0067ah(this);
    }

    /* renamed from: a */
    void m121a(InterfaceC0068ai interfaceC0068ai) {
        this.f98d = interfaceC0068ai;
    }

    /* renamed from: a */
    boolean m122a() {
        Intent intent = new Intent("com.facebook.platform.PLATFORM_SERVICE");
        intent.addCategory("android.intent.category.DEFAULT");
        Intent intentM132b = C0071al.m132b(this.f95a, intent);
        if (intentM132b == null) {
            m117a((Bundle) null);
            return false;
        }
        this.f99e = true;
        this.f95a.bindService(intentM132b, this, 1);
        return true;
    }

    /* renamed from: b */
    void m123b() {
        this.f99e = false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) throws RemoteException {
        this.f100f = new Messenger(iBinder);
        m120c();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f100f = null;
        this.f95a.unbindService(this);
        m117a((Bundle) null);
    }

    /* renamed from: c */
    private void m120c() throws RemoteException {
        Bundle bundle = new Bundle();
        bundle.putString("com.facebook.platform.extra.APPLICATION_ID", this.f96b);
        Message messageObtain = Message.obtain((Handler) null, 65536);
        messageObtain.arg1 = 20121101;
        messageObtain.setData(bundle);
        messageObtain.replyTo = new Messenger(this.f97c);
        try {
            this.f100f.send(messageObtain);
        } catch (RemoteException e) {
            m117a((Bundle) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m118a(Message message) {
        if (message.what == 65537) {
            Bundle data = message.getData();
            if (data.getString("com.facebook.platform.status.ERROR_TYPE") != null) {
                m117a((Bundle) null);
            } else {
                m117a(data);
            }
            this.f95a.unbindService(this);
        }
    }

    /* renamed from: a */
    private void m117a(Bundle bundle) {
        if (this.f99e) {
            this.f99e = false;
            InterfaceC0068ai interfaceC0068ai = this.f98d;
            if (interfaceC0068ai != null) {
                interfaceC0068ai.mo124a(bundle);
            }
        }
    }
}
