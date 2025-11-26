package com.sec.common.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;

/* compiled from: IcsAdapterView.java */
/* renamed from: com.sec.common.widget.i */
/* loaded from: classes.dex */
class C3376i extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ IcsAdapterView f12248a;

    /* renamed from: b */
    private Parcelable f12249b = null;

    C3376i(IcsAdapterView icsAdapterView) {
        this.f12248a = icsAdapterView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f12248a.f12170v = true;
        this.f12248a.f12150B = this.f12248a.f12149A;
        this.f12248a.f12149A = this.f12248a.mo11880f().getCount();
        if (this.f12248a.mo11880f().hasStableIds() && this.f12249b != null && this.f12248a.f12150B == 0 && this.f12248a.f12149A > 0) {
            this.f12248a.onRestoreInstanceState(this.f12249b);
            this.f12249b = null;
        } else {
            this.f12248a.m11901q();
        }
        this.f12248a.m11896l();
        this.f12248a.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f12248a.f12170v = true;
        if (this.f12248a.mo11880f().hasStableIds()) {
            this.f12249b = this.f12248a.onSaveInstanceState();
        }
        this.f12248a.f12150B = this.f12248a.f12149A;
        this.f12248a.f12149A = 0;
        this.f12248a.f12173y = -1;
        this.f12248a.f12174z = Long.MIN_VALUE;
        this.f12248a.f12171w = -1;
        this.f12248a.f12172x = Long.MIN_VALUE;
        this.f12248a.f12164p = false;
        this.f12248a.m11896l();
        this.f12248a.requestLayout();
    }
}
