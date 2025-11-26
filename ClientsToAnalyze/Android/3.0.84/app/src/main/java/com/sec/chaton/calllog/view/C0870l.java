package com.sec.chaton.calllog.view;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e;
import com.sec.chaton.calllog.manager.model.CallLogData;
import com.sec.chaton.calllog.view.layout.List_Common;
import com.sec.chaton.calllog.view.layout.List_DetailCallLog;
import com.sec.chaton.calllog.view.layout.List_DetailGroupCallLog;
import java.util.ArrayList;

/* compiled from: CallLogDetailViewCreator.java */
/* renamed from: com.sec.chaton.calllog.view.l */
/* loaded from: classes.dex */
public class C0870l implements InterfaceC0881u {

    /* renamed from: a */
    private CallLogData f3392a;

    public C0870l(CallLogData callLogData) {
        this.f3392a = callLogData;
    }

    @Override // com.sec.chaton.calllog.view.InterfaceC0881u
    /* renamed from: a */
    public List_Common mo4641a(Context context, Handler handler, InterfaceC0836e interfaceC0836e) {
        ArrayList arrayList = new ArrayList();
        return this.f3392a.groupcallkey == null ? new List_DetailCallLog(context, handler, arrayList, interfaceC0836e) : new List_DetailGroupCallLog(context, handler, arrayList, interfaceC0836e);
    }
}
