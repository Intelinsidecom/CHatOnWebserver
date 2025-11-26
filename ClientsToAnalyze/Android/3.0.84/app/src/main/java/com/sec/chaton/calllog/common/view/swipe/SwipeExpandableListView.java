package com.sec.chaton.calllog.common.view.swipe;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;

/* loaded from: classes.dex */
public class SwipeExpandableListView extends ExpandableListView implements View.OnTouchListener, InterfaceC0836e {

    /* renamed from: a */
    private InterfaceC0833b f3175a;

    /* renamed from: b */
    private InterfaceC0837f f3176b;

    public SwipeExpandableListView(Context context) {
        super(context);
    }

    public SwipeExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSwipeListener(InterfaceC0837f interfaceC0837f) {
        this.f3176b = interfaceC0837f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f3176b == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                setFastScrollAlwaysVisible(true);
                break;
            case 1:
                if (this.f3175a != null) {
                    this.f3175a.mo4418a(motionEvent);
                    break;
                } else {
                    this.f3175a = null;
                    setFastScrollAlwaysVisible(false);
                    break;
                }
            case 2:
                if (this.f3175a != null) {
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
        if (this.f3176b == null) {
            return false;
        }
        this.f3175a = interfaceC0833b;
        return true;
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e
    /* renamed from: a */
    public void mo4388a(View view, int i) {
        if (this.f3176b != null) {
            this.f3176b.m4419a(view, getPositionForView(view), i);
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e
    public void onClick(View view) {
        if (this.f3176b != null) {
            performItemClick(view, getPositionForView(view), view.getId());
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e
    /* renamed from: a */
    public void mo4387a(View view) {
        if (this.f3176b != null) {
            view.performLongClick();
        }
    }
}
