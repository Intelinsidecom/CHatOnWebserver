package com.sec.chaton.chat.clipboard;

import android.content.Context;

/* loaded from: classes.dex */
public class ClipboardHoneycomb implements IClipboard {

    /* renamed from: a */
    String f948a;

    /* renamed from: b */
    Context f949b;

    public ClipboardHoneycomb(Context context, String str) {
        this.f948a = "";
        this.f949b = context;
        this.f948a = str;
        m808a();
    }

    /* renamed from: a */
    public void m808a() {
        ((android.content.ClipboardManager) this.f949b.getSystemService("clipboard")).setText(this.f948a);
    }
}
