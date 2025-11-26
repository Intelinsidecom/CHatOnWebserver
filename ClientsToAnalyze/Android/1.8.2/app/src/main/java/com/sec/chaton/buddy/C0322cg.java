package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.buddy.p010a.C0255a;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.EnumC1748bd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: BuddyGroupEditAdapter.java */
/* renamed from: com.sec.chaton.buddy.cg */
/* loaded from: classes.dex */
public class C0322cg extends BaseExpandableListAdapter implements SectionIndexer {

    /* renamed from: a */
    private LayoutInflater f1442a;

    /* renamed from: b */
    private Context f1443b;

    /* renamed from: c */
    private ExpandableListView f1444c;

    /* renamed from: d */
    private int f1445d;

    /* renamed from: e */
    private int f1446e;

    /* renamed from: f */
    private LinearLayout f1447f;

    /* renamed from: g */
    private boolean f1448g;

    /* renamed from: h */
    private boolean f1449h;

    /* renamed from: i */
    private int f1450i;

    /* renamed from: j */
    private ArrayList f1451j;

    /* renamed from: k */
    private ArrayList f1452k;

    /* renamed from: l */
    private HashMap f1453l;

    /* renamed from: m */
    private String[] f1454m;

    /* renamed from: n */
    private TextView f1455n;

    /* renamed from: o */
    private HorizontalScrollView f1456o;

    /* renamed from: p */
    private View.OnClickListener f1457p = new ViewOnClickListenerC0324ci(this);

