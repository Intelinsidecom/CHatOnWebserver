package com.sec.common.widget;

import android.database.DataSetObserver;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.m */
/* loaded from: classes.dex */
class C5068m extends DataSetObserver {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f18503a;

    private C5068m(IcsListPopupWindow icsListPopupWindow) {
        this.f18503a = icsListPopupWindow;
    }

    /* synthetic */ C5068m(IcsListPopupWindow icsListPopupWindow, C5065j c5065j) {
        this(icsListPopupWindow);
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        if (this.f18503a.m19267d()) {
            this.f18503a.mo19255a();
        }
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.f18503a.m19262b();
    }
}
