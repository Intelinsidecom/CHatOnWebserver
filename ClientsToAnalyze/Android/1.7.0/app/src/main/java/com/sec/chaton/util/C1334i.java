package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.net.Uri;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.i */
/* loaded from: classes.dex */
final class C1334i implements MediaScannerConnection.MediaScannerConnectionClient {
    C1334i() {
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        C1324bt.f4546b.scanFile(C1324bt.f4547c.substring(7), "image");
        C1341p.m4659c("mImagescanning.substring(7):" + C1324bt.f4547c.substring(7));
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        C1324bt.f4546b.disconnect();
    }
}
