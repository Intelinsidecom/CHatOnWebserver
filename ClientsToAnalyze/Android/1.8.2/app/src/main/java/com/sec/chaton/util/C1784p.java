package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.net.Uri;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.p */
/* loaded from: classes.dex */
final class C1784p implements MediaScannerConnection.MediaScannerConnectionClient {
    C1784p() {
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        C1783o.f6447b.scanFile(C1783o.f6448c.substring(7), "image");
        C1786r.m6064d("mImagescanning.substring(7):" + C1783o.f6448c.substring(7));
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        C1783o.f6447b.disconnect();
    }
}
