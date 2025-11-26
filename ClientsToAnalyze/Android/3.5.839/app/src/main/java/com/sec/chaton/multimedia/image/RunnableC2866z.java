package com.sec.chaton.multimedia.image;

import com.sec.chaton.util.C4904y;

/* compiled from: ImagePagerFragment.java */
/* renamed from: com.sec.chaton.multimedia.image.z */
/* loaded from: classes.dex */
class RunnableC2866z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String[] f10508a;

    /* renamed from: b */
    final /* synthetic */ ImagePagerFragment f10509b;

    RunnableC2866z(ImagePagerFragment imagePagerFragment, String[] strArr) {
        this.f10509b = imagePagerFragment;
        this.f10508a = strArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (C4904y.f17872b) {
            C4904y.m18639b("mCommentHandler run: " + this.f10509b.f10250l, ImagePagerFragment.f10232f);
        }
        if (this.f10509b.f10260v != null) {
            this.f10509b.f10233A = this.f10509b.f10234B.m17522a(this.f10509b.m11844d().m11825m(), this.f10508a[4], this.f10508a[3], 100, 239);
        }
    }
}
