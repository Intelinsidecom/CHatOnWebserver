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
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.p018a.C0666j;
import com.sec.chaton.p017e.p018a.InterfaceC0667k;
import com.sec.chaton.util.C1746bb;
import java.util.ArrayList;

/* compiled from: RelationHideAdapter.java */
/* renamed from: com.sec.chaton.settings.cw */
/* loaded from: classes.dex */
class C1298cw extends ArrayAdapter {

    /* renamed from: a */
    ArrayList f4853a;

    /* renamed from: b */
    private Context f4854b;

    /* renamed from: c */
    private int f4855c;

    /* renamed from: d */
    private String f4856d;

    /* renamed from: e */
    private String f4857e;

    /* renamed from: f */
    private LayoutInflater f4858f;

    /* renamed from: g */
    private C0666j f4859g;

    public C1298cw(Context context, int i, ArrayList arrayList, InterfaceC0667k interfaceC0667k) {
        super(context, 0);
        this.f4855c = i;
        this.f4854b = context;
        this.f4853a = arrayList;
        this.f4859g = new C0666j(this.f4854b.getContentResolver(), interfaceC0667k);
        this.f4858f = (LayoutInflater) this.f4854b.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1301cz c1301cz;
        if (view == null) {
            view = this.f4858f.inflate(R.layout.item_hide_list, (ViewGroup) null);
            C1301cz c1301cz2 = new C1301cz();
            c1301cz2.f4866b = (TextView) view.findViewById(R.id.name);
            c1301cz2.f4865a = (TextView) view.findViewById(R.id.buddyid);
            c1301cz2.f4867c = (ImageView) view.findViewById(R.id.friendImageCheck);
            c1301cz2.f4868d = (Button) view.findViewById(R.id.menuCall);
            view.setTag(c1301cz2);
            c1301cz = c1301cz2;
        } else {
            c1301cz = (C1301cz) view.getTag();
        }
        c1301cz.f4867c.setOnClickListener(new ViewOnClickListenerC1299cx(this, i));
        c1301cz.f4868d.setOnClickListener(new ViewOnClickListenerC1300cy(this, c1301cz, i));
        C0257c item = getItem(i);
        c1301cz.f4866b.setText(item.m2324b());
        c1301cz.f4865a.setText(item.m2318a());
        C1746bb.m5945a(this.f4854b).m5959a(c1301cz.f4867c, item.m2318a());
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f4853a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C0257c getItem(int i) {
        return (C0257c) this.f4853a.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
