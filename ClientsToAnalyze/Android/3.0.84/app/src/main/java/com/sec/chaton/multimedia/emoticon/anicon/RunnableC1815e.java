package com.sec.chaton.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.e */
/* loaded from: classes.dex */
class RunnableC1815e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AniconContainer f6787a;

    RunnableC1815e(AniconContainer aniconContainer) {
        this.f6787a = aniconContainer;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f6787a.f6771r != null) {
            this.f6787a.f6771r.requery();
            this.f6787a.m7465c(null);
        }
    }
}
