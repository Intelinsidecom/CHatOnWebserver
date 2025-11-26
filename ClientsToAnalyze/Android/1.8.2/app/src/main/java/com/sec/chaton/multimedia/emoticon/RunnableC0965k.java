package com.sec.chaton.multimedia.emoticon;

/* compiled from: EmoticonSelectionView.java */
/* renamed from: com.sec.chaton.multimedia.emoticon.k */
/* loaded from: classes.dex */
class RunnableC0965k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0963i f3553a;

    RunnableC0965k(C0963i c0963i) {
        this.f3553a = c0963i;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3553a.f3548a.f3364k.getChildCount() > 1) {
            this.f3553a.f3548a.f3364k.setCurrentItem(1, false);
        }
        this.f3553a.f3548a.f3363j.setViewPager(this.f3553a.f3548a.f3364k);
    }
}
