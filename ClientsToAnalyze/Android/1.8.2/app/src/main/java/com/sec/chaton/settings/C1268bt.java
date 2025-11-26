package com.sec.chaton.settings;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1722ae;
import com.sec.chaton.widget.FontSizeListViewItemLayout;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.bt */
/* loaded from: classes.dex */
class C1268bt extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView2 f4815a;

    C1268bt(FragmentChatView2 fragmentChatView2) {
        this.f4815a = fragmentChatView2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return EnumC1267bs.values().length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return EnumC1267bs.values()[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        FontSizeListViewItemLayout fontSizeListViewItemLayout;
        if (view == null) {
            fontSizeListViewItemLayout = (FontSizeListViewItemLayout) LayoutInflater.from(this.f4815a.f4610c).inflate(R.layout.layout_setting_chatview_item, viewGroup, false);
        } else {
            fontSizeListViewItemLayout = (FontSizeListViewItemLayout) view;
        }
        AbsListView.LayoutParams layoutParams = null;
        Resources resources = this.f4815a.f4610c.getResources();
        switch (i) {
            case 0:
                fontSizeListViewItemLayout.setBackgroundResource(R.drawable.popup_bg_center);
                layoutParams = new AbsListView.LayoutParams(-1, C1722ae.m5896c(resources.getDimension(R.dimen.row_size_tiny)));
                break;
            case 1:
                fontSizeListViewItemLayout.setBackgroundResource(R.drawable.popup_bg_center_2);
                layoutParams = new AbsListView.LayoutParams(-1, C1722ae.m5896c(resources.getDimension(R.dimen.row_size_small)));
                break;
            case 2:
                fontSizeListViewItemLayout.setBackgroundResource(R.drawable.popup_bg_center_2);
                layoutParams = new AbsListView.LayoutParams(-1, C1722ae.m5896c(resources.getDimension(R.dimen.row_size_normal)));
                break;
            case 3:
                fontSizeListViewItemLayout.setBackgroundResource(R.drawable.popup_bg_center_2);
                layoutParams = new AbsListView.LayoutParams(-1, C1722ae.m5896c(resources.getDimension(R.dimen.row_size_large)));
                break;
            case 4:
                fontSizeListViewItemLayout.setBackgroundResource(R.drawable.popup_bg_center_2);
                layoutParams = new AbsListView.LayoutParams(-1, C1722ae.m5896c(resources.getDimension(R.dimen.row_size_huge)));
                break;
        }
        fontSizeListViewItemLayout.setLayoutParams(layoutParams);
        EnumC1267bs enumC1267bsM4743a = EnumC1267bs.m4743a(i);
        fontSizeListViewItemLayout.m6115a(0, ((Float) this.f4815a.f4609b.get(enumC1267bsM4743a)).floatValue());
        fontSizeListViewItemLayout.m6116a((String) this.f4815a.f4608a.get(enumC1267bsM4743a));
        return fontSizeListViewItemLayout;
    }
}
