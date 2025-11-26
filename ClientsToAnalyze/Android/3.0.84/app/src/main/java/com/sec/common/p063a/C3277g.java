package com.sec.common.p063a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.g */
/* loaded from: classes.dex */
class C3277g extends ArrayAdapter<CharSequence> {

    /* renamed from: a */
    final /* synthetic */ ListView f11872a;

    /* renamed from: b */
    final /* synthetic */ DialogC3275e f11873b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3277g(DialogC3275e dialogC3275e, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        super(context, i, i2, charSequenceArr);
        this.f11873b = dialogC3275e;
        this.f11872a = listView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f11873b.f11859o != null && this.f11873b.f11859o[i]) {
            this.f11872a.setItemChecked(i, true);
        }
        return view2;
    }
}
