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
public class C1941o extends BaseAdapter {

    /* renamed from: a */
    private LayoutInflater f7450a;

    /* renamed from: b */
    private List<C1929c> f7451b;

    /* renamed from: c */
    private Context f7452c;

    public C1941o(Context context, List<C1929c> list) {
        this.f7452c = context;
        this.f7450a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f7451b = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1942p c1942p;
        if (view == null) {
            View viewInflate = this.f7450a.inflate(R.layout.list_item_common_4, viewGroup, false);
            view = viewInflate;
            c1942p = new C1942p(this, (CheckableRelativeLayout) viewInflate);
        } else {
            c1942p = (C1942p) view.getTag();
        }
        c1942p.f7455c.setChecked(this.f7451b.get(i).f7406f);
        m7890a(c1942p.f7453a, this.f7451b.get(i));
        m7891b(c1942p.f7454b, this.f7451b.get(i));
        view.setTag(c1942p);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7451b.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1929c getItem(int i) {
        return this.f7451b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.f7451b.get(i).f7404d;
    }

    /* renamed from: a */
    private void m7890a(View view, C1929c c1929c) {
        int i = R.string.vcard_phone_type_01;
        if (c1929c.f7404d == 5) {
            switch (c1929c.f7401a) {
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
        if (c1929c.f7404d == 1) {
            ((TextView) view).setText(R.string.vcard_type_email);
        } else if (c1929c.f7404d == 9) {
            ((TextView) view).setText(R.string.vcard_notes_type);
        }
    }

    /* renamed from: b */
    private void m7891b(View view, C1929c c1929c) {
        if (c1929c.f7402b != null) {
            ((TextView) view).setText(c1929c.f7402b);
        }
    }
}
