package com.sec.chaton.util;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;

/* compiled from: ChatONFileUtil.java */
/* renamed from: com.sec.chaton.util.p */
/* loaded from: classes.dex */
final class C4895p implements MediaScannerConnection.MediaScannerConnectionClient {
    C4895p() {
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        C4894o.f17853b.scanFile(C4894o.f17854c.substring(7), SlookAirButtonRecentMediaAdapter.IMAGE_TYPE);
        C4904y.m18644d("mImagescanning.substring(7):" + C4894o.f17854c.substring(7));
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        C4894o.f17853b.disconnect();
    }
}
