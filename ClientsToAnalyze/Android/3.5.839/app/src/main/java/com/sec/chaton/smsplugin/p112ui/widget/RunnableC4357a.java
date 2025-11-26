package com.sec.chaton.smsplugin.p112ui.widget;

/* compiled from: ChoicePanel.java */
/* renamed from: com.sec.chaton.smsplugin.ui.widget.a */
/* loaded from: classes.dex */
class RunnableC4357a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChoicePanel f15806a;

    RunnableC4357a(ChoicePanel choicePanel) {
        this.f15806a = choicePanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f15806a.smoothScrollTo(this.f15806a.getChildAt(0).getWidth(), 0);
    }
}
