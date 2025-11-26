package com.sec.chaton.settings.downloads;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC1825o;

/* compiled from: SkinPreviewDispatcherTask.java */
/* renamed from: com.sec.chaton.settings.downloads.ct */
/* loaded from: classes.dex */
public class C2607ct extends CallableC1825o {
    public C2607ct(String str) {
        super(str);
        m9591n();
    }

    /* renamed from: n */
    private void m9591n() {
        m7494a(R.drawable.download_default);
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.CallableC1825o, com.sec.common.p069e.AbstractRunnableC3324a
    /* renamed from: c */
    public Object mo4333c() {
        String strI = mo7454i();
        if (!strI.startsWith("android.resource")) {
            return super.mo4333c();
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(m11714k().getContentResolver().openAssetFileDescriptor(Uri.parse(strI), "r").createInputStream());
        bitmapDecodeStream.setDensity(160);
        return bitmapDecodeStream;
    }
}
