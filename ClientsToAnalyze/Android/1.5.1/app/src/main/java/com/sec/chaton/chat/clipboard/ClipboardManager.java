package com.sec.chaton.chat.clipboard;

import android.content.Context;
import com.sec.chaton.constant.ChatONConst;
import com.sec.chaton.util.ChatONLogWriter;

/* loaded from: classes.dex */
public class ClipboardManager {

    /* renamed from: a */
    String f950a;

    /* renamed from: b */
    Context f951b;

    public ClipboardManager(Context context, String str) {
        this.f950a = "";
        this.f951b = context;
        this.f950a = str;
    }

    /* renamed from: a */
    public IClipboard m809a() {
        ChatONLogWriter.m3509d("ChatONConst.SDK_VERSION:" + ChatONConst.f1337a);
        return ChatONConst.f1337a == 11 ? new ClipboardHoneycomb(this.f951b, this.f950a) : new ClipboardFroyo(this.f951b, this.f950a);
    }
}
