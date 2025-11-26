package com.sec.chaton.settings;

import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.widget.CheckableRelativeLayout;

/* compiled from: ActivityNoti2.java */
/* renamed from: com.sec.chaton.settings.cc */
/* loaded from: classes.dex */
class C3539cc extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ ActivityNoti2 f13027a;

    C3539cc(ActivityNoti2 activityNoti2) {
        this.f13027a = activityNoti2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13027a.f12576z.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f13027a.f12576z[i];
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) throws Resources.NotFoundException {
        View viewInflate = LayoutInflater.from(this.f13027a).inflate(R.layout.list_item_common_1, viewGroup, false);
        ((CheckableRelativeLayout) viewInflate).setChoiceMode(1);
        viewInflate.setPadding(this.f13027a.getResources().getDimensionPixelOffset(R.dimen.datepicker_picker_margin_left), 0, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.text1);
        CheckBox checkBox = (CheckBox) viewInflate.findViewById(android.R.id.checkbox);
        String str = this.f13027a.f12576z[i];
        textView.setText(str);
        if (!this.f13027a.f12559i && (i == 1 || i == 2)) {
            checkBox.setEnabled(false);
            int color = this.f13027a.getResources().getColor(R.color.setting_disable_summary_color);
            SpannableString spannableString = new SpannableString(str);
            if (!TextUtils.isEmpty(str)) {
                spannableString.setSpan(new ForegroundColorSpan(color), 0, str.length(), 0);
                textView.setText(spannableString);
            }
        }
        return viewInflate;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.f13027a.f12559i || !(i == 1 || i == 2)) {
            return super.isEnabled(i);
        }
        return false;
    }
}
