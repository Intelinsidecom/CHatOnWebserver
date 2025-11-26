package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.common.p131f.C4999c;
import java.io.File;
import java.io.IOException;

/* compiled from: BuddyProfileImageHistoryManager.java */
/* renamed from: com.sec.chaton.buddy.go */
/* loaded from: classes.dex */
class AsyncTaskC1335go extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f4908a;

    /* renamed from: b */
    final /* synthetic */ C1337gq f4909b;

    /* renamed from: c */
    final /* synthetic */ String f4910c;

    /* renamed from: d */
    final /* synthetic */ int f4911d;

    /* renamed from: e */
    final /* synthetic */ C1331gk f4912e;

    AsyncTaskC1335go(C1331gk c1331gk, File file, C1337gq c1337gq, String str, int i) {
        this.f4912e = c1331gk;
        this.f4908a = file;
        this.f4909b = c1337gq;
        this.f4910c = str;
        this.f4911d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            return new C4999c().m18976a(this.f4908a).m18969a();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        if (bitmap != null) {
            this.f4909b.m7482a().setImageBitmap(bitmap);
            this.f4909b.m7484a(true);
            this.f4909b.m7483a(this.f4910c);
            this.f4912e.m7455a(this.f4911d);
        }
    }
}
