package com.sec.chaton.trunk;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: ContentAdapter.java */
/* renamed from: com.sec.chaton.trunk.b */
/* loaded from: classes.dex */
public class C2986b extends CursorAdapter {

    /* renamed from: a */
    private Context f10811a;

    /* renamed from: b */
    private TrunkItemView f10812b;

    public C2986b(Context context, Cursor cursor, int i, TrunkItemView trunkItemView) {
        super(context, cursor, i);
        this.f10812b = trunkItemView;
        this.f10811a = context;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C3042d c3042d = (C3042d) view.getTag();
        TextView textView = c3042d.f10931b;
        ImageView imageView = c3042d.f10932c;
        TextView textView2 = c3042d.f10933d;
        TextView textView3 = c3042d.f10934e;
        Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("registration_time")));
        String string = cursor.getString(cursor.getColumnIndex("writer_uid"));
        String string2 = cursor.getString(cursor.getColumnIndex("writer_name"));
        c3042d.f10935f = string;
        c3042d.f10936g = string2;
        if ("ME".equals(string)) {
            textView.setText(this.f10811a.getString(R.string.setting_interaction_me));
            C3205bt.m11182a(this.f10811a).m11210a(imageView, C3159aa.m10962a().m10979a("chaton_id", ""));
        } else {
            textView.setText(string2);
            if (string != null) {
                C3205bt.m11182a(this.f10811a).m11210a(imageView, string);
            } else {
                imageView.setImageResource(R.drawable.contacts_default_01);
            }
        }
        textView3.setText(cursor.getString(cursor.getColumnIndex("content")));
        textView2.setText(m10481a(lValueOf.longValue()));
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.list_item_common_10, viewGroup, false);
        C3042d c3042d = new C3042d(this, null);
        c3042d.f10930a = (FrameLayout) viewInflate.findViewById(R.id.trunk_comment_list);
        c3042d.f10931b = (TextView) viewInflate.findViewById(R.id.text1);
        c3042d.f10932c = (ImageView) viewInflate.findViewById(R.id.image1);
        c3042d.f10933d = (TextView) viewInflate.findViewById(R.id.text3);
        c3042d.f10934e = (TextView) viewInflate.findViewById(R.id.text2);
        c3042d.f10932c.setOnClickListener(new ViewOnClickListenerC3019c(this, c3042d));
        viewInflate.setTag(c3042d);
        return viewInflate;
    }

    /* renamed from: a */
    private String m10481a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            return DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        if (str2.equals(str4)) {
            return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
    }
}
