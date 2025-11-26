package com.sec.chaton.registration;

import android.os.AsyncTask;
import android.os.Environment;
import com.sec.chaton.util.C4894o;
import java.io.File;

/* compiled from: AuthenticatorActivity.java */
/* renamed from: com.sec.chaton.registration.r */
/* loaded from: classes.dex */
class AsyncTaskC3311r extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ AuthenticatorActivity f12088a;

    AsyncTaskC3311r(AuthenticatorActivity authenticatorActivity) {
        this.f12088a = authenticatorActivity;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        File file = new File(Environment.getExternalStorageDirectory(), "//profile");
        if (file.exists()) {
            C4894o.m18605a(file);
            return null;
        }
        return null;
    }
}
