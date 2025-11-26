package com.sec.chaton.registration;

import android.os.AsyncTask;
import android.os.Environment;
import com.sec.chaton.util.C1783o;
import java.io.File;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ba */
/* loaded from: classes.dex */
class AsyncTaskC1174ba extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC1172az f4376a;

    AsyncTaskC1174ba(ViewOnClickListenerC1172az viewOnClickListenerC1172az) {
        this.f4376a = viewOnClickListenerC1172az;
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
