package com.sec.chaton.block;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.R;
import com.sec.chaton.p025d.C1328f;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.ArrayList;

/* compiled from: BlockListBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.s */
/* loaded from: classes.dex */
class C0493s extends ArrayAdapter<C0475ac> {

    /* renamed from: a */
    ArrayList<C0475ac> f1620a;

    /* renamed from: b */
    ArrayList<C0475ac> f1621b;

    /* renamed from: c */
    public boolean[] f1622c;

    /* renamed from: d */
    public Handler f1623d;

    /* renamed from: e */
    private Context f1624e;

    /* renamed from: f */
    private C1328f f1625f;

    /* renamed from: g */
    private LayoutInflater f1626g;

    /* renamed from: h */
    private ProgressDialog f1627h;

    /* renamed from: i */
    private ViewGroup f1628i;

    /* renamed from: j */
    private InterfaceC0495u f1629j;

    /* renamed from: a */
    public void m3157a(InterfaceC0495u interfaceC0495u) {
        this.f1629j = interfaceC0495u;
    }

    public C0493s(Context context, int i, ArrayList<C0475ac> arrayList) {
        super(context, 0, arrayList);
        this.f1623d = new HandlerC0494t(this);
        this.f1624e = context;
        this.f1620a = arrayList;
        this.f1621b = new ArrayList<>();
        this.f1622c = new boolean[this.f1620a.size()];
        this.f1626g = (LayoutInflater) this.f1624e.getSystemService("layout_inflater");
        this.f1628i = (ViewGroup) this.f1626g.inflate(i, (ViewGroup) null);
        this.f1627h = (ProgressDialog) new C3263j(this.f1624e).m11487a(R.string.dialog_userprofile_updating);
    }

    /* renamed from: a */
    public void m3156a() {
        this.f1625f = new C1328f(this.f1623d);
        this.f1625f.m5707a(this.f1621b);
        this.f1627h.show();
    }

    /* renamed from: a */
    public void m3158a(boolean z) {
        int length = this.f1622c.length;
        for (int i = 0; i < length; i++) {
            this.f1622c[i] = z;
        }
        if (z) {
            this.f1621b.clear();
            this.f1621b.addAll(this.f1620a);
        } else {
            this.f1621b.clear();
        }
        notifyDataSetChanged();
    }

    /* renamed from: b */
    public void m3159b() {
        String str = "";
        int i = 0;
        while (i < this.f1621b.size()) {
            String str2 = str + this.f1621b.get(i).f1585b + ", ";
            i++;
            str = str2;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0496v c0496v;
        if (view == null) {
            View viewInflate = this.f1626g.inflate(R.layout.list_item_common_6, (ViewGroup) null);
            C0496v c0496v2 = new C0496v((CheckableRelativeLayout) viewInflate);
            viewInflate.setTag(c0496v2);
            view = viewInflate;
            c0496v = c0496v2;
        } else {
            c0496v = (C0496v) view.getTag();
        }
        c0496v.f1634d.setChecked(this.f1622c[i]);
        C0475ac item = getItem(i);
        c0496v.f1631a.setText(item.f1585b);
        C3205bt.m11182a(this.f1624e).m11210a(c0496v.f1633c, item.f1584a);
        return view;
    }
}
