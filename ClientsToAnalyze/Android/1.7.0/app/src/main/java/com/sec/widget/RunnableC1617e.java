package com.sec.widget;

/* compiled from: ChoicePanel.java */
/* renamed from: com.sec.widget.e */
/* loaded from: classes.dex */
class RunnableC1617e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChoicePanel f5711a;

    RunnableC1617e(ChoicePanel choicePanel) {
        this.f5711a = choicePanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5711a.smoothScrollTo(this.f5711a.getChildAt(0).getWidth(), 0);
    }
}
