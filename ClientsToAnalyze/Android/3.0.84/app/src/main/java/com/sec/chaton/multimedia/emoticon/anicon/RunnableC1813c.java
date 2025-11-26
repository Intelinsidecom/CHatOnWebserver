package com.sec.chaton.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.c */
/* loaded from: classes.dex */
class RunnableC1813c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f6784a;

    /* renamed from: b */
    final /* synthetic */ AniconContainer f6785b;

    RunnableC1813c(AniconContainer aniconContainer, int i) {
        this.f6785b = aniconContainer;
        this.f6784a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f6785b.f6760g.scrollTo(this.f6784a, 0);
        this.f6785b.f6773t = -1;
    }
}
