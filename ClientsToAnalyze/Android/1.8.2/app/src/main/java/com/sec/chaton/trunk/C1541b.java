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
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p017e.C0688c;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1789u;
import com.sec.chaton.widget.ProfileImageView;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.b */
/* loaded from: classes.dex */
public class C1541b extends CursorAdapter {

    /* renamed from: a */
    private Context f5596a;

    public C1541b(Context context, Cursor cursor, int i) {
        super(context, cursor, i);
        this.f5596a = context;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) throws NumberFormatException {
        String string;
        String string2;
        String str;
        C1576d c1576d = (C1576d) view.getTag();
        TextView textView = c1576d.f5676a;
        ProfileImageView profileImageView = c1576d.f5677b;
        TextView textView2 = c1576d.f5678c;
        TextView textView3 = c1576d.f5679d;
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("registration_time")));
        String string3 = cursor.getString(cursor.getColumnIndex("writer_uid"));
        Cursor cursorQuery = GlobalApplication.m3260b().getContentResolver().query(C0688c.f2606a, null, "buddy_no=?", new String[]{string3}, null);
        if (cursorQuery != null) {
            if (!cursorQuery.moveToFirst()) {
                string = null;
            } else {
                string = cursorQuery.getString(cursorQuery.getColumnIndex("buddy_name"));
            }
            cursorQuery.close();
        } else {
            string = cursor.getString(cursor.getColumnIndex("writer_name"));
        }
        if (string != null) {
            string2 = string.trim();
        } else {
            string2 = cursor.getString(cursor.getColumnIndex("writer_name"));
        }
        c1576d.f5680e = string3;
        c1576d.f5681f = string2;
        if ("ME".equals(string3)) {
            if (!GlobalApplication.m3265f()) {
                view.setBackgroundResource(R.drawable.trunk_my_comment_background);
            }
            textView.setText(R.string.setting_interaction_me);
            C1746bb.m5945a(this.f5596a).m5959a(profileImageView, C1789u.m6075a().getString("msisdn", ""));
        } else {
            if (!GlobalApplication.m3265f()) {
                view.setBackgroundResource(R.drawable.trunk_comment_background);
            }
            textView.setText(string2);
            try {
                Long.parseLong(string3);
                str = string3;
            } catch (Exception e) {
                str = "5";
            }
            C1746bb.m5945a(this.f5596a).m5959a(profileImageView, str);
        }
        textView3.setText(cursor.getString(cursor.getColumnIndex("content")));
        textView2.setText(m5394a(lValueOf.longValue()));
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_trunkcontent, viewGroup, false);
        C1576d c1576d = new C1576d(this, null);
        c1576d.f5676a = (TextView) viewInflate.findViewById(R.id.commentWriterName);
        c1576d.f5677b = (ProfileImageView) viewInflate.findViewById(R.id.commentBuddyProfile);
        c1576d.f5678c = (TextView) viewInflate.findViewById(R.id.commentRegistrationTime);
        c1576d.f5679d = (TextView) viewInflate.findViewById(R.id.commentBuddyContent);
        c1576d.f5677b.setOnClickListener(new ViewOnClickListenerC1568c(this, c1576d));
        viewInflate.setTag(c1576d);
        return viewInflate;
    }

    /* renamed from: a */
    private String m5394a(long j) {
        String[] strArrSplit;
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (DateFormat.is24HourFormat(this.f5596a)) {
            strArrSplit = new SimpleDateFormat("dd MMM/HH:mm", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        } else {
            strArrSplit = new SimpleDateFormat("dd MMM/h:mm aa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        }
        if (str3.equals(str)) {
            return strArrSplit[1];
        }
        if (str2.equals(str4)) {
            return strArrSplit[0];
        }
        return new SimpleDateFormat("d MMM,yyyy", Locale.ENGLISH).format(Long.valueOf(j));
    }
}
