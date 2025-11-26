package com.sec.common.widget;

/* compiled from: IcsListPopupWindow.java */
/* renamed from: com.sec.common.widget.t */
/* loaded from: classes.dex */
class RunnableC3387t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IcsListPopupWindow f12260a;

    private RunnableC3387t(IcsListPopupWindow icsListPopupWindow) {
        this.f12260a = icsListPopupWindow;
    }

    /* synthetic */ RunnableC3387t(IcsListPopupWindow icsListPopupWindow, C3381n c3381n) {
        this(icsListPopupWindow);
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f12260a.f12178d != null && this.f12260a.f12178d.getCount() > this.f12260a.f12178d.getChildCount() && this.f12260a.f12178d.getChildCount() <= this.f12260a.f12184j) {
            this.f12260a.f12176b.setInputMethodMode(2);
            this.f12260a.mo11913a();
        }
    }
}
