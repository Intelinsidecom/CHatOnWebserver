package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.emoticon.anicon.c */
/* loaded from: classes.dex */
class RunnableC3915c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f14107a;

    /* renamed from: b */
    final /* synthetic */ AniconContainer f14108b;

    RunnableC3915c(AniconContainer aniconContainer, int i) {
        this.f14108b = aniconContainer;
        this.f14107a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f14108b.f14081h.scrollTo(this.f14107a, 0);
        this.f14108b.f14092s = -1;
    }
}
