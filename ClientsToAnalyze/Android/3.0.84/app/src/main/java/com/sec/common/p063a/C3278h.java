package com.sec.common.p063a;

import android.R;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.sec.common.C3313d;

/* compiled from: AlertDialogImpl.java */
/* renamed from: com.sec.common.a.h */
/* loaded from: classes.dex */
class C3278h extends CursorAdapter {

    /* renamed from: a */
    final /* synthetic */ ListView f11874a;

    /* renamed from: b */
    final /* synthetic */ DialogC3275e f11875b;

    /* renamed from: c */
    private final int f11876c;

    /* renamed from: d */
    private final int f11877d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C3278h(DialogC3275e dialogC3275e, Context context, Cursor cursor, boolean z, ListView listView) {
        super(context, cursor, z);
        this.f11875b = dialogC3275e;
        this.f11874a = listView;
        Cursor cursor2 = getCursor();
        this.f11876c = cursor2.getColumnIndexOrThrow(this.f11875b.f11861q);
        this.f11877d = cursor2.getColumnIndexOrThrow(this.f11875b.f11860p);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f11876c));
        this.f11874a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f11877d) == 1);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(this.mContext).inflate(C3313d.layout_dialog_listview_multichoice, viewGroup, false);
    }
}
