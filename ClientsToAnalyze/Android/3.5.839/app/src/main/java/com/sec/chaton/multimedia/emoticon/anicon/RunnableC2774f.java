package com.sec.chaton.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.f */
/* loaded from: classes.dex */
class RunnableC2774f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f10062a;

    RunnableC2774f(AniconContainer aniconContainer) {
        this.f10062a = aniconContainer;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (this.f10062a.f10034p != null) {
            this.f10062a.f10034p.requery();
            this.f10062a.m11651c((String) null);
        }
    }
}
