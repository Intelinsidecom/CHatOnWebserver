package com.sec.common.widget;

import android.content.Context;
import android.widget.ListView;
import com.sec.common.C4969b;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.k */
/* loaded from: classes.dex */
class C5066k extends ListView {

    /* renamed from: a */
    private boolean f18500a;

    /* renamed from: b */
    private boolean f18501b;

    public C5066k(Context context, boolean z) {
        super(context, null, C4969b.dropDownListViewStyle);
        this.f18501b = z;
        setCacheColorHint(0);
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f18501b && this.f18500a) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f18501b || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f18501b || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f18501b || super.hasFocus();
    }
}
