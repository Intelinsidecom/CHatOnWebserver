package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.i */
/* loaded from: classes.dex */
public class C1183i extends CursorAdapter {

    /* renamed from: a */
    private Context f4053a;

    public C1183i(Context context, Cursor cursor, int i) {
        super(context, cursor, i);
        this.f4053a = context;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws NumberFormatException {
        String str;
        C1108af c1108af = (C1108af) view.getTag();
        TextView textView = c1108af.f3899a;
        ProfileImageView profileImageView = c1108af.f3900b;
        TextView textView2 = c1108af.f3901c;
        TextView textView3 = c1108af.f3902d;
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("registration_time")));
        String string = cursor.getString(cursor.getColumnIndex("writer_uid"));
        String string2 = cursor.getString(cursor.getColumnIndex("writer_name"));
        c1108af.f3903e = string;
        c1108af.f3904f = string2;
        if ("ME".equals(string)) {
            textView.setText(R.string.setting_interaction_me);
            C1348w.m4685a(this.f4053a).m4699a(profileImageView, C1323bs.m4575a().getString("msisdn", ""));
        } else {
            textView.setText(string2);
            try {
                Long.parseLong(string);
                str = string;
            } catch (Exception e) {
                str = "5";
            }
            C1348w.m4685a(this.f4053a).m4699a(profileImageView, str);
        }
        textView3.setText(cursor.getString(cursor.getColumnIndex("content")));
        textView2.setText(m4256a(lValueOf.longValue()));
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_trunk_detail_comment, viewGroup, false);
        C1108af c1108af = new C1108af(this, null);
        c1108af.f3899a = (TextView) viewInflate.findViewById(R.id.commentWriterName);
        c1108af.f3900b = (ProfileImageView) viewInflate.findViewById(R.id.commentBuddyProfile);
        c1108af.f3901c = (TextView) viewInflate.findViewById(R.id.commentRegistrationTime);
        c1108af.f3902d = (TextView) viewInflate.findViewById(R.id.commentBuddyContent);
        c1108af.f3900b.setOnClickListener(new ViewOnClickListenerC1195u(this, c1108af));
        viewInflate.setTag(c1108af);
        return viewInflate;
    }

    /* renamed from: a */
    private String m4256a(long j) {
        String[] strArrSplit;
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (DateFormat.is24HourFormat(this.f4053a)) {
            strArrSplit = new SimpleDateFormat("MMM dd/HH:mm", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        } else {
            strArrSplit = new SimpleDateFormat("MMM dd/h:mm aa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        }
        if (str3.equals(str)) {
            return strArrSplit[1];
        }
        if (str2.equals(str4)) {
            return strArrSplit[0];
        }
        return new SimpleDateFormat("MMM d,yyyy", Locale.ENGLISH).format(Long.valueOf(j));
    }
}
