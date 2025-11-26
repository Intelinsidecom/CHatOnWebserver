package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import java.util.HashMap;
import java.util.Set;

/* loaded from: classes.dex */
public class List_ProfileCallLog extends List_Common {

    /* renamed from: a */
    public final Context f3417a;

    /* renamed from: b */
    private List_ProfileCallLogDetail f3418b;

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4651a(Context context, Color color, AttributeSet attributeSet) {
        this.f3418b = new List_ProfileCallLogDetail(context);
        addView(this.f3418b);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        if (callLogData instanceof SeperatorCallLog) {
            this.f3418b.setVisibility(8);
        } else if (callLogData instanceof CallLogData) {
            m4663a(callLogData, m4661a(callLogData, z2), z, str, z3);
        }
    }

    /* renamed from: a */
    private String m4661a(CallLogData callLogData, boolean z) {
        boolean zM4662b = m4662b();
        if (z) {
            if (zM4662b) {
                return C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
            }
            return C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
        }
        if (zM4662b) {
            return C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "a h:mm");
        }
        return C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "h:mm a");
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4650a() {
        super.mo4650a();
        this.f3418b.setVisibility(8);
    }

    /* renamed from: a */
    protected void m4663a(CallLogData callLogData, String str, boolean z, String str2, boolean z2) {
        this.f3418b.setDeleteMode(z);
        if (callLogData.callmethod == 11 || callLogData.callmethod == 10) {
        }
        this.f3418b.setTime(str);
        this.f3418b.setDuration(C0841a.m4451a().m4456a(callLogData.userInfo.get(0).f3215k));
        this.f3418b.setCallType(callLogData);
        this.f3418b.setCallMethod(callLogData.callmethod);
        this.f3418b.setDate(C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, str2));
        this.f3418b.setChecked(z2);
        this.f3418b.setVisibility(0);
    }

    /* renamed from: b */
    private boolean m4662b() {
        return "kor".equals(this.f3417a.getResources().getConfiguration().locale.getISO3Language());
    }
}
