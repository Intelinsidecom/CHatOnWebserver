package com.sec.chaton.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.sec.chaton.R;
import com.sec.chaton.widget.FontSizeListViewItemLayout;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.a */
/* loaded from: classes.dex */
class C1002a extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView2 f3603a;

    C1002a(FragmentChatView2 fragmentChatView2) {
        this.f3603a = fragmentChatView2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return EnumC1094z.values().length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return EnumC1094z.values()[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        FontSizeListViewItemLayout fontSizeListViewItemLayout;
        if (view == null) {
            fontSizeListViewItemLayout = (FontSizeListViewItemLayout) LayoutInflater.from(this.f3603a.f3495c).inflate(R.layout.layout_setting_chatview_item, viewGroup, false);
        } else {
            fontSizeListViewItemLayout = (FontSizeListViewItemLayout) view;
        }
        EnumC1094z enumC1094zM3955a = EnumC1094z.m3955a(i);
        fontSizeListViewItemLayout.m4717a(0, ((Float) this.f3603a.f3494b.get(enumC1094zM3955a)).floatValue());
        fontSizeListViewItemLayout.m4718a((String) this.f3603a.f3493a.get(enumC1094zM3955a));
        return fontSizeListViewItemLayout;
    }
}
