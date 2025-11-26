package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import com.sec.chaton.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LayoutSelectorAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.ab */
/* loaded from: classes.dex */
public class C4093ab extends C4362z {
    public C4093ab(Context context) {
        super(context, m16289a(context));
    }

    /* renamed from: a */
    protected static List<C4092aa> m16289a(Context context) {
        ArrayList arrayList = new ArrayList(2);
        m16290a(arrayList, context.getString(R.string.select_top_text), R.drawable.ic_mms_text_top);
        m16290a(arrayList, context.getString(R.string.select_bottom_text), R.drawable.ic_mms_text_bottom);
        return arrayList;
    }

    /* renamed from: a */
    protected static void m16290a(List<C4092aa> list, String str, int i) {
        list.add(new C4092aa(str, i));
    }
}
