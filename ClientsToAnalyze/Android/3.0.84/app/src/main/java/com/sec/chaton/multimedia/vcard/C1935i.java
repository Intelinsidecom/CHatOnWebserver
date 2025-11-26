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

/* compiled from: ReadVCardAdapter.java */
/* renamed from: com.sec.chaton.multimedia.vcard.i */
/* loaded from: classes.dex */
public class C1935i extends BaseAdapter {

    /* renamed from: a */
    private Context f7432a;

    /* renamed from: b */
    private LayoutInflater f7433b;

    /* renamed from: c */
    private List<C1929c> f7434c;

    public C1935i(Context context, List<C1929c> list) {
        this.f7432a = context;
        this.f7433b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f7434c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1936j c1936j;
        if (view == null) {
            View viewInflate = this.f7433b.inflate(R.layout.list_item_common_4, viewGroup, false);
            view = viewInflate;
            c1936j = new C1936j(this, (CheckableRelativeLayout) viewInflate);
        } else {
            c1936j = (C1936j) view.getTag();
        }
        C1929c c1929c = this.f7434c.get(i);
        m7867a(c1936j.f7435a, c1929c);
        m7868b(c1936j.f7436b, c1929c);
        c1936j.f7437c = c1929c;
        view.setTag(c1936j);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7434c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C1929c getItem(int i) {
        return this.f7434c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.f7434c.get(i).f7404d;
    }

    /* renamed from: a */
    private void m7867a(View view, C1929c c1929c) {
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
            return;
        }
        if (c1929c.f7404d == 9) {
            ((TextView) view).setText(R.string.vcard_notes_type);
        } else if (c1929c.f7403c != null) {
            ((TextView) view).setText(this.f7432a.getString(R.string.vcard_type_other) + c1929c.f7403c);
        } else {
            ((TextView) view).setText(R.string.vcard_type_other);
        }
    }

    /* renamed from: b */
    private void m7868b(View view, C1929c c1929c) {
        if (c1929c.f7402b != null) {
            if (c1929c.f7404d == 5) {
                ((TextView) view).setText(c1929c.f7402b.replace("-", ""));
            } else {
                ((TextView) view).setText(c1929c.f7402b);
            }
        }
    }
}
