package com.sec.chaton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.NavigationTabWidget;
import com.sec.common.util.C3347i;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.bv */
/* loaded from: classes.dex */
final class C0812bv extends BaseAdapter {

    /* renamed from: a */
    final String[] f3108a;

    /* renamed from: b */
    final /* synthetic */ TabActivity f3109b;

    private C0812bv(TabActivity tabActivity) {
        this.f3109b = tabActivity;
        this.f3108a = new String[]{GlobalApplication.m6451b().getString(R.string.tab_buddies), GlobalApplication.m6451b().getString(R.string.tab_chat), GlobalApplication.m6451b().getString(R.string.tab_mypage), GlobalApplication.m6451b().getString(R.string.plus)};
    }

    /* synthetic */ C0812bv(TabActivity tabActivity, C0435am c0435am) {
        this(tabActivity);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3108a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f3108a[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        switch (i) {
            case 0:
                return 2131165192L;
            case 1:
                return 2131165193L;
            case 2:
                return 2131165194L;
            case 3:
                return 2131165195L;
            default:
                return -1L;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f3109b.m11543k().mo11578a() == 2) {
            if (view == null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f3109b).inflate(R.layout.actionbar_navigation_tab, viewGroup, false);
                frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                if (!GlobalApplication.m6456e()) {
                    ((NavigationTabWidget) frameLayout.findViewById(R.id.tab)).setMaxWidth(m4363a());
                }
                view = frameLayout;
            }
            ((NavigationTabWidget) view.findViewById(R.id.tab)).setTitleText(this.f3108a[i]);
            TextView textView = (TextView) view.findViewById(R.id.tab_badge);
            int iM4364a = m4364a(i);
            if (iM4364a == 0) {
                textView.setVisibility(8);
                return view;
            }
            String strValueOf = String.valueOf(iM4364a);
            if (iM4364a > 99) {
                strValueOf = String.format("%d+", 99);
            }
            textView.setText(strValueOf);
            textView.setVisibility(0);
            return view;
        }
        TextView textView2 = (TextView) view;
        TextView textView3 = textView2 == null ? (TextView) LayoutInflater.from(this.f3109b).inflate(R.layout.actionbar_dropdown_title, viewGroup, false) : textView2;
        textView3.setText(this.f3108a[i]);
        return textView3;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f3109b).inflate(R.layout.actionbar_dropdown_item, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.dropDownItem)).setText(this.f3108a[i]);
        TextView textView = (TextView) view.findViewById(R.id.dropDownItemCount);
        int iM4364a = m4364a(i);
        if (iM4364a == 0) {
            textView.setVisibility(8);
        } else {
            String strValueOf = String.valueOf(iM4364a);
            if (iM4364a > 99) {
                strValueOf = String.format("%d+", 99);
            }
            textView.setText(strValueOf);
            textView.setVisibility(0);
            if (C3250y.f11734b) {
                C3250y.m11450b("getDropDownView setBadge : " + i + ", count : " + strValueOf, TabActivity.f732f);
            }
        }
        return view;
    }

    /* renamed from: a */
    private int m4364a(int i) {
        switch (i) {
            case 0:
                return this.f3109b.f793q + this.f3109b.f794r;
            case 1:
                return this.f3109b.f795s;
            case 2:
                return this.f3109b.f796t;
            case 3:
                return this.f3109b.f797u;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    private int m4363a() {
        return Math.round((C3347i.m11779b() / this.f3108a.length) - (this.f3109b.getResources().getDimension(R.dimen.one_dip) * 2.0f));
    }
}
