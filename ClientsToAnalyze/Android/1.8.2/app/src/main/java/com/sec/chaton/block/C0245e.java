package com.sec.chaton.block;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.widget.C1805i;
import java.util.ArrayList;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.e */
/* loaded from: classes.dex */
class C0245e extends ArrayAdapter {

    /* renamed from: a */
    ArrayList f814a;

    /* renamed from: b */
    public Handler f815b;

    /* renamed from: c */
    private Context f816c;

    /* renamed from: d */
    private int f817d;

    /* renamed from: e */
    private String f818e;

    /* renamed from: f */
    private LayoutInflater f819f;

    /* renamed from: g */
    private ProgressDialog f820g;

    /* renamed from: h */
    private ViewGroup f821h;

    /* renamed from: i */
    private LinearLayout f822i;

    /* renamed from: j */
    private ListView f823j;

    /* renamed from: k */
    private boolean f824k;

    public C0245e(Context context, int i, ArrayList arrayList, LinearLayout linearLayout, boolean z) {
        super(context, 0, arrayList);
        this.f815b = new HandlerC0247g(this);
        this.f817d = i;
        this.f816c = context;
        this.f814a = arrayList;
        this.f819f = (LayoutInflater) this.f816c.getSystemService("layout_inflater");
        this.f821h = (ViewGroup) this.f819f.inflate(i, (ViewGroup) null);
        this.f822i = linearLayout;
        this.f823j = (ListView) this.f821h.findViewById(R.id.list);
        this.f820g = (ProgressDialog) new C1805i(this.f816c).m6139a(R.string.dialog_userprofile_updating);
        this.f824k = z;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0248h c0248h;
        if (view == null) {
            view = this.f819f.inflate(R.layout.block_list_item, (ViewGroup) null);
            c0248h = new C0248h();
            c0248h.f829b = (TextView) view.findViewById(R.id.name);
            c0248h.f828a = (TextView) view.findViewById(R.id.buddyid);
            c0248h.f830c = (ImageView) view.findViewById(R.id.friendImageCheck);
            c0248h.f831d = (CheckBox) view.findViewById(R.id.item_check);
            view.setTag(c0248h);
        } else {
            c0248h = (C0248h) view.getTag();
        }
        if (this.f824k) {
            c0248h.f831d.setVisibility(0);
        }
        c0248h.f830c.setOnClickListener(new ViewOnClickListenerC0246f(this, i));
        C0253m c0253m = (C0253m) getItem(i);
        c0248h.f829b.setText(c0253m.f838c);
        c0248h.f828a.setText(c0253m.f837b);
        C1746bb.m5945a(this.f816c).m5959a(c0248h.f830c, c0253m.f837b);
        return view;
    }
}
