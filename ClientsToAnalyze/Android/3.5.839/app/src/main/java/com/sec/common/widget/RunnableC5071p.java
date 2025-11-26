package com.sec.common.widget;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.p */
/* loaded from: classes.dex */
class RunnableC5071p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f18506a;

    private RunnableC5071p(IcsListPopupWindow icsListPopupWindow) {
        this.f18506a = icsListPopupWindow;
    }

    /* synthetic */ RunnableC5071p(IcsListPopupWindow icsListPopupWindow, C5065j c5065j) {
        this(icsListPopupWindow);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f18506a.f18448d != null && this.f18506a.f18448d.getCount() > this.f18506a.f18448d.getChildCount() && this.f18506a.f18448d.getChildCount() <= this.f18506a.f18454j) {
            this.f18506a.f18446b.setInputMethodMode(2);
            this.f18506a.mo19255a();
        }
    }
}
