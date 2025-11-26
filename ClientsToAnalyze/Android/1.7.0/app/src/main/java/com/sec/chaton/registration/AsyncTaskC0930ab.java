package com.sec.chaton.registration;

import android.os.AsyncTask;
import android.os.Environment;
import com.sec.chaton.util.C1324bt;
import java.io.File;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.ab */
/* loaded from: classes.dex */
class AsyncTaskC0930ab extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0941am f3317a;

    AsyncTaskC0930ab(ViewOnClickListenerC0941am viewOnClickListenerC0941am) {
        this.f3317a = viewOnClickListenerC0941am;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        File file = new File(Environment.getExternalStorageDirectory(), "//profile");
        if (file.exists()) {
            C1324bt.m4584a(file);
            return null;
        }
        return null;
    }
}
