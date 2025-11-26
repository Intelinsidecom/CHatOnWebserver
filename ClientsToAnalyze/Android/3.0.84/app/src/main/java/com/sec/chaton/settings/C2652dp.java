package com.sec.chaton.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p035io.entry.inner.FontType;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: FragmentFontChange.java */
/* renamed from: com.sec.chaton.settings.dp */
/* loaded from: classes.dex */
class C2652dp extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentFontChange f9912a;

    C2652dp(FragmentFontChange fragmentFontChange) {
        this.f9912a = fragmentFontChange;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f9912a.f9146n.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f9912a.f9146n.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f9912a.f9142j).inflate(R.layout.list_item_common_1, viewGroup, false);
        ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text1);
        FontType fontType = (FontType) this.f9912a.f9146n.get(i);
        textView.setText((CharSequence) this.f9912a.f9143k.get(Integer.valueOf(fontType.getId())));
        textView.setTypeface(fontType.getFontType());
        return viewInflate;
    }
}
