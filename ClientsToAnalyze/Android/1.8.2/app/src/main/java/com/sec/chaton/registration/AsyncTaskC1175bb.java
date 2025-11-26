package com.sec.chaton.registration;

import android.os.AsyncTask;
import android.os.Environment;
import com.sec.chaton.util.C1783o;
import java.io.File;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.bb */
/* loaded from: classes.dex */
class AsyncTaskC1175bb extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f4377a;

    AsyncTaskC1175bb(AuthenticatorActivity authenticatorActivity) {
        this.f4377a = authenticatorActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        File file = new File(Environment.getExternalStorageDirectory(), "//profile");
        if (file.exists()) {
            C1783o.m6035a(file);
            return null;
        }
        return null;
    }
}
