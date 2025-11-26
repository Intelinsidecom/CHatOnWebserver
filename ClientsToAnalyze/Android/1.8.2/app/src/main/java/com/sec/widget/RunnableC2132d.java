package com.sec.widget;

/* compiled from: ChoicePanel.java */
/* renamed from: com.sec.widget.d */
/* loaded from: classes.dex */
class RunnableC2132d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChoicePanel f7778a;

    RunnableC2132d(ChoicePanel choicePanel) {
        this.f7778a = choicePanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7778a.smoothScrollTo(this.f7778a.getChildAt(0).getWidth(), 0);
    }
}
