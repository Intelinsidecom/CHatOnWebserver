package com.sec.chaton.calllog.common.view.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

/* loaded from: classes.dex */
public class SwipeListView extends ListView implements View.OnTouchListener, InterfaceC0836e {

    /* renamed from: a */
    private InterfaceC0833b f3185a;

    /* renamed from: b */
    private InterfaceC0837f f3186b;

    public SwipeListView(Context context) {
        super(context);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSwipeListener(InterfaceC0837f interfaceC0837f) {
        this.f3186b = interfaceC0837f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f3186b == null || view == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 1:
                if (this.f3185a != null) {
                    this.f3185a.mo4418a(motionEvent);
                    break;
                } else {
                    this.f3185a = null;
                    break;
                }
            case 2:
                if (this.f3185a != null) {
                    break;
                }
                break;
        }
        return false;
    }

    @Override // android.widget.ListView, android.view.View
    protected void onFinishInflate() {
        setOnTouchListener(this);
        super.onFinishInflate();
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e
    /* renamed from: a */
    public boolean mo4389a(InterfaceC0833b interfaceC0833b) {
        if (this.f3186b == null) {
            return false;
        }
        this.f3185a = interfaceC0833b;
        return true;
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e
    /* renamed from: a */
    public void mo4388a(View view, int i) {
        if (this.f3186b != null && view != null) {
            this.f3186b.m4419a(view, getPositionForView(view), i);
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e
    public void onClick(View view) {
        if (this.f3186b != null && view != null) {
            performItemClick(view, getPositionForView(view), view.getId());
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e
    /* renamed from: a */
    public void mo4387a(View view) {
        if (this.f3186b != null && view != null) {
            view.performLongClick();
        }
    }
}
