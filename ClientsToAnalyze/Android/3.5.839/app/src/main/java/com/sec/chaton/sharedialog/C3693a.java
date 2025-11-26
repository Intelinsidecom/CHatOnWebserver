package com.sec.chaton.sharedialog;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import com.sec.common.util.C5033j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: SetAppPreferences.java */
/* renamed from: com.sec.chaton.sharedialog.a */
/* loaded from: classes.dex */
public class C3693a {

    /* renamed from: a */
    SharedPreferences f13297a;

    /* renamed from: b */
    SharedPreferences.Editor f13298b;

    /* renamed from: c */
    List<Map.Entry<String, Integer>> f13299c;

    /* renamed from: d */
    private Context f13300d;

    /* renamed from: e */
    private List<C3695c> f13301e;

    /* renamed from: f */
    private HashMap<String, Integer> f13302f = new HashMap<>();

    public C3693a(List<C3695c> list, Context context) {
        this.f13301e = new ArrayList();
        this.f13300d = context;
        this.f13301e = list;
        this.f13297a = this.f13300d.getSharedPreferences("custom share preference", 0);
        this.f13298b = this.f13297a.edit();
        if (list != null) {
            for (C3695c c3695c : list) {
                String strM13960b = c3695c.m13960b();
                String str = c3695c.m13961c().getPackage();
                if (!this.f13297a.contains(str)) {
                    this.f13298b.putInt(str, 0);
                    C5033j.m19087a(this.f13298b);
                }
                this.f13302f.put(strM13960b, Integer.valueOf(this.f13297a.getInt(str, -1)));
            }
        }
        this.f13299c = new ArrayList(this.f13302f.entrySet());
    }

    /* renamed from: a */
    public List<C3695c> m13952a() {
        ArrayList arrayList = new ArrayList();
        Collections.sort(this.f13299c, new C3701i());
        ListIterator<Map.Entry<String, Integer>> listIterator = this.f13299c.listIterator();
        while (listIterator.hasNext()) {
            Map.Entry<String, Integer> next = listIterator.next();
            String key = next.getKey();
            Log.e(getClass().getSimpleName(), "Pref: " + key + "Value: " + next.getValue().intValue());
            for (C3695c c3695c : this.f13301e) {
                if (c3695c.m13960b() == key) {
                    arrayList.add(c3695c);
                }
            }
        }
        return arrayList;
    }
}
