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
public class C2904i extends BaseAdapter {

    /* renamed from: a */
    private Context f10753a;

    /* renamed from: b */
    private LayoutInflater f10754b;

    /* renamed from: c */
    private List<C2898c> f10755c;

    /* renamed from: a */
    public static C2904i m12094a(Context context, List<C2898c> list) {
        return new C2904i(context, list);
    }

    private C2904i(Context context, List<C2898c> list) {
        this.f10753a = context;
        this.f10754b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f10755c = list;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2905j c2905j;
        if (view == null) {
            View viewInflate = this.f10754b.inflate(R.layout.list_item_common_4, viewGroup, false);
            view = viewInflate;
            c2905j = new C2905j(this, (CheckableRelativeLayout) viewInflate);
        } else {
            c2905j = (C2905j) view.getTag();
        }
        C2898c c2898c = this.f10755c.get(i);
        m12095a(c2905j.f10756a, c2898c);
        m12096b(c2905j.f10757b, c2898c);
        c2905j.f10758c = c2898c;
        view.setTag(c2905j);
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10755c.size();
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C2898c getItem(int i) {
        return this.f10755c.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.f10755c.get(i).f10725d;
    }

    /* renamed from: a */
    private void m12095a(View view, C2898c c2898c) {
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
            return;
        }
        if (c2898c.f10725d == 9) {
            ((TextView) view).setText(R.string.vcard_notes_type);
        } else if (c2898c.f10724c != null) {
            ((TextView) view).setText(this.f10753a.getString(R.string.vcard_type_other) + c2898c.f10724c);
        } else {
            ((TextView) view).setText(R.string.vcard_type_other);
        }
    }

    /* renamed from: b */
    private void m12096b(View view, C2898c c2898c) {
        if (c2898c.f10723b != null) {
            if (c2898c.f10725d == 5) {
                ((TextView) view).setText(c2898c.f10723b.replace("-", ""));
            } else {
                ((TextView) view).setText(c2898c.f10723b);
            }
        }
    }
}
