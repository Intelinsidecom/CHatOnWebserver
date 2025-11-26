package com.sec.chaton.settings;

import android.view.View;
import com.sec.chaton.settings.theme.Carousel;
import com.sec.chaton.settings.theme.CarouselAdapter;

/* renamed from: com.sec.chaton.settings.ak */
/* loaded from: classes.dex */
class C0462ak implements CarouselAdapter.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ Carousel f3153a;

    /* renamed from: b */
    final /* synthetic */ ActivitySkins f3154b;

    C0462ak(ActivitySkins activitySkins, Carousel carousel) {
        this.f3154b = activitySkins;
        this.f3153a = carousel;
    }

    @Override // com.sec.chaton.settings.theme.CarouselAdapter.OnItemClickListener
    /* renamed from: a */
    public void mo3220a(CarouselAdapter carouselAdapter, View view, int i, long j) {
        int i2 = i > 4 ? i - 5 : i;
        this.f3154b.f3072d.setText("Skin  " + i2);
        this.f3154b.f3073e = i2 + "";
        this.f3153a.setSelection(i2);
    }
}
