package com.sec.chaton.buddy.honeycomb;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.HomeActivity;
import com.sec.chaton.R;
import com.sec.chaton.buddy.InterfaceC0298bj;
import com.sec.chaton.buddy.p010a.C0255a;
import com.sec.chaton.buddy.p010a.C0256b;
import com.sec.chaton.buddy.p010a.C0257c;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.util.C1734aq;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class BuddySelectFragment extends Fragment implements ExpandableListView.OnChildClickListener, ExpandableListView.OnGroupClickListener, ExpandableListView.OnGroupCollapseListener, ExpandableListView.OnGroupExpandListener, InterfaceC0298bj {

    /* renamed from: a */
    public static final String f1579a = BuddySelectFragment.class.getSimpleName();

    /* renamed from: A */
    private ExpandableListView f1580A;

    /* renamed from: B */
    private View f1581B;

    /* renamed from: C */
    private TextView f1582C;

    /* renamed from: D */
    private LinearLayout f1583D;

    /* renamed from: E */
    private ImageView f1584E;

    /* renamed from: F */
    private TextView f1585F;

    /* renamed from: G */
    private String f1586G;

    /* renamed from: b */
    private Context f1590b;

    /* renamed from: c */
    private Bundle f1591c;

    /* renamed from: d */
    private int f1592d;

    /* renamed from: e */
    private C0418a f1593e;

    /* renamed from: j */
    private C0256b f1598j;

    /* renamed from: l */
    private LinearLayout f1600l;

    /* renamed from: m */
    private LinearLayout f1601m;

    /* renamed from: n */
    private EditText f1602n;

    /* renamed from: o */
    private LinearLayout f1603o;

    /* renamed from: p */
    private TextView f1604p;

    /* renamed from: q */
    private TextView f1605q;

    /* renamed from: r */
    private Button f1606r;

    /* renamed from: s */
    private Button f1607s;

    /* renamed from: t */
    private LinearLayout f1608t;

    /* renamed from: u */
    private LinearLayout f1609u;

    /* renamed from: v */
    private Button f1610v;

    /* renamed from: w */
    private Button f1611w;

    /* renamed from: x */
    private LinearLayout f1612x;

    /* renamed from: y */
    private TextView f1613y;

    /* renamed from: z */
    private TextView f1614z;

    /* renamed from: f */
    private ArrayList f1594f = new ArrayList();

    /* renamed from: g */
    private ArrayList f1595g = new ArrayList();

    /* renamed from: h */
    private ArrayList f1596h = new ArrayList();

    /* renamed from: i */
    private String[] f1597i = null;

    /* renamed from: k */
    private C0431n f1599k = new C0431n(this);

    /* renamed from: H */
    private InterfaceC0432o f1587H = new C0423f(this);

    /* renamed from: I */
    private View.OnClickListener f1588I = new ViewOnClickListenerC0426i(this);

    /* renamed from: J */
    private TextWatcher f1589J = new C0428k(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        C1786r.m6067f("onCreate()", f1579a);
        this.f1590b = getActivity();
        this.f1591c = getArguments();
        this.f1586G = null;
        this.f1592d = this.f1591c.getInt("ACTION_PURPOSE");
        if (this.f1592d == 2) {
            this.f1598j = (C0256b) this.f1591c.get("ACTION_PURPOSE_ARG1");
            this.f1594f = (ArrayList) this.f1591c.get("ACTION_PURPOSE_ARG2");
            if (this.f1594f == null) {
                this.f1594f = new ArrayList();
            }
            C1786r.m6067f("onCreate() : " + this.f1594f.size(), f1579a);
            return;
        }
        if (this.f1592d == 3) {
            this.f1597i = this.f1591c.getStringArray("ACTION_PURPOSE_ARG2");
            return;
        }
        if (this.f1592d == 4 || this.f1592d == 5 || this.f1592d == 6) {
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C1786r.m6067f("onCreateView()", f1579a);
        return layoutInflater.inflate(R.layout.buddy_select_layout, viewGroup, false);
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) throws Resources.NotFoundException {
        super.onActivityCreated(bundle);
        C1786r.m6067f("onActivityCreated()", f1579a);
        m2414a();
        this.f1593e = new C0418a(this.f1580A, getActivity(), this, this.f1595g, R.layout.buddy_select_group_item, this.f1596h, R.layout.buddy_select_child_item, this.f1592d, this.f1587H);
        this.f1580A.setAdapter(this.f1593e);
        if (this.f1592d == 2) {
            m2419b();
            this.f1593e.notifyDataSetChanged();
            for (int i = 0; i < this.f1595g.size(); i++) {
                this.f1580A.expandGroup(i);
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        C1786r.m6067f("onStart()", f1579a);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        C1786r.m6067f("onResume()", f1579a);
        this.f1602n.setText(this.f1586G);
        this.f1602n.addTextChangedListener(this.f1589J);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.f1586G = this.f1602n.getText().toString().trim();
        C1786r.m6067f("onPause()", f1579a);
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        this.f1602n.removeTextChangedListener(this.f1589J);
        super.onStop();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    /* renamed from: a */
    private void m2414a() throws Resources.NotFoundException {
        this.f1600l = (LinearLayout) getView().findViewById(R.id.buddy_select_group_name_layout);
        this.f1601m = (LinearLayout) getView().findViewById(R.id.buddy_select_group_name_edit_layout);
        this.f1602n = (EditText) getView().findViewById(R.id.buddy_select_group_name_edit);
        this.f1612x = (LinearLayout) getView().findViewById(R.id.buddy_select_group_member_layout);
        this.f1613y = (TextView) getView().findViewById(R.id.buddy_select_group_member);
        this.f1614z = (TextView) getView().findViewById(R.id.buddy_select_group_member_participant);
        this.f1608t = (LinearLayout) getView().findViewById(R.id.buddy_select_for_call_layout);
        this.f1609u = (LinearLayout) getView().findViewById(R.id.buddy_select_call_type_layout);
        this.f1611w = (Button) getView().findViewById(R.id.buddy_select_voice_call);
        this.f1610v = (Button) getView().findViewById(R.id.buddy_select_video_call);
        this.f1611w.setOnClickListener(this.f1588I);
        this.f1610v.setOnClickListener(this.f1588I);
        this.f1603o = (LinearLayout) getView().findViewById(R.id.buddy_select_group_chat_broadcast_layout);
        this.f1604p = (TextView) getView().findViewById(R.id.buddy_select_group_name_4_chat);
        this.f1605q = (TextView) getView().findViewById(R.id.buddy_select_group_count_4_chat);
        this.f1606r = (Button) getView().findViewById(R.id.buddy_select_group_chat);
        this.f1607s = (Button) getView().findViewById(R.id.buddy_select_group_broadcast);
        this.f1606r.setOnClickListener(this.f1588I);
        this.f1607s.setOnClickListener(this.f1588I);
        this.f1581B = getActivity().getLayoutInflater().inflate(R.layout.buddy_select_footer, (ViewGroup) null);
        this.f1580A = (ExpandableListView) getView().findViewById(R.id.buddy_select_list);
        this.f1580A.setOnGroupClickListener(this);
        this.f1580A.setOnChildClickListener(this);
        this.f1582C = (TextView) this.f1581B.findViewById(R.id.buddy_select_footer_layout);
        this.f1582C.setOnClickListener(new ViewOnClickListenerC0424g(this));
        this.f1583D = (LinearLayout) getView().findViewById(R.id.buddy_select_list_nobuddy_layout);
        this.f1583D.setOnClickListener(new ViewOnClickListenerC0425h(this));
        this.f1584E = (ImageView) getView().findViewById(R.id.buddy_select_list_nobuddy_image);
        this.f1585F = (TextView) getView().findViewById(R.id.buddy_select_list_nobuddy_text);
        if (this.f1592d == 1 || this.f1592d == 3) {
            if (this.f1592d == 3) {
                this.f1602n.setText(this.f1591c.getString("ACTION_PURPOSE_ARG1"));
            }
            this.f1600l.setVisibility(0);
            if (this.f1592d != 1 && this.f1592d == 3) {
            }
            this.f1612x.setVisibility(0);
            this.f1613y.setText(String.format(getString(R.string.buddy_select_no_list_select_buddies), 0));
            this.f1580A.setVisibility(8);
            this.f1583D.setVisibility(0);
            m2430a(0);
            if (this.f1592d == 1) {
                this.f1602n.requestFocus();
                m2415a(this.f1602n);
            }
            if (this.f1592d == 3) {
                m2429f();
                return;
            }
            return;
        }
        if (this.f1592d == 2) {
            this.f1603o.setVisibility(0);
            if (this.f1598j != null) {
                this.f1604p.setText(this.f1598j.m2316b());
                this.f1605q.setText("(" + this.f1598j.m2317c() + ")");
            }
            if (this.f1594f.size() > 0) {
                this.f1580A.setVisibility(0);
                this.f1583D.setVisibility(8);
            } else {
                this.f1580A.setVisibility(8);
                this.f1583D.setVisibility(0);
                this.f1585F.setText(getString(R.string.buddy_select_no_list_add_members));
            }
            if (this.f1598j != null && this.f1598j.m2317c() > 0) {
                this.f1606r.setEnabled(true);
                this.f1607s.setEnabled(true);
                return;
            } else {
                this.f1606r.setEnabled(false);
                this.f1607s.setEnabled(false);
                return;
            }
        }
        if (this.f1592d == 7) {
            this.f1608t.setVisibility(0);
            this.f1609u.setVisibility(0);
            if (this.f1594f != null && this.f1594f.size() > 0) {
                this.f1610v.setEnabled(true);
                this.f1611w.setEnabled(true);
            } else {
                this.f1610v.setEnabled(false);
                this.f1611w.setEnabled(false);
            }
            this.f1612x.setVisibility(0);
            this.f1613y.setText("Selected buddies");
            this.f1580A.setVisibility(8);
            this.f1583D.setVisibility(0);
            return;
        }
        if (this.f1592d == 4 || this.f1592d == 5 || this.f1592d == 6) {
            this.f1600l.setVisibility(8);
            this.f1603o.setVisibility(8);
            this.f1612x.setVisibility(0);
            this.f1613y.setText(getString(R.string.buddy_select_no_list_select_buddies));
            this.f1580A.setVisibility(8);
            this.f1583D.setVisibility(0);
        }
    }

    /* renamed from: b */
    private void m2419b() {
        ArrayList arrayList;
        int i = 2;
        Collections.sort(this.f1594f, this.f1599k);
        this.f1595g.clear();
        this.f1596h.clear();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.f1594f.iterator();
        ArrayList arrayList3 = arrayList2;
        int i2 = 0;
        char c = 0;
        while (it.hasNext()) {
            C0257c c0257c = (C0257c) it.next();
            c0257c.m2322a(true);
            char cM5917a = C1734aq.m5917a(Character.toUpperCase(c0257c.m2324b().charAt(0)));
            if (c == cM5917a || c == 0) {
                arrayList = arrayList3;
            } else {
                this.f1596h.add(arrayList3);
                this.f1595g.add(new C0255a(i, String.valueOf(c), i2, 3, false, false, 0));
                arrayList = new ArrayList();
                i2 = 0;
                i++;
            }
            arrayList.add(new C0257c(c0257c));
            i2++;
            arrayList3 = arrayList;
            c = cM5917a;
        }
        this.f1596h.add(arrayList3);
        int i3 = i + 1;
        this.f1595g.add(new C0255a(i, String.valueOf(c), i2, 3, false, false, 0));
    }

    /* renamed from: d */
    private boolean m2426d(String str) {
        Iterator it = this.f1594f.iterator();
        while (it.hasNext()) {
            if (((C0257c) it.next()).m2318a().equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m2422c() {
        int i = 0;
        Iterator it = this.f1594f.iterator();
        while (true) {
            int i2 = i;
            if (it.hasNext()) {
                i = ((C0257c) it.next()).m2345q() ? i2 + 1 : i2;
            } else {
                return i2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public ArrayList m2425d() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f1594f.iterator();
        while (it.hasNext()) {
            C0257c c0257c = (C0257c) it.next();
            if (c0257c.m2345q()) {
                arrayList.add(c0257c.m2318a());
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private void m2421b(C0257c c0257c) {
        Iterator it = this.f1594f.iterator();
        while (it.hasNext()) {
            C0257c c0257c2 = (C0257c) it.next();
            if (c0257c2.m2318a().equals(c0257c.m2318a())) {
                c0257c2.m2322a(c0257c.m2345q());
                return;
            }
        }
    }

    /* renamed from: a */
    public void m2432a(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1594f.size()) {
                if (!((C0257c) this.f1594f.get(i2)).m2318a().equals(str)) {
                    i = i2 + 1;
                } else {
                    this.f1594f.remove(i2);
                    return;
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: b */
    public boolean m2433b(String str) {
        for (String str2 : this.f1597i) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public void m2434c(String str) {
        this.f1614z.setText(str);
        this.f1614z.setVisibility(0);
    }

    /* renamed from: a */
    public void m2430a(int i) {
        this.f1613y.setText(String.format(getString(R.string.buddy_select_category_group_member), Integer.valueOf(i)));
        this.f1614z.setVisibility(4);
    }

    /* renamed from: e */
    private void m2427e() {
        if (this.f1592d == 2) {
            this.f1606r.setEnabled(false);
            this.f1607s.setEnabled(false);
            if (m2422c() > 0 && m2422c() + 1 <= 199) {
                this.f1606r.setEnabled(true);
            }
            if (m2422c() > 0 && m2422c() <= 200) {
                this.f1607s.setEnabled(true);
            }
        }
    }

    @Override // com.sec.chaton.buddy.InterfaceC0298bj
    /* renamed from: a */
    public void mo2367a(C0257c c0257c) {
        C1786r.m6067f("onBuddyClick() : " + c0257c.m2324b() + ", " + c0257c.m2345q(), f1579a);
        if (this.f1592d == 1 || this.f1592d == 3 || this.f1592d == 4 || this.f1592d == 5 || this.f1592d == 6 || this.f1592d == 7) {
            if (c0257c.m2345q()) {
                if (!m2426d(c0257c.m2318a())) {
                    this.f1594f.add(c0257c);
                }
            } else {
                m2432a(c0257c.m2318a());
            }
            if (this.f1594f.size() > 0) {
                if (this.f1592d == 1 || this.f1592d == 4 || this.f1592d == 5 || this.f1592d == 6 || this.f1592d == 7) {
                    ArrayList arrayList = new ArrayList();
                    Iterator it = this.f1594f.iterator();
                    while (it.hasNext()) {
                        arrayList.add(new C0257c((C0257c) it.next()));
                    }
                    this.f1595g.clear();
                    this.f1596h.clear();
                    if (this.f1592d == 1) {
                        this.f1595g.add(new C0255a(-1, "New", this.f1594f.size(), 1, false, false, 0));
                    } else if (this.f1592d == 4) {
                        this.f1595g.add(new C0255a(-1, "Groupchat", this.f1594f.size(), 3, false, false, 0));
                    } else if (this.f1592d == 5) {
                        this.f1595g.add(new C0255a(-1, "Broadcast", this.f1594f.size(), 3, false, false, 0));
                    } else if (this.f1592d == 6) {
                        this.f1595g.add(new C0255a(-1, "Invite", this.f1594f.size(), 3, false, false, 0));
                    } else if (this.f1592d == 7) {
                        this.f1595g.add(new C0255a(-1, "Call", this.f1594f.size(), 3, false, false, 0));
                        this.f1610v.setEnabled(true);
                        this.f1611w.setEnabled(true);
                    }
                    this.f1596h.add(arrayList);
                } else if (this.f1592d == 3) {
                    this.f1595g.clear();
                    this.f1596h.clear();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = this.f1594f.iterator();
                    while (it2.hasNext()) {
                        C0257c c0257c2 = (C0257c) it2.next();
                        if (m2433b(c0257c2.m2318a())) {
                            arrayList3.add(c0257c2);
                        } else {
                            arrayList2.add(c0257c2);
                        }
                    }
                    if (arrayList2.size() > 0) {
                        this.f1595g.add(new C0255a(-1, getResources().getString(R.string.buddy_select_group_profile_new_header), arrayList2.size(), 1, false, false, 0));
                        this.f1596h.add(arrayList2);
                    }
                    if (arrayList3.size() > 0) {
                        this.f1595g.add(new C0255a(-1, getResources().getString(R.string.buddy_select_group_profile_existing_header), arrayList3.size(), 2, false, false, 0));
                        this.f1596h.add(arrayList3);
                    }
                }
                this.f1580A.setVisibility(0);
                this.f1583D.setVisibility(8);
                this.f1593e.notifyDataSetChanged();
                for (int i = 0; i < this.f1595g.size(); i++) {
                    this.f1580A.expandGroup(i);
                }
            } else {
                this.f1580A.setVisibility(8);
                this.f1583D.setVisibility(0);
                this.f1610v.setEnabled(false);
                this.f1611w.setEnabled(false);
            }
            if (this.f1592d == 3 || this.f1592d == 1) {
                m2430a(this.f1594f.size());
            } else {
                m2434c("(" + this.f1594f.size() + ")");
            }
            m2417a(true);
        }
    }

    /* renamed from: a */
    public void m2431a(InterfaceC0432o interfaceC0432o) {
        this.f1587H = interfaceC0432o;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m2429f() throws Resources.NotFoundException {
        Drawable drawable = getResources().getDrawable(R.drawable.chaton_ic_field_x_nor);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        if (this.f1602n.getText().toString().length() > 0) {
            this.f1602n.setCompoundDrawables(null, null, drawable, null);
            this.f1602n.setOnClickListener(new ViewOnClickListenerC0429l(this));
            this.f1602n.setOnTouchListener(new ViewOnTouchListenerC0430m(this, drawable));
        } else {
            this.f1602n.setCompoundDrawables(null, null, null, null);
            this.f1602n.setOnTouchListener(null);
        }
    }

    @Override // android.widget.ExpandableListView.OnChildClickListener
    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        C1786r.m6067f("onChildClick() : " + i + ", " + i2, f1579a);
        C0257c c0257c = (C0257c) ((ArrayList) this.f1596h.get(i)).get(i2);
        if (this.f1592d == 2 || this.f1592d == 7) {
            CheckBox checkBox = (CheckBox) view.findViewById(R.id.buddy_select_child_check);
            if (checkBox.isChecked()) {
                checkBox.setChecked(false);
            } else {
                checkBox.setChecked(true);
            }
            c0257c.m2322a(checkBox.isChecked());
            m2421b(c0257c);
            m2427e();
            this.f1580A.invalidateViews();
        } else if (this.f1592d == 3) {
            Intent intentM585a = HomeActivity.m585a((Context) getActivity(), true);
            intentM585a.putExtra("chatType", EnumC0695j.ONETOONE.m3146a());
            intentM585a.putExtra("receivers", new String[]{c0257c.m2318a()});
            startActivity(intentM585a);
        }
        return false;
    }

    @Override // android.widget.ExpandableListView.OnGroupClickListener
    public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        C1786r.m6067f("onGroupClick() : " + i, f1579a);
        m2417a(false);
        return false;
    }

    @Override // android.widget.ExpandableListView.OnGroupExpandListener
    public void onGroupExpand(int i) {
    }

    @Override // android.widget.ExpandableListView.OnGroupCollapseListener
    public void onGroupCollapse(int i) {
    }

    /* renamed from: a */
    private void m2415a(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            inputMethodManager.showSoftInputFromInputMethod(view.getWindowToken(), 0);
            inputMethodManager.showSoftInput(view, 1);
        } catch (Exception e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m2420b(View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService("input_method");
            if (inputMethodManager != null && view != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    private void m2417a(boolean z) {
        int i;
        int i2 = 0;
        int i3 = 0;
        while (i2 < this.f1595g.size()) {
            int size = i3 + 36;
            C1786r.m6067f("******* " + size, f1579a);
            if (this.f1580A.isGroupExpanded(i2) == z) {
                size += ((ArrayList) this.f1596h.get(i2)).size() * 75;
                C1786r.m6067f("******* " + size, f1579a);
            }
            i2++;
            i3 = size;
        }
        if (getResources().getConfiguration().orientation == 2) {
            i = 576 - i3;
            C1786r.m6067f("******* ORIENTATION_LANDSCAPE : " + i, f1579a);
        } else {
            i = 1057 - i3;
            C1786r.m6067f("******* ORIENTATION_PORTRAIT : " + i, f1579a);
        }
        this.f1582C.setLayoutParams(new LinearLayout.LayoutParams(-1, i >= 0 ? i : 0));
    }

    @Override // android.support.v4.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2 || configuration.orientation == 1) {
            m2417a(true);
        }
    }
}
