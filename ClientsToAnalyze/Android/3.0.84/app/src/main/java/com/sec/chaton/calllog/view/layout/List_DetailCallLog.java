package com.sec.chaton.calllog.view.layout;

import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.util.AttributeSet;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.manager.model.SeperatorCallLog;
import com.sec.chaton.calllog.manager.p022b.C0841a;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
public class List_DetailCallLog extends List_Common {

    /* renamed from: a */
    public final Handler f3408a;

    /* renamed from: b */
    public final Context f3409b;

    /* renamed from: c */
    protected List<Boolean> f3410c;

    /* renamed from: g */
    private List_TypeDetailCallLog f3411g;

    public List_DetailCallLog(Context context, Handler handler, List<Boolean> list, InterfaceC0836e interfaceC0836e) {
        super(context, true, interfaceC0836e);
        this.f3409b = context;
        this.f3408a = handler;
        this.f3410c = list;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4651a(Context context, Color color, AttributeSet attributeSet) {
        super.mo4651a(context, color, attributeSet);
        this.f3411g = new List_TypeDetailCallLog(context);
        addView(this.f3411g);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        this.f3407f = str;
        mo4650a();
        if (callLogData instanceof SeperatorCallLog) {
            mo4654a((SeperatorCallLog) callLogData);
        } else if (callLogData instanceof CallLogData) {
            m4657a(callLogData, m4655a(callLogData, z2), z, z3);
        }
    }

    /* renamed from: a */
    private String m4655a(CallLogData callLogData, boolean z) {
        String strM4459a;
        String strM4459a2;
        if (z) {
            strM4459a = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
            strM4459a2 = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
        } else {
            strM4459a = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "a h:mm");
            strM4459a2 = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "h:mm a");
        }
        return m4656b() ? strM4459a : strM4459a2;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4650a() {
        super.mo4650a();
        this.f3411g.setVisibility(8);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4654a(SeperatorCallLog seperatorCallLog) {
        this.f3405d.setTitle(seperatorCallLog.seperatorname);
        this.f3405d.setTag(seperatorCallLog.tagname);
        this.f3405d.setVisibility(0);
    }

    /* renamed from: a */
    protected void m4657a(CallLogData callLogData, String str, boolean z, boolean z2) {
        this.f3411g.setDeleteMode(z);
        this.f3411g.setTime(str);
        this.f3411g.setDuration(C0841a.m4451a().m4457a(callLogData));
        this.f3411g.setCallType(callLogData);
        this.f3411g.setCallMethod(callLogData.callmethod);
        this.f3411g.setChecked(z2);
        this.f3411g.setVisibility(0);
    }

    /* renamed from: b */
    private boolean m4656b() {
        return "kor".equals(this.f3409b.getResources().getConfiguration().locale.getISO3Language());
    }
}
