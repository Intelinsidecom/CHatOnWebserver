package com.sec.chaton.buddy;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.BuddyRecommendListActivity;
import com.sec.chaton.util.C1746bb;
import com.sec.widget.AbstractC2129ai;

/* compiled from: BuddyRecommendListActivity.java */
/* renamed from: com.sec.chaton.buddy.eh */
/* loaded from: classes.dex */
class C0377eh extends AbstractC2129ai {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendListActivity.BuddyRecommendListFragment f1528a;

    /* renamed from: b */
    private int f1529b;

    /* renamed from: c */
    private int f1530c;

    /* renamed from: d */
    private int f1531d;

    /* renamed from: e */
    private LayoutInflater f1532e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0377eh(BuddyRecommendListActivity.BuddyRecommendListFragment buddyRecommendListFragment, Context context, int i, Cursor cursor, String str) {
        super(context, i, cursor, str);
        this.f1528a = buddyRecommendListFragment;
        this.f1532e = (LayoutInflater) context.getSystemService("layout_inflater");
        m2411a();
    }

    /* renamed from: a */
    public void m2411a() {
        Cursor cursor = getCursor();
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                String string = cursor.getString(this.f1530c);
                if (string != null && !this.f1528a.f1197o.contains(string)) {
                    this.f1528a.f1197o.add(string);
                }
            }
            cursor.moveToPosition(-1);
        }
    }

    @Override // com.sec.widget.AbstractC2129ai
    /* renamed from: a */
    protected View mo2410a(int i, int i2, View view, ViewGroup viewGroup) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        if (view == null) {
            linearLayout = (LinearLayout) this.f1532e.inflate(R.layout.list_item_sub_title2, viewGroup, false);
            textView2 = (TextView) linearLayout.findViewById(R.id.RecommendListBuddyTitle);
            textView = (TextView) linearLayout.findViewById(R.id.RecommendListSubTitleMore);
            imageView = (ImageView) linearLayout.findViewById(R.id.RecommendListMoreBtn);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) view;
            TextView textView3 = (TextView) linearLayout2.findViewById(R.id.RecommendListBuddyTitle);
            TextView textView4 = (TextView) linearLayout2.findViewById(R.id.RecommendListSubTitleMore);
            imageView = (ImageView) linearLayout2.findViewById(R.id.RecommendListMoreBtn);
            textView = textView4;
            textView2 = textView3;
            linearLayout = linearLayout2;
        }
        textView.setVisibility(8);
        imageView.setVisibility(8);
        linearLayout.setBackgroundDrawable(this.f1528a.getResources().getDrawable(R.drawable.sub_title_bg));
        if (i == 200) {
            textView2.setText(this.f1528a.getResources().getString(R.string.add_buddy_suggestion_people_you_may_know) + " (" + Integer.toString(this.f1528a.m2212c()) + ")");
        } else if (i == 100) {
            textView2.setText(this.f1528a.getResources().getString(R.string.buddy_suggestion_special_buddy) + " (" + Integer.toString(this.f1528a.m2212c()) + ")");
        }
        return linearLayout;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C0378ei c0378ei = (C0378ei) view.getTag();
        String string = cursor.getString(this.f1529b);
        String string2 = cursor.getString(this.f1530c);
        String string3 = cursor.getString(this.f1531d);
        c0378ei.f1534b.setText(string);
        c0378ei.f1535c.setTag(R.id.TAG_FOR_BUDDYNO, string2);
        c0378ei.f1535c.setTag(R.id.TAG_FOR_TYPE, string3);
        toString();
        if (string3.equals(String.valueOf(100))) {
            c0378ei.f1535c.setVisibility(8);
            c0378ei.f1536d.setVisibility(0);
        } else {
            c0378ei.f1535c.setVisibility(0);
            c0378ei.f1536d.setVisibility(8);
        }
        C1746bb.m5945a(context).m5959a(c0378ei.f1533a, string2);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        C0378ei c0378ei = new C0378ei(viewNewView);
        c0378ei.f1535c.setOnClickListener(this.f1528a.f1199q);
        if (this.f1528a.f1189g == 100) {
            viewNewView.setOnClickListener(this.f1528a.f1200r);
        } else {
            this.f1528a.registerForContextMenu(viewNewView);
            viewNewView.setOnClickListener(this.f1528a.f1201s);
        }
        viewNewView.setTag(c0378ei);
        return viewNewView;
    }

    @Override // com.sec.widget.AbstractC2129ai, android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        Cursor cursorSwapCursor = super.swapCursor(cursor);
        if (cursor != null) {
            this.f1529b = cursor.getColumnIndexOrThrow("buddy_name");
            this.f1530c = cursor.getColumnIndexOrThrow("buddy_no");
            this.f1531d = cursor.getColumnIndexOrThrow("type");
        }
        m2411a();
        return cursorSwapCursor;
    }
}
