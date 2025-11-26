package com.sec.chaton.multimedia.vcalendar;

import android.content.Context;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.common.CommonApplication;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/* compiled from: VCalendarListAdapter2.java */
/* renamed from: com.sec.chaton.multimedia.vcalendar.e */
/* loaded from: classes.dex */
public class C2889e extends BaseExpandableListAdapter {

    /* renamed from: a */
    private Context f10654a;

    /* renamed from: b */
    private ArrayList<String> f10655b;

    /* renamed from: c */
    private ArrayList<ArrayList<C2890f>> f10656c;

    /* renamed from: d */
    private int f10657d;

    /* renamed from: e */
    private int f10658e;

    /* renamed from: f */
    private String f10659f = null;

    /* renamed from: g */
    private LayoutInflater f10660g;

    public C2889e(ExpandableListView expandableListView, Context context, ArrayList<String> arrayList, int i, ArrayList<ArrayList<C2890f>> arrayList2, int i2) {
        this.f10654a = context;
        this.f10655b = arrayList;
        this.f10656c = arrayList2;
        this.f10657d = i;
        this.f10658e = i2;
        this.f10660g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f10660g.inflate(this.f10657d, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.group_layout).findViewById(R.id.text1);
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(this.f10655b.get(i));
            Calendar.getInstance().setTime(date);
            boolean zM12052b = m12052b(new SimpleDateFormat("dd/MM/yyyy").format(date));
            textView.setText(new SimpleDateFormat("EEEE ", GlobalApplication.m10283b().getConfiguration().locale).format(date) + DateFormat.getDateFormat(CommonApplication.m18732r()).format(date));
            if (zM12052b) {
                view.setBackgroundResource(R.drawable.listview_selector_pressed);
            } else {
                view.setBackgroundResource(R.drawable.listview_selector);
            }
        } catch (Exception e) {
        }
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        String str;
        int iIndexOf;
        if (view == null) {
            view = this.f10660g.inflate(this.f10658e, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.text1);
        TextView textView2 = (TextView) view.findViewById(R.id.text2);
        C2890f c2890f = this.f10656c.get(i).get(i2);
        textView.setText(c2890f.m12054a(), TextView.BufferType.SPANNABLE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mma", GlobalApplication.m10283b().getConfiguration().locale);
        if (DateFormat.is24HourFormat(this.f10654a)) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", GlobalApplication.m10283b().getConfiguration().locale);
        }
        if (String.valueOf(c2890f.m12055b()).equals(String.valueOf(c2890f.m12056c()))) {
            str = "";
        } else {
            str = simpleDateFormat.format(new Date(c2890f.m12055b().longValue())) + " - " + simpleDateFormat.format(new Date(c2890f.m12056c().longValue()));
        }
        if (TextUtils.isEmpty(str)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
        if (this.f10659f != null && this.f10659f.length() > 0 && (iIndexOf = textView.getText().toString().toLowerCase().indexOf(this.f10659f.toString().toLowerCase())) >= 0) {
            int length = this.f10659f.length() + textView.getText().toString().toLowerCase().indexOf(this.f10659f.toString().toLowerCase());
            Spannable spannable = (Spannable) textView.getText();
            spannable.setSpan(new ForegroundColorSpan(GlobalApplication.m10283b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, length, 33);
            textView.setText(spannable);
        }
        return view;
    }

    /* renamed from: a */
    public void m12053a(String str) {
        this.f10659f = str;
    }

    /* renamed from: b */
    private boolean m12052b(String str) {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date()).equals(str);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f10656c.get(i).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f10656c.get(i).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f10655b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f10655b.size();
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
