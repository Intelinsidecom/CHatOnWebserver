package com.sec.chaton.calllog.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.calllog.manager.model.C0844c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import java.util.List;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ak */
/* loaded from: classes.dex */
public class C0858ak extends ArrayAdapter {

    /* renamed from: a */
    public CallLogData f3371a;

    /* renamed from: b */
    private Context f3372b;

    /* renamed from: c */
    private int f3373c;

    /* renamed from: d */
    private InterfaceC0855ah f3374d;

    /* renamed from: e */
    private boolean f3375e;

    /* renamed from: f */
    private List<Boolean> f3376f;

    public C0858ak(Context context, int i, CallLogData callLogData, InterfaceC0855ah interfaceC0855ah) {
        super(context, i);
        this.f3372b = null;
        this.f3375e = false;
        this.f3372b = context;
        this.f3373c = i;
        this.f3371a = callLogData;
        this.f3374d = interfaceC0855ah;
        this.f3375e = false;
    }

    public C0858ak(Context context, int i, CallLogData callLogData, List<Boolean> list) {
        super(context, i);
        this.f3372b = null;
        this.f3375e = false;
        this.f3372b = context;
        this.f3373c = i;
        this.f3371a = callLogData;
        this.f3376f = list;
        this.f3375e = true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f3371a.userInfo.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0857aj c0857aj;
        C0844c c0844c = this.f3371a.userInfo.get(i);
        int iM4554a = CallLogFragment.m4554a(c0844c);
        C3250y.m11450b("MembersAdapter.getView() position[" + i + "], buddyType[" + iM4554a + "]", ShowConferenceMemberList.class.getSimpleName());
        if (view != null) {
            c0857aj = (C0857aj) view.getTag();
        } else {
            View viewInflate = LayoutInflater.from(this.f3372b).inflate(this.f3373c, viewGroup, false);
            view = viewInflate;
            c0857aj = new C0857aj((ViewGroup) viewInflate);
        }
        if (this.f3375e) {
            if (c0844c.f3207c == null || c0844c.f3207c.length() <= 0) {
                c0857aj.f3366b.setText(c0844c.f3206b);
            } else {
                c0857aj.f3366b.setText(c0844c.f3207c);
            }
            c0857aj.f3370f.setVisibility(0);
            c0857aj.f3368d.setVisibility(8);
            c0857aj.f3368d.setOnClickListener(null);
            c0857aj.f3369e.setVisibility(0);
            if (this.f3376f.get(i).booleanValue()) {
                c0857aj.f3369e.setChecked(true);
            } else {
                c0857aj.f3369e.setChecked(false);
            }
        } else {
            c0857aj.f3369e.setVisibility(8);
            if (iM4554a == 4 || iM4554a == 2) {
                c0857aj.f3366b.setText(c0844c.f3206b);
                c0857aj.f3370f.setVisibility(0);
                c0857aj.f3368d.setVisibility(0);
                c0857aj.f3368d.setOnClickListener(new ViewOnClickListenerC0859al(this, c0844c));
            } else {
                c0857aj.f3366b.setText(c0844c.f3207c);
                c0857aj.f3370f.setVisibility(8);
                c0857aj.f3368d.setOnClickListener(null);
            }
        }
        C3205bt.m11182a(this.f3372b).m11210a(c0857aj.f3365a, c0844c.f3205a);
        view.setTag(c0857aj);
        return view;
    }
}
