package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.sec.common.p131f.C4999c;
import java.io.File;
import java.io.IOException;

/* compiled from: BuddyProfileImageHistoryManager.java */
/* renamed from: com.sec.chaton.buddy.gn */
/* loaded from: classes.dex */
class AsyncTaskC1334gn extends AsyncTask<Void, Void, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ File f4903a;

    /* renamed from: b */
    final /* synthetic */ C1337gq f4904b;

    /* renamed from: c */
    final /* synthetic */ String f4905c;

    /* renamed from: d */
    final /* synthetic */ int f4906d;

    /* renamed from: e */
    final /* synthetic */ C1331gk f4907e;

    AsyncTaskC1334gn(C1331gk c1331gk, File file, C1337gq c1337gq, String str, int i) {
        this.f4907e = c1331gk;
        this.f4903a = file;
        this.f4904b = c1337gq;
        this.f4905c = str;
        this.f4906d = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(Void... voidArr) {
        try {
            return new C4999c().m18976a(this.f4903a).m18969a();
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
            this.f4904b.m7482a().setImageBitmap(bitmap);
            this.f4904b.m7484a(true);
            this.f4904b.m7483a(this.f4905c);
            this.f4907e.m7455a(this.f4906d);
        }
    }
}
