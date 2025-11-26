package com.sec.chaton.settings.tellfriends;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: TellFriendsImageDownloader.java */
/* renamed from: com.sec.chaton.settings.tellfriends.bw */
/* loaded from: classes.dex */
class AsyncTaskC1395bw extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ C1392bt f5255a;

    /* renamed from: b */
    private String f5256b;

    /* renamed from: c */
    private final WeakReference f5257c;

    public AsyncTaskC1395bw(C1392bt c1392bt, ImageView imageView) {
        this.f5255a = c1392bt;
        this.f5257c = new WeakReference(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(String... strArr) {
        this.f5256b = strArr[0];
        return this.f5255a.m5143a(this.f5256b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        if (isCancelled()) {
            bitmap = null;
        }
        this.f5255a.m5136a(this.f5256b, bitmap);
        if (this.f5257c != null) {
            ImageView imageView = (ImageView) this.f5257c.get();
            if (this == C1392bt.m5138b(imageView)) {
                imageView.setImageBitmap(bitmap);
            }
        }
    }
}
