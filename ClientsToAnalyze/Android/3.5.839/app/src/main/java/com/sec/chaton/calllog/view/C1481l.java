package com.sec.chaton.calllog.view;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.view.layout.List_Common;
import com.sec.chaton.calllog.view.layout.List_DetailCallLog;
import com.sec.chaton.calllog.view.layout.List_DetailGroupCallLog;
import java.util.ArrayList;

/* compiled from: CallLogDetailViewCreator.java */
/* renamed from: com.sec.chaton.calllog.view.l */
/* loaded from: classes.dex */
public class C1481l implements InterfaceC1492u {

    /* renamed from: a */
    private CallLogData f5365a;

    public C1481l(CallLogData callLogData) {
        this.f5365a = callLogData;
    }

    @Override // com.sec.chaton.calllog.view.InterfaceC1492u
    /* renamed from: a */
    public List_Common mo7797a(Context context, Handler handler, InterfaceC1447e interfaceC1447e) {
        ArrayList arrayList = new ArrayList();
        return this.f5365a.groupcallkey == null ? new List_DetailCallLog(context, handler, arrayList, interfaceC1447e) : new List_DetailGroupCallLog(context, handler, arrayList, interfaceC1447e);
    }
}
