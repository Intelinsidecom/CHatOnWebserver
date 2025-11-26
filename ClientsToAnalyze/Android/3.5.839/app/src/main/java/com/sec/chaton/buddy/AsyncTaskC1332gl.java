package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.common.p131f.C4999c;
import java.io.File;
import java.io.IOException;

/* compiled from: BuddyProfileImageHistoryManager.java */
/* renamed from: com.sec.chaton.buddy.gl */
/* loaded from: classes.dex */
class AsyncTaskC1332gl extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f4893a;

    /* renamed from: b */
    final /* synthetic */ C1337gq f4894b;

    /* renamed from: c */
    final /* synthetic */ String f4895c;

    /* renamed from: d */
    final /* synthetic */ int f4896d;

    /* renamed from: e */
    final /* synthetic */ C1331gk f4897e;

    AsyncTaskC1332gl(C1331gk c1331gk, File file, C1337gq c1337gq, String str, int i) {
        this.f4897e = c1331gk;
        this.f4893a = file;
        this.f4894b = c1337gq;
        this.f4895c = str;
        this.f4896d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            return new C4999c().m18976a(this.f4893a).m18969a();
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
            this.f4894b.m7482a().setImageBitmap(bitmap);
            this.f4894b.m7484a(true);
            this.f4894b.m7483a(this.f4895c);
            this.f4897e.m7455a(this.f4896d);
        }
    }
}
