package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.SectionIndexer;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p017a.C0363a;
import com.sec.chaton.buddy.p017a.C0364b;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.chaton.util.EnumC1310bf;
import com.sec.widget.FastScrollableExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyAdapter.java */
/* renamed from: com.sec.chaton.buddy.ae */
/* loaded from: classes.dex */
public class C0370ae extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: a */
    private FastScrollableExpandableListView f1324a;

    /* renamed from: b */
    private LayoutInflater f1325b;

    /* renamed from: c */
    private Context f1326c;

    /* renamed from: d */
    private ArrayList f1327d;

    /* renamed from: e */
    private int f1328e;

    /* renamed from: f */
    private ArrayList f1329f;

    /* renamed from: g */
    private int f1330g;

    /* renamed from: h */
    private boolean f1331h;

    /* renamed from: i */
    private boolean f1332i;

    /* renamed from: j */
    private boolean f1333j;

    /* renamed from: k */
    private String[] f1334k;

    /* renamed from: l */
    private HashMap f1335l;

    /* renamed from: n */
    private InterfaceC0427ch f1337n;

    /* renamed from: m */
    private String f1336m = null;

    /* renamed from: o */
    private View.OnClickListener f1338o = new ViewOnClickListenerC0451p(this);

    public C0370ae(FastScrollableExpandableListView fastScrollableExpandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, boolean z, boolean z2, InterfaceC0427ch interfaceC0427ch, boolean z3) {
        this.f1324a = fastScrollableExpandableListView;
        this.f1325b = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1326c = context;
        this.f1327d = arrayList;
        this.f1328e = i;
        this.f1329f = arrayList2;
        this.f1330g = i2;
        this.f1331h = z;
        this.f1332i = z2;
        this.f1333j = z3;
        this.f1337n = interfaceC0427ch;
    }

    /* renamed from: a */
    public void m2363a(boolean z) {
        this.f1332i = z;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f1327d.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f1329f.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f1327d.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f1329f.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return this.f1337n.mo2198a((C0363a) ((ArrayList) this.f1329f.get(i)).get(i2));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        C0393ba c0393ba;
        if (getGroupType(i) == 0) {
            if (view == null) {
                View viewInflate = this.f1325b.inflate(this.f1328e, viewGroup, false);
                C0393ba c0393ba2 = new C0393ba((LinearLayout) viewInflate);
                viewInflate.setTag(c0393ba2);
                view = viewInflate;
                c0393ba = c0393ba2;
            } else {
                c0393ba = (C0393ba) view.getTag();
            }
            c0393ba.f1363a.setText(((C0364b) this.f1327d.get(i)).m2341b());
            c0393ba.f1364b.setText("(" + ((C0364b) this.f1327d.get(i)).m2342c() + ")");
            if (z) {
                c0393ba.f1365c.setBackgroundResource(R.drawable.title_arrow_up);
            } else {
                c0393ba.f1365c.setBackgroundResource(R.drawable.title_arrow_down);
            }
            view.setTag(c0393ba);
            return view;
        }
        if (view == null) {
            View view2 = new View(this.f1325b.getContext());
            view2.setVisibility(8);
            return view2;
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C0420ca c0420ca;
        if (view == null) {
            View viewInflate = this.f1325b.inflate(getChildType(i, i2) == 1 ? R.layout.buddy_adapter_child_item_highlight : this.f1330g, viewGroup, false);
            c0420ca = new C0420ca((ViewGroup) viewInflate);
            if (this.f1331h || !this.f1333j) {
                view = viewInflate;
            } else {
                c0420ca.f1396b.setOnClickListener(this.f1338o);
                view = viewInflate;
            }
        } else {
            c0420ca = (C0420ca) view.getTag();
        }
        C0363a c0363a = (C0363a) ((ArrayList) this.f1329f.get(i)).get(i2);
        c0420ca.f1396b.setTag(c0363a);
        if (!this.f1331h || c0363a.m2336v()) {
            c0420ca.f1395a.setVisibility(8);
        } else {
            c0420ca.f1395a.setVisibility(0);
            c0420ca.f1395a.setChecked(this.f1324a.m5846a(c0363a.m2308a()));
        }
        if (c0363a.m2336v()) {
            C1348w.m4685a(this.f1326c).m4698a(c0420ca.f1396b, EnumC1310bf.GROUP);
        } else {
            C1348w.m4685a(this.f1326c).m4700a(c0420ca.f1396b, c0363a.m2308a(), c0363a.m2332r());
        }
        c0363a.m2310a(c0420ca.f1396b);
        if (c0363a.m2336v()) {
            c0420ca.f1397c.setText(c0363a.m2314b() + " (" + (c0363a.m2337w() != null ? c0363a.m2337w().size() : 0) + ")");
        } else {
            c0420ca.f1397c.setText(c0363a.m2314b());
        }
        String strM2316c = c0363a.m2316c();
        if (c0363a.m2336v()) {
            if (c0363a.m2337w() != null) {
                Iterator it = c0363a.m2337w().keySet().iterator();
                StringBuffer stringBuffer = new StringBuffer();
                while (it.hasNext()) {
                    stringBuffer.append(((String) c0363a.m2337w().get(it.next())) + ", ");
                }
                C1341p.m4663f(stringBuffer.toString(), "BuddyFragment");
                strM2316c = stringBuffer.toString();
                if (strM2316c.endsWith(", ")) {
                    strM2316c = strM2316c.substring(0, strM2316c.length() - 2);
                }
            } else {
                strM2316c = "";
            }
        } else if (strM2316c == null || strM2316c.trim().length() == 0) {
            strM2316c = "";
        }
        c0420ca.f1398d.setText(strM2316c);
        if (c0363a.m2324j()) {
            c0420ca.f1398d.setTextColor(this.f1326c.getResources().getColor(R.color.buddy_list_item_status_highlight));
        } else if (c0363a.m2334t()) {
            c0420ca.f1398d.setTextColor(this.f1326c.getResources().getColor(R.color.buddy_list_item_status_changed));
        } else {
            c0420ca.f1398d.setTextColor(this.f1326c.getResources().getColor(R.color.buddy_list_item_status));
        }
        if (this.f1337n.mo2198a(c0363a)) {
            c0420ca.f1399e.setEnabled(true);
            if (c0363a.m2324j()) {
                c0420ca.f1397c.setTextColor(this.f1326c.getResources().getColor(R.color.buddy_list_item_name_highlight));
            } else {
                c0420ca.f1397c.setTextColor(this.f1326c.getResources().getColor(R.color.buddy_list_item_name));
            }
        } else {
            c0420ca.f1399e.setEnabled(false);
            c0420ca.f1397c.setTextColor(this.f1326c.getResources().getColor(R.color.gray));
        }
        view.setTag(c0420ca);
        return view;
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        if (i < this.f1334k.length) {
            return ((Integer) this.f1335l.get(this.f1334k[i])).intValue();
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f1334k;
    }

    /* renamed from: a */
    public void m2361a() {
        this.f1335l = new HashMap();
        for (int i = 0; i < this.f1327d.size(); i++) {
            if (((C0364b) this.f1327d.get(i)).m2343d() == 2) {
                this.f1335l.put(((C0364b) this.f1327d.get(i)).m2341b(), Integer.valueOf(i));
            }
        }
        this.f1334k = new String[this.f1327d.size()];
        for (int i2 = 0; i2 < this.f1327d.size(); i2++) {
            if (((C0364b) this.f1327d.get(i2)).m2343d() == 0 || ((C0364b) this.f1327d.get(i2)).m2343d() == -1 || ((C0364b) this.f1327d.get(i2)).m2343d() == 4) {
                this.f1334k[i2] = "";
            } else if (((C0364b) this.f1327d.get(i2)).m2343d() == 1) {
                this.f1334k[i2] = "★";
            } else {
                this.f1334k[i2] = ((C0364b) this.f1327d.get(i2)).m2341b().substring(0, 1);
            }
        }
    }

    /* renamed from: a */
    public void m2362a(String str) {
        if (str == null || str.trim().length() > 0) {
            this.f1336m = str;
            this.f1324a.invalidateViews();
        }
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupType(int i) {
        return this.f1332i ? 0 : 1;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getGroupTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildType(int i, int i2) {
        return ((C0363a) ((ArrayList) this.f1329f.get(i)).get(i2)).m2324j() ? 1 : 0;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.HeterogeneousExpandableList
    public int getChildTypeCount() {
        return 2;
    }
}
