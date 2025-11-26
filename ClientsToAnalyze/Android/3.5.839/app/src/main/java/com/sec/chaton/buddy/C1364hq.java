package com.sec.chaton.buddy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: MultipleExpandableAdapter.java */
/* renamed from: com.sec.chaton.buddy.hq */
/* loaded from: classes.dex */
public class C1364hq extends BaseExpandableListAdapter {

    /* renamed from: a */
    private Context f4955a;

    /* renamed from: b */
    private Map<String, List<String>> f4956b;

    /* renamed from: c */
    private List<String> f4957c;

    /* renamed from: d */
    private HashMap<Integer, Integer> f4958d = new HashMap<>();

    /* renamed from: e */
    private HashMap<String, String> f4959e;

    /* renamed from: f */
    private ExpandableListView f4960f;

    /* renamed from: g */
    private HashMap<String, String> f4961g;

    public C1364hq(Context context, List<String> list, Map<String, List<String>> map, HashMap<String, String> map2, HashMap<String, String> map3) {
        this.f4955a = context;
        this.f4956b = map;
        this.f4957c = list;
        this.f4959e = map2;
        this.f4961g = map3;
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f4956b.get(this.f4957c.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        String str = (String) getChild(i, i2);
        LayoutInflater layoutInflater = (LayoutInflater) this.f4955a.getSystemService("layout_inflater");
        if (view == null) {
            View viewInflate = layoutInflater.inflate(R.layout.list_item_common_1, (ViewGroup) null);
            ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
            view = viewInflate;
        }
        TextView textView = (TextView) view.findViewById(R.id.text1);
        CheckBox checkBox = (CheckBox) view.findViewById(android.R.id.checkbox);
        if (this.f4958d.get(Integer.valueOf(i)) != null && this.f4958d.get(Integer.valueOf(i)).intValue() == i2) {
            checkBox.setChecked(true);
        } else {
            checkBox.setChecked(false);
        }
        view.setOnClickListener(new ViewOnClickListenerC1365hr(this, checkBox, i, i2));
        textView.setText(str);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f4956b.get(this.f4957c.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f4957c.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f4957c.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        String str = (String) getGroup(i);
        if (view == null) {
            view = ((LayoutInflater) this.f4955a.getSystemService("layout_inflater")).inflate(R.layout.layout_common_group_header, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.text1)).setText(this.f4959e.get(str));
        if (this.f4960f == null) {
            this.f4960f = (ExpandableListView) viewGroup;
        }
        this.f4960f.expandGroup(i);
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    @Override // android.widget.BaseExpandableListAdapter, android.widget.ExpandableListAdapter
    public void onGroupCollapsed(int i) {
    }

    /* renamed from: a */
    public HashMap<String, String> m7499a() {
        return this.f4961g;
    }
}
