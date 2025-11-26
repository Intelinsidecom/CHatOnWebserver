package com.sec.chaton.chat.translate;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.sec.chaton.global.GlobalApplication;
import java.util.List;

/* compiled from: LanguageSpinnerAdapter.java */
/* renamed from: com.sec.chaton.chat.translate.b */
/* loaded from: classes.dex */
public class C1849b<T> extends ArrayAdapter<T> {
    /* renamed from: a */
    public static <T> C1849b<T> m9017a(Context context, int i, int i2, List<T> list) {
        return new C1849b<>(context, i, i2, list);
    }

    private C1849b(Context context, int i, int i2, List<T> list) {
        super(context, i, i2, list);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean zIsEnabled = viewGroup.isEnabled();
        TextView textView = (TextView) view2.findViewById(R.id.text1);
        if (textView != null) {
            if (zIsEnabled) {
                textView.setTextColor(GlobalApplication.m10283b().getColor(com.sec.chaton.R.color.translation_popup_text_normal));
            } else {
                textView.setTextColor(GlobalApplication.m10283b().getColor(com.sec.chaton.R.color.translation_popup_text_disable));
            }
        }
        return view2;
    }
}
