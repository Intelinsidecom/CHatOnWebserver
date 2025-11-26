package com.sec.chaton.p025d.p026a;

import com.sec.chaton.chat.p024b.EnumC0962m;
import com.sec.chaton.p035io.entry.TranslationEntry;

/* compiled from: TranslateTask.java */
/* renamed from: com.sec.chaton.d.a.dz */
/* loaded from: classes.dex */
public class C1252dz {

    /* renamed from: a */
    final /* synthetic */ C1249dw f4819a;

    /* renamed from: b */
    private EnumC0962m f4820b;

    /* renamed from: c */
    private TranslationEntry f4821c;

    C1252dz(C1249dw c1249dw, EnumC0962m enumC0962m, TranslationEntry translationEntry) {
        this.f4819a = c1249dw;
        this.f4820b = enumC0962m;
        this.f4821c = translationEntry;
    }

    /* renamed from: a */
    public EnumC0962m m5566a() {
        return this.f4820b;
    }

    /* renamed from: b */
    public String m5567b() {
        if (this.f4821c == null) {
            return null;
        }
        return this.f4821c.target_text;
    }
}
