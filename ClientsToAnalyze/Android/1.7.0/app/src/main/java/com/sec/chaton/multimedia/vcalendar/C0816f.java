package com.sec.chaton.multimedia.vcalendar;

import android.content.Context;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* compiled from: VCalendarListAdapter2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.f */
/* loaded from: classes.dex */
public class C0816f extends BaseExpandableListAdapter {

    /* renamed from: a */
    private ExpandableListView f2804a;

    /* renamed from: b */
    private Context f2805b;

    /* renamed from: c */
    private ArrayList f2806c;

    /* renamed from: d */
    private ArrayList f2807d;

    /* renamed from: e */
    private int f2808e;

    /* renamed from: f */
    private int f2809f;

    /* renamed from: g */
    private LayoutInflater f2810g;

    public C0816f(ExpandableListView expandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2) {
        this.f2804a = expandableListView;
        this.f2805b = context;
        this.f2806c = arrayList;
        this.f2807d = arrayList2;
        this.f2808e = i;
        this.f2809f = i2;
        this.f2810g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f2810g.inflate(this.f2808e, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.vcalendar_event_group_date);
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse((String) this.f2806c.get(i));
            Calendar.getInstance().setTime(date);
            String strM3342a = m3342a(new SimpleDateFormat("dd/MM/yyyy").format(date));
            textView.setText(new SimpleDateFormat("EEEE ", GlobalApplication.m3106g().getConfiguration().locale).format(date) + DateFormat.getDateFormat(GlobalApplication.m3100a()).format(date));
            if (strM3342a.length() > 0) {
                view.setBackgroundResource(R.drawable.sub_title_bg_press);
            } else {
                view.setBackgroundResource(R.drawable.sub_title_bg);
            }
        } catch (Exception e) {
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        String str;
        if (view == null) {
            view = this.f2810g.inflate(this.f2809f, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.vcalendar_event_title);
        TextView textView2 = (TextView) view.findViewById(R.id.vcalendar_event_child_date);
        C0817g c0817g = (C0817g) ((ArrayList) this.f2807d.get(i)).get(i2);
        textView.setText(c0817g.m3343a());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mma", GlobalApplication.m3106g().getConfiguration().locale);
        if (DateFormat.is24HourFormat(this.f2805b)) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", GlobalApplication.m3106g().getConfiguration().locale);
        }
        if (String.valueOf(c0817g.m3344b()).equals(String.valueOf(c0817g.m3345c()))) {
            str = "";
        } else {
            str = simpleDateFormat.format(new Date(c0817g.m3344b().longValue())) + " - " + simpleDateFormat.format(new Date(c0817g.m3345c().longValue()));
        }
        if (TextUtils.isEmpty(str)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
        return view;
    }

    /* renamed from: a */
    private String m3342a(String str) {
        if (!new SimpleDateFormat("dd/MM/yyyy").format(new Date()).equals(str)) {
            return "";
        }
        return "(" + this.f2805b.getResources().getString(R.string.list_vcalendar_today) + ") ";
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f2807d.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f2807d.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f2806c.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f2806c.size();
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
