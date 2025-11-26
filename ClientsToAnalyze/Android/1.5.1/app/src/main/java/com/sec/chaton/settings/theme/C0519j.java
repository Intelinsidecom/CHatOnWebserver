package com.sec.chaton.settings.theme;

import java.util.Comparator;

/* renamed from: com.sec.chaton.settings.theme.j */
/* loaded from: classes.dex */
class C0519j implements Comparator {

    /* renamed from: a */
    final /* synthetic */ Carousel f3296a;

    C0519j(Carousel carousel) {
        this.f3296a = carousel;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(CarouselImageView carouselImageView, CarouselImageView carouselImageView2) {
        int iM3263b = (int) carouselImageView.m3263b();
        if (iM3263b > 180) {
            iM3263b = 360 - iM3263b;
        }
        int iM3263b2 = (int) carouselImageView2.m3263b();
        if (iM3263b2 > 180) {
            iM3263b2 = 360 - iM3263b2;
        }
        return iM3263b - iM3263b2;
    }
}
