package com.sec.chaton.buddy;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendActivity;
import com.sec.chaton.util.C1348w;
import com.sec.widget.AbstractC1629q;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.cb */
/* loaded from: classes.dex */
class C0421cb extends AbstractC1629q {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1403a;

    /* renamed from: b */
    private int f1404b;

    /* renamed from: c */
    private int f1405c;

    /* renamed from: d */
    private LayoutInflater f1406d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0421cb(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment, Context context, int i, Cursor cursor, String str) {
        super(context, i, cursor, str);
        this.f1403a = buddyRecommendFragment;
        this.f1406d = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // com.sec.widget.AbstractC1629q
    /* renamed from: a */
    protected View mo2369a(int i, int i2, View view, ViewGroup viewGroup) {
        TextView textView;
        if (view == null) {
            textView = (TextView) this.f1406d.inflate(R.layout.list_item_sub_title2, viewGroup, false);
        } else {
            textView = (TextView) view;
        }
        if (i == 200) {
            textView.setText(R.string.tab_buddies);
        } else if (i == 100) {
            textView.setText("Special Buddy");
        }
        return textView;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C0369ad c0369ad = (C0369ad) view.getTag();
        String string = cursor.getString(this.f1404b);
        String string2 = cursor.getString(this.f1405c);
        c0369ad.f1321b.setText(string);
        c0369ad.f1322c.setTag(string2);
        C1348w.m4685a(context).m4699a(c0369ad.f1320a, string2);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        C0369ad c0369ad = new C0369ad(this, viewNewView);
        c0369ad.f1322c.setOnClickListener(this.f1403a.f1262g);
        viewNewView.setTag(c0369ad);
        return viewNewView;
    }

    @Override // com.sec.widget.AbstractC1629q, android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (cursor != null) {
            this.f1404b = cursor.getColumnIndexOrThrow("buddy_name");
            this.f1405c = cursor.getColumnIndexOrThrow("buddy_no");
        }
        return super.swapCursor(cursor);
    }
}
