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
import com.sec.chaton.buddy.BuddyRecommendActivity;
import com.sec.chaton.util.C1746bb;
import com.sec.widget.AbstractC2129ai;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyRecommendActivity.java */
/* renamed from: com.sec.chaton.buddy.dt */
/* loaded from: classes.dex */
class C0362dt extends AbstractC2129ai {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendActivity.BuddyRecommendFragment f1506a;

    /* renamed from: b */
    private int f1507b;

    /* renamed from: c */
    private int f1508c;

    /* renamed from: d */
    private int f1509d;

    /* renamed from: e */
    private LayoutInflater f1510e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0362dt(BuddyRecommendActivity.BuddyRecommendFragment buddyRecommendFragment, Context context, int i, Cursor cursor, String str) {
        super(context, i, cursor, str);
        this.f1506a = buddyRecommendFragment;
        this.f1510e = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // com.sec.widget.AbstractC2129ai
    /* renamed from: a */
    protected View mo2410a(int i, int i2, View view, ViewGroup viewGroup) {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        if (view == null) {
            linearLayout = (LinearLayout) this.f1510e.inflate(R.layout.list_item_sub_title2, viewGroup, false);
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
        if (i == 200) {
            textView2.setText(this.f1506a.getResources().getString(R.string.add_buddy_suggestion_people_you_may_know) + " (" + Integer.toString(this.f1506a.m2176a()) + ")");
            if (this.f1506a.m2176a() > 3) {
                textView.setVisibility(0);
                imageView.setVisibility(0);
                linearLayout.setOnClickListener(this.f1506a.f1179o);
            } else {
                textView.setVisibility(8);
                imageView.setVisibility(8);
                linearLayout.setBackgroundDrawable(this.f1506a.getResources().getDrawable(R.drawable.sub_title_bg));
                linearLayout.setOnClickListener(null);
            }
        } else if (i == 100) {
            textView2.setText(this.f1506a.getResources().getString(R.string.buddy_suggestion_special_buddy) + " (" + Integer.toString(this.f1506a.m2184b()) + ")");
            if (this.f1506a.m2184b() > 3) {
                textView.setVisibility(0);
                imageView.setVisibility(0);
                linearLayout.setOnClickListener(this.f1506a.f1177m);
            } else {
                textView.setVisibility(8);
                imageView.setVisibility(8);
                linearLayout.setBackgroundDrawable(this.f1506a.getResources().getDrawable(R.drawable.sub_title_bg));
                linearLayout.setOnClickListener(null);
            }
        }
        return linearLayout;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C0363du c0363du = (C0363du) view.getTag();
        String string = cursor.getString(this.f1507b);
        String string2 = cursor.getString(this.f1508c);
        String string3 = cursor.getString(this.f1509d);
        c0363du.f1512b.setText(string);
        c0363du.f1513c.setTag(R.id.TAG_FOR_BUDDYNO, string2);
        c0363du.f1513c.setTag(R.id.TAG_FOR_TYPE, string3);
        toString();
        if (string3.equals(String.valueOf(100))) {
            c0363du.f1513c.setVisibility(8);
            c0363du.f1514d.setVisibility(0);
        } else {
            c0363du.f1513c.setVisibility(0);
            c0363du.f1514d.setVisibility(8);
        }
        C1746bb.m5945a(context).m5959a(c0363du.f1511a, string2);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        C0363du c0363du = new C0363du(viewNewView);
        c0363du.f1513c.setOnClickListener(this.f1506a.f1176l);
        String string = cursor.getString(this.f1509d);
        toString();
        if (string.equals(String.valueOf(100))) {
            viewNewView.setOnClickListener(this.f1506a.f1178n);
        } else {
            String string2 = cursor.getString(this.f1509d);
            toString();
            if (string2.equals(String.valueOf(HttpResponseCode.f7897OK))) {
                this.f1506a.registerForContextMenu(viewNewView);
                viewNewView.setOnClickListener(this.f1506a.f1180p);
            }
        }
        viewNewView.setTag(c0363du);
        return viewNewView;
    }

    @Override // com.sec.widget.AbstractC2129ai, android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (cursor != null) {
            this.f1507b = cursor.getColumnIndexOrThrow("buddy_name");
            this.f1508c = cursor.getColumnIndexOrThrow("buddy_no");
            this.f1509d = cursor.getColumnIndexOrThrow("type");
        }
        return super.swapCursor(cursor);
    }
}
