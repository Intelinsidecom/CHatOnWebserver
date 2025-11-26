package com.sec.chaton.multimedia.audio;

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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.widget.AdaptableTextView;
import com.sec.common.util.C5034k;
import java.util.Date;

/* compiled from: VoiceListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.audio.m */
/* loaded from: classes.dex */
public class C2737m extends C0266z {

    /* renamed from: n */
    private static final String[] f9821n = {"_data", "_id", "mime_type", "_display_name", "date_modified", "duration"};

    /* renamed from: m */
    View.OnClickListener f9822m;

    /* renamed from: o */
    private Context f9823o;

    /* renamed from: p */
    private LayoutInflater f9824p;

    /* renamed from: q */
    private int f9825q;

    /* renamed from: r */
    private View f9826r;

    /* renamed from: s */
    private String f9827s;

    /* renamed from: t */
    private C2743s f9828t;

    /* renamed from: u */
    private Handler f9829u;

    public C2737m(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f9821n, null, -1);
        this.f9822m = new ViewOnClickListenerC2738n(this);
        this.f9829u = new HandlerC2739o(this);
        this.f9823o = context;
        this.f9824p = (LayoutInflater) this.f9823o.getSystemService("layout_inflater");
        this.f9825q = i;
    }

    @Override // android.support.v4.widget.C0266z, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        C2740p c2740p = (C2740p) view.getTag();
        c2740p.f9833b.setText(cursor.getString(cursor.getColumnIndex("_display_name")));
        long j = cursor.getLong(cursor.getColumnIndex("date_modified"));
        long j2 = cursor.getLong(cursor.getColumnIndex("duration"));
        Date date = new Date(j * 1000);
        c2740p.f9834c.setText(String.format("%02d:%02d", Long.valueOf(j2 / 60000), Long.valueOf((j2 / 1000) % 60)));
        c2740p.f9835d.setText(DateFormat.getDateFormat(GlobalApplication.m18732r()).format(date));
        String string = this.f579c.getString(this.f579c.getColumnIndex("_data"));
        c2740p.f9832a.setContentDescription(this.f9823o.getString(R.string.ams_play));
        if (string != null && string.equals(this.f9827s)) {
            c2740p.f9832a.setImageResource(R.drawable.chat_attach_btn_pause);
        } else {
            c2740p.f9832a.setImageResource(R.drawable.chat_attach_btn_play);
        }
        c2740p.f9832a.setTag(string);
        c2740p.f9832a.setOnClickListener(this.f9822m);
        view.setTag(c2740p);
    }

    @Override // android.support.v4.widget.AbstractC0259s, android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f9824p.inflate(this.f9825q, viewGroup, false);
        C2740p c2740p = new C2740p();
        c2740p.f9832a = (ImageView) viewInflate.findViewById(R.id.image1);
        c2740p.f9833b = (TextView) viewInflate.findViewById(R.id.text1);
        c2740p.f9833b.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        c2740p.f9835d = (TextView) viewInflate.findViewById(R.id.text2);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.space4);
        frameLayout.setVisibility(0);
        frameLayout.setPadding(0, (int) C5034k.m19088a(2.0f), 0, 0);
        AdaptableTextView adaptableTextView = new AdaptableTextView(this.f9823o);
        adaptableTextView.setGravity(5);
        adaptableTextView.setTextAppearance(this.f9823o, R.style.TextAppearance_List07_Variable);
        frameLayout.addView(adaptableTextView);
        c2740p.f9834c = adaptableTextView;
        c2740p.f9832a.setBackgroundResource(R.drawable.chat_attach_btn_bg);
        c2740p.f9832a.setScaleType(ImageView.ScaleType.CENTER);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c2740p.f9832a.getLayoutParams();
        layoutParams.width = (int) C5034k.m19088a(37.0f);
        layoutParams.height = (int) C5034k.m19088a(38.0f);
        layoutParams.leftMargin = (int) C5034k.m19088a(6.0f);
        c2740p.f9832a.setLayoutParams(layoutParams);
        viewInflate.setTag(c2740p);
        return viewInflate;
    }

    /* renamed from: c */
    public void m11496c() throws IllegalStateException {
        if (this.f9828t != null) {
            this.f9828t.m11509b();
        }
    }
}
