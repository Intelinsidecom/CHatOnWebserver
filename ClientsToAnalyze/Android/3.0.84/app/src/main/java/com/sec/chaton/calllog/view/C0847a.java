package com.sec.chaton.calllog.view;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.view.layout.List_Common;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* compiled from: CallLogArrayAdapter.java */
/* renamed from: com.sec.chaton.calllog.view.a */
/* loaded from: classes.dex */
public class C0847a extends ArrayAdapter<CallLogData> {

    /* renamed from: a */
    public static boolean f3346a = false;

    /* renamed from: b */
    public static boolean f3347b = false;

    /* renamed from: c */
    public static String f3348c = null;

    /* renamed from: d */
    public static Context f3349d = null;

    /* renamed from: e */
    public Handler f3350e;

    /* renamed from: f */
    public ArrayList<CallLogData> f3351f;

    /* renamed from: g */
    public List<Boolean> f3352g;

    /* renamed from: h */
    public HashMap<Set<String>, String> f3353h;

    /* renamed from: i */
    public InterfaceC0881u f3354i;

    /* renamed from: j */
    public InterfaceC0836e f3355j;

    /* renamed from: k */
    private ArrayList<List_Common> f3356k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0847a(Context context, int i, ArrayList<CallLogData> arrayList, HashMap<Set<String>, String> map, Handler handler, InterfaceC0881u interfaceC0881u, List<Boolean> list, InterfaceC0836e interfaceC0836e) {
        super(context, i, arrayList);
        f3349d = context;
        this.f3350e = null;
        this.f3352g = null;
        this.f3353h = null;
        this.f3354i = null;
        this.f3355j = null;
        this.f3350e = handler;
        this.f3351f = arrayList;
        this.f3354i = interfaceC0881u;
        this.f3352g = list;
        this.f3353h = map;
        this.f3355j = interfaceC0836e;
        this.f3356k = new ArrayList<>();
    }

    /* renamed from: a */
    public int m4636a() {
        return this.f3351f.size();
    }

    /* renamed from: a */
    public void m4637a(List<Boolean> list) {
        this.f3352g = list;
    }

    /* renamed from: a */
    public static void m4634a(boolean z) {
        f3346a = z;
    }

    /* renamed from: b */
    public static void m4635b(boolean z) {
        f3347b = z;
    }

    /* renamed from: a */
    public static void m4633a(int i) {
        switch (i) {
            case 0:
                f3348c = "MM/dd/yyyy";
                break;
            case 1:
                f3348c = "dd/MM/yyyy";
                break;
            case 2:
                f3348c = "yyyy/MM/dd";
                break;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        List_Common list_CommonMo4641a = (List_Common) view;
        if (list_CommonMo4641a == null && this.f3354i != null) {
            list_CommonMo4641a = this.f3354i.mo4641a(f3349d, this.f3350e, this.f3355j);
            this.f3356k.add(list_CommonMo4641a);
        }
        List_Common list_Common = list_CommonMo4641a;
        CallLogData item = getItem(i);
        if (item != null) {
            boolean zBooleanValue = false;
            if (this.f3352g != null && this.f3352g.size() > i) {
                zBooleanValue = this.f3352g.get(i).booleanValue();
            }
            list_Common.setView(item, f3346a, f3347b, f3348c, this.f3353h, zBooleanValue);
        }
        list_Common.setTag(item);
        return list_Common;
    }
}
