package com.sec.common.p123a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.h */
/* loaded from: classes.dex */
class C4939h extends ArrayAdapter<CharSequence> {

    /* renamed from: a */
    final /* synthetic */ ListView f18071a;

    /* renamed from: b */
    final /* synthetic */ DialogC4937f f18072b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4939h(DialogC4937f dialogC4937f, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
        super(context, i, i2, charSequenceArr);
        this.f18072b = dialogC4937f;
        this.f18071a = listView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        if (this.f18072b.f18058o != null && this.f18072b.f18058o[i]) {
            this.f18071a.setItemChecked(i, true);
        }
        return view2;
    }
}
