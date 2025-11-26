package com.sec.chaton;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.NavigationTabWidget;
import com.sec.common.util.C5034k;

/* compiled from: TabActivity.java */
/* renamed from: com.sec.chaton.ek */
/* loaded from: classes.dex */
final class C2317ek extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ TabActivity f8240a;

    /* renamed from: b */
    private String[] f8241b;

    public C2317ek(TabActivity tabActivity) {
        this.f8240a = tabActivity;
        if (C4822an.m18218a()) {
            this.f8241b = new String[]{GlobalApplication.m10283b().getString(R.string.chaton_contacts_tab), GlobalApplication.m10283b().getString(R.string.tab_chat), GlobalApplication.m10283b().getString(R.string.tab_mypage), GlobalApplication.m10283b().getString(R.string.header_more)};
        } else {
            this.f8241b = new String[]{GlobalApplication.m10283b().getString(R.string.media_contact), GlobalApplication.m10283b().getString(R.string.tab_message)};
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f8241b.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f8241b[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        switch (i) {
            case 0:
                return 2131165194L;
            case 1:
                return 2131165195L;
            case 2:
                return 2131165196L;
            case 3:
                return 2131165197L;
            default:
                return -1L;
        }
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.f8240a.m18784t().mo18818a() == 2) {
            if (view == null) {
                view = LayoutInflater.from(this.f8240a).inflate(R.layout.actionbar_navigation_tab, viewGroup, false);
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                if (!GlobalApplication.m10286e()) {
                    ((NavigationTabWidget) view.findViewById(R.id.tab)).setMaxWidth(m10230a());
                }
            }
            ((NavigationTabWidget) view.findViewById(R.id.tab)).setTitleText(this.f8241b[i]);
            TextView textView = (TextView) view.findViewById(R.id.tab_badge);
            int iM10231a = m10231a(i);
            if (iM10231a == 0) {
                textView.setVisibility(8);
                return view;
            }
            String strValueOf = String.valueOf(iM10231a);
            if (iM10231a > 999) {
                strValueOf = String.format("%d+", 999);
            }
            textView.setText(strValueOf);
            textView.setVisibility(0);
            return view;
        }
        TextView textView2 = (TextView) view;
        TextView textView3 = textView2 == null ? (TextView) LayoutInflater.from(this.f8240a).inflate(R.layout.actionbar_dropdown_title, viewGroup, false) : textView2;
        textView3.setText(this.f8241b[i]);
        return textView3;
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f8240a).inflate(R.layout.actionbar_dropdown_item, (ViewGroup) null);
        }
        ((TextView) view.findViewById(R.id.dropDownItem)).setText(this.f8241b[i]);
        TextView textView = (TextView) view.findViewById(R.id.dropDownItemCount);
        int iM10231a = m10231a(i);
        if (iM10231a == 0) {
            textView.setVisibility(8);
        } else {
            String strValueOf = String.valueOf(iM10231a);
            if (iM10231a > 999) {
                strValueOf = String.format("%d+", 999);
            }
            textView.setText(strValueOf);
            textView.setVisibility(0);
            if (C4904y.f17872b) {
                C4904y.m18639b("getDropDownView setBadge : " + i + ", count : " + strValueOf, TabActivity.f2029t);
            }
        }
        return view;
    }

    /* renamed from: a */
    private int m10231a(int i) {
        switch (i) {
            case 0:
                return this.f8240a.f2037F + this.f8240a.f2038G;
            case 1:
                return this.f8240a.f2039H;
            case 2:
                return this.f8240a.f2040I;
            case 3:
                return this.f8240a.f2041J;
            default:
                return 0;
        }
    }

    /* renamed from: a */
    private int m10230a() {
        return Math.round((C5034k.m19096b() / this.f8241b.length) - (this.f8240a.getResources().getDimension(R.dimen.one_dip) * 2.0f));
    }
}
