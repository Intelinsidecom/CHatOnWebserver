package com.sec.chaton.calllog.view;

import android.content.Context;
import android.os.Handler;
import com.sec.chaton.calllog.common.view.swipe.InterfaceC1447e;
import com.sec.chaton.calllog.view.layout.List_CallLog;
import com.sec.chaton.calllog.view.layout.List_Common;

/* compiled from: CallLogViewCreator.java */
/* renamed from: com.sec.chaton.calllog.view.v */
/* loaded from: classes.dex */
public class C1493v implements InterfaceC1492u {
    @Override // com.sec.chaton.calllog.view.InterfaceC1492u
    /* renamed from: a */
    public List_Common mo7797a(Context context, Handler handler, InterfaceC1447e interfaceC1447e) {
        return new List_CallLog(context, handler, interfaceC1447e);
    }
}
