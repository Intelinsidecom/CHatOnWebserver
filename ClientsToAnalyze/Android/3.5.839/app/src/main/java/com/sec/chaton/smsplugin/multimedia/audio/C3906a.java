package com.sec.chaton.smsplugin.multimedia.audio;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.widget.C0266z;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.audio.C2743s;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5034k;
import java.util.Date;

/* compiled from: MmsVoiceListAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.audio.a */
/* loaded from: classes.dex */
public class C3906a extends C0266z {

    /* renamed from: n */
    private static final String[] f14035n = {"_data", "_id", "mime_type", "_display_name", "date_modified", "duration"};

    /* renamed from: m */
    View.OnClickListener f14036m;

    /* renamed from: o */
    private Context f14037o;

    /* renamed from: p */
    private LayoutInflater f14038p;

    /* renamed from: q */
    private int f14039q;

    /* renamed from: r */
    private View f14040r;

    /* renamed from: s */
    private String f14041s;

    /* renamed from: t */
    private C2743s f14042t;

    /* renamed from: u */
    private Handler f14043u;

    public C3906a(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f14035n, null, -1);
        this.f14036m = new ViewOnClickListenerC3907b(this);
        this.f14043u = new HandlerC3908c(this);
        this.f14037o = context;
        this.f14038p = (LayoutInflater) this.f14037o.getSystemService("layout_inflater");
        this.f14039q = i;
    }

    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        C3909d c3909d = (C3909d) view.getTag();
        c3909d.f14047b.setText(cursor.getString(cursor.getColumnIndex("_display_name")));
        long j = cursor.getLong(cursor.getColumnIndex("date_modified"));
        long j2 = cursor.getLong(cursor.getColumnIndex("duration"));
        Date date = new Date(j * 1000);
        c3909d.f14048c.setText(String.format("%02d:%02d", Long.valueOf(j2 / 60000), Long.valueOf((j2 / 1000) % 60)));
        c3909d.f14049d.setText(DateFormat.getDateFormat(CommonApplication.m18732r()).format(date));
        String string = this.f579c.getString(this.f579c.getColumnIndex("_data"));
        if (string != null && string.equals(this.f14041s)) {
            c3909d.f14046a.setImageResource(R.drawable.chat_attach_btn_pause);
        } else {
            c3909d.f14046a.setImageResource(R.drawable.chat_attach_btn_play);
        }
        c3909d.f14046a.setTag(string);
        c3909d.f14046a.setOnClickListener(this.f14036m);
        view.setTag(c3909d);
    }

    @Override // android.support.v4.widget.AbstractC0259s, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f14038p.inflate(this.f14039q, viewGroup, false);
        C3909d c3909d = new C3909d();
        c3909d.f14046a = (ImageView) viewInflate.findViewById(R.id.image1);
        c3909d.f14047b = (TextView) viewInflate.findViewById(R.id.text1);
        c3909d.f14047b.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        c3909d.f14049d = (TextView) viewInflate.findViewById(R.id.text2);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.space4);
        frameLayout.setVisibility(0);
        frameLayout.setPadding(0, (int) C5034k.m19088a(2.0f), 0, 0);
        AdaptableTextView adaptableTextView = new AdaptableTextView(this.f14037o);
        adaptableTextView.setGravity(5);
        adaptableTextView.setTextAppearance(this.f14037o, R.style.TextAppearance_List07_Variable);
        frameLayout.addView(adaptableTextView);
        c3909d.f14048c = adaptableTextView;
        c3909d.f14046a.setBackgroundResource(R.drawable.chat_attach_btn_bg);
        c3909d.f14046a.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c3909d.f14046a.getLayoutParams();
        layoutParams.width = (int) C5034k.m19088a(37.0f);
        layoutParams.height = (int) C5034k.m19088a(38.0f);
        layoutParams.leftMargin = (int) C5034k.m19088a(6.0f);
        c3909d.f14046a.setLayoutParams(layoutParams);
        viewInflate.setTag(c3909d);
        return viewInflate;
    }

    /* renamed from: c */
    public void m15095c() throws IllegalStateException {
        if (this.f14042t != null) {
            this.f14042t.m11509b();
        }
    }
}
