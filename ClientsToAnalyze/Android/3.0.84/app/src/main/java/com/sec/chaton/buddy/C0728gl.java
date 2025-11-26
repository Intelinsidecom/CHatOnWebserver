package com.sec.chaton.buddy;

import android.content.Context;
import android.database.Cursor;
import android.hardware.motion.MotionRecognitionManager;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings2.PrefFragmentChats;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.widget.AbstractC3656ax;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.gl */
/* loaded from: classes.dex */
class C0728gl extends AbstractC3656ax {

    /* renamed from: a */
    final /* synthetic */ BuddyRecommendFragment f2972a;

    /* renamed from: b */
    private int f2973b;

    /* renamed from: c */
    private int f2974c;

    /* renamed from: d */
    private int f2975d;

    /* renamed from: e */
    private int f2976e;

    /* renamed from: f */
    private LayoutInflater f2977f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0728gl(BuddyRecommendFragment buddyRecommendFragment, Context context, int i, Cursor cursor, String str) {
        super(context, i, cursor, str);
        this.f2972a = buddyRecommendFragment;
        this.f2977f = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // com.sec.widget.AbstractC3656ax
    /* renamed from: a */
    protected View mo4350a(int i, int i2, View view, ViewGroup viewGroup) {
        TextView textView;
        LinearLayout linearLayout;
        if (view == null) {
            linearLayout = (LinearLayout) this.f2977f.inflate(R.layout.layout_common_header, viewGroup, false);
            textView = (TextView) linearLayout.findViewById(R.id.text1);
        } else {
            LinearLayout linearLayout2 = (LinearLayout) view;
            textView = (TextView) linearLayout2.findViewById(R.id.text1);
            linearLayout = linearLayout2;
        }
        textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow, 0);
        if (i == 200) {
            textView.setText(this.f2972a.getResources().getString(R.string.add_buddy_suggestion_people_may_know) + " (" + Integer.toString(this.f2972a.f2200m) + ")");
            if (this.f2972a.f2200m > 10) {
                linearLayout.setOnClickListener(this.f2972a.f2184P);
                linearLayout.setEnabled(true);
                linearLayout.setFocusable(true);
                linearLayout.setDescendantFocusability(MotionRecognitionManager.EVENT_CALL_POSE);
            } else {
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                linearLayout.setEnabled(false);
                linearLayout.setOnClickListener(null);
            }
        }
        return linearLayout;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        long jLongValue;
        C0729gm c0729gm = (C0729gm) view.getTag();
        String string = cursor.getString(this.f2973b);
        String string2 = cursor.getString(this.f2974c);
        String string3 = cursor.getString(this.f2975d);
        Long lValueOf = Long.valueOf(cursor.getLong(this.f2976e));
        Long lValueOf2 = Long.valueOf(C3159aa.m10962a().m10976a("recommend_timestamp", 0L));
        c0729gm.f2978a.setBackgroundResource(R.drawable.frame_background);
        c0729gm.f2979b.setText(string);
        c0729gm.f2980c.setBackgroundResource(R.drawable.list_ic_add);
        c0729gm.f2980c.setTag(R.id.TAG_FOR_BUDDYNO, string2);
        c0729gm.f2980c.setTag(R.id.TAG_FOR_TYPE, string3);
        c0729gm.f2980c.setFocusable(false);
        toString();
        if (string3.equals(String.valueOf(HttpResponseCode.f13733OK))) {
            c0729gm.f2980c.setVisibility(0);
            BuddyRecommendFragment buddyRecommendFragment = this.f2972a;
            if (this.f2972a.f2201n > lValueOf.longValue()) {
                jLongValue = this.f2972a.f2201n;
            } else {
                jLongValue = lValueOf.longValue();
            }
            buddyRecommendFragment.f2201n = jLongValue;
            if (lValueOf.longValue() > lValueOf2.longValue()) {
                int paddingTop = c0729gm.f2981d.getPaddingTop();
                int paddingRight = c0729gm.f2981d.getPaddingRight();
                int paddingBottom = c0729gm.f2981d.getPaddingBottom();
                int paddingLeft = c0729gm.f2981d.getPaddingLeft();
                c0729gm.f2981d.setBackgroundResource(R.drawable.listview_selector_highlight);
                c0729gm.f2981d.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            } else {
                int paddingTop2 = c0729gm.f2981d.getPaddingTop();
                int paddingRight2 = c0729gm.f2981d.getPaddingRight();
                int paddingBottom2 = c0729gm.f2981d.getPaddingBottom();
                int paddingLeft2 = c0729gm.f2981d.getPaddingLeft();
                if (!GlobalApplication.m6456e()) {
                    if (Build.VERSION.SDK_INT >= 16) {
                        c0729gm.f2981d.setBackground(null);
                    } else {
                        c0729gm.f2981d.setBackgroundDrawable(null);
                    }
                    c0729gm.f2981d.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
                }
            }
        }
        C3205bt.m11182a(context).m11214a(c0729gm.f2978a, string2, true);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewNewView = super.newView(context, cursor, viewGroup);
        C0729gm c0729gm = new C0729gm(viewNewView);
        c0729gm.f2980c.setOnClickListener(this.f2972a.f2181M);
        String string = cursor.getString(this.f2975d);
        toString();
        if (string.equals(String.valueOf(HttpResponseCode.f13733OK))) {
        }
        viewNewView.setTag(c0729gm);
        return viewNewView;
    }

    @Override // com.sec.widget.AbstractC3656ax, android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        if (cursor != null) {
            this.f2973b = cursor.getColumnIndexOrThrow("buddy_name");
            this.f2974c = cursor.getColumnIndexOrThrow("buddy_no");
            this.f2975d = cursor.getColumnIndexOrThrow(PrefFragmentChats.TYPE);
            this.f2976e = cursor.getColumnIndexOrThrow("timestamp");
        }
        return super.swapCursor(cursor);
    }
}
