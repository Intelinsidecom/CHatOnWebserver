package com.sec.chaton.sharedialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: ShareDialogAdapter.java */
/* renamed from: com.sec.chaton.sharedialog.f */
/* loaded from: classes.dex */
public class C3698f extends BaseAdapter {

    /* renamed from: a */
    private final LayoutInflater f13318a;

    /* renamed from: b */
    private ArrayList<C3695c> f13319b;

    C3698f(ArrayList<C3695c> arrayList, Context context) {
        this.f13319b = new ArrayList<>();
        this.f13319b = arrayList;
        this.f13318a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3700h c3700h;
        C3695c c3695c = (C3695c) getItem(i);
        if (view == null) {
            view = this.f13318a.inflate(R.layout.item_share_dialog, viewGroup, false);
            c3700h = new C3700h(this);
            c3700h.f13320a = (ImageView) view.findViewById(R.id.insertMenuIcon);
            c3700h.f13321b = (TextView) view.findViewById(R.id.insertMenuText);
            view.setTag(c3700h);
        } else {
            c3700h = (C3700h) view.getTag();
        }
        try {
            c3700h.f13320a.setBackgroundDrawable(c3695c.m13958a());
        } catch (OutOfMemoryError e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, getClass().getSimpleName());
            }
            c3700h.f13320a.setBackgroundDrawable(null);
        }
        c3700h.f13321b.setText(c3695c.m13960b());
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13319b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13319b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
