package com.sec.chaton.chat;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/* compiled from: ChatActivity.java */
/* renamed from: com.sec.chaton.chat.b */
/* loaded from: classes.dex */
class C0551b implements TabHost.TabContentFactory {

    /* renamed from: a */
    private final Context f1911a;

    public C0551b(Context context) {
        this.f1911a = context;
    }

    @Override // android.widget.TabHost.TabContentFactory
    public View createTabContent(String str) {
        View view = new View(this.f1911a);
        view.setMinimumWidth(0);
        view.setMinimumHeight(0);
        return view;
    }
}