    public C0322cg(ExpandableListView expandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2, LinearLayout linearLayout, boolean z, int i3, TextView textView) {
        this.f1444c = expandableListView;
        this.f1442a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.f1443b = context;
        this.f1451j = arrayList;
        this.f1445d = i;
        this.f1452k = arrayList2;
        this.f1446e = i2;
        this.f1447f = linearLayout;
        this.f1448g = z;
        this.f1450i = i3;
        this.f1455n = textView;
        if (this.f1450i == 2) {
            this.f1449h = true;
        } else {
            this.f1449h = false;
        }
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f1451j.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f1452k.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f1451j.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f1452k.get(i)).get(i2);
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
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (this.f1448g) {
            return this.f1442a.inflate(R.layout.buddy_adapter_group_item_gone, viewGroup, false);
        }
        View viewInflate = this.f1442a.inflate(this.f1445d, viewGroup, false);
        C0327cl c0327cl = new C0327cl((LinearLayout) viewInflate);
        c0327cl.f1467a.setText(((C0255a) this.f1451j.get(i)).m2307b());
        c0327cl.f1468b.setText("(" + ((C0255a) this.f1451j.get(i)).m2308c() + ")");
        if (z) {
            c0327cl.f1469c.setBackgroundResource(R.drawable.messenger_subtitle_icon_up);
        } else {
            c0327cl.f1469c.setBackgroundResource(R.drawable.messenger_subtitle_icon_down);
        }
        viewInflate.setTag(c0327cl);
        return viewInflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        C0326ck c0326ck;
        if (view == null) {
            View viewInflate = this.f1442a.inflate(this.f1446e, viewGroup, false);
            view = viewInflate;
            c0326ck = new C0326ck((RelativeLayout) viewInflate);
        } else {
            c0326ck = (C0326ck) view.getTag();
        }
        c0326ck.f1465c.setText(((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2324b());
        String strM2327c = ((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2327c();
        c0326ck.f1466d.setText(strM2327c);
        if (((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2350v() || strM2327c == null || strM2327c.equals("")) {
            c0326ck.f1466d.setVisibility(4);
        } else {
            c0326ck.f1466d.setVisibility(0);
        }
        if (!this.f1449h || ((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2350v()) {
            c0326ck.f1463a.setVisibility(8);
            c0326ck.f1463a.setOnClickListener(null);
        } else {
            c0326ck.f1463a.setVisibility(0);
            c0326ck.f1463a.setOnClickListener(new ViewOnClickListenerC0323ch(this, i, i2));
            if (((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2345q()) {
                c0326ck.f1463a.setChecked(true);
            } else {
                c0326ck.f1463a.setChecked(false);
            }
        }
        if (((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2350v()) {
            C1746bb.m5945a(this.f1443b).m5958a(c0326ck.f1464b, EnumC1748bd.GROUP);
        } else {
            C1746bb.m5945a(this.f1443b).m5960a(c0326ck.f1464b, ((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2318a(), ((C0257c) ((ArrayList) this.f1452k.get(i)).get(i2)).m2346r());
        }
        view.setTag(c0326ck);
        return view;
    }

    /* renamed from: a */
    public void m2398a(int i) {
        ArrayList arrayListM2397a = m2397a();
        if (arrayListM2397a.size() > 0) {
            if (i == 1) {
                ((Button) this.f1447f.findViewById(R.id.buddy_remove_to_group)).setEnabled(true);
                return;
            }
            if (i == 2) {
                ((Button) this.f1447f.findViewById(R.id.buddy_add_to_group)).setEnabled(true);
                return;
            }
            if (i == 3) {
                if (arrayListM2397a.size() < 199) {
                    ((Button) this.f1447f.findViewById(R.id.buddy_menu_groupchat)).setEnabled(true);
                } else {
                    ((Button) this.f1447f.findViewById(R.id.buddy_menu_groupchat)).setEnabled(false);
                }
                if (arrayListM2397a.size() <= 200) {
                    ((Button) this.f1447f.findViewById(R.id.buddy_menu_broadcast)).setEnabled(true);
                    return;
                } else {
                    ((Button) this.f1447f.findViewById(R.id.buddy_menu_broadcast)).setEnabled(false);
                    return;
                }
            }
            return;
        }
        ((Button) this.f1447f.findViewById(R.id.buddy_add_to_group)).setEnabled(false);
        ((Button) this.f1447f.findViewById(R.id.buddy_remove_to_group)).setEnabled(false);
        ((Button) this.f1447f.findViewById(R.id.buddy_menu_groupchat)).setEnabled(false);
        ((Button) this.f1447f.findViewById(R.id.buddy_menu_broadcast)).setEnabled(false);
    }

    /* renamed from: a */
    public ArrayList m2397a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1452k.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2345q() && !arrayList.contains(c0257c.m2318a())) {
                    arrayList.add(c0257c.m2318a());
                }
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public void m2404b() {
        this.f1453l = new HashMap();
        for (int i = 0; i < this.f1451j.size(); i++) {
            if (((C0255a) this.f1451j.get(i)).m2309d() == 2) {
                this.f1453l.put(((C0255a) this.f1451j.get(i)).m2307b(), Integer.valueOf(i));
            }
        }
        this.f1454m = new String[this.f1451j.size()];
        for (int i2 = 0; i2 < this.f1451j.size(); i2++) {
            if (((C0255a) this.f1451j.get(i2)).m2309d() == 0 || ((C0255a) this.f1451j.get(i2)).m2309d() == -1 || ((C0255a) this.f1451j.get(i2)).m2309d() == 4) {
                this.f1454m[i2] = "";
            } else if (((C0255a) this.f1451j.get(i2)).m2309d() == 1) {
                this.f1454m[i2] = "★";
            } else {
                this.f1454m[i2] = ((C0255a) this.f1451j.get(i2)).m2307b().substring(0, 1);
            }
        }
    }

    @Override // android.widget.SectionIndexer
    public int getPositionForSection(int i) {
        if (i < this.f1454m.length) {
            return ((Integer) this.f1453l.get(this.f1454m[i])).intValue();
        }
        return -1;
    }

    @Override // android.widget.SectionIndexer
    public int getSectionForPosition(int i) {
        return 0;
    }

    @Override // android.widget.SectionIndexer
    public Object[] getSections() {
        return this.f1454m;
    }

    /* renamed from: a */
    public void m2402a(String str, boolean z) {
        Iterator it = this.f1452k.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) it.next()).iterator();
            while (it2.hasNext()) {
                C0257c c0257c = (C0257c) it2.next();
                if (c0257c.m2318a().equals(str)) {
                    c0257c.m2322a(z);
                    if (z) {
                        m2401a(str, c0257c.m2324b());
                    } else {
                        m2400a(str);
                    }
                }
            }
        }
        if (this.f1450i == 2) {
            this.f1455n.setText(this.f1443b.getString(R.string.buddy_group_profile_title_add_member) + " (" + ((LinearLayout) this.f1456o.getChildAt(0)).getChildCount() + ")");
        }
    }

    /* renamed from: a */
    public void m2399a(HorizontalScrollView horizontalScrollView) {
        this.f1456o = horizontalScrollView;
        this.f1456o.setVisibility(8);
    }

    /* renamed from: a */
    public void m2401a(String str, String str2) {
        if (this.f1456o != null) {
            if (str2.length() > 10) {
                str2 = str2.substring(0, 10) + "...";
            }
            LinearLayout linearLayout = (LinearLayout) this.f1456o.getChildAt(0);
            if (linearLayout.findViewWithTag(str) == null) {
                Button button = new Button(this.f1456o.getContext());
                button.setOnClickListener(this.f1457p);
                button.setText(str2);
                button.setTag(str);
                button.setBackgroundResource(R.drawable.btn_choice_panel_xml);
                button.setTextColor(this.f1443b.getResources().getColorStateList(R.color.buddy_list_selected_buddy_xml));
                button.setTextSize(1, 16.0f);
                int i = (int) ((8.0d * this.f1443b.getResources().getDisplayMetrics().density) + 0.5d);
                button.setPadding(i, 0, i, 0);
                linearLayout.addView(button, -2, -1);
                ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(button.getLayoutParams());
                marginLayoutParams.setMargins(3, 0, 3, 0);
                button.setLayoutParams(new LinearLayout.LayoutParams(marginLayoutParams));
                if (this.f1456o.getVisibility() == 8) {
                    this.f1456o.setVisibility(0);
                }
                this.f1456o.post(new RunnableC0325cj(this));
            }
        }
    }

    /* renamed from: a */
    public void m2400a(String str) {
        LinearLayout linearLayout;
        View viewFindViewWithTag;
        if (this.f1456o != null && (viewFindViewWithTag = (linearLayout = (LinearLayout) this.f1456o.getChildAt(0)).findViewWithTag(str)) != null) {
            linearLayout.removeView(viewFindViewWithTag);
            if (linearLayout.getChildCount() == 0 && this.f1456o.getVisibility() == 0) {
                this.f1456o.setVisibility(8);
            }
        }
    }

    /* renamed from: c */
    public void m2406c() {
        if (this.f1456o != null) {
            ((LinearLayout) this.f1456o.getChildAt(0)).removeAllViews();
            this.f1456o.setVisibility(8);
        }
    }

    /* renamed from: a */
    public void m2403a(boolean z) {
        this.f1448g = z;
    }

    /* renamed from: b */
    public void m2405b(boolean z) {
        this.f1449h = z;
    }

    /* renamed from: d */
    public boolean m2407d() {
        return this.f1449h;
    }
}
