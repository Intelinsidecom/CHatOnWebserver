package com.sec.chaton.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.e */
/* loaded from: classes.dex */
class RunnableC2773e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f10061a;

    RunnableC2773e(AniconContainer aniconContainer) {
        this.f10061a = aniconContainer;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        if (this.f10061a.f10034p != null) {
            this.f10061a.f10034p.requery();
            this.f10061a.m11651c((String) null);
        }
    }
}
