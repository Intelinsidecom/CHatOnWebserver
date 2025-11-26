package com.sec.chaton.calllog.common.view.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ExpandableListView;

@SuppressLint({"NewApi"})
/* loaded from: classes.dex */
public class SwipeExpandableListView extends ExpandableListView implements View.OnTouchListener, InterfaceC1447e {

    /* renamed from: a */
    private InterfaceC1444b f5145a;

    /* renamed from: b */
    private InterfaceC1448f f5146b;

    public SwipeExpandableListView(Context context) {
        super(context);
    }

    public SwipeExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnSwipeListener(InterfaceC1448f interfaceC1448f) {
        this.f5146b = interfaceC1448f;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.f5146b == null) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                setFastScrollAlwaysVisible(true);
                break;
            case 1:
                if (this.f5145a != null) {
                    this.f5145a.mo7572a(motionEvent);
                    break;
                } else {
                    this.f5145a = null;
                    setFastScrollAlwaysVisible(false);
                    break;
                }
            case 2:
                if (this.f5145a != null) {
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
        if (this.f5146b == null) {
            return false;
        }
        this.f5145a = interfaceC1444b;
        return true;
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e
    /* renamed from: a */
    public void mo7542a(View view, int i) {
        if (this.f5146b != null) {
            this.f5146b.m7573a(view, getPositionForView(view), i);
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e
    public void onClick(View view) {
        if (this.f5146b != null) {
            performItemClick(view, getPositionForView(view), view.getId());
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e
    /* renamed from: a */
    public void mo7541a(View view) {
        if (this.f5146b != null) {
            view.performLongClick();
        }
    }
}
