package com.sec.chaton.multimedia.p079b;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: SaveFileTask.java */
/* renamed from: com.sec.chaton.multimedia.b.b */
/* loaded from: classes.dex */
class C2752b implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC2751a f9888a;

    C2752b(AsyncTaskC2751a asyncTaskC2751a) {
        this.f9888a = asyncTaskC2751a;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f9888a.f9886g.disconnect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (TextUtils.isEmpty(this.f9888a.f9882c) || !this.f9888a.f9882c.endsWith("/")) {
            this.f9888a.f9886g.scanFile(this.f9888a.f9882c + "/" + this.f9888a.f9883d, null);
        } else {
            this.f9888a.f9886g.scanFile(this.f9888a.f9882c + this.f9888a.f9883d, null);
        }
    }
}
