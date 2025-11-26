package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.emoticon.anicon.e */
/* loaded from: classes.dex */
class RunnableC3917e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f14110a;

    RunnableC3917e(AniconContainer aniconContainer) {
        this.f14110a = aniconContainer;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (this.f14110a.f14090q != null) {
            this.f14110a.f14090q.requery();
            this.f14110a.m15118c((String) null);
        }
    }
}
