package com.sec.chaton.buddy;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.support.v4.widget.AbstractC0243c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.sec.chaton.R;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4809aa;

/* compiled from: BuddyRecommendFragment.java */
/* renamed from: com.sec.chaton.buddy.hk */
/* loaded from: classes.dex */
class C1358hk extends AbstractC0243c {

    /* renamed from: j */
    final /* synthetic */ BuddyRecommendFragment f4937j;

    /* renamed from: k */
    private int f4938k;

    /* renamed from: l */
    private int f4939l;

    /* renamed from: m */
    private int f4940m;

    /* renamed from: n */
    private int f4941n;

    /* renamed from: o */
    private int f4942o;

    /* renamed from: p */
    private long f4943p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1358hk(BuddyRecommendFragment buddyRecommendFragment, Context context, int i, Cursor cursor) {
        super(context, cursor, 2);
        this.f4937j = buddyRecommendFragment;
        this.f4942o = i;
        this.f4943p = C4809aa.m18104a().m18118a("recommend_timestamp", 0L);
    }

    @Override // android.support.v4.widget.AbstractC0243c
    @TargetApi(16)
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        long jLongValue;
        C1359hl c1359hl = (C1359hl) view.getTag();
        String string = cursor.getString(this.f4938k);
        String string2 = cursor.getString(this.f4939l);
        String string3 = cursor.getString(this.f4940m);
        Long lValueOf = Long.valueOf(cursor.getLong(this.f4941n));
        c1359hl.f4946c.setText(string);
        c1359hl.f4947d.setBackgroundResource(R.drawable.list_ic_add);
        c1359hl.f4947d.setTag(R.id.TAG_FOR_BUDDYNO, string2);
        c1359hl.f4947d.setTag(R.id.TAG_FOR_TYPE, string3);
        c1359hl.f4947d.setFocusable(false);
        c1359hl.f4947d.setContentDescription(this.f4937j.getResources().getString(R.string.buddy_add_contact));
        c1359hl.f4947d.setVisibility(0);
        BuddyRecommendFragment buddyRecommendFragment = this.f4937j;
        if (this.f4937j.f4087o > lValueOf.longValue()) {
            jLongValue = this.f4937j.f4087o;
        } else {
            jLongValue = lValueOf.longValue();
        }
        buddyRecommendFragment.f4087o = jLongValue;
        if (lValueOf.longValue() > this.f4943p) {
            int paddingTop = c1359hl.f4948e.getPaddingTop();
            int paddingRight = c1359hl.f4948e.getPaddingRight();
            int paddingBottom = c1359hl.f4948e.getPaddingBottom();
            int paddingLeft = c1359hl.f4948e.getPaddingLeft();
            c1359hl.f4948e.setBackgroundResource(R.drawable.listview_selector_highlight);
            c1359hl.f4948e.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
            C4809aa.m18107a("recommend_timestamp", Long.valueOf(this.f4937j.f4087o));
        } else {
            int paddingTop2 = c1359hl.f4948e.getPaddingTop();
            int paddingRight2 = c1359hl.f4948e.getPaddingRight();
            int paddingBottom2 = c1359hl.f4948e.getPaddingBottom();
            int paddingLeft2 = c1359hl.f4948e.getPaddingLeft();
            if (Build.VERSION.SDK_INT >= 16) {
                c1359hl.f4948e.setBackground(null);
            } else {
                c1359hl.f4948e.setBackgroundDrawable(null);
            }
            c1359hl.f4948e.setPadding(paddingLeft2, paddingTop2, paddingRight2, paddingBottom2);
        }
        c1359hl.f4944a.setBackgroundResource(R.drawable.circle_background);
        C2496n.m10765a(c1359hl.f4944a, string2, EnumC2498p.ROUND);
        if ("201".equals(string3)) {
            c1359hl.f4945b.setVisibility(0);
            c1359hl.f4945b.setImageResource(R.drawable.facebook_btn_normal);
        } else if ("202".equals(string3)) {
            c1359hl.f4945b.setVisibility(0);
            c1359hl.f4945b.setImageResource(R.drawable.vkontakte_btn_normal);
        } else if ("203".equals(string3)) {
            c1359hl.f4945b.setVisibility(0);
            c1359hl.f4945b.setImageResource(R.drawable.odnoklassniki_btn_normal);
        } else {
            c1359hl.f4945b.setVisibility(8);
        }
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(this.f4942o, viewGroup, false);
        C1359hl c1359hl = new C1359hl(viewInflate);
        c1359hl.f4947d.setOnClickListener(this.f4937j.f4071F);
        viewInflate.setTag(c1359hl);
        return viewInflate;
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: b */
    public Cursor mo877b(Cursor cursor) {
        if (cursor != null) {
            this.f4938k = cursor.getColumnIndexOrThrow("buddy_name");
            this.f4939l = cursor.getColumnIndexOrThrow("buddy_no");
            this.f4940m = cursor.getColumnIndexOrThrow("type");
            this.f4941n = cursor.getColumnIndexOrThrow("timestamp");
        }
        return super.mo877b(cursor);
    }
}
