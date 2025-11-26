package com.sec.chaton.calllog.view;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC0836e;
import com.sec.chaton.calllog.view.layout.List_CallLog;
import com.sec.chaton.calllog.view.layout.List_Common;

/* compiled from: CallLogViewCreator.java */
/* renamed from: com.sec.chaton.calllog.view.v */
/* loaded from: classes.dex */
public class C0882v implements InterfaceC0881u {
    @Override // com.sec.chaton.calllog.view.InterfaceC0881u
    /* renamed from: a */
    public List_Common mo4641a(Context context, Handler handler, InterfaceC0836e interfaceC0836e) {
        return new List_CallLog(context, handler, interfaceC0836e);
    }
}
