package com.sec.common.widget;

import android.database.DataSetObserver;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.q */
/* loaded from: classes.dex */
class C3384q extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f12257a;

    private C3384q(IcsListPopupWindow icsListPopupWindow) {
        this.f12257a = icsListPopupWindow;
    }

    /* synthetic */ C3384q(IcsListPopupWindow icsListPopupWindow, C3381n c3381n) {
        this(icsListPopupWindow);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        if (this.f12257a.m11925d()) {
            this.f12257a.mo11913a();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f12257a.m11920b();
    }
}
