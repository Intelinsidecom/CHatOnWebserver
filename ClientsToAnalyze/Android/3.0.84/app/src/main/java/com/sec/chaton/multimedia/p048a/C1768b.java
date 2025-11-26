package com.sec.chaton.multimedia.p048a;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: SaveFileTask.java */
/* renamed from: com.sec.chaton.multimedia.a.b */
/* loaded from: classes.dex */
class C1768b implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a */
    final /* synthetic */ AsyncTaskC1767a f6521a;

    C1768b(AsyncTaskC1767a asyncTaskC1767a) {
        this.f6521a = asyncTaskC1767a;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f6521a.f6519g.disconnect();
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        if (TextUtils.isEmpty(this.f6521a.f6515c) || !this.f6521a.f6515c.endsWith("/")) {
            this.f6521a.f6519g.scanFile(this.f6521a.f6515c + "/" + this.f6521a.f6516d, null);
        } else {
            this.f6521a.f6519g.scanFile(this.f6521a.f6515c + this.f6521a.f6516d, null);
        }
    }
}
