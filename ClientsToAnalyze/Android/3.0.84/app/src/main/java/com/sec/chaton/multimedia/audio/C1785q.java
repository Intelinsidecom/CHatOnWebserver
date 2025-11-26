package com.sec.chaton.multimedia.audio;

import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.support.v4.widget.SimpleCursorAdapter;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.widget.AdaptableTextView;
import java.util.Date;

/* compiled from: VoiceListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.audio.q */
/* loaded from: classes.dex */
public class C1785q extends SimpleCursorAdapter {

    /* renamed from: b */
    private static final String[] f6613b = {"_data", "_id", "mime_type", "_display_name", "date_modified", "duration"};

    /* renamed from: a */
    View.OnClickListener f6614a;

    /* renamed from: c */
    private Context f6615c;

    /* renamed from: d */
    private LayoutInflater f6616d;

    /* renamed from: e */
    private int f6617e;

    /* renamed from: f */
    private View f6618f;

    /* renamed from: g */
    private String f6619g;

    /* renamed from: h */
    private C1791w f6620h;

    /* renamed from: i */
    private Handler f6621i;

    public C1785q(Context context, int i, Cursor cursor) {
        super(context, i, cursor, f6613b, null, -1);
        this.f6614a = new ViewOnClickListenerC1786r(this);
        this.f6621i = new HandlerC1787s(this);
        this.f6615c = context;
        this.f6616d = (LayoutInflater) this.f6615c.getSystemService("layout_inflater");
        this.f6617e = i;
    }

    @Override // android.support.v4.widget.SimpleCursorAdapter, android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C1788t c1788t = (C1788t) view.getTag();
        c1788t.f6625b.setText(cursor.getString(cursor.getColumnIndex("_display_name")));
        long j = cursor.getLong(cursor.getColumnIndex("date_modified"));
        long j2 = cursor.getLong(cursor.getColumnIndex("duration"));
        Date date = new Date(j * 1000);
        c1788t.f6626c.setText(String.format("%02d:%02d", Long.valueOf(j2 / 60000), Long.valueOf((j2 / 1000) % 60)));
        c1788t.f6627d.setText(DateFormat.getDateFormat(GlobalApplication.m11493l()).format(date));
        String string = this.mCursor.getString(this.mCursor.getColumnIndex("_data"));
        if (string != null && string.equals(this.f6619g)) {
            c1788t.f6624a.setImageResource(R.drawable.chat_attach_btn_pause);
        } else {
            c1788t.f6624a.setImageResource(R.drawable.chat_attach_btn_play);
        }
        c1788t.f6624a.setTag(string);
        c1788t.f6624a.setOnClickListener(this.f6614a);
        view.setTag(c1788t);
    }

    @Override // android.support.v4.widget.ResourceCursorAdapter, android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f6616d.inflate(this.f6617e, viewGroup, false);
        C1788t c1788t = new C1788t();
        c1788t.f6624a = (ImageView) viewInflate.findViewById(R.id.image1);
        c1788t.f6625b = (TextView) viewInflate.findViewById(R.id.text1);
        c1788t.f6625b.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        c1788t.f6627d = (TextView) viewInflate.findViewById(R.id.text2);
        FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.space4);
        frameLayout.setVisibility(0);
        frameLayout.setPadding(0, (int) C3172an.m11085a(2.0f), 0, 0);
        AdaptableTextView adaptableTextView = new AdaptableTextView(this.f6615c);
        adaptableTextView.setGravity(5);
        adaptableTextView.setTextAppearance(this.f6615c, R.style.TextAppearance_List07_Variable);
        frameLayout.addView(adaptableTextView);
        c1788t.f6626c = adaptableTextView;
        c1788t.f6624a.setBackgroundResource(R.drawable.chat_attach_btn_bg);
        c1788t.f6624a.setScaleType(ImageView.ScaleType.CENTER);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c1788t.f6624a.getLayoutParams();
        layoutParams.width = (int) C3172an.m11085a(37.0f);
        layoutParams.height = (int) C3172an.m11085a(38.0f);
        layoutParams.leftMargin = (int) C3172an.m11085a(6.0f);
        c1788t.f6624a.setLayoutParams(layoutParams);
        viewInflate.setTag(c1788t);
        return viewInflate;
    }

    /* renamed from: a */
    public void m7372a() throws IllegalStateException {
        if (this.f6620h != null) {
            this.f6620h.m7382b();
        }
    }
}
