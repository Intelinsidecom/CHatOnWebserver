package com.sec.chaton.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.d */
/* loaded from: classes.dex */
class RunnableC1814d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f6786a;

    RunnableC1814d(AniconContainer aniconContainer) {
        this.f6786a = aniconContainer;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6786a.f6771r != null) {
            this.f6786a.f6771r.requery();
            this.f6786a.m7465c(null);
        }
    }
}
