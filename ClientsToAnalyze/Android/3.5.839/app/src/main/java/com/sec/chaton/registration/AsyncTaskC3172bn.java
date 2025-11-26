package com.sec.chaton.registration;

import android.os.AsyncTask;
import android.os.Environment;
import com.sec.chaton.util.C4894o;
import java.io.File;

/* compiled from: FragmentDisclaimerGlobal.java */
/* renamed from: com.sec.chaton.registration.bn */
/* loaded from: classes.dex */
class AsyncTaskC3172bn extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    final /* synthetic */ FragmentDisclaimerGlobal f11924a;

    AsyncTaskC3172bn(FragmentDisclaimerGlobal fragmentDisclaimerGlobal) {
        this.f11924a = fragmentDisclaimerGlobal;
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
