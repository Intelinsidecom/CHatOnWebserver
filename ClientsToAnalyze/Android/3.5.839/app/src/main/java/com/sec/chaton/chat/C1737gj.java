package com.sec.chaton.chat;

import android.text.util.Linkify;
import java.util.regex.Matcher;

/* compiled from: ChatUtil.java */
/* renamed from: com.sec.chaton.chat.gj */
/* loaded from: classes.dex */
final class C1737gj implements Linkify.TransformFilter {
    C1737gj() {
    }

    @Override // android.text.util.Linkify.TransformFilter
    public String transformUrl(Matcher matcher, String str) {
        return str;
    }
}
