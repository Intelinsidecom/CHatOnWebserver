package com.sec.chaton.multimedia.vcalendar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.sec.chaton.C0062R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class VCalendarListAdapter2 extends BaseExpandableListAdapter {

    /* renamed from: a */
    private ExpandableListView f2206a;

    /* renamed from: b */
    private Context f2207b;

    /* renamed from: c */
    private ArrayList f2208c;

    /* renamed from: d */
    private ArrayList f2209d;

    /* renamed from: e */
    private int f2210e;

    /* renamed from: f */
    private int f2211f;

    /* renamed from: g */
    private LayoutInflater f2212g;

    public VCalendarListAdapter2(ExpandableListView expandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2) {
        this.f2206a = expandableListView;
        this.f2207b = context;
        this.f2208c = arrayList;
        this.f2209d = arrayList2;
        this.f2210e = i;
        this.f2211f = i2;
        this.f2212g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    /* renamed from: a */
    private String m2581a(String str) {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date()).equals(str) ? "(" + this.f2207b.getResources().getString(C0062R.string.list_vcalendar_today) + ") " : "";
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f2209d.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f2212g.inflate(this.f2211f, viewGroup, false) : view;
        TextView textView = (TextView) viewInflate.findViewById(C0062R.id.vcalendar_event_title);
        TextView textView2 = (TextView) viewInflate.findViewById(C0062R.id.vcalendar_event_child_date);
        VCalendarListChildItem vCalendarListChildItem = (VCalendarListChildItem) ((ArrayList) this.f2209d.get(i)).get(i2);
        textView.setText(vCalendarListChildItem.m2582a());
        textView2.setText((String.valueOf(vCalendarListChildItem.m2583b()).equals(String.valueOf(vCalendarListChildItem.m2584c())) ? "" : new SimpleDateFormat("hh:ssa", Locale.US).format(new Date(vCalendarListChildItem.m2583b().longValue())) + " - " + new SimpleDateFormat("hh:ssa", Locale.US).format(new Date(vCalendarListChildItem.m2584c().longValue()))).toLowerCase());
        return viewInflate;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f2209d.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f2208c.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f2208c.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View viewInflate = view == null ? this.f2212g.inflate(this.f2210e, viewGroup, false) : view;
        TextView textView = (TextView) viewInflate.findViewById(C0062R.id.vcalendar_event_group_date);
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse((String) this.f2208c.get(i));
            Calendar.getInstance().setTime(date);
            String strM2581a = m2581a(new SimpleDateFormat("dd/MM/yyyy").format(date));
            textView.setText(new SimpleDateFormat("dd MMM, yyyy", Locale.US).format(date));
            if (strM2581a.length() > 0) {
                viewInflate.setBackgroundResource(C0062R.drawable.co_sub_title_today_bg);
            } else {
                viewInflate.setBackgroundResource(C0062R.drawable.co_sub_title_bg);
            }
        } catch (Exception e) {
        }
        return viewInflate;
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
