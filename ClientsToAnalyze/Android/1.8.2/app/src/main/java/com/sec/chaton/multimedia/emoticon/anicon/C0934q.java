package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.p056b.p059c.C1821b;
import com.sec.common.p056b.p060d.C1828c;

/* compiled from: AniconPackageListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.q */
/* loaded from: classes.dex */
public class C0934q extends CursorAdapter {

    /* renamed from: a */
    private static final String f3485a = C0934q.class.getSimpleName();

    /* renamed from: b */
    private int f3486b;

    /* renamed from: c */
    private int f3487c;

    /* renamed from: d */
    private C1821b f3488d;

    /* renamed from: e */
    private InterfaceC0938u f3489e;

    /* renamed from: f */
    private View.OnClickListener f3490f;

    /* renamed from: g */
    private View.OnClickListener f3491g;

    public C0934q(Context context, Cursor cursor, boolean z, C1821b c1821b) {
        super(context, cursor, z);
        this.f3490f = new ViewOnClickListenerC0935r(this);
        this.f3491g = new ViewOnClickListenerC0936s(this);
        this.f3486b = context.getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_width);
        this.f3487c = context.getResources().getDimensionPixelOffset(R.dimen.anicon_download_thumbnail_height);
        this.f3488d = c1821b;
    }

    /* renamed from: a */
    public void m3803a(InterfaceC0938u interfaceC0938u) {
        this.f3489e = interfaceC0938u;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.item_list_anicon_package, viewGroup, false);
        C0937t c0937t = new C0937t(this, null);
        c0937t.f3495b = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_thumbnail);
        c0937t.f3496c = (TextView) viewInflate.findViewById(R.id.anicon_package_item_name);
        c0937t.f3497d = (TextView) viewInflate.findViewById(R.id.anicon_package_item_volume);
        c0937t.f3498e = (ImageView) viewInflate.findViewById(R.id.anicon_package_item_download);
        c0937t.f3499f = (TextView) viewInflate.findViewById(R.id.anicon_download_information);
        c0937t.f3500g = (TextView) viewInflate.findViewById(R.id.anicon_package_item_ribbon);
        viewInflate.setOnClickListener(this.f3490f);
        c0937t.f3498e.setOnClickListener(this.f3491g);
        viewInflate.setTag(c0937t);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C0937t c0937t = (C0937t) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("package_id"));
        String string2 = cursor.getString(cursor.getColumnIndex("name"));
        String string3 = cursor.getString(cursor.getColumnIndex("thumbnail_url"));
        String string4 = cursor.getString(cursor.getColumnIndex("anicon_count"));
        int i = cursor.getInt(cursor.getColumnIndex("volume"));
        int i2 = cursor.getInt(cursor.getColumnIndex("install"));
        long j = cursor.getLong(cursor.getColumnIndex("expiration_time"));
        int i3 = cursor.getInt(cursor.getColumnIndex("new"));
        int i4 = cursor.getInt(cursor.getColumnIndex("special"));
        String dateTime = null;
        if (i2 != 0 && j != 0) {
            dateTime = DateUtils.formatDateTime(context, j, 8212);
        }
        c0937t.f3494a = string;
        c0937t.f3496c.setText(string2);
        if (dateTime == null) {
            c0937t.f3497d.setText(C1828c.m6207a(string4, " (", Integer.valueOf(i / 1000), "KB)"));
        } else {
            c0937t.f3497d.setText(C1828c.m6207a(string4, " (", Integer.valueOf(i / 1000), "KB)", " / ", dateTime));
        }
        if (i2 == 0) {
            c0937t.f3498e.setVisibility(0);
            c0937t.f3499f.setVisibility(8);
        } else {
            c0937t.f3498e.setVisibility(8);
            c0937t.f3499f.setVisibility(0);
        }
        if (i4 != 0) {
            c0937t.f3500g.setVisibility(0);
            c0937t.f3500g.setText(R.string.download_special_ribbon_text);
            c0937t.f3500g.setBackgroundResource(R.drawable.thumbnail_special_bg);
        } else if (i3 != 0) {
            c0937t.f3500g.setVisibility(0);
            c0937t.f3500g.setText(R.string.download_new_ribbon_text);
            c0937t.f3500g.setBackgroundResource(R.drawable.thumbnail_new_bg);
        } else {
            c0937t.f3500g.setVisibility(8);
        }
        c0937t.f3498e.setTag(string);
        this.f3488d.m6190a(c0937t.f3495b, new CallableC0917ab(string3, this.f3486b, this.f3487c));
    }
}
