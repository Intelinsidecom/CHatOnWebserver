package com.sec.chaton.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: FragmentChatView2.java */
/* renamed from: com.sec.chaton.settings.ef */
/* loaded from: classes.dex */
class C3596ef extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentChatView2 f13123a;

    C3596ef(FragmentChatView2 fragmentChatView2) {
        this.f13123a = fragmentChatView2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return EnumC3594ed.values().length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return EnumC3594ed.values()[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f13123a.f12681c).inflate(R.layout.list_item_fontsize, viewGroup, false);
        ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
        TableLayout tableLayout = (TableLayout) viewInflate.findViewById(R.id.listItem_layout);
        TextView textView = (TextView) viewInflate.findViewById(R.id.listbubble_textView);
        EnumC3594ed enumC3594edM13898a = EnumC3594ed.m13898a(i);
        textView.setText((CharSequence) this.f13123a.f12679a.get(enumC3594edM13898a));
        textView.setTextSize(0, ((Float) this.f13123a.f12680b.get(enumC3594edM13898a)).floatValue());
        if (i == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) tableLayout.getLayoutParams();
            layoutParams.leftMargin = 0;
            tableLayout.setLayoutParams(layoutParams);
            ((LinearLayout) tableLayout.findViewById(R.id.fontItem_layout)).setBackgroundResource(0);
        }
        return viewInflate;
    }
}
