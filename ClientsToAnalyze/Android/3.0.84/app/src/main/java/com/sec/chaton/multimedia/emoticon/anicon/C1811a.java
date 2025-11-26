package com.sec.chaton.multimedia.emoticon.anicon;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.chaton.settings.downloads.EnumC2651z;
import com.sec.common.p069e.C3326c;
import com.sec.common.util.C3347i;

/* compiled from: AniconAdapter.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.a */
/* loaded from: classes.dex */
public class C1811a extends CursorAdapter {

    /* renamed from: a */
    private int f6777a;

    /* renamed from: b */
    private C3326c f6778b;

    /* renamed from: c */
    private LayoutInflater f6779c;

    /* renamed from: d */
    private EnumC2651z f6780d;

    public C1811a(Context context, Cursor cursor, int i, C3326c c3326c) {
        super(context, cursor, i);
        m7475a(c3326c);
    }

    /* renamed from: a */
    private void m7475a(C3326c c3326c) {
        Resources resources = this.mContext.getResources();
        this.f6778b = c3326c;
        this.f6777a = resources.getDimensionPixelOffset(R.dimen.anicon_gridview_item_height);
        this.f6779c = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewInflate = this.f6779c.inflate(R.layout.layout_anicon_container_item, viewGroup, false);
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, this.f6777a);
        C1812b c1812b = new C1812b();
        c1812b.f6781a = (ImageView) viewInflate.findViewById(R.id.anicon_image);
        c1812b.f6782b = (ImageView) viewInflate.findViewById(R.id.anicon_icon);
        viewInflate.setLayoutParams(layoutParams);
        viewInflate.setTag(c1812b);
        return viewInflate;
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        C1812b c1812b = (C1812b) view.getTag();
        String string = cursor.getString(cursor.getColumnIndex("anicon_id"));
        c1812b.f6783c = string;
        if (this.f6780d == null) {
            this.f6780d = C2646u.m9673i(this.mContext, string);
        }
        if (this.f6780d == EnumC2651z.NORMAL) {
            c1812b.f6782b.setVisibility(8);
        } else {
            if (this.f6780d == EnumC2651z.SOUND) {
                c1812b.f6782b.setImageResource(R.drawable.chat_haptic_sound_nor);
            } else if (this.f6780d == EnumC2651z.HAPTIC_SOUND) {
                c1812b.f6782b.setImageResource(R.drawable.chat_haptic_sound_vi2_nor);
            } else {
                c1812b.f6782b.setImageResource(R.drawable.chat_haptic_vibration_nor);
            }
            c1812b.f6782b.setVisibility(0);
            c1812b.f6782b.setTag(c1812b);
        }
        if (string.equals(String.valueOf(Integer.MIN_VALUE))) {
            this.f6778b.m11732a(c1812b.f6781a);
            ((ImageView) view).setImageResource(R.drawable.chat_anicon_btn_down);
            view.setTag(string);
        } else {
            CallableC1826p callableC1826p = new CallableC1826p(string, C3347i.m11782e(), C3347i.m11783f());
            callableC1826p.m11708a((View) c1812b.f6781a);
            this.f6778b.m11730a(c1812b.f6781a, callableC1826p);
        }
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        this.f6780d = null;
        super.notifyDataSetInvalidated();
    }
}
