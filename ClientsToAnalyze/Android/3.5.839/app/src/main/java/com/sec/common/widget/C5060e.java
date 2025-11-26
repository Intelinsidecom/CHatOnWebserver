package com.sec.common.widget;

import android.database.DataSetObserver;
import android.os.Parcelable;

/* compiled from: IcsAdapterView.java */
/* renamed from: com.sec.common.widget.e */
/* loaded from: classes.dex */
class C5060e extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ IcsAdapterView f18494a;

    /* renamed from: b */
    private Parcelable f18495b = null;

    C5060e(IcsAdapterView icsAdapterView) {
        this.f18494a = icsAdapterView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.f18494a.f18440v = true;
        this.f18494a.f18420B = this.f18494a.f18419A;
        this.f18494a.f18419A = this.f18494a.mo19222f().getCount();
        if (this.f18494a.mo19222f().hasStableIds() && this.f18495b != null && this.f18494a.f18420B == 0 && this.f18494a.f18419A > 0) {
            this.f18494a.onRestoreInstanceState(this.f18495b);
            this.f18495b = null;
        } else {
            this.f18494a.m19243q();
        }
        this.f18494a.m19238l();
        this.f18494a.requestLayout();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f18494a.f18440v = true;
        if (this.f18494a.mo19222f().hasStableIds()) {
            this.f18495b = this.f18494a.onSaveInstanceState();
        }
        this.f18494a.f18420B = this.f18494a.f18419A;
        this.f18494a.f18419A = 0;
        this.f18494a.f18443y = -1;
        this.f18494a.f18444z = Long.MIN_VALUE;
        this.f18494a.f18441w = -1;
        this.f18494a.f18442x = Long.MIN_VALUE;
        this.f18494a.f18434p = false;
        this.f18494a.m19238l();
        this.f18494a.requestLayout();
    }
}
