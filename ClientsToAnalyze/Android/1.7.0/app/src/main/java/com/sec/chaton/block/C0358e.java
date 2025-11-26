package com.sec.chaton.block;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p013a.C0217p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.widget.C1356c;
import java.util.ArrayList;

/* compiled from: BlockBuddyAdapter.java */
/* renamed from: com.sec.chaton.block.e */
/* loaded from: classes.dex */
class C0358e extends ArrayAdapter {

    /* renamed from: a */
    ArrayList f1042a;

    /* renamed from: b */
    public Handler f1043b;

    /* renamed from: c */
    private Context f1044c;

    /* renamed from: d */
    private C0217p f1045d;

    /* renamed from: e */
    private String f1046e;

    /* renamed from: f */
    private String f1047f;

    /* renamed from: g */
    private LayoutInflater f1048g;

    /* renamed from: h */
    private ProgressDialog f1049h;

    /* renamed from: i */
    private ViewGroup f1050i;

    /* renamed from: j */
    private View.OnClickListener f1051j;

    public C0358e(Context context, int i, ArrayList arrayList) {
        super(context, 0, arrayList);
        this.f1051j = new ViewOnClickListenerC0361h(this);
        this.f1043b = new HandlerC0360g(this);
        this.f1044c = context;
        this.f1042a = arrayList;
        this.f1048g = (LayoutInflater) this.f1044c.getSystemService("layout_inflater");
        this.f1050i = (ViewGroup) this.f1048g.inflate(i, (ViewGroup) null);
        this.f1049h = (ProgressDialog) new C1356c(this.f1044c).m4728a(R.string.dialog_userprofile_updating);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0357d c0357d;
        if (view == null) {
            view = this.f1048g.inflate(R.layout.item_mylist, (ViewGroup) null);
            c0357d = new C0357d();
            c0357d.f1039a = (TextView) view.findViewById(R.id.listItemText1);
            c0357d.f1040b = (ImageView) view.findViewById(R.id.listItemImage);
            c0357d.f1041c = (Button) view.findViewById(R.id.listItemButton);
            view.setTag(c0357d);
        } else {
            c0357d = (C0357d) view.getTag();
        }
        c0357d.f1041c.setTag(Integer.valueOf(i));
        c0357d.f1041c.setOnClickListener(this.f1051j);
        C0359f c0359f = (C0359f) getItem(i);
        c0357d.f1039a.setText(c0359f.f1053b);
        C1348w.m4685a(this.f1044c).m4699a(c0357d.f1040b, c0359f.f1052a);
        return view;
    }
}
