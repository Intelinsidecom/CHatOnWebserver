package com.sec.chaton.multimedia.vcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.List;

/* compiled from: VCardReadContactAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.o */
/* loaded from: classes.dex */
public class C2910o extends BaseAdapter {

    /* renamed from: a */
    private LayoutInflater f10771a;

    /* renamed from: b */
    private List<C2898c> f10772b;

    /* renamed from: c */
    private Context f10773c;

    /* renamed from: a */
    public static C2910o m12118a(Context context, List<C2898c> list) {
        return new C2910o(context, list);
    }

    private C2910o(Context context, List<C2898c> list) {
        this.f10773c = context;
        this.f10771a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f10772b = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2911p c2911p;
        if (view == null) {
            View viewInflate = this.f10771a.inflate(R.layout.list_item_common_4, viewGroup, false);
            view = viewInflate;
            c2911p = new C2911p(this, (CheckableRelativeLayout) viewInflate);
        } else {
            c2911p = (C2911p) view.getTag();
        }
        c2911p.f10776c.setChecked(this.f10772b.get(i).f10727f);
        m12119a(c2911p.f10774a, this.f10772b.get(i));
        m12120b(c2911p.f10775b, this.f10772b.get(i));
        view.setTag(c2911p);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10772b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C2898c getItem(int i) {
        return this.f10772b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.f10772b.get(i).f10725d;
    }

    /* renamed from: a */
    private void m12119a(View view, C2898c c2898c) {
        int i = R.string.vcard_phone_type_01;
        if (c2898c.f10725d == 5) {
            switch (c2898c.f10722a) {
                case 2:
                    i = R.string.vcard_phone_type_02;
                    break;
                case 3:
                    i = R.string.vcard_phone_type_03;
                    break;
                case 4:
                    i = R.string.vcard_phone_type_04;
                    break;
            }
            ((TextView) view).setText(i);
            return;
        }
        if (c2898c.f10725d == 1) {
            ((TextView) view).setText(R.string.vcard_type_email);
        } else if (c2898c.f10725d == 9) {
            ((TextView) view).setText(R.string.vcard_notes_type);
        }
    }

    /* renamed from: b */
    private void m12120b(View view, C2898c c2898c) {
        if (c2898c.f10723b != null) {
            ((TextView) view).setText(c2898c.f10723b);
        }
    }
}
