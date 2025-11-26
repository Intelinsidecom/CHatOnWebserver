package com.sec.chaton.util;

import android.os.AsyncTask;
import com.sec.chaton.common.entry.ImageRequestResult;
import com.sec.chaton.util.ImageDownloader;

/* renamed from: com.sec.chaton.util.o */
/* loaded from: classes.dex */
class AsyncTaskC0617o extends AsyncTask {

    /* renamed from: a */
    final /* synthetic */ ImageDownloader f3788a;

    /* renamed from: b */
    private String f3789b;

    /* renamed from: c */
    private String f3790c;

    /* renamed from: d */
    private ImageDownloader.OnImageLoaded f3791d;

    public AsyncTaskC0617o(ImageDownloader imageDownloader, ImageDownloader.OnImageLoaded onImageLoaded) {
        this.f3788a = imageDownloader;
        this.f3791d = onImageLoaded;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImageRequestResult doInBackground(String... strArr) {
        this.f3789b = strArr[0];
        this.f3790c = strArr[1];
        return this.f3788a.m3589a(this.f3789b + "&r=" + System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(ImageRequestResult imageRequestResult) {
        if (isCancelled()) {
            imageRequestResult.m1961a(null);
        }
        if (imageRequestResult.m1962b() != ImageDownloader.ImageDownResult.ERROR) {
            this.f3788a.m3590a(this.f3789b, imageRequestResult.m1960a());
        }
        this.f3791d.mo653a(this.f3790c, imageRequestResult.m1960a(), imageRequestResult.m1962b());
    }
}
