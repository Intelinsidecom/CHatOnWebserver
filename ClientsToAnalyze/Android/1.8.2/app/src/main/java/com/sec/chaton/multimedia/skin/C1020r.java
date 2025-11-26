package com.sec.chaton.multimedia.skin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.CallableC0917ab;

/* compiled from: SkinPreviewDispatcherTask.java */
/* renamed from: com.sec.chaton.multimedia.skin.r */
/* loaded from: classes.dex */
public class C1020r extends CallableC0917ab {
    public C1020r(String str) {
        super(str);
        m3959n();
    }

    /* renamed from: n */
    private void m3959n() {
        m3777a(R.drawable.thumb_setting_networkerror);
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.CallableC0917ab, com.sec.common.p056b.p059c.AbstractRunnableC1820a
    /* renamed from: c */
    public Object mo3769c() {
        String str = (String) m6178j();
        if (!str.startsWith("android.resource")) {
            return super.mo3769c();
        }
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(m6179k().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r").createInputStream());
        bitmapDecodeStream.setDensity(160);
        return bitmapDecodeStream;
    }
}
