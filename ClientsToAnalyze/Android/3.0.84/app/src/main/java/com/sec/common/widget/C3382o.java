package com.sec.common.widget;

import android.content.Context;
import android.widget.ListView;
import com.sec.common.C3307b;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.o */
/* loaded from: classes.dex */
class C3382o extends ListView {

    /* renamed from: a */
    private boolean f12254a;

    /* renamed from: b */
    private boolean f12255b;

    public C3382o(Context context, boolean z) {
        super(context, null, C3307b.dropDownListViewStyle);
        this.f12255b = z;
        setCacheColorHint(0);
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f12255b && this.f12254a) || super.isInTouchMode();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f12255b || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f12255b || super.isFocused();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f12255b || super.hasFocus();
    }
}
