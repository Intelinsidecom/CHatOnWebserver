package com.sec.widget;

/* compiled from: ChoicePanel.java */
/* renamed from: com.sec.widget.a */
/* loaded from: classes.dex */
class RunnableC3632a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChoicePanel f13462a;

    RunnableC3632a(ChoicePanel choicePanel) {
        this.f13462a = choicePanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f13462a.smoothScrollTo(this.f13462a.getChildAt(0).getWidth(), 0);
    }
}
