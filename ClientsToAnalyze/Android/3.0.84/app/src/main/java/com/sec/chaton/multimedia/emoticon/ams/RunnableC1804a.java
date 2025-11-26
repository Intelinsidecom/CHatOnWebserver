package com.sec.chaton.multimedia.emoticon.ams;

import com.sec.chaton.p025d.EnumC1327e;

/* compiled from: AmsContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.ams.a */
/* loaded from: classes.dex */
class RunnableC1804a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC1327e f6740a;

    /* renamed from: b */
    final /* synthetic */ AmsContainer f6741b;

    RunnableC1804a(AmsContainer amsContainer, EnumC1327e enumC1327e) {
        this.f6741b = amsContainer;
        this.f6740a = enumC1327e;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6740a == EnumC1327e.Template) {
            this.f6741b.m7447a("myWorks");
        }
    }
}
