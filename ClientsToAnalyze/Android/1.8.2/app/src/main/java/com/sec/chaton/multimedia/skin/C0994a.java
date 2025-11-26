package com.sec.chaton.multimedia.skin;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.common.p056b.p059c.C1821b;

/* compiled from: SkinAdapter.java */
/* renamed from: com.sec.chaton.multimedia.skin.a */
/* loaded from: classes.dex */
public class C0994a extends CursorAdapter {

    /* renamed from: a */
    private C1821b f3684a;

    public C0994a(Context context, Cursor cursor, boolean z, C1821b c1821b) {
        super(context, cursor, z);
        this.f3684a = c1821b;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.item_theme, viewGroup, false);
        C0998b c0998b = new C0998b(this);
        c0998b.f3689a = (TextView) viewInflate.findViewById(R.id.theme_item_ribbon);
        c0998b.f3690b = (ImageView) viewInflate.findViewById(R.id.theme_preview);
        c0998b.f3691c = (ImageView) viewInflate.findViewById(R.id.theme_download_button);
        viewInflate.setTag(c0998b);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C0998b c0998b = (C0998b) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("thumbnail_url"));
        boolean z = cursor.getInt(cursor.getColumnIndex("install")) != 0;
        int i = cursor.getInt(cursor.getColumnIndex("new"));
        int i2 = cursor.getInt(cursor.getColumnIndex("special"));
        this.f3684a.m6190a(c0998b.f3690b, new C1020r(string));
        if (z) {
            c0998b.f3691c.setImageResource(R.drawable.icon_download_complete);
        } else {
            c0998b.f3691c.setImageResource(R.drawable.anicon_package_item_download_event_xml);
        }
        if (i2 != 0) {
            c0998b.f3689a.setVisibility(0);
            c0998b.f3689a.setText(R.string.download_special_ribbon_text);
            c0998b.f3689a.setBackgroundResource(R.drawable.thumb_setting_special);
        } else {
            if (i != 0) {
                c0998b.f3689a.setVisibility(0);
                c0998b.f3689a.setText(R.string.download_new_ribbon_text);
                c0998b.f3689a.setBackgroundResource(R.drawable.thumb_setting_new);
                return;
            }
            c0998b.f3689a.setVisibility(8);
        }
    }
}
