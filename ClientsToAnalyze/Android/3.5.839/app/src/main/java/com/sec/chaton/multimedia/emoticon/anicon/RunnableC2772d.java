package com.sec.chaton.multimedia.emoticon.anicon;

/* compiled from: AniconContainer.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.anicon.d */
/* loaded from: classes.dex */
class RunnableC2772d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f10059a;

    /* renamed from: b */
    final /* synthetic */ AniconContainer f10060b;

    RunnableC2772d(AniconContainer aniconContainer, int i) {
        this.f10060b = aniconContainer;
        this.f10059a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f10060b.f10025g.scrollTo(this.f10059a, 0);
        this.f10060b.f10038t = -1;
    }
}
