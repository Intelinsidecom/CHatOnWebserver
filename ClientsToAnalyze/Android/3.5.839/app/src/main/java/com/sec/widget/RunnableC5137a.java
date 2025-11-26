package com.sec.widget;

/* compiled from: ChoicePanel.java */
/* renamed from: com.sec.widget.a */
/* loaded from: classes.dex */
class RunnableC5137a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChoicePanel f18829a;

    RunnableC5137a(ChoicePanel choicePanel) {
        this.f18829a = choicePanel;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f18829a.getChildAt(0) != null) {
            this.f18829a.smoothScrollTo(this.f18829a.getChildAt(0).getWidth(), 0);
        }
    }
}
