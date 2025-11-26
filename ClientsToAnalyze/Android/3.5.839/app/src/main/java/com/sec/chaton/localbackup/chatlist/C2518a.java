package com.sec.chaton.localbackup.chatlist;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.C0266z;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: BackupChatListAdapter.java */
/* renamed from: com.sec.chaton.localbackup.chatlist.a */
/* loaded from: classes.dex */
public class C2518a extends C0266z {

    /* renamed from: m */
    private static final String[] f9061m = {"_id", "inbox_no", "inbox_chat_type", "inbox_participants", "inbox_title", "inbox_unread_count", "inbox_last_time", "inbox_translated", "inbox_last_message", "inbox_session_id", "inbox_title_fixed"};

    /* renamed from: n */
    private Context f9062n;

    /* renamed from: o */
    private LayoutInflater f9063o;

    /* renamed from: p */
    private int f9064p;

    public C2518a(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f9061m, null, -1);
        this.f9062n = context;
        this.f9063o = (LayoutInflater) this.f9062n.getSystemService("layout_inflater");
        this.f9064p = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x02eb  */
    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo876a(android.view.View r12, android.content.Context r13, android.database.Cursor r14) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 766
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.localbackup.chatlist.C2518a.mo876a(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    /* renamed from: a */
    private String m10894a(long j) {
        if (new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(System.currentTimeMillis())).equals(new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j)))) {
            return DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
    }

    @Override // android.support.v4.widget.AbstractC0259s, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f9063o.inflate(this.f9064p, viewGroup, false);
        C2520c c2520c = new C2520c();
        c2520c.f9066a = (ImageView) viewInflate.findViewById(R.id.image1);
        c2520c.f9067b = (TextView) viewInflate.findViewById(R.id.text1);
        c2520c.f9068c = (TextView) viewInflate.findViewById(R.id.text2);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.space3);
        frameLayout.setVisibility(0);
        LinearLayout linearLayout = new LinearLayout(this.f9062n);
        AdaptableTextView adaptableTextView = new AdaptableTextView(this.f9062n);
        adaptableTextView.setTextAppearance(this.f9062n, R.style.TextAppearance_List01_Variable);
        adaptableTextView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 1.0f));
        c2520c.f9070e = adaptableTextView;
        AdaptableTextView adaptableTextView2 = new AdaptableTextView(this.f9062n);
        adaptableTextView2.setTextAppearance(this.f9062n, R.style.TextAppearance_List07_Variable);
        c2520c.f9069d = adaptableTextView2;
        linearLayout.setOrientation(0);
        linearLayout.addView(adaptableTextView);
        linearLayout.addView(adaptableTextView2);
        frameLayout.addView(linearLayout);
        viewInflate.setTag(c2520c);
        return viewInflate;
    }
}
