package com.sec.chaton.p055d.p056a;

import com.sec.chaton.chat.translate.EnumC1860m;
import com.sec.chaton.p065io.entry.TranslationEntry;

/* compiled from: TranslateTask.java */
/* renamed from: com.sec.chaton.d.a.ex */
/* loaded from: classes.dex */
public class C2032ex {

    /* renamed from: a */
    final /* synthetic */ C2029eu f7434a;

    /* renamed from: b */
    private EnumC1860m f7435b;

    /* renamed from: c */
    private TranslationEntry f7436c;

    C2032ex(C2029eu c2029eu, EnumC1860m enumC1860m, TranslationEntry translationEntry) {
        this.f7434a = c2029eu;
        this.f7435b = enumC1860m;
        this.f7436c = translationEntry;
    }

    /* renamed from: a */
    public EnumC1860m m9168a() {
        return this.f7435b;
    }

    /* renamed from: b */
    public String m9169b() {
        if (this.f7436c == null) {
            return null;
        }
        return this.f7436c.target_text;
    }
}
