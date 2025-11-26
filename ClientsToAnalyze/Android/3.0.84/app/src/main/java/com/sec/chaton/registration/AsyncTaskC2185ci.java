package com.sec.chaton.registration;

import android.os.AsyncTask;
import android.os.Environment;
import com.sec.chaton.util.C3243r;
import java.io.File;

/* compiled from: FragmentGlobalDisclaimer.java */
/* renamed from: com.sec.chaton.registration.ci */
/* loaded from: classes.dex */
class AsyncTaskC2185ci extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ FragmentGlobalDisclaimer f8472a;

    AsyncTaskC2185ci(FragmentGlobalDisclaimer fragmentGlobalDisclaimer) {
        this.f8472a = fragmentGlobalDisclaimer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        File file = new File(Environment.getExternalStorageDirectory(), "//profile");
        if (file.exists()) {
            C3243r.m11418a(file);
            return null;
        }
        return null;
    }
}
