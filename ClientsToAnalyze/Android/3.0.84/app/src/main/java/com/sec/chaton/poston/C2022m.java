package com.sec.chaton.poston;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3205bt;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: PostONCommentAdapter.java */
/* renamed from: com.sec.chaton.poston.m */
/* loaded from: classes.dex */
public class C2022m extends BaseAdapter {

    /* renamed from: a */
    private Context f7784a;

    /* renamed from: b */
    private ArrayList<C2025p> f7785b;

    /* renamed from: c */
    private LayoutInflater f7786c;

    /* renamed from: d */
    private int f7787d;

    /* renamed from: e */
    private String f7788e;

    /* renamed from: f */
    private InterfaceC2024o f7789f;

    /* renamed from: a */
    public void m8061a(InterfaceC2024o interfaceC2024o) {
        this.f7789f = interfaceC2024o;
    }

    public C2022m(ListView listView, Context context, ArrayList<C2025p> arrayList, int i) {
        this.f7788e = null;
        this.f7784a = context;
        this.f7785b = arrayList;
        this.f7787d = i;
        this.f7786c = (LayoutInflater) this.f7784a.getSystemService("layout_inflater");
    }

    public C2022m(ListView listView, Context context, ArrayList<C2025p> arrayList, int i, String str) {
        this.f7788e = null;
        this.f7784a = context;
        this.f7785b = arrayList;
        this.f7787d = i;
        this.f7786c = (LayoutInflater) this.f7784a.getSystemService("layout_inflater");
        this.f7788e = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f7785b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f7785b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C2026q c2026q;
        if (view == null) {
            View viewInflate = this.f7786c.inflate(this.f7787d, viewGroup, false);
            C2026q c2026q2 = new C2026q((LinearLayout) viewInflate);
            c2026q2.f7798a.setOnClickListener(new ViewOnClickListenerC2023n(this, i));
            view = viewInflate;
            c2026q = c2026q2;
        } else {
            c2026q = (C2026q) view.getTag();
        }
        c2026q.f7800c.setText(this.f7785b.get(i).m8064c());
        c2026q.f7801d.setText(m8060a(Long.parseLong(this.f7785b.get(i).m8065d())));
        C3205bt.m11182a(this.f7784a).m11210a(c2026q.f7798a, this.f7785b.get(i).m8062a());
        if (this.f7785b.get(i).m8062a().equals(C3159aa.m10962a().m10979a("chaton_id", ""))) {
            c2026q.f7799b.setText(GlobalApplication.m6451b().getString(R.string.setting_interaction_me));
        } else {
            c2026q.f7799b.setText(this.f7785b.get(i).m8063b());
        }
        view.setTag(c2026q);
        return view;
    }

    /* renamed from: a */
    public String m8060a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            return DateFormat.getTimeFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        if (str2.equals(str4)) {
            return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m11493l()).format(new Date(j));
    }
}
