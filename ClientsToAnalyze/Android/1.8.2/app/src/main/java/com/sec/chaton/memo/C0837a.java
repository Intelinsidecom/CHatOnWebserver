package com.sec.chaton.memo;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1789u;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* compiled from: MemoAdapter.java */
/* renamed from: com.sec.chaton.memo.a */
/* loaded from: classes.dex */
public class C0837a extends BaseAdapter {

    /* renamed from: e */
    private static String f3076e = "";

    /* renamed from: a */
    private Context f3077a;

    /* renamed from: b */
    private ArrayList f3078b;

    /* renamed from: c */
    private LayoutInflater f3079c;

    /* renamed from: d */
    private int f3080d;

    public C0837a(ListView listView, Context context, ArrayList arrayList, int i) {
        this.f3077a = context;
        this.f3078b = arrayList;
        this.f3080d = i;
        this.f3079c = (LayoutInflater) this.f3077a.getSystemService("layout_inflater");
        f3076e = C1789u.m6075a().getString("msisdn", "");
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3078b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3078b.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0840d c0840d;
        if (view == null) {
            View viewInflate = this.f3079c.inflate(this.f3080d, viewGroup, false);
            view = viewInflate;
            c0840d = new C0840d((RelativeLayout) viewInflate);
        } else {
            c0840d = (C0840d) view.getTag();
        }
        c0840d.f3089c.setText(((C0839c) this.f3078b.get(i)).m3497c());
        c0840d.f3090d.setText(m3494a(Long.parseLong(((C0839c) this.f3078b.get(i)).m3498d())));
        C1746bb.m5945a(this.f3077a).m5959a(c0840d.f3087a, ((C0839c) this.f3078b.get(i)).m3495a());
        ViewOnClickListenerC0838b viewOnClickListenerC0838b = new ViewOnClickListenerC0838b(this, i);
        c0840d.f3091e.setOnClickListener(viewOnClickListenerC0838b);
        c0840d.f3087a.setOnClickListener(viewOnClickListenerC0838b);
        if (((C0839c) this.f3078b.get(i)).m3495a().equals(f3076e)) {
            c0840d.f3088b.setText(GlobalApplication.m3262c().getString(R.string.setting_interaction_me));
        } else {
            c0840d.f3088b.setText(((C0839c) this.f3078b.get(i)).m3496b());
            if (!GlobalApplication.m3265f()) {
                if (this.f3077a instanceof Activity) {
                    c0840d.f3091e.setBackgroundColor(-16777216);
                    c0840d.f3089c.setTextColor(Color.parseColor("#FFFFA800"));
                } else {
                    c0840d.f3091e.setBackgroundResource(R.drawable.buddy_item_xml);
                }
            }
        }
        view.setTag(c0840d);
        return view;
    }

    /* renamed from: a */
    public String m3494a(long j) {
        String[] strArrSplit;
        String str = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        String str2 = new SimpleDateFormat("yyyy").format(Long.valueOf(j));
        long jCurrentTimeMillis = System.currentTimeMillis();
        String str3 = new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(jCurrentTimeMillis));
        String str4 = new SimpleDateFormat("yyyy").format(Long.valueOf(jCurrentTimeMillis));
        if (DateFormat.is24HourFormat(this.f3077a)) {
            strArrSplit = new SimpleDateFormat("dd MMM/HH:mm", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        } else {
            strArrSplit = new SimpleDateFormat("dd MMM/h:mm aa", Locale.ENGLISH).format(Long.valueOf(j)).split("/");
        }
        if (str3.equals(str)) {
            return strArrSplit[1];
        }
        if (str2.equals(str4)) {
            return strArrSplit[0];
        }
        return new SimpleDateFormat("d MMM,yyyy", Locale.ENGLISH).format(Long.valueOf(j));
    }
}
