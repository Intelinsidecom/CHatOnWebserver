package com.sec.chaton.multimedia.doc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.chaton.R;
import java.util.ArrayList;

/* compiled from: FileListAdapter.java */
/* renamed from: com.sec.chaton.multimedia.doc.d */
/* loaded from: classes.dex */
public class C0907d extends BaseAdapter {

    /* renamed from: e */
    private static final int[] f3336e = {R.drawable.list_folder, R.drawable.list_pdf, R.drawable.list_hunminjeongeum, R.drawable.list_hangul, R.drawable.list_powerpoint, R.drawable.list_word, R.drawable.list_excel};

    /* renamed from: a */
    private Context f3337a;

    /* renamed from: b */
    private LayoutInflater f3338b;

    /* renamed from: c */
    private int f3339c;

    /* renamed from: d */
    private ArrayList f3340d;

    public C0907d(Context context, int i, ArrayList arrayList) {
        this.f3337a = context;
        this.f3338b = (LayoutInflater) this.f3337a.getSystemService("layout_inflater");
        this.f3340d = arrayList;
        this.f3339c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3340d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3340d.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0908e c0908e;
        if (view == null) {
            view = this.f3338b.inflate(this.f3339c, viewGroup, false);
            C0908e c0908e2 = new C0908e(view);
            view.setTag(c0908e2);
            c0908e = c0908e2;
        } else {
            c0908e = (C0908e) view.getTag();
        }
        c0908e.f3341a.setImageResource(f3336e[((C0906c) this.f3340d.get(i)).m3640a().m3639a()]);
        c0908e.f3342b.setText(((C0906c) this.f3340d.get(i)).m3644b());
        c0908e.f3343c.setText(((C0906c) this.f3340d.get(i)).m3648d() + "  " + ((C0906c) this.f3340d.get(i)).m3647c());
        if (((C0906c) this.f3340d.get(i)).m3640a() == EnumC0905b.DIRECTORY) {
            c0908e.f3343c.setVisibility(8);
        } else {
            c0908e.f3343c.setVisibility(0);
        }
        return view;
    }
}
