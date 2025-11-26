package com.sec.chaton.buddy.honeycomb;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0255a;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.util.C1746bb;
import java.util.ArrayList;

/* compiled from: BuddySelectAdapter.java */
/* renamed from: com.sec.chaton.buddy.honeycomb.a */
/* loaded from: classes.dex */
public class C0418a extends BaseExpandableListAdapter {

    /* renamed from: a */
    public static final String f1615a = C0418a.class.getSimpleName();

    /* renamed from: b */
    private BuddySelectFragment f1616b;

    /* renamed from: c */
    private ExpandableListView f1617c;

    /* renamed from: d */
    private LayoutInflater f1618d;

    /* renamed from: e */
    private Context f1619e;

    /* renamed from: f */
    private ArrayList f1620f;

    /* renamed from: g */
    private int f1621g;

    /* renamed from: h */
    private ArrayList f1622h;

    /* renamed from: i */
    private int f1623i;

    /* renamed from: j */
    private int f1624j;

    /* renamed from: k */
    private InterfaceC0432o f1625k;

    public C0418a(ExpandableListView expandableListView, Context context, BuddySelectFragment buddySelectFragment, ArrayList arrayList, int i, ArrayList arrayList2, int i2, int i3, InterfaceC0432o interfaceC0432o) {
        this.f1617c = expandableListView;
        this.f1618d = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1616b = buddySelectFragment;
        this.f1619e = context;
        this.f1620f = arrayList;
        this.f1621g = i;
        this.f1622h = arrayList2;
        this.f1623i = i2;
        this.f1624j = i3;
        this.f1625k = interfaceC0432o;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C0422e c0422e;
        if (view == null) {
            View viewInflate = this.f1618d.inflate(this.f1621g, viewGroup, false);
            view = viewInflate;
            c0422e = new C0422e((LinearLayout) viewInflate);
        } else {
            c0422e = (C0422e) view.getTag();
        }
        if (this.f1624j == 4 || this.f1624j == 5 || this.f1624j == 6) {
            c0422e.m2438a(8);
            view.setBackgroundResource(0);
        } else {
            c0422e.m2438a(0);
            view.setBackgroundResource(R.drawable.buddy_select_group_background_xml);
        }
        c0422e.f1637b.setText(((C0255a) this.f1620f.get(i)).m2307b());
        c0422e.f1638c.setText("(" + ((ArrayList) this.f1622h.get(i)).size() + ")");
        view.setTag(c0422e);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C0421d c0421d;
        View viewInflate;
        C0257c c0257c = (C0257c) ((ArrayList) this.f1622h.get(i)).get(i2);
        C0255a c0255a = (C0255a) this.f1620f.get(i);
        if (view == null) {
            viewInflate = this.f1618d.inflate(this.f1623i, viewGroup, false);
            c0421d = new C0421d((LinearLayout) viewInflate);
        } else {
            c0421d = (C0421d) view.getTag();
            viewInflate = view;
        }
        c0421d.f1630a.setBackgroundResource(R.drawable.buddy_item_xml);
        if (this.f1624j == 1 || this.f1624j == 3 || this.f1624j == 4 || this.f1624j == 5 || this.f1624j == 6 || this.f1624j == 7) {
            c0421d.f1631b.setVisibility(8);
        } else if (this.f1624j == 2) {
            c0421d.f1631b.setVisibility(0);
            c0421d.f1631b.setChecked(c0257c.m2345q());
        }
        C1746bb.m5945a(this.f1619e).m5960a(c0421d.f1632c, c0257c.m2318a(), c0257c.m2346r());
        if (this.f1624j == 2 || this.f1624j == 3) {
            c0421d.f1632c.setOnClickListener(new ViewOnClickListenerC0419b(this, c0257c));
        } else {
            c0421d.f1632c.setOnClickListener(null);
        }
        c0421d.f1633d.setText(c0257c.m2324b());
        c0421d.f1634e.setText(c0257c.m2327c());
        if (c0255a.m2309d() == 1) {
            c0421d.f1634e.setTextColor(Color.parseColor("#a18815"));
        } else {
            c0421d.f1634e.setTextColor(Color.parseColor("#e07a20"));
        }
        if (this.f1624j == 1 || this.f1624j == 3 || this.f1624j == 4 || this.f1624j == 5 || this.f1624j == 6 || this.f1624j == 7) {
            c0421d.f1635f.setVisibility(0);
            c0421d.f1635f.setOnClickListener(new ViewOnClickListenerC0420c(this, c0257c));
        } else {
            c0421d.f1635f.setVisibility(8);
            c0421d.f1635f.setOnClickListener(null);
        }
        viewInflate.setTag(c0421d);
        return viewInflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f1622h.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f1622h.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f1620f.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f1620f.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }
}
