package com.sec.chaton.buddy;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;

/* compiled from: BuddyRecommendListFragment.java */
/* renamed from: com.sec.chaton.buddy.he */
/* loaded from: classes.dex */
class C0748he extends CursorAdapter {

    /* renamed from: a */
    TextView f3002a;

    /* renamed from: b */
    final /* synthetic */ BuddyRecommendListFragment f3003b;

    /* renamed from: c */
    private int f3004c;

    /* renamed from: d */
    private int f3005d;

    /* renamed from: e */
    private int f3006e;

    /* renamed from: f */
    private int f3007f;

    /* renamed from: g */
    private LayoutInflater f3008g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0748he(BuddyRecommendListFragment buddyRecommendListFragment, Context context, Cursor cursor, int i) {
        super(context, cursor, i);
        this.f3003b = buddyRecommendListFragment;
        this.f3002a = null;
        this.f3008g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        long jLongValue;
        C0749hf c0749hf = (C0749hf) view.getTag();
        String string = cursor.getString(this.f3004c);
        String string2 = cursor.getString(this.f3005d);
        String string3 = cursor.getString(this.f3006e);
        Long lValueOf = Long.valueOf(cursor.getLong(this.f3007f));
        Long lValueOf2 = Long.valueOf(C3159aa.m10962a().m10976a("recommend_timestamp", 0L));
        c0749hf.f3010b.setText(string);
        c0749hf.f3009a.setBackgroundResource(R.drawable.frame_background);
        c0749hf.f3011c.setTag(R.id.TAG_FOR_BUDDYNO, string2);
        c0749hf.f3011c.setTag(R.id.TAG_FOR_TYPE, string3);
        c0749hf.f3011c.setBackgroundResource(R.drawable.list_ic_add);
        c0749hf.f3011c.setFocusable(false);
        if (string2 != null && !this.f3003b.f2231q.contains(string2)) {
            this.f3003b.f2231q.add(string2);
        }
        if (string3.equals(String.valueOf(100))) {
            c0749hf.f3011c.setVisibility(8);
            c0749hf.f3012d.setOnClickListener(this.f3003b.f2238x);
        } else {
            c0749hf.f3011c.setVisibility(0);
            BuddyRecommendListFragment buddyRecommendListFragment = this.f3003b;
            if (this.f3003b.f2234t > lValueOf.longValue()) {
                jLongValue = this.f3003b.f2234t;
            } else {
                jLongValue = lValueOf.longValue();
            }
            buddyRecommendListFragment.f2234t = jLongValue;
            if (lValueOf.longValue() > lValueOf2.longValue()) {
                int paddingTop = c0749hf.f3012d.getPaddingTop();
                int paddingRight = c0749hf.f3012d.getPaddingRight();
                int paddingBottom = c0749hf.f3012d.getPaddingBottom();
                int paddingLeft = c0749hf.f3012d.getPaddingLeft();
                c0749hf.f3012d.setBackgroundResource(R.drawable.listview_selector_highlight);
                c0749hf.f3012d.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            } else {
                int paddingTop2 = c0749hf.f3012d.getPaddingTop();
                int paddingRight2 = c0749hf.f3012d.getPaddingRight();
                int paddingBottom2 = c0749hf.f3012d.getPaddingBottom();
                int paddingLeft2 = c0749hf.f3012d.getPaddingLeft();
                if (Build.VERSION.SDK_INT >= 16) {
                    c0749hf.f3012d.setBackground(null);
                } else {
                    c0749hf.f3012d.setBackgroundDrawable(null);
                }
                c0749hf.f3012d.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
            }
        }
        C3205bt.m11182a(context).m11214a(c0749hf.f3009a, string2, true);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.list_item_common_11, viewGroup, false);
        C0749hf c0749hf = new C0749hf(viewInflate);
        c0749hf.f3011c.setOnClickListener(this.f3003b.f2237w);
        viewInflate.setTag(c0749hf);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (cursor != null) {
            this.f3004c = cursor.getColumnIndexOrThrow("buddy_name");
            this.f3005d = cursor.getColumnIndexOrThrow("buddy_no");
            this.f3006e = cursor.getColumnIndexOrThrow(PrefFragmentChats.TYPE);
            this.f3007f = cursor.getColumnIndexOrThrow("timestamp");
        }
        return super.swapCursor(cursor);
    }
}
