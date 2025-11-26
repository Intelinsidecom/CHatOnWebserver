package com.coolots.chaton.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public class AuthenticationService extends Service {
    private Authenticator authenticator;

    @Override // android.app.Service
    public void onCreate() {
        this.authenticator = new Authenticator(this);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.authenticator.getIBinder();
    }
}
