package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p112ui.SearchActivity;

/* compiled from: SearchActivity.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hp */
/* loaded from: classes.dex */
class C4296hp extends CursorAdapter {

    /* renamed from: a */
    final /* synthetic */ int f15684a;

    /* renamed from: b */
    final /* synthetic */ int f15685b;

    /* renamed from: c */
    final /* synthetic */ int f15686c;

    /* renamed from: d */
    final /* synthetic */ int f15687d;

    /* renamed from: e */
    final /* synthetic */ C4295ho f15688e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    C4296hp(C4295ho c4295ho, Context context, Cursor cursor, boolean z, int i, int i2, int i3, int i4) {
        super(context, cursor, z);
        this.f15688e = c4295ho;
        this.f15684a = i;
        this.f15685b = i2;
        this.f15686c = i3;
        this.f15687d = i4;
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.findViewById(R.id.title);
        SearchActivity.TextViewSnippet textViewSnippet = (SearchActivity.TextViewSnippet) view.findViewById(R.id.subtitle);
        String string = cursor.getString(this.f15684a);
        C3782a c3782aM14204a = string != null ? C3782a.m14204a(string, false) : null;
        textView.setText(c3782aM14204a != null ? c3782aM14204a.m14266h() : "");
        textViewSnippet.setText(cursor.getString(this.f15685b), this.f15688e.f15681a);
        view.setOnClickListener(new ViewOnClickListenerC4297hq(this, cursor.getLong(this.f15686c), cursor.getLong(this.f15687d)));
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.search_item, viewGroup, false);
    }
}
