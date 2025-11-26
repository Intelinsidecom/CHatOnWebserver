package com.sec.chaton.chat;

import android.widget.AdapterView;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.widget.C1798b;

/* compiled from: IAllowWithPush.java */
/* renamed from: com.sec.chaton.chat.bi */
/* loaded from: classes.dex */
public interface InterfaceC0495bi {
    void allowWithPush(String str, int i, String str2, String str3, EnumC0695j enumC0695j);

    boolean enableAutoScroll();

    C1798b getMenu();

    AdapterView.OnItemSelectedListener getMenuListener();

    void setPreviewText(int i);
}
