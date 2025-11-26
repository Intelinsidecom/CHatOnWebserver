package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.common.p131f.C4999c;
import java.io.File;
import java.io.IOException;

/* compiled from: BuddyProfileImageHistoryManager.java */
/* renamed from: com.sec.chaton.buddy.gm */
/* loaded from: classes.dex */
class AsyncTaskC1333gm extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f4898a;

    /* renamed from: b */
    final /* synthetic */ C1337gq f4899b;

    /* renamed from: c */
    final /* synthetic */ String f4900c;

    /* renamed from: d */
    final /* synthetic */ int f4901d;

    /* renamed from: e */
    final /* synthetic */ C1331gk f4902e;

    AsyncTaskC1333gm(C1331gk c1331gk, File file, C1337gq c1337gq, String str, int i) {
        this.f4902e = c1331gk;
        this.f4898a = file;
        this.f4899b = c1337gq;
        this.f4900c = str;
        this.f4901d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            return new C4999c().m18976a(this.f4898a).m18969a();
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
            this.f4899b.m7482a().setImageBitmap(bitmap);
            this.f4899b.m7484a(true);
            this.f4899b.m7483a(this.f4900c);
            this.f4902e.m7455a(this.f4901d);
        }
    }
}
