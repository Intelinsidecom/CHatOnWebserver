package com.sec.chaton.multimedia.vcalendar;

import android.content.Context;
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
/* renamed from: com.sec.chaton.multimedia.vcalendar.e */
/* loaded from: classes.dex */
public class C1025e extends BaseExpandableListAdapter {

    /* renamed from: a */
    private ExpandableListView f3757a;

    /* renamed from: b */
    private Context f3758b;

    /* renamed from: c */
    private ArrayList f3759c;

    /* renamed from: d */
    private ArrayList f3760d;

    /* renamed from: e */
    private int f3761e;

    /* renamed from: f */
    private int f3762f;

    /* renamed from: g */
    private LayoutInflater f3763g;

    public C1025e(ExpandableListView expandableListView, Context context, ArrayList arrayList, int i, ArrayList arrayList2, int i2) {
        this.f3757a = expandableListView;
        this.f3758b = context;
        this.f3759c = arrayList;
        this.f3760d = arrayList2;
        this.f3761e = i;
        this.f3762f = i2;
        this.f3763g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f3763g.inflate(this.f3761e, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.vcalendar_event_group_date);
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse((String) this.f3759c.get(i));
            Calendar.getInstance().setTime(date);
            String strM3985a = m3985a(new SimpleDateFormat("dd/MM/yyyy").format(date));
            textView.setText(new SimpleDateFormat("EEEE dd/MM/yyyy", GlobalApplication.m3262c().getConfiguration().locale).format(date));
            if (strM3985a.length() > 0) {
                view.setBackgroundResource(R.drawable.sub_title_bg);
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
            view = this.f3763g.inflate(this.f3762f, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.vcalendar_event_title);
        TextView textView2 = (TextView) view.findViewById(R.id.vcalendar_event_child_date);
        C1026f c1026f = (C1026f) ((ArrayList) this.f3760d.get(i)).get(i2);
        textView.setText(c1026f.m3987b());
        if (String.valueOf(c1026f.m3988c()).equals(String.valueOf(c1026f.m3989d()))) {
            str = "";
        } else {
            str = new SimpleDateFormat("hh:mma", GlobalApplication.m3262c().getConfiguration().locale).format(new Date(c1026f.m3988c().longValue())) + " - " + new SimpleDateFormat("hh:mma", GlobalApplication.m3262c().getConfiguration().locale).format(new Date(c1026f.m3989d().longValue()));
        }
        textView2.setText(str);
        return view;
    }

    /* renamed from: a */
    private String m3985a(String str) {
        if (!new SimpleDateFormat("dd/MM/yyyy").format(new Date()).equals(str)) {
            return "";
        }
        return "(" + this.f3758b.getResources().getString(R.string.list_vcalendar_today) + ") ";
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return ((ArrayList) this.f3760d.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return ((ArrayList) this.f3760d.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f3759c.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f3759c.size();
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
