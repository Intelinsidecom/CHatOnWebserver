package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.s */
/* loaded from: classes.dex */
final class C3244s implements MediaScannerConnection.MediaScannerConnectionClient {
    C3244s() {
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        C3243r.f11722b.scanFile(C3243r.f11723c.substring(7), SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
        C3250y.m11454d("mImagescanning.substring(7):" + C3243r.f11723c.substring(7));
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        C3243r.f11722b.disconnect();
    }
}
