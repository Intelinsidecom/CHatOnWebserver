package com.sec.chaton.calllog.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.sec.chaton.calllog.manager.model.C1455c;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.util.C4855bt;
import com.sec.chaton.util.C4904y;
import java.util.List;

/* compiled from: ShowConferenceMemberListFragment.java */
/* renamed from: com.sec.chaton.calllog.view.ak */
/* loaded from: classes.dex */
public class C1469ak extends ArrayAdapter {

    /* renamed from: a */
    public CallLogData f5344a;

    /* renamed from: b */
    private Context f5345b;

    /* renamed from: c */
    private int f5346c;

    /* renamed from: d */
    private InterfaceC1466ah f5347d;

    /* renamed from: e */
    private boolean f5348e;

    /* renamed from: f */
    private List<Boolean> f5349f;

    public C1469ak(Context context, int i, CallLogData callLogData, InterfaceC1466ah interfaceC1466ah) {
        super(context, i);
        this.f5345b = null;
        this.f5348e = false;
        this.f5345b = context;
        this.f5346c = i;
        this.f5344a = callLogData;
        this.f5347d = interfaceC1466ah;
        this.f5348e = false;
    }

    public C1469ak(Context context, int i, CallLogData callLogData, List<Boolean> list) {
        super(context, i);
        this.f5345b = null;
        this.f5348e = false;
        this.f5345b = context;
        this.f5346c = i;
        this.f5344a = callLogData;
        this.f5349f = list;
        this.f5348e = true;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f5344a.userInfo.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C1468aj c1468aj;
        C1455c c1455c = this.f5344a.userInfo.get(i);
        int iM7709a = CallLogFragment.m7709a(c1455c);
        C4904y.m18639b("MembersAdapter.getView() position[" + i + "], buddyType[" + iM7709a + "]", ShowConferenceMemberList.class.getSimpleName());
        if (view != null) {
            c1468aj = (C1468aj) view.getTag();
        } else {
            View viewInflate = LayoutInflater.from(this.f5345b).inflate(this.f5346c, viewGroup, false);
            view = viewInflate;
            c1468aj = new C1468aj((ViewGroup) viewInflate);
        }
        if (this.f5348e) {
            if (c1455c.f5177c == null || c1455c.f5177c.length() <= 0) {
                c1468aj.f5339b.setText(c1455c.f5176b);
            } else {
                c1468aj.f5339b.setText(c1455c.f5177c);
            }
            c1468aj.f5343f.setVisibility(0);
            c1468aj.f5341d.setVisibility(8);
            c1468aj.f5341d.setOnClickListener(null);
            c1468aj.f5342e.setVisibility(0);
            if (this.f5349f.get(i).booleanValue()) {
                c1468aj.f5342e.setChecked(true);
            } else {
                c1468aj.f5342e.setChecked(false);
            }
        } else {
            c1468aj.f5342e.setVisibility(8);
            if (iM7709a == 4 || iM7709a == 2) {
                c1468aj.f5339b.setText(c1455c.f5176b);
                c1468aj.f5343f.setVisibility(0);
                c1468aj.f5341d.setVisibility(0);
                c1468aj.f5341d.setOnClickListener(new ViewOnClickListenerC1470al(this, c1455c));
            } else {
                c1468aj.f5339b.setText(c1455c.f5177c);
                c1468aj.f5343f.setVisibility(8);
                c1468aj.f5341d.setOnClickListener(null);
            }
        }
        C4855bt.m18351a(this.f5345b).m18360a(c1468aj.f5338a, c1455c.f5175a);
        view.setTag(c1468aj);
        return view;
    }
}
