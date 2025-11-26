package com.sec.chaton.poston;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p074l.C2496n;
import com.sec.chaton.p074l.EnumC2498p;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.widget.CheckableRelativeLayout;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* compiled from: PostONCommentAdapter.java */
/* renamed from: com.sec.chaton.poston.m */
/* loaded from: classes.dex */
public class C3018m extends BaseAdapter {

    /* renamed from: a */
    private Context f11181a;

    /* renamed from: b */
    private ArrayList<C3021p> f11182b;

    /* renamed from: c */
    private LayoutInflater f11183c;

    /* renamed from: d */
    private int f11184d;

    /* renamed from: e */
    private String f11185e;

    /* renamed from: f */
    private InterfaceC3020o f11186f;

    /* renamed from: a */
    public void m12381a(InterfaceC3020o interfaceC3020o) {
        this.f11186f = interfaceC3020o;
    }

    public C3018m(ListView listView, Context context, ArrayList<C3021p> arrayList, int i) {
        this.f11185e = null;
        this.f11181a = context;
        this.f11182b = arrayList;
        this.f11184d = i;
        this.f11183c = (LayoutInflater) this.f11181a.getSystemService("layout_inflater");
    }

    public C3018m(ListView listView, Context context, ArrayList<C3021p> arrayList, int i, String str) {
        this.f11185e = null;
        this.f11181a = context;
        this.f11182b = arrayList;
        this.f11184d = i;
        this.f11183c = (LayoutInflater) this.f11181a.getSystemService("layout_inflater");
        this.f11185e = str;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11182b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f11182b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3022q c3022q;
        if (view == null) {
            View viewInflate = this.f11183c.inflate(this.f11184d, viewGroup, false);
            C3022q c3022q2 = new C3022q((CheckableRelativeLayout) viewInflate, i, null);
            c3022q2.f11195a.setOnClickListener(new ViewOnClickListenerC3019n(this, c3022q2));
            viewInflate.setTag(c3022q2);
            view = viewInflate;
            c3022q = c3022q2;
        } else {
            c3022q = (C3022q) view.getTag();
        }
        c3022q.f11200f = i;
        c3022q.f11197c.setText(this.f11182b.get(i).m12384c());
        c3022q.f11198d.setText(m12380a(Long.parseLong(this.f11182b.get(i).m12385d())));
        if (this.f11182b.get(i).m12382a().equals(C4809aa.m18104a().m18121a("chaton_id", ""))) {
            C2496n.m10763a(c3022q.f11195a, EnumC2498p.ROUND);
            c3022q.f11196b.setText(GlobalApplication.m10283b().getString(R.string.setting_interaction_me));
        } else {
            C2496n.m10765a(c3022q.f11195a, this.f11182b.get(i).m12382a(), EnumC2498p.ROUND);
            c3022q.f11196b.setText(this.f11182b.get(i).m12383b());
        }
        return view;
    }

    /* renamed from: a */
    public String m12380a(long j) {
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (str3.equals(str)) {
            return DateFormat.getTimeFormat(CommonApplication.m18732r()).format(new Date(j));
        }
        if (str2.equals(str4)) {
            return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
        }
        return DateFormat.getDateFormat(CommonApplication.m18732r()).format(new Date(j));
    }
}
