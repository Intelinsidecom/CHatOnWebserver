package com.sec.chaton.multimedia.emoticon.ams;

import com.sec.chaton.p025d.EnumC1327e;

/* compiled from: AmsContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.ams.b */
/* loaded from: classes.dex */
class RunnableC1805b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ EnumC1327e f6742a;

    /* renamed from: b */
    final /* synthetic */ AmsContainer f6743b;

    RunnableC1805b(AmsContainer amsContainer, EnumC1327e enumC1327e) {
        this.f6743b = amsContainer;
        this.f6742a = enumC1327e;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6742a == EnumC1327e.Template) {
            this.f6743b.m7447a("myWorks");
        }
    }
}
