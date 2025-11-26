package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.AbstractC0243c;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4822an;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.b */
/* loaded from: classes.dex */
public class C4602b extends AbstractC0243c {

    /* renamed from: j */
    private Context f16732j;

    /* renamed from: k */
    private TrunkItemView f16733k;

    public C4602b(Context context, Cursor cursor, int i, TrunkItemView trunkItemView) {
        super(context, cursor, i);
        this.f16733k = trunkItemView;
        this.f16732j = context;
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        C4662d c4662d = (C4662d) view.getTag();
        TextView textView = c4662d.f16881a;
        ImageView imageView = c4662d.f16882b;
        TextView textView2 = c4662d.f16883c;
        TextView textView3 = c4662d.f16884d;
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("registration_time")));
        String string = cursor.getString(cursor.getColumnIndex("writer_uid"));
        String string2 = cursor.getString(cursor.getColumnIndex("writer_name"));
        c4662d.f16885e = string;
        c4662d.f16886f = string2;
        if ("ME".equals(string)) {
            textView.setText(this.f16732j.getString(R.string.setting_interaction_me));
            C2496n.m10763a(imageView, EnumC2498p.ROUND);
        } else {
            textView.setText(string2);
            if (string != null) {
                C2496n.m10765a(imageView, string, EnumC2498p.ROUND);
            } else {
                imageView.setImageResource(R.drawable.profile_photo_buddy_default);
            }
        }
        if (C4822an.m18218a()) {
            imageView.setBackgroundResource(R.drawable.circle_background);
        }
        textView3.setText(cursor.getString(cursor.getColumnIndex("content")));
        textView2.setText(m17552a(lValueOf.longValue()));
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.list_item_common_10, viewGroup, false);
        C4662d c4662d = new C4662d(null);
        c4662d.f16881a = (TextView) viewInflate.findViewById(R.id.text1);
        c4662d.f16882b = (ImageView) viewInflate.findViewById(R.id.image1);
        c4662d.f16883c = (TextView) viewInflate.findViewById(R.id.text3);
        c4662d.f16884d = (TextView) viewInflate.findViewById(R.id.text2);
        c4662d.f16882b.setOnClickListener(new ViewOnClickListenerC4635c(this, c4662d));
        viewInflate.setTag(c4662d);
        return viewInflate;
    }

    /* renamed from: a */
    private String m17552a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            return DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j));
        }
        if (str2.equals(str4)) {
            return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
    }
}
