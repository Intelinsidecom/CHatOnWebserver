package com.sec.chaton.multimedia.image;

import android.database.Cursor;
import android.net.Uri;
import com.sec.chaton.p057e.p058a.InterfaceC2211y;

/* compiled from: ImagePagerActivity.java */
/* renamed from: com.sec.chaton.multimedia.image.n */
/* loaded from: classes.dex */
class C2854n implements InterfaceC2211y {

    /* renamed from: a */
    final /* synthetic */ ImagePagerActivity f10488a;

    C2854n(ImagePagerActivity imagePagerActivity) {
        this.f10488a = imagePagerActivity;
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7100a(int i, Object obj, Cursor cursor) {
        if (i == 1 && cursor != null) {
            try {
                this.f10488a.f10227v = cursor.getCount();
                int iM11783a = this.f10488a.m11783a(cursor);
                this.f10488a.f10225t.m617c();
                this.f10488a.f10221p.setCurrentItem(iM11783a, false);
                this.f10488a.f10228w = iM11783a;
                this.f10488a.m11786a(iM11783a);
            } finally {
                cursor.close();
            }
        }
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7101a(int i, Object obj, Uri uri) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: a */
    public void mo7099a(int i, Object obj, int i2) {
    }

    @Override // com.sec.chaton.p057e.p058a.InterfaceC2211y
    /* renamed from: b */
    public void mo7102b(int i, Object obj, int i2) {
    }
}
