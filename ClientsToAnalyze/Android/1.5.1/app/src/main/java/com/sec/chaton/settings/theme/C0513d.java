package com.sec.chaton.settings.theme;

import android.database.DataSetObserver;
import android.os.Parcelable;

/* renamed from: com.sec.chaton.settings.theme.d */
/* loaded from: classes.dex */
class C0513d extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ CarouselAdapter f3288a;

    /* renamed from: b */
    private Parcelable f3289b = null;

    C0513d(CarouselAdapter carouselAdapter) {
        this.f3288a = carouselAdapter;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f3288a.f3234l = true;
        this.f3288a.f3240r = this.f3288a.f3239q;
        this.f3288a.f3239q = this.f3288a.mo3248b().getCount();
        if (!this.f3288a.mo3248b().hasStableIds() || this.f3289b == null || this.f3288a.f3240r != 0 || this.f3288a.f3239q <= 0) {
            this.f3288a.m3259l();
        } else {
            this.f3288a.onRestoreInstanceState(this.f3289b);
            this.f3289b = null;
        }
        this.f3288a.m3255h();
        this.f3288a.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f3288a.f3234l = true;
        if (this.f3288a.mo3248b().hasStableIds()) {
            this.f3289b = this.f3288a.onSaveInstanceState();
        }
        this.f3288a.f3240r = this.f3288a.f3239q;
        this.f3288a.f3239q = 0;
        this.f3288a.f3237o = -1;
        this.f3288a.f3238p = Long.MIN_VALUE;
        this.f3288a.f3235m = -1;
        this.f3288a.f3236n = Long.MIN_VALUE;
        this.f3288a.f3228f = false;
        this.f3288a.m3257j();
        this.f3288a.m3255h();
        this.f3288a.requestLayout();
    }
}
