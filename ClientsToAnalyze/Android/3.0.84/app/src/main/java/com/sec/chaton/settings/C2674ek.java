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
import com.sec.chaton.p027e.p028a.C1360d;
import com.sec.chaton.util.C3205bt;
import com.sec.common.CommonApplication;
import java.util.ArrayList;

/* compiled from: PostONHideAdapter.java */
/* renamed from: com.sec.chaton.settings.ek */
/* loaded from: classes.dex */
public class C2674ek extends ArrayAdapter<String> {

    /* renamed from: a */
    ArrayList<String> f9953a;

    /* renamed from: b */
    InterfaceC2677en f9954b;

    /* renamed from: c */
    private Context f9955c;

    /* renamed from: d */
    private String f9956d;

    /* renamed from: e */
    private String f9957e;

    /* renamed from: f */
    private LayoutInflater f9958f;

    /* renamed from: a */
    public void m9684a(InterfaceC2677en interfaceC2677en) {
        this.f9954b = interfaceC2677en;
    }

    public C2674ek(Context context, ArrayList<String> arrayList) {
        super(context, 0);
        this.f9955c = context;
        this.f9953a = arrayList;
        this.f9958f = (LayoutInflater) this.f9955c.getSystemService("layout_inflater");
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2676em c2676em;
        if (view == null) {
            view = this.f9958f.inflate(R.layout.list_item_common_5, (ViewGroup) null);
            c2676em = new C2676em();
            c2676em.f9961a = (TextView) view.findViewById(R.id.text1);
            c2676em.f9962b = (ImageView) view.findViewById(R.id.image1);
            c2676em.f9963c = (Button) view.findViewById(R.id.button1);
            view.setTag(c2676em);
        } else {
            c2676em = (C2676em) view.getTag();
        }
        c2676em.f9962b.setBackgroundResource(R.drawable.frame_background);
        this.f9957e = this.f9953a.get(i);
        this.f9956d = C1360d.m6037b(CommonApplication.m11493l().getContentResolver(), this.f9953a.get(i));
        c2676em.f9963c.setText(R.string.setting_block_unblock);
        c2676em.f9963c.setOnClickListener(new ViewOnClickListenerC2675el(this, i));
        c2676em.f9961a.setText(this.f9956d);
        C3205bt.m11182a(this.f9955c).m11210a(c2676em.f9962b, this.f9957e);
        return view;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f9953a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.f9953a.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }
}
