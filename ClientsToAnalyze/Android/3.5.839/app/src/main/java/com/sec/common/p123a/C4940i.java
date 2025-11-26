package com.sec.common.p123a;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.AbstractC0243c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.sec.common.C4975d;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.i */
/* loaded from: classes.dex */
class C4940i extends AbstractC0243c {

    /* renamed from: j */
    final /* synthetic */ ListView f18073j;

    /* renamed from: k */
    final /* synthetic */ DialogC4937f f18074k;

    /* renamed from: l */
    private final int f18075l;

    /* renamed from: m */
    private final int f18076m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4940i(DialogC4937f dialogC4937f, Context context, Cursor cursor, boolean z, ListView listView) {
        super(context, cursor, z);
        this.f18074k = dialogC4937f;
        this.f18073j = listView;
        Cursor cursorA = mo871a();
        this.f18075l = cursorA.getColumnIndexOrThrow(this.f18074k.f18060q);
        this.f18076m = cursorA.getColumnIndexOrThrow(this.f18074k.f18059p);
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f18075l));
        this.f18073j.setItemChecked(cursor.getPosition(), cursor.getInt(this.f18076m) == 1);
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(this.f580d).inflate(C4975d.layout_dialog_listview_multichoice, viewGroup, false);
    }
}
