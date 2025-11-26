package com.sec.chaton.chat.p024b;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;
import java.util.List;

/* compiled from: LanguageSpinnerAdapter.java */
/* renamed from: com.sec.chaton.chat.b.b */
/* loaded from: classes.dex */
public class C0951b<T> extends ArrayAdapter<T> {
    public C0951b(Context context, int i, int i2, List<T> list) {
        super(context, i, i2, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean zIsEnabled = viewGroup.isEnabled();
        TextView textView = (TextView) view2.findViewById(R.id.text1);
        if (textView != null) {
            if (zIsEnabled) {
                textView.setTextColor(GlobalApplication.m6451b().getColor(com.sec.chaton.R.color.translation_popup_text_normal));
            } else {
                textView.setTextColor(GlobalApplication.m6451b().getColor(com.sec.chaton.R.color.translation_popup_text_disable));
            }
        }
        return view2;
    }
}
