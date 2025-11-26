package com.sec.chaton.registration;

import android.os.AsyncTask;
import android.os.Environment;
import com.sec.chaton.util.ChatONFileUtil;
import java.io.File;

/* renamed from: com.sec.chaton.registration.ap */
/* loaded from: classes.dex */
class AsyncTaskC0418ap extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0412aj f2929a;

    AsyncTaskC0418ap(ViewOnClickListenerC0412aj viewOnClickListenerC0412aj) {
        this.f2929a = viewOnClickListenerC0412aj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        File file = new File(Environment.getExternalStorageDirectory(), "//profile");
        if (!file.exists()) {
            return null;
        }
        ChatONFileUtil.m3482a(file);
        return null;
    }
}
