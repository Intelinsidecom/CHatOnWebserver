package com.sec.chaton.buddy;

import android.graphics.Bitmap;
import com.sec.chaton.util.ImageDownloader;

/* renamed from: com.sec.chaton.buddy.aj */
/* loaded from: classes.dex */
class C0086aj implements ImageDownloader.OnImageLoaded {

    /* renamed from: a */
    final /* synthetic */ ViewProfileImage f623a;

    C0086aj(ViewProfileImage viewProfileImage) {
        this.f623a = viewProfileImage;
    }

    @Override // com.sec.chaton.util.ImageDownloader.OnImageLoaded
    /* renamed from: a */
    public void mo653a(String str, Bitmap bitmap, ImageDownloader.ImageDownResult imageDownResult) {
        this.f623a.runOnUiThread(new RunnableC0085ai(this, imageDownResult, bitmap));
    }
}
