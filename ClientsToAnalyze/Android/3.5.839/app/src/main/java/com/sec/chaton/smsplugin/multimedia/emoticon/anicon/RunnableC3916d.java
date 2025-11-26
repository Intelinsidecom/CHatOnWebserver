package com.sec.chaton.smsplugin.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.emoticon.anicon.d */
/* loaded from: classes.dex */
class RunnableC3916d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f14109a;

    RunnableC3916d(AniconContainer aniconContainer) {
        this.f14109a = aniconContainer;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (this.f14109a.f14090q != null) {
            this.f14109a.f14090q.requery();
            this.f14109a.m15118c((String) null);
        }
    }
}
