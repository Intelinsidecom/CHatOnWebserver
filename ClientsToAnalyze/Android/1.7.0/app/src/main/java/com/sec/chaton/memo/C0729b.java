package com.sec.chaton.memo;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1323bs;
import com.sec.chaton.util.C1348w;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: MemoAdapter.java */
/* renamed from: com.sec.chaton.memo.b */
/* loaded from: classes.dex */
public class C0729b extends BaseAdapter {

    /* renamed from: e */
    private static String f2467e = "";

    /* renamed from: a */
    private Context f2468a;

    /* renamed from: b */
    private ArrayList f2469b;

    /* renamed from: c */
    private LayoutInflater f2470c;

    /* renamed from: d */
    private int f2471d;

    public C0729b(ListView listView, Context context, ArrayList arrayList, int i) {
        this.f2468a = context;
        this.f2469b = arrayList;
        this.f2471d = i;
        this.f2470c = (LayoutInflater) this.f2468a.getSystemService("layout_inflater");
        f2467e = C1323bs.m4575a().getString("msisdn", "");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f2469b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f2469b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0735h c0735h;
        if (view == null) {
            View viewInflate = this.f2470c.inflate(this.f2471d, viewGroup, false);
            view = viewInflate;
            c0735h = new C0735h((RelativeLayout) viewInflate);
        } else {
            c0735h = (C0735h) view.getTag();
        }
        c0735h.f2483c.setText(((C0734g) this.f2469b.get(i)).m3140c());
        c0735h.f2484d.setText(m3137a(Long.parseLong(((C0734g) this.f2469b.get(i)).m3141d())));
        C1348w.m4685a(this.f2468a).m4699a(c0735h.f2481a, ((C0734g) this.f2469b.get(i)).m3138a());
        c0735h.f2481a.setOnClickListener(new ViewOnClickListenerC0730c(this, i));
        if (((C0734g) this.f2469b.get(i)).m3138a().equals(f2467e)) {
            c0735h.f2482b.setText(GlobalApplication.m3106g().getString(R.string.setting_interaction_me));
        } else {
            c0735h.f2482b.setText(((C0734g) this.f2469b.get(i)).m3139b());
        }
        view.setTag(c0735h);
        return view;
    }

    /* renamed from: a */
    public String m3137a(long j) {
        String[] strArrSplit;
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (DateFormat.is24HourFormat(this.f2468a)) {
            strArrSplit = new SimpleDateFormat("MMM dd/HH:mm", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        } else {
            strArrSplit = new SimpleDateFormat("MMM dd/h:mm aa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        }
        if (str3.equals(str)) {
            return strArrSplit[1];
        }
        if (str2.equals(str4)) {
            return strArrSplit[0];
        }
        return new SimpleDateFormat("MMM d,yyyy", Locale.ENGLISH).format(Long.valueOf(j));
    }
}
