package com.sec.chaton.settings;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.p065io.entry.inner.FontType;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: FragmentFontChange.java */
/* renamed from: com.sec.chaton.settings.ei */
/* loaded from: classes.dex */
class C3599ei extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ FragmentFontChange f13125a;

    C3599ei(FragmentFontChange fragmentFontChange) {
        this.f13125a = fragmentFontChange;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13125a.f12700p.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13125a.f12700p.get(i);
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
        View viewInflate = LayoutInflater.from(this.f13125a.f12696l).inflate(R.layout.list_item_common_1, viewGroup, false);
        ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text1);
        FontType fontType = (FontType) this.f13125a.f12700p.get(i);
        textView.setText((CharSequence) this.f13125a.f12697m.get(Integer.valueOf(fontType.getId())));
        textView.setTypeface(fontType.getFontType());
        return viewInflate;
    }
}
