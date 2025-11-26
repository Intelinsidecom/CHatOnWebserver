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
public class C1920e extends BaseExpandableListAdapter {

    /* renamed from: a */
    private Context f7333a;

    /* renamed from: b */
    private ArrayList<String> f7334b;

    /* renamed from: c */
    private ArrayList<ArrayList<C1921f>> f7335c;

    /* renamed from: d */
    private int f7336d;

    /* renamed from: e */
    private int f7337e;

    /* renamed from: f */
    private String f7338f = null;

    /* renamed from: g */
    private LayoutInflater f7339g;

    public C1920e(ExpandableListView expandableListView, Context context, ArrayList<String> arrayList, int i, ArrayList<ArrayList<C1921f>> arrayList2, int i2) {
        this.f7333a = context;
        this.f7334b = arrayList;
        this.f7335c = arrayList2;
        this.f7336d = i;
        this.f7337e = i2;
        this.f7339g = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7339g.inflate(this.f7336d, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.group_layout).findViewById(R.id.text1);
        try {
            Date date = new SimpleDateFormat("yyyy/MM/dd").parse(this.f7334b.get(i));
            Calendar.getInstance().setTime(date);
            boolean zM7822b = m7822b(new SimpleDateFormat("dd/MM/yyyy").format(date));
            textView.setText(new SimpleDateFormat("EEEE ", GlobalApplication.m6451b().getConfiguration().locale).format(date) + DateFormat.getDateFormat(CommonApplication.m11493l()).format(date));
            if (zM7822b) {
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
            view = this.f7339g.inflate(this.f7337e, viewGroup, false);
        }
        TextView textView = (TextView) view.findViewById(R.id.text1);
        TextView textView2 = (TextView) view.findViewById(R.id.text2);
        C1921f c1921f = this.f7335c.get(i).get(i2);
        textView.setText(c1921f.m7824a(), TextView.BufferType.SPANNABLE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mma", GlobalApplication.m6451b().getConfiguration().locale);
        if (DateFormat.is24HourFormat(this.f7333a)) {
            simpleDateFormat = new SimpleDateFormat("HH:mm", GlobalApplication.m6451b().getConfiguration().locale);
        }
        if (String.valueOf(c1921f.m7825b()).equals(String.valueOf(c1921f.m7826c()))) {
            str = "";
        } else {
            str = simpleDateFormat.format(new Date(c1921f.m7825b().longValue())) + " - " + simpleDateFormat.format(new Date(c1921f.m7826c().longValue()));
        }
        if (TextUtils.isEmpty(str)) {
            textView2.setVisibility(8);
        } else {
            textView2.setVisibility(0);
            textView2.setText(str);
        }
        if (this.f7338f != null && this.f7338f.length() > 0 && (iIndexOf = textView.getText().toString().toLowerCase().indexOf(this.f7338f.toString().toLowerCase())) >= 0) {
            int length = this.f7338f.length() + textView.getText().toString().toLowerCase().indexOf(this.f7338f.toString().toLowerCase());
            Spannable spannable = (Spannable) textView.getText();
            spannable.setSpan(new ForegroundColorSpan(GlobalApplication.m6451b().getColor(R.color.buddy_list_item_status_highlight)), iIndexOf, length, 33);
            textView.setText(spannable);
        }
        return view;
    }

    /* renamed from: a */
    public void m7823a(String str) {
        this.f7338f = str;
    }

    /* renamed from: b */
    private boolean m7822b(String str) {
        return new SimpleDateFormat("dd/MM/yyyy").format(new Date()).equals(str);
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getChild(int i, int i2) {
        return this.f7335c.get(i).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f7335c.get(i).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f7334b.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f7334b.size();
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
