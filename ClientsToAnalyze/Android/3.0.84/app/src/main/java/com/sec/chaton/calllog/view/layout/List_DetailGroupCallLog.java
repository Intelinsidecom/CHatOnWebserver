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
public class List_DetailGroupCallLog extends List_Common {

    /* renamed from: a */
    public final Handler f3412a;

    /* renamed from: b */
    public final Context f3413b;

    /* renamed from: c */
    protected List<Boolean> f3414c;

    /* renamed from: g */
    private final C0841a f3415g;

    /* renamed from: h */
    private List_TypeDetailGroupCallLog f3416h;

    public List_DetailGroupCallLog(Context context, Handler handler, List<Boolean> list, InterfaceC0836e interfaceC0836e) {
        super(context, true, interfaceC0836e);
        this.f3415g = C0841a.m4451a();
        this.f3413b = context;
        this.f3412a = handler;
        this.f3414c = list;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4651a(Context context, Color color, AttributeSet attributeSet) {
        super.mo4651a(context, color, attributeSet);
        this.f3416h = new List_TypeDetailGroupCallLog(context);
        addView(this.f3416h);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    public void setView(CallLogData callLogData, boolean z, boolean z2, String str, HashMap<Set<String>, String> map, boolean z3) {
        this.f3407f = str;
        mo4650a();
        if (callLogData instanceof SeperatorCallLog) {
            mo4654a((SeperatorCallLog) callLogData);
        } else if (callLogData instanceof CallLogData) {
            m4660a(callLogData, m4658a(callLogData, z2), z, z3);
        }
    }

    /* renamed from: a */
    private String m4658a(CallLogData callLogData, boolean z) {
        String strM4459a;
        String strM4459a2;
        if (z) {
            strM4459a = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
            strM4459a2 = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "HH:mm");
        } else {
            strM4459a = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "a h:mm");
            strM4459a2 = C0841a.m4451a().m4459a(callLogData.userInfo.get(0).f3214j, "h:mm a");
        }
        return m4659b() ? strM4459a : strM4459a2;
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4650a() {
        super.mo4650a();
        this.f3416h.setVisibility(8);
    }

    @Override // com.sec.chaton.calllog.view.layout.List_Common
    /* renamed from: a */
    protected void mo4654a(SeperatorCallLog seperatorCallLog) {
        this.f3405d.setTitle(seperatorCallLog.seperatorname);
        this.f3405d.setTag(seperatorCallLog.tagname);
        this.f3405d.setVisibility(0);
    }

    /* renamed from: a */
    protected void m4660a(CallLogData callLogData, String str, boolean z, boolean z2) {
        this.f3416h.setDeleteMode(z);
        this.f3416h.setName(this.f3415g.m4461b(callLogData));
        this.f3416h.setTime(str);
        this.f3416h.setDuration(C0841a.m4451a().m4457a(callLogData));
        this.f3416h.setCallType(callLogData);
        this.f3416h.setCallMethod(callLogData.callmethod);
        this.f3416h.setChecked(z2);
        this.f3416h.setVisibility(0);
    }

    /* renamed from: b */
    private boolean m4659b() {
        return "kor".equals(this.f3413b.getResources().getConfiguration().locale.getISO3Language());
    }
}
