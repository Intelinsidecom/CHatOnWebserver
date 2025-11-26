package com.sec.chaton.smsplugin.p112ui;

import android.app.Activity;
import android.content.Intent;
import android.provider.Browser;
import com.sec.chaton.smsplugin.p111h.C3897t;

/* compiled from: LinkActionChooserFragment.java */
/* renamed from: com.sec.chaton.smsplugin.ui.af */
/* loaded from: classes.dex */
final class C4097af extends AbstractC4102ak {
    C4097af(int i) {
        super(i);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.AbstractC4102ak
    /* renamed from: a */
    public void mo16294a(Activity activity, String str, String str2) {
        Intent intent = new Intent("android.intent.action.INSERT", Browser.BOOKMARKS_URI);
        intent.putExtra("url", str);
        intent.setType("vnd.android.cursor.dir/bookmark");
        C3897t.m15050a(activity, intent);
    }
}
