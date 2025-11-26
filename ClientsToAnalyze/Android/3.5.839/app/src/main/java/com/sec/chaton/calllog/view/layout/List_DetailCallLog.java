package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.calllog.manager.p053b.C1452a;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class List_DetailCallLog extends List_Common {

    /* renamed from: a */
    protected RelativeLayout f5381a;

    /* renamed from: b */
    public final Handler f5382b;

    /* renamed from: c */
    public final Context f5383c;

    /* renamed from: g */
    protected List<Boolean> f5384g;

    public List_DetailCallLog(Context context, Handler handler, List<Boolean> list, InterfaceC1447e interfaceC1447e) {
        super(context, true, interfaceC1447e);
        this.f5383c = context;
        this.f5382b = handler;
        this.f5384g = list;
    }

    /* renamed from: a */
    protected RelativeLayout mo7810a(Context context) {
        return new List_TypeDetailCallLog(context);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo7806a(Context context, Color color, AttributeSet attributeSet) {
        super.mo7806a(context, color, attributeSet);
        this.f5381a = mo7810a(context);
        addView(this.f5381a);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        this.f5380f = str;
        mo7805a();
        if (callLogData instanceof SeperatorCallLog) {
            mo7809a((SeperatorCallLog) callLogData);
        } else {
            mo7811a(callLogData, C1452a.m7606a(callLogData, z2), z, z3);
        }
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo7805a() {
        super.mo7805a();
        this.f5381a.setVisibility(8);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo7809a(SeperatorCallLog seperatorCallLog) {
        this.f5378d.setTitle(seperatorCallLog.seperatorname);
        this.f5378d.setTag(seperatorCallLog.tagname);
        this.f5378d.setVisibility(0);
    }

    /* renamed from: a */
    protected void mo7811a(CallLogData callLogData, String str, boolean z, boolean z2) {
        ((List_TypeDetailCallLog) this.f5381a).setDeleteMode(z);
        ((List_TypeDetailCallLog) this.f5381a).setTime(str);
        ((List_TypeDetailCallLog) this.f5381a).setDuration(C1452a.m7605a().m7612a(callLogData));
        ((List_TypeDetailCallLog) this.f5381a).setCallType(callLogData);
        ((List_TypeDetailCallLog) this.f5381a).setCallMethod(callLogData.callmethod);
        ((List_TypeDetailCallLog) this.f5381a).setChecked(z2);
        ((List_TypeDetailCallLog) this.f5381a).setVisibility(0);
    }
}
