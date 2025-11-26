package com.sec.chaton.calllog.common.view.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SwipeListView extends ListView implements View.OnTouchListener, InterfaceC1447e {

    /* renamed from: a */
    private InterfaceC1444b f5155a;

    /* renamed from: b */
    private InterfaceC1448f f5156b;

    public SwipeListView(Context context) {
        super(context);
    }

    public SwipeListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSwipeListener(InterfaceC1448f interfaceC1448f) {
        this.f5156b = interfaceC1448f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f5156b == null || view == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 1:
                if (this.f5155a != null) {
                    this.f5155a.mo7572a(motionEvent);
                    break;
                } else {
                    this.f5155a = null;
                    break;
                }
            case 2:
                if (this.f5155a != null) {
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

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e
    /* renamed from: a */
    public boolean mo7543a(InterfaceC1444b interfaceC1444b) {
        if (this.f5156b == null) {
            return false;
        }
        this.f5155a = interfaceC1444b;
        return true;
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e
    /* renamed from: a */
    public void mo7542a(View view, int i) {
        if (this.f5156b != null && view != null) {
            this.f5156b.m7573a(view, getPositionForView(view), i);
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e
    public void onClick(View view) {
        if (this.f5156b != null && view != null) {
            performItemClick(view, getPositionForView(view), view.getId());
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e
    /* renamed from: a */
    public void mo7541a(View view) {
        if (this.f5156b != null && view != null) {
            view.performLongClick();
        }
    }
}
