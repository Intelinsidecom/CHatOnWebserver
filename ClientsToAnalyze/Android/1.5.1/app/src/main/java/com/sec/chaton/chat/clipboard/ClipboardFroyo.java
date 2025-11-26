package com.sec.chaton.chat.clipboard;

import android.content.Context;

/* loaded from: classes.dex */
public class ClipboardFroyo implements IClipboard {

    /* renamed from: a */
    String f946a;

    /* renamed from: b */
    Context f947b;

    public ClipboardFroyo(Context context, String str) {
        this.f946a = "";
        this.f947b = context;
        this.f946a = str;
        m807a();
    }

    /* renamed from: a */
    public void m807a() {
        ((android.text.ClipboardManager) this.f947b.getSystemService("clipboard")).setText(this.f946a);
    }
}
