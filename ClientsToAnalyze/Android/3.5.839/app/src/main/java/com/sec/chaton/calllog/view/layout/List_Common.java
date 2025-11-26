package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e;
import com.sec.chaton.calllog.common.view.swipe.SwipeLayout;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class List_Common extends SwipeLayout {

    /* renamed from: d */
    protected CallLogTitleBar f5378d;

    /* renamed from: e */
    protected boolean f5379e;

    /* renamed from: f */
    protected String f5380f;

    public List_Common(Context context, boolean z, InterfaceC1447e interfaceC1447e) {
        super(context, interfaceC1447e);
        this.f5379e = true;
        this.f5380f = "";
        mo7806a(context, null, null);
        this.f5379e = z;
    }

    /* renamed from: a */
    protected void mo7806a(Context context, Color color, AttributeSet attributeSet) {
        View.inflate(context, R.layout.list_type, this);
        if (this.f5379e) {
            this.f5378d = new CallLogTitleBar(context);
            addView(this.f5378d);
        }
    }

    public void setView(CallLogData callLogData, boolean z) {
        mo7805a();
    }

    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        this.f5380f = str;
        mo7805a();
    }

    /* renamed from: a */
    protected void mo7805a() {
        if (this.f5378d != null) {
            this.f5378d.setVisibility(8);
        }
    }

    /* renamed from: a */
    protected void mo7809a(SeperatorCallLog seperatorCallLog) {
        if (this.f5378d != null) {
            if (this.f5378d != null) {
                this.f5378d.setTitle(seperatorCallLog.seperatorname);
            }
            this.f5378d.setVisibility(0);
        }
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo7558a(int i, int i2) {
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: a */
    protected void mo7556a(float f) {
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: b */
    protected void mo7559b(float f) {
    }

    @Override // com.sec.chaton.calllog.common.view.swipe.SwipeLayout
    /* renamed from: c */
    protected void mo7561c(float f) {
    }
}
