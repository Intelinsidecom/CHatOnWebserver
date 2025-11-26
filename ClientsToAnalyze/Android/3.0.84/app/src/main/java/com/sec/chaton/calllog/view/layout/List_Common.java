package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e;
import com.sec.chaton.calllog.common.view.swipe.SwipeLayout;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class List_Common extends SwipeLayout {

    /* renamed from: d */
    protected CallLogTitleBar f3405d;

    /* renamed from: e */
    protected boolean f3406e;

    /* renamed from: f */
    protected String f3407f;

    public List_Common(Context context, boolean z, InterfaceC0836e interfaceC0836e) {
        super(context, interfaceC0836e);
        this.f3406e = true;
        this.f3407f = "";
        mo4651a(context, null, null);
        this.f3406e = z;
    }

    /* renamed from: a */
    protected void mo4651a(Context context, Color color, AttributeSet attributeSet) {
        View.inflate(context, R.layout.list_type, this);
        if (this.f3406e) {
            this.f3405d = new CallLogTitleBar(context);
            addView(this.f3405d);
        }
    }

    public void setView(CallLogData callLogData, boolean z) {
        mo4650a();
    }

    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        this.f3407f = str;
        mo4650a();
    }

    /* renamed from: a */
    protected void mo4650a() {
        if (this.f3405d != null) {
            this.f3405d.setVisibility(8);
        }
    }

    /* renamed from: a */
    protected void mo4654a(SeperatorCallLog seperatorCallLog) {
        if (this.f3405d != null) {
            if (this.f3405d != null) {
                this.f3405d.setTitle(seperatorCallLog.seperatorname);
            }
            this.f3405d.setVisibility(0);
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo4404a(int i, int i2) {
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo4402a(float f) {
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: b */
    protected void mo4405b(float f) {
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: c */
    protected void mo4407c(float f) {
    }
}
