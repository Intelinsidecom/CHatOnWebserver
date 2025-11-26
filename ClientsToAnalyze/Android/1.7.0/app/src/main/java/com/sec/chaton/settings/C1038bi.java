package com.sec.chaton.settings;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.p025d.p026a.C0630j;
import com.sec.chaton.p025d.p026a.InterfaceC0626f;
import com.sec.chaton.util.C1348w;
import java.util.ArrayList;

/* compiled from: RelationHideAdapter.java */
/* renamed from: com.sec.chaton.settings.bi */
/* loaded from: classes.dex */
class C1038bi extends ArrayAdapter {

    /* renamed from: a */
    ArrayList f3642a;

    /* renamed from: b */
    InterfaceC1072d f3643b;

    /* renamed from: c */
    private Context f3644c;

    /* renamed from: d */
    private int f3645d;

    /* renamed from: e */
    private String f3646e;

    /* renamed from: f */
    private String f3647f;

    /* renamed from: g */
    private LayoutInflater f3648g;

    /* renamed from: h */
    private C0630j f3649h;

    /* renamed from: a */
    public void m3927a(InterfaceC1072d interfaceC1072d) {
        this.f3643b = interfaceC1072d;
    }

    public C1038bi(Context context, int i, ArrayList arrayList, InterfaceC0626f interfaceC0626f) {
        super(context, 0);
        this.f3645d = i;
        this.f3644c = context;
        this.f3642a = arrayList;
        this.f3649h = new C0630j(this.f3644c.getContentResolver(), interfaceC0626f);
        this.f3648g = (LayoutInflater) this.f3644c.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1003aa c1003aa;
        if (view == null) {
            view = this.f3648g.inflate(R.layout.item_hide_list, (ViewGroup) null);
            C1003aa c1003aa2 = new C1003aa();
            c1003aa2.f3605b = (TextView) view.findViewById(R.id.name);
            c1003aa2.f3604a = (TextView) view.findViewById(R.id.buddyid);
            c1003aa2.f3606c = (ImageView) view.findViewById(R.id.friendImageCheck);
            c1003aa2.f3607d = (Button) view.findViewById(R.id.menuCall);
            view.setTag(c1003aa2);
            c1003aa = c1003aa2;
        } else {
            c1003aa = (C1003aa) view.getTag();
        }
        c1003aa.f3606c.setOnClickListener(new ViewOnClickListenerC1092x(this, i));
        c1003aa.f3607d.setOnClickListener(new ViewOnClickListenerC1091w(this, i));
        C0363a item = getItem(i);
        c1003aa.f3605b.setText(item.m2314b());
        c1003aa.f3604a.setText(item.m2308a());
        C1348w.m4685a(this.f3644c).m4699a(c1003aa.f3606c, item.m2308a());
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f3642a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0363a getItem(int i) {
        return (C0363a) this.f3642a.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
