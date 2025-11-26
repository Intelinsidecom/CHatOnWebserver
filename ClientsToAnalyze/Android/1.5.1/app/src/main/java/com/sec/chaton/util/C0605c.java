package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.net.Uri;

/* renamed from: com.sec.chaton.util.c */
/* loaded from: classes.dex */
final class C0605c implements MediaScannerConnection.MediaScannerConnectionClient {
    C0605c() {
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        ChatONFileUtil.f3619b.scanFile(ChatONFileUtil.f3620c.substring(7), "image");
        ChatONLogWriter.m3509d("mImagescanning.substring(7):" + ChatONFileUtil.f3620c.substring(7));
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        ChatONFileUtil.f3619b.disconnect();
    }
}
