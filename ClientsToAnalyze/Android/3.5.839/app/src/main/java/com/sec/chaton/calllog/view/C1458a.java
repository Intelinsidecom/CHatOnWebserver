package com.sec.chaton.calllog.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.view.layout.List_Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: CallLogArrayAdapter.java */
/* renamed from: com.sec.chaton.calllog.view.a */
/* loaded from: classes.dex */
public class C1458a extends ArrayAdapter<CallLogData> {

    /* renamed from: a */
    public static boolean f5319a = false;

    /* renamed from: b */
    public static boolean f5320b = false;

    /* renamed from: c */
    public static String f5321c = null;

    /* renamed from: d */
    public static Context f5322d = null;

    /* renamed from: e */
    public Handler f5323e;

    /* renamed from: f */
    public ArrayList<CallLogData> f5324f;

    /* renamed from: g */
    public List<Boolean> f5325g;

    /* renamed from: h */
    public HashMap<Set<String>, String> f5326h;

    /* renamed from: i */
    public InterfaceC1492u f5327i;

    /* renamed from: j */
    public InterfaceC1447e f5328j;

    /* renamed from: k */
    private ArrayList<List_Common> f5329k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1458a(Context context, int i, ArrayList<CallLogData> arrayList, HashMap<Set<String>, String> map, Handler handler, InterfaceC1492u interfaceC1492u, List<Boolean> list, InterfaceC1447e interfaceC1447e) {
        super(context, i, arrayList);
        f5322d = context;
        this.f5323e = null;
        this.f5325g = null;
        this.f5326h = null;
        this.f5327i = null;
        this.f5328j = null;
        this.f5323e = handler;
        this.f5324f = arrayList;
        this.f5327i = interfaceC1492u;
        this.f5325g = list;
        this.f5326h = map;
        this.f5328j = interfaceC1447e;
        this.f5329k = new ArrayList<>();
    }

    /* renamed from: a */
    public int m7792a() {
        return this.f5324f.size();
    }

    /* renamed from: a */
    public void m7793a(List<Boolean> list) {
        this.f5325g = list;
    }

    /* renamed from: a */
    public static void m7790a(boolean z) {
        f5319a = z;
    }

    /* renamed from: b */
    public static void m7791b(boolean z) {
        f5320b = z;
    }

    /* renamed from: a */
    public static void m7789a(int i) {
        switch (i) {
            case 0:
                f5321c = "MM/dd/yyyy";
                break;
            case 1:
                f5321c = "dd/MM/yyyy";
                break;
            case 2:
                f5321c = "yyyy/MM/dd";
                break;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        List_Common list_CommonMo7797a = (List_Common) view;
        if (list_CommonMo7797a == null && this.f5327i != null) {
            list_CommonMo7797a = this.f5327i.mo7797a(f5322d, this.f5323e, this.f5328j);
            this.f5329k.add(list_CommonMo7797a);
        }
        List_Common list_Common = list_CommonMo7797a;
        CallLogData item = getItem(i);
        if (item != null) {
            boolean zBooleanValue = false;
            if (this.f5325g != null && this.f5325g.size() > i) {
                zBooleanValue = this.f5325g.get(i).booleanValue();
            }
            if (list_Common != null) {
                list_Common.setView(item, f5319a, f5320b, f5321c, this.f5326h, zBooleanValue);
            }
        }
        if (list_Common != null) {
            list_Common.setTag(item);
        }
        return list_Common;
    }
}
